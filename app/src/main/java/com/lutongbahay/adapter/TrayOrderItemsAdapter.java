package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

public class TrayOrderItemsAdapter extends RecyclerView.Adapter<TrayOrderItemsAdapter.TrayViewHolder> {


    @NonNull
    @Override
    public TrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_order_list_item, parent, false);
        return new TrayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrayViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class TrayViewHolder extends RecyclerView.ViewHolder{

        public TrayViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
