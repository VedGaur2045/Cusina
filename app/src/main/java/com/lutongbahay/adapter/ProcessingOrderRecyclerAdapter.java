package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.ButterKnife;

public class ProcessingOrderRecyclerAdapter extends RecyclerView.Adapter<ProcessingOrderRecyclerAdapter.ProcessingOrderViewHolder>{


    @NonNull
    @Override
    public ProcessingOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_processing_order, parent, false);
        return new ProcessingOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcessingOrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ProcessingOrderViewHolder extends RecyclerView.ViewHolder{


        public ProcessingOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
