package com.lutongbahay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lutongbahay.R;
import com.lutongbahay.glide.GlideApp;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DocumentUploadRecyclerAdapter extends RecyclerView.Adapter<DocumentUploadRecyclerAdapter.DocumentUploadViewModel> {

    private ArrayList<String> imageList = new ArrayList<>();
    private Context context;
    public DocumentUploadRecyclerAdapter(ArrayList<String> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public DocumentUploadViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_uploaded_document,parent,false);
        return new DocumentUploadViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentUploadViewModel holder, int position) {
        File file = new File(imageList.get(position));
        System.out.println(file+"   "+imageList.get(position));
        GlideApp.with(context).load(file).into(holder.imageSelected);

        holder.close.setOnClickListener(view -> {
            holder.imageSelected.setImageDrawable(null);
            holder.close.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class DocumentUploadViewModel extends RecyclerView.ViewHolder {
        @BindView(R.id.imageSelected)
        ImageView imageSelected;
        @BindView(R.id.close)
        ImageView close;

        public DocumentUploadViewModel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
