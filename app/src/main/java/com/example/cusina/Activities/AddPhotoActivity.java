package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.example.cusina.AdapterClass.AddPhotoAdapter.AddPhotoAdapter;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import java.util.ArrayList;
import java.util.List;

public class AddPhotoActivity extends AppCompatActivity  implements BSImagePicker.OnSingleImageSelectedListener,
        BSImagePicker.OnMultiImageSelectedListener,
        BSImagePicker.ImageLoaderDelegate {

    TextView next;
    ImageView img;
    GridView gridView;

    private Uri[] mUrls = null;

    String absolutePathOfImage;
    ArrayList<String> listOfAllImages = new ArrayList<>();
    ArrayList<AddPhotoAdapter> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        UtilClass.redStatusBar(this);

        setObjectId();

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);
        findViewById(R.id.closeImgBtn).setVisibility(View.VISIBLE);
        TextView toolBarTitleTxt = findViewById(R.id.titleName);
        toolBarTitleTxt.setText(getString(R.string.addDishPhoto));

        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });

        Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.MediaColumns.DATA};
        final Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor != null) {
            try {
                cursor.moveToFirst();
                mUrls = new Uri[cursor.getCount()];
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    mUrls[i] = Uri.parse(cursor.getString(1));

                    //Log.e("mNames[i]",mNames[i]+":"+cc.getColumnCount()+ " : " +cc.getString(3));
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println(mUrls.length);

            AddPhotoAdapter photoAdapter = new AddPhotoAdapter(this,mUrls);

            gridView.setAdapter(photoAdapter);
        }


    }

    private void setObjectId(){
        next = findViewById(R.id.next);
        img = findViewById(R.id.img);
        gridView = findViewById(R.id.gridViewMenuList);
    }


    @Override
    public void loadImage(Uri imageUri, ImageView ivImage) {
        Glide.with(AddPhotoActivity.this).load(imageUri).into(img);
    }

    @Override
    public void onMultiImageSelected(List<Uri> uriList, String tag) {

    }

    @Override
    public void onSingleImageSelected(Uri uri, String tag) {
        Glide.with(AddPhotoActivity.this).load(uri).into(img);
    }
}
