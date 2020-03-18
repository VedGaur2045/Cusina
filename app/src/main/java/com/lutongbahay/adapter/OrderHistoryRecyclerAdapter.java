package com.lutongbahay.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.order_history.OrderHistoryFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderHistoryRecyclerAdapter extends RecyclerView.Adapter<OrderHistoryRecyclerAdapter.OrderHistoryViewHolder> {

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_history_item, parent, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        holder.orderListLayout.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("check", 11);
            Navigation.findNavController(view).navigate(R.id.ProcessOrderFragment,bundle);
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class OrderHistoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.orderListLayout)
        RelativeLayout orderListLayout;

        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}