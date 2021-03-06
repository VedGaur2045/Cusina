package com.lutongbahay.main.fragments.camera.mvvm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;
import com.lutongbahay.adapter.GalleryImagesRecyclerAdapter;
import com.lutongbahay.helper.CameraPreview;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.main.fragments.camera.CameraFragmentDirections;
import com.lutongbahay.utils.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.lutongbahay.helper.MarshMallowPermission.checkPermission;

public class CameraView extends FrameLayout {
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 109;
    public static final int SETTINGS_REQUEST_CODE_CAMERA = 405;


    public static final int SETTINGS_REQUEST_CODE_STORAGE = 305;
    public static final int STORAGE_PERMISSION_CODE = 301;


    private final CameraViewModel viewModel;
    @BindView(R.id.camera_preview)
    FrameLayout camera_preview;
    @BindView(R.id.indicator)
    TabLayout indicator;
    @BindView(R.id.sideBarBtn)
    ImageButton sideBarBtn;
    @BindView(R.id.timeBtn)
    ImageButton timeBtn;
    @BindView(R.id.hdrBtn)
    ImageButton hdrBtn;
    @BindView(R.id.gridIconBtn)
    ImageButton gridIconBtn;
    @BindView(R.id.tempBtn)
    ImageButton tempBtn;
    @BindView(R.id.flashAutoBtn)
    ImageButton flashAutoBtn;
    @BindView(R.id.capturedImage)
    CircleImageView capturedImage;
    @BindView(R.id.capturedImageBtn)
    ImageButton capturedImageBtn;
    @BindView(R.id.chooseImageCategory)
    ImageButton chooseImageCategory;

    private String pictureFilePath;

    private Camera mCamera;
    private CameraPreview mPreview;
    private Camera.PictureCallback mPicture;
    private Context myContext;
    private LinearLayout cameraPreview;
    private boolean cameraFront = false;
    public static Bitmap bitmap;
    Context context;

    AppCompatActivity compatActivity;

    public CameraView(@NonNull AppCompatActivity context, CameraViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        this.compatActivity  = context;
        inflate(context, R.layout.fragment_camera,this);
        ButterKnife.bind(this,this);

        context.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        takeCameraPermission();


    }

    public void takeCameraPermission() {
        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) getContext(),
                new String[]{CAMERA},
                CAMERA_PERMISSION_REQUEST_CODE) && MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) getContext(),
                new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE},
                CAMERA_PERMISSION_REQUEST_CODE)) {
            onPermissionGranted();
        }
    }

    public void onPermissionGranted() {
        myContext = context;
        mCamera =  Camera.open();
        mCamera.setDisplayOrientation(90);
        mPreview = new CameraPreview(myContext, mCamera);
        camera_preview.addView(mPreview);
        mCamera.startPreview();
    }

    @OnClick({R.id.capturedImageBtn,R.id.chooseImageCategory})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.capturedImageBtn:
                checkStoragePermission(view);
                Navigation.findNavController(view).navigate(CameraFragmentDirections.toAddPhoto());
                //captureImageOnBtnClick(view);
                compatActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                //    Navigation.findNavController(view).navigate(CameraFragmentDirections.toAddPhoto());
                break;
            case R.id.chooseImageCategory:
                Navigation.findNavController(view).navigate(CameraFragmentDirections.toChooseCategory());
                compatActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                break;
        }
    }

    public void captureImageOnBtnClick(View view) {
        mCamera.takePicture(null, null, mPicture);
    }

    public void cameraOpen() {
        if(mCamera == null) {
            mCamera = Camera.open();
            mCamera.setDisplayOrientation(90);
            mPicture = getPictureCallback();
            try {
                mPreview.refreshCamera(mCamera);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            Log.d("nu", "null");
        }else {
            Log.d("nu","no null");
        }

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        //when on Pause, release camera in order to be used from other applications
//        releaseCamera();
//    }

    public void releaseCamera() {
        // stop and release camera
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }

    // navigating user to app settings
    public void openSettings(int requestCode) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
        intent.setData(uri);
        ((AppCompatActivity) getContext()).startActivityForResult(intent, requestCode);
    }

    private Camera.PictureCallback getPictureCallback() {
        Camera.PictureCallback picture = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()+ "/Camera/Cusina";

                Log.e("Hello : ",root);

                File directory = getContext().getDir("mydir", Context.MODE_PRIVATE);
                Log.e("directory", directory.getAbsolutePath().toString());

                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                pictureFilePath = BitMapToString(bitmap);

                System.out.println(pictureFilePath);

                capturedImage.setImageBitmap(bitmap);

                saveImage(bitmap);

            }
        };
        return picture;
    }

    private void saveImage(Bitmap finalBitmap) {

        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        File myDir = new File(root);
        myDir.mkdirs();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fname = "IMG_"+ timeStamp +".jpg";

        File file = new File(myDir, fname);
        if (file.exists()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkStoragePermission(View view){
        if (checkPermission(context, WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            captureImageOnBtnClick(view);
        }
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] arr=baos.toByteArray();
        return Base64.encodeToString(arr, Base64.DEFAULT);
    }


}
