package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.AppAction;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrayOrderItemsAdapter extends RecyclerView.Adapter<TrayOrderItemsAdapter.TrayViewHolder> {

    private static int COUNT = 1;

    @NonNull
    @Override
    public TrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_order_list_item, parent, false);
        return new TrayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrayViewHolder holder, int position) {
        holder.minus.setOnClickListener(view -> {
            AppAction.minusCount(COUNT,holder.quantityProduct);
        });
        holder.plus.setOnClickListener(view -> {
            AppAction.addCount(COUNT,holder.quantityProduct);
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class TrayViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.minus)
        RelativeLayout minus;
        @BindView(R.id.plus)
        RelativeLayout plus;
        @BindView(R.id.quantityProduct)
        TextView quantityProduct;
        @BindView(R.id.productNameOrdered)
        TextView productNameOrdered;
        @BindView(R.id.productPriceOrdered)
        TextView productPriceOrdered;
        @BindView(R.id.subTotal)
        TextView subTotal;
        @BindView(R.id.DeliveryFees)
        TextView DeliveryFees;
        @BindView(R.id.radioGroup)
        RadioGroup radioGroup;
        @BindView(R.id.forDeliveryCheck)
        RadioButton forDeliveryCheck;
        @BindView(R.id.forPickUpCheck)
        RadioButton forPickUpCheck;

        TrayViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
