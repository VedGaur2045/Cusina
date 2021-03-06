package com.lutongbahay.main.fragments.add_photo.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.GalleryImagesRecyclerAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.helper.GridSpacingItemDecoration;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.interfaces.DocumentMediaInterface;
import com.lutongbahay.interfaces.SignUpInterface;
import com.lutongbahay.list.AddPhotoAdapter;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragment;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.user_auth.fragments.sign_up.mvvm.SignUpView;
import com.lutongbahay.utils.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class AddPhotoView extends FrameLayout {
    private static final int PERMISSION_REQUEST_CODE = 902;
    private final AddPhotoViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.allPhoto)
    TextView allPhoto;
    @BindView(R.id.next)
    TextView next;
    @BindView(R.id.gallery_rv)
    RecyclerView gridViewGalleryPhotoList;
    @BindView(R.id.choosePhotoTxt)
    TextView choosePhotoTxt;
    @BindView(R.id.minimumPhotoTxt)
    TextView minimumPhotoTxt;

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 304;
    public static final int SETTINGS_REQUEST_CODE_STORAGE = 305;
    public static final int SETTINGS_REQUEST_CODE_LOCATION = 306;

    public static final int STORAGE_PERMISSION_CODE = 301;
    public static final int GALLERY_REQUEST_CODE = 302;
    public static final int CAMERA_REQUEST_CODE = 303;

    ArrayList<String> allImages= new ArrayList<>();

    private Uri[] mUrls = null;
    Context appContext;

    DocumentMediaInterface documentMediaInterface;
    SignUpInterface signUpInterface;
    static int valGet;

    GalleryImagesRecyclerAdapter galleryImagesRecyclerAdapter;

    public AddPhotoView(@NonNull Context context, AddPhotoViewModel viewModel, int val, String titleNameTxt, String text1, String text2, String text3, DocumentMediaInterface documentMediaInterface, SignUpInterface signUpInterface) {
        super(context);
        this.viewModel = viewModel;
        this.appContext = context;
        this.documentMediaInterface = documentMediaInterface;
        this.signUpInterface = signUpInterface;
        inflate(context, R.layout.fragment_add_photo,this);
        ButterKnife.bind(this,this);

        System.out.println("Val : "+val);
        valGet = val;

        int spanCount = 5; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = false;
        gridViewGalleryPhotoList.setLayoutManager(new GridLayoutManager(context, 5));

        gridViewGalleryPhotoList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        titleName.setText(titleNameTxt);
        allPhoto.setText(text1);
        choosePhotoTxt.setText(text2);
        minimumPhotoTxt.setText(text3);
        backBtnImg.setVisibility(GONE);
        takeStoragePermission();


    }

    public void takeStoragePermission() {

        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) getContext(),
                new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE)) {
            onPermissionGranted();
        }
    }

    // navigating user to app settings
    public void openSettings(int requestCode) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
        intent.setData(uri);
        ((AppCompatActivity) getContext()).startActivityForResult(intent, requestCode);
    }


    public void onPermissionGranted() {
        ProgressDialogFragment.showProgressDialog(getContext(),"Please wait...");
        allImages = getAllShownImagesPath((AppCompatActivity) appContext);
        galleryImagesRecyclerAdapter = new GalleryImagesRecyclerAdapter(appContext,allImages,valGet);
        gridViewGalleryPhotoList.setAdapter(galleryImagesRecyclerAdapter);
        ProgressDialogFragment.dismissProgressDialog(getContext());
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context,
                0,
                "Error",
                errorMessage,
                null,
                "Ok",
                null,
                (view, dialog) -> {
                },
                null);
    }
    /**
     * Getting All Images Path.
     *
     * @param activity
     *            the activity
     * @return ArrayList with images Path
     */
    private ArrayList<String> getAllShownImagesPath(AppCompatActivity activity) {
        allImages = new ArrayList<>();
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        listOfAllImages.add("");
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(absolutePathOfImage);
        }
        Logger.ErrorLog("COUNT IMAGES ",listOfAllImages.size() + "");
        return listOfAllImages;
    }


    @OnClick({R.id.closeImgBtn,R.id.next})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigateUp();
        } else if(id == R.id.next){
            if(valGet == 12 || valGet == 13 || valGet == 14) {
                String[] imageArr = new String[galleryImagesRecyclerAdapter.selectedImage.size()];
                for (int i = 0; i < galleryImagesRecyclerAdapter.selectedImage.size(); i++) {
                    imageArr[i] = galleryImagesRecyclerAdapter.selectedImage.get(i);
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("photoList", imageArr);
                if (documentMediaInterface != null) {
                    Logger.ErrorLog("CALLBACK", "RECEIVED");
                    documentMediaInterface.mediaCallBack(galleryImagesRecyclerAdapter.selectedFiles);
                }
            } else if(valGet == 15) {
                String file = String.valueOf(galleryImagesRecyclerAdapter.selectedFiles.get(0).getAbsolutePath());
                System.out.println(file+"    "+valGet);
                Bundle bundle = new Bundle();
                bundle.putString("fileImage", file);
                if (signUpInterface != null) {
                    Logger.ErrorLog("CALLBACK", "RECEIVED");

                    signUpInterface.mediaCallBack(galleryImagesRecyclerAdapter.selectedFiles);
                }
            } else {
                Logger.ErrorLog("CALLBACK", "RECEIVED NOT SET");
            }

            Navigation.findNavController(view).navigateUp();
        }
    }

}
