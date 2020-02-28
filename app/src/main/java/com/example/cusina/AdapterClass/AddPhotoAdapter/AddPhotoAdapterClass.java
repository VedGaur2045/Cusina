package com.example.cusina.AdapterClass.AddPhotoAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
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
           // holder.galleryImage.setImageResource(R.layout.camera_layout);

        } else {
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.galleryImage = itemView.findViewById(R.id.galleryImg);
        }
    }
}
