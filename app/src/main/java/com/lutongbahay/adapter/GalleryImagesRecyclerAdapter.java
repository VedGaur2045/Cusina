package com.lutongbahay.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryImagesRecyclerAdapter extends RecyclerView.Adapter<GalleryImagesRecyclerAdapter.GalleryViewHolder> {

    Context context;
    ArrayList<String> images = new ArrayList<>();
    static int countSelectedImage;
    public ArrayList<String> selectedImage = new ArrayList<>();

    public ArrayList<File> selectedFiles = new ArrayList<>();

    public GalleryImagesRecyclerAdapter(Context context, ArrayList<String> images, int val) {
        this.context = context;
        this.images = images;
        countSelectedImage = 0;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_add_photo, parent, false);
        return new GalleryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

        if (position == 0){
            holder.cameraLayout.setVisibility(View.VISIBLE);
            holder.imageLayout.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(v -> openAlertBox(holder.itemView));
        }else{
            holder.cameraLayout.setVisibility(View.GONE);
            holder.imageLayout.setVisibility(View.VISIBLE);
            holder.imageBg.setVisibility(View.GONE);
            holder.selectedCount.setVisibility(View.GONE);
            Logger.DebugLog("IMAGE POSITION " + position + " ", images.get(position));

            File file = new File(images.get(position));
            Uri imageUri = Uri.fromFile(file);
            GlideApp.with(context).load(file).placeholder(R.drawable.no_image_placeholder).into(holder.imageView);

            if (selectedFiles.contains(file)){
                int index = Collections.singletonList(selectedFiles).indexOf(file);
                holder.imageBg.setVisibility(View.VISIBLE);
                holder.selectedCount.setVisibility(View.VISIBLE);
                holder.selectedCount.setText(Integer.toString(index));
            }else{
                holder.imageBg.setVisibility(View.GONE);
                holder.selectedCount.setVisibility(View.GONE);
            }


            holder.imageLayout.setOnClickListener(view -> {


                if (selectedFiles.contains(file)){
                    selectedFiles.remove(file);
                }else {
                    if (selectedFiles.size() == 3) {
                        ToastUtils.shortToast("Maximum three images selected");
                    } else {
                        selectedFiles.add(file);
                    }

                }
                  notifyDataSetChanged();
//                if(countSelectedImage == 3){
//                    holder.imageBg.setVisibility(View.GONE);
//                    holder.selectedCount.setVisibility(View.GONE);
//                    if(countSelectedImage >= 0){
//                        countSelectedImage = 0;
//                    } else {
//                        countSelectedImage--;
//
//                    }
//                } else {
//                    countSelectedImage++;
//                    if(selectedImage.size() > 2){
//                        Logger.ErrorLog("Out Of Array Size : ","Now Data not set");
//                    } else {
//                        holder.imageBg.setVisibility(View.VISIBLE);
//                        holder.selectedCount.setVisibility(View.VISIBLE);
//                        holder.selectedCount.setText(Integer.toString(countSelectedImage));
//                        selectedImage.add(images.get(position));
//                        System.out  .println("Size OD hghjgj : "+selectedImage.size()+"   "+countSelectedImage);
//                    }
//
//                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.galleryImg)
        ImageView imageView;
        @BindView(R.id.cameraImg)
        ImageView cameraImg;
        @BindView(R.id.newPhoto)
        TextView newPhoto;
        @BindView(R.id.cameraLayout)
        RelativeLayout cameraLayout;
        @BindView(R.id.imageLayout)
        RelativeLayout imageLayout;
        @BindView(R.id.imageBg)
        ImageView imageBg;
        @BindView(R.id.selectedCount)
        TextView selectedCount;


        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void openAlertBox(View view){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.custom_popup_started_camera_from_gallery, null);



        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setView(popupView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        assert window != null;

        dialog.show();
        ImageButton closeBtn = popupView.findViewById(R.id.closeImgBtn);
        Button getStarted = popupView.findViewById(R.id.getStarted);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Navigation.findNavController(view).navigate(AddPhotoFragmentDirections.toCameraSecondFragment());
            }
        });
    }
}
