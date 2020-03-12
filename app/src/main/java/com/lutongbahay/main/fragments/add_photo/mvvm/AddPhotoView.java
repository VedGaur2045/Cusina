package com.lutongbahay.main.fragments.add_photo.mvvm;

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

    private Uri[] mUrls = null;

    public AddPhotoView(@NonNull Context context, AddPhotoViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_add_photo,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.addDishPhoto);
        backBtnImg.setVisibility(GONE);

        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE)) {
            Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            final Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);

            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    mUrls = new Uri[cursor.getCount()];
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        mUrls[i] = Uri.parse(cursor.getString(1));
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(mUrls.length);

                AddPhotoAdapter photoAdapter = new AddPhotoAdapter(context,mUrls);

                gridViewGalleryPhotoList.setAdapter(photoAdapter);
            }
        } else {

        }

    }

    @OnClick(R.id.closeImgBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(AddPhotoFragmentDirections.toProfileFragment());
        }
    }

}
