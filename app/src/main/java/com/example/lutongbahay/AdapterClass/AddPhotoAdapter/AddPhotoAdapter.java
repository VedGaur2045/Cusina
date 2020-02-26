package com.example.lutongbahay.AdapterClass.AddPhotoAdapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lutongbahay.R;

import java.util.ArrayList;

public class AddPhotoAdapter extends BaseAdapter {
    private Context context;
    private Uri[] _filePaths;

    public AddPhotoAdapter(Context context, Uri[] _filePaths) {
        this.context = context;
        this._filePaths = _filePaths;
    }

    @Override
    public int getCount() {
        return this._filePaths.length;
    }

    @Override
    public Object getItem(int i) {
        return this._filePaths[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView;
        View galleryImgView = null;

        if (view == null) {
            galleryImgView = LayoutInflater.from(context).inflate(R.layout.add_photo_adapter, viewGroup, false);
            imageView = galleryImgView.findViewById(R.id.galleryImg);

            Bitmap bmp = decodeURI(_filePaths[i].getPath());
            //BitmapFactory.decodeFile(mUrls[position].getPath());
            imageView.setImageBitmap(bmp);

        } else {
            galleryImgView = view;
        }

        return galleryImgView;
    }

    private Bitmap decodeURI(String filePath){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Only scale if we need to
        // (16384 buffer for img processing)
        Boolean scaleByHeight = Math.abs(options.outHeight - 100) >= Math.abs(options.outWidth - 100);
        if(options.outHeight * options.outWidth * 2 >= 16384){
            // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
            double sampleSize = scaleByHeight
                    ? options.outHeight / 100
                    : options.outWidth / 100;
            options.inSampleSize =
                    (int)Math.pow(2d, Math.floor(
                            Math.log(sampleSize)/Math.log(2d)));
        }

        // Do the actual decoding
        options.inJustDecodeBounds = false;
        options.inTempStorage = new byte[512];
        Bitmap output = BitmapFactory.decodeFile(filePath, options);

        return output;
    }


}
