package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProcessOrderRecyclerAdapter extends RecyclerView.Adapter<ProcessOrderRecyclerAdapter.ProcessOrderViewHolder> {

    @NonNull
    @Override
    public ProcessOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_list_poduct_fragment,parent,false);
        return new ProcessOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcessOrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ProcessOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.orderCountFirst)
        TextView orderCountFirst;
        @BindView(R.id.orderPriceFirst)
        TextView orderPriceFirst;
        public ProcessOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
