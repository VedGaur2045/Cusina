package com.example.cusina.AdapterClass.CompletedOrdersListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;

import java.text.DecimalFormat;

public class CompletedOrdersAdapterClass extends RecyclerView.Adapter<CompletedOrdersAdapterClass.ViewHolder> {
    Context context;
    CompletedOrdersModalClass[] modalClasses;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.completed_orders_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DecimalFormat dFormat = new DecimalFormat("#0.00");

        holder.productImg.setImageResource(modalClasses[position].getImageName());
        holder.prooductName.setText(modalClasses[position].getProductName());
        holder.productCount.setText(String.valueOf(modalClasses[position].getOrderCount()));
        holder.productPrice.setText(dFormat.format(modalClasses[position].getProductPrice()));
        holder.productSubTotalPrice.setText(dFormat.format(modalClasses[position].getProductSubTotalPrice()));
        holder.deliveryFees.setText(dFormat.format(modalClasses[position].getDeliveryFees()));
    }

    @Override
    public int getItemCount() {
        return modalClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImg;
        TextView prooductName,productCount,productPrice, productSubTotalPrice,deliveryFees;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productImg = itemView.findViewById(R.id.productImg);
            this.prooductName = itemView.findViewById(R.id.productName);
            this.productCount = itemView.findViewById(R.id.productCount);
            this.productPrice = itemView.findViewById(R.id.productPriceOrdered);
            this.productSubTotalPrice = itemView.findViewById(R.id.subTotal);
            this.deliveryFees = itemView.findViewById(R.id.DeliveryFees);

        }
    }
}
