package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

public class HorizontalHomeFoodMenuAdapter extends RecyclerView.Adapter<HorizontalHomeFoodMenuAdapter.HorizontalHomeViewHolder>{


    @NonNull
    @Override
    public HorizontalHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_paluto_dishes, parent, false);
        return new HorizontalHomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalHomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class HorizontalHomeViewHolder extends RecyclerView.ViewHolder{

        public HorizontalHomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
