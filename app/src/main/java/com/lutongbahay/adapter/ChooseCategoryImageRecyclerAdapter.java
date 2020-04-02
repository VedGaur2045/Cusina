package com.lutongbahay.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;
import com.lutongbahay.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseCategoryImageRecyclerAdapter extends RecyclerView.Adapter<ChooseCategoryImageRecyclerAdapter.ChooseCategoryImageViewHolder> {
    Context context;
    ArrayList<String> images = new ArrayList<>();
    public ArrayList<String> selectedImage = new ArrayList<>();
    public ArrayList<File> selectedFiles = new ArrayList<>();

    public ChooseCategoryImageRecyclerAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ChooseCategoryImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_choose_category,parent,false);
        return new ChooseCategoryImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseCategoryImageViewHolder holder, int position) {
//        File file = new File(images.get(position));
//        Uri imageUri = Uri.fromFile(file);
//        GlideApp.with(context).load(file).placeholder(R.drawable.no_image_placeholder).into(holder.imageFirst);

        holder.imageFirst.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCameraSecondFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ChooseCategoryImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageFirst)
        ImageView imageFirst;
        public ChooseCategoryImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
