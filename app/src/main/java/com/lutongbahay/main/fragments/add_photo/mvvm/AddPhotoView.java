package com.lutongbahay.main.fragments.add_photo.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import com.lutongbahay.helper.GridSpacingItemDecoration;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.list.AddPhotoAdapter;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragment;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;

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

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 304;
    public static final int SETTINGS_REQUEST_CODE_STORAGE = 305;
    public static final int SETTINGS_REQUEST_CODE_LOCATION = 306;

    public static final int STORAGE_PERMISSION_CODE = 301;
    public static final int GALLERY_REQUEST_CODE = 302;
    public static final int CAMERA_REQUEST_CODE = 303;

    ArrayList<String> allImages= new ArrayList<>();

    private Uri[] mUrls = null;
    Context appContext;

    public AddPhotoView(@NonNull Context context, AddPhotoViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.appContext = context;
        inflate(context, R.layout.fragment_add_photo,this);
        ButterKnife.bind(this,this);

        int spanCount = 5; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = false;
        gridViewGalleryPhotoList.setLayoutManager(new GridLayoutManager(context, 5));

        gridViewGalleryPhotoList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        titleName.setText(R.string.addDishPhoto);
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
        allImages = getAllShownImagesPath((AppCompatActivity) appContext);
        GalleryImagesRecyclerAdapter galleryImagesRecyclerAdapter = new GalleryImagesRecyclerAdapter(appContext,allImages);
        gridViewGalleryPhotoList.setAdapter(galleryImagesRecyclerAdapter);
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


    @OnClick(R.id.closeImgBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(AddPhotoFragmentDirections.toProfileFragment());
        }
    }

}
