package com.example.cusina.AdapterClass.AddPhotoAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;

public class AddPhotoAdapterClass extends RecyclerView.Adapter<AddPhotoAdapterClass.ViewHolder> {
    private Context context;
    private Uri[] modelClasses;

    public AddPhotoAdapterClass(Context context, Uri[] modelClasses) {
        this.context = context;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.add_photo_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position == 0){
            holder.cameraLayout.setVisibility(View.VISIBLE);
            holder.galleryImage.setVisibility(View.GONE);

            holder.cameraLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openAlertBox();
                }
            });

        } else {
            holder.cameraLayout.setVisibility(View.GONE);
            holder.galleryImage.setVisibility(View.VISIBLE);
            holder.galleryImage.setImageURI(modelClasses[position]);
        }
    }

    @Override
    public int getItemCount() {
        return modelClasses.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView galleryImage;
        RelativeLayout cameraLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.galleryImage = itemView.findViewById(R.id.galleryImg);
            this.cameraLayout = itemView.findViewById(R.id.cameraLayout);
        }
    }

    private void openAlertBox(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.started_camera_from_gallery_layout, null);

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

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
