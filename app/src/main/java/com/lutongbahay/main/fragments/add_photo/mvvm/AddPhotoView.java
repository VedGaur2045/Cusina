package com.lutongbahay.main.fragments.add_photo.mvvm;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.list.AddPhotoAdapter;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragment;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;

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
    @BindView(R.id.gridViewGalleryPhotoList)
    GridView gridViewGalleryPhotoList;

    ArrayList<String> allImages= new ArrayList<>();

    private Uri[] mUrls = null;
    Context appContext;

    public AddPhotoView(@NonNull Context context, AddPhotoViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.appContext = context;
        inflate(context, R.layout.fragment_add_photo,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.addDishPhoto);
        backBtnImg.setVisibility(GONE);
        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE)) {
            allImages.addAll(getAllShownImagesPath((AppCompatActivity) appContext));
            AddPhotoAdapter addPhotoAdapter = new AddPhotoAdapter(appContext,allImages);
            gridViewGalleryPhotoList.setAdapter(addPhotoAdapter);
        } else {

        }

//        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE)) {
//            Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//
//            final Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
//
//            if (cursor != null) {
//                try {
//                    cursor.moveToFirst();
//                    mUrls = new Uri[cursor.getCount()];
//                    for (int i = 0; i < cursor.getCount(); i++) {
//                        cursor.moveToPosition(i);
//                        mUrls[i] = Uri.parse(cursor.getString(1));
//                    }
//
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//
//                System.out.println(mUrls.length);
//
//                AddPhotoAdapter addPhotoAdapter = new AddPhotoAdapter(context,mUrls);
//                gridViewGalleryPhotoList.setAdapter(addPhotoAdapter);
//
//            }
//        } else {
//
//        }

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
        uri = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(absolutePathOfImage);
        }
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
