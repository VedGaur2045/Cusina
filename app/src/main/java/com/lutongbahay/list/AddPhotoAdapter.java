package com.lutongbahay.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;

import java.util.ArrayList;

public class AddPhotoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> images = new ArrayList<>();

    public AddPhotoAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return this.images.size();
    }

    @Override
    public Object getItem(int i) {
        return this.images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView;
        RelativeLayout relativeLayout;
        View galleryImgView = null;

        if (view == null) {
            galleryImgView = LayoutInflater.from(context).inflate(R.layout.adapter_add_photo, viewGroup, false);
            imageView = galleryImgView.findViewById(R.id.galleryImg);
            relativeLayout = galleryImgView.findViewById(R.id.cameraLayout);

            if(i == 0){
                relativeLayout.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);

                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openAlertBox();
                    }
                });
            } else {
                relativeLayout.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                GlideApp.with(context).load(images.get(i)).placeholder(R.drawable.no_image_placeholder).into(imageView);

            }

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


    private void openAlertBox(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.custom_popup_started_camera_from_gallery, null);

// create the popup window

        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setView(popupView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        assert window != null;
        //window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        dialog.show();
        ImageButton closeBtn = popupView.findViewById(R.id.closeImgBtn);
        Button getStarted = popupView.findViewById(R.id.getStarted);

        closeBtn.setOnClickListener(v -> dialog.dismiss());
        getStarted.setOnClickListener(v -> Navigation.findNavController(v).navigate(AddPhotoFragmentDirections.toCameraFragment()));
    }

}
