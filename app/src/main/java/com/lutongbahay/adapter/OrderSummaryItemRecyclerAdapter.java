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

public class OrderSummaryItemRecyclerAdapter extends RecyclerView.Adapter<OrderSummaryItemRecyclerAdapter.OrderSummaryViewHolder> {

    String type = "";
    public OrderSummaryItemRecyclerAdapter(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public OrderSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_orders_list_on_fragment_button, parent, false);
        return new OrderSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummaryViewHolder holder, int position) {
        if (type.equalsIgnoreCase("Cancelled Order")){
            holder.productNameCancelled.setVisibility(View.VISIBLE);
        }else if (type.equalsIgnoreCase("Delivered Order")){
            holder.productNameDelivered.setVisibility(View.VISIBLE);
        }else if (type.equalsIgnoreCase("Processing Order")){
            holder.productNameProcessingDeliveryAndPickup.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class OrderSummaryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.productNameDelivered)
        TextView productNameDelivered;
        @BindView(R.id.productNameCancelled)
        TextView productNameCancelled;
        @BindView(R.id.productNameProcessingDeliveryAndPickup)
        TextView productNameProcessingDeliveryAndPickup;

        public OrderSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
