package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

public class FavouritesRecyclerAdapter extends RecyclerView.Adapter<FavouritesRecyclerAdapter.FavouritesViewHolder>{


    @NonNull
    @Override
    public FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false);
        return new FavouritesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class FavouritesViewHolder extends RecyclerView.ViewHolder{

        public FavouritesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
