package com.lutongbahay.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;


import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.interfaces.OnImageCompressedListener;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class ImageCompressAsync extends AsyncTask<File, Void, MultipartBody.Part> {
    private static final String TAG = "ImageCompressAsync";

    private Context mContext;
    private OnImageCompressedListener onImageCompressedListener;

    private int imageSize;
    private String type;

    public ImageCompressAsync(Context mContext, String type, int imageSize, OnImageCompressedListener onImageCompressedListener) {
        this.mContext = mContext;
        this.imageSize = imageSize;
        this.type = type;
        this.onImageCompressedListener = onImageCompressedListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ProgressDialogFragment.showProgressDialog(mContext, "Loading image...");
    }

    @Override
    protected MultipartBody.Part doInBackground(File... files) {
        File file = files[0];

        try {
            Bitmap bitmapImage = BitmapFactory.decodeFile(file.getAbsolutePath());

            int nh = (int) (bitmapImage.getHeight() * (((float) this.imageSize) / bitmapImage.getWidth()));
            Bitmap scaled = Bitmap.createScaledBitmap(bitmapImage, this.imageSize, nh, true);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            scaled.compress(Bitmap.CompressFormat.PNG, 50, stream);
            byte[] byteArray = stream.toByteArray();

            Logger.DebugLog(TAG, "IMAGE_SIZE : " + byteArray.length + " from " + bitmapImage.getByteCount());

            RequestBody requestFile = RequestBody.create(MediaType.parse(this.type), byteArray);

            return MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(MultipartBody.Part part) {
        super.onPostExecute(part);
        ProgressDialogFragment.dismissProgressDialog(mContext);

        if (this.onImageCompressedListener != null) {
            this.onImageCompressedListener.OnImageCompressed(part);
        }
    }
}
