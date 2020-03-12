package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

public class OrderSummaryItemRecyclerAdapter extends RecyclerView.Adapter<OrderSummaryItemRecyclerAdapter.OrderSummaryViewHolder> {


    @NonNull
    @Override
    public OrderSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_orders_list_on_fragment_button,parent,false);
        return new OrderSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummaryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class OrderSummaryViewHolder extends RecyclerView.ViewHolder{

        public OrderSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
