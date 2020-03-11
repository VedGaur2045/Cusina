package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.ButterKnife;

public class CancelledOrderRecyclerAdapter extends RecyclerView.Adapter<CancelledOrderRecyclerAdapter.CancelledOrderViewHolder> {


    @NonNull
    @Override
    public CancelledOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_completed_list_item, parent, false);
        return new CancelledOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledOrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class CancelledOrderViewHolder extends RecyclerView.ViewHolder{

        public CancelledOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
