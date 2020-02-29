package com.example.cusina.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Rect;
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
import com.example.cusina.AdapterClass.AddPhotoAdapter.AddPhotoAdapterClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class AddPhotoActivity extends AppCompatActivity {

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

        requestPermission();

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
//        gridView = findViewById(R.id.galleryImgListView);
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE}, 100);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode)
            {
                case 100:{ break;}
            }

        } else {
        }
        return;


    }

}
