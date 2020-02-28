package com.example.cusina.AdapterClass.ProcessingListAdapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.Activities.CompletedOrdersActivity;
import com.example.cusina.R;

public class listProcessingAdapterClass extends RecyclerView.Adapter<listProcessingAdapterClass.ViewHolder> {
    private Context context;
    private listProcessingHolderClass[] holderClasses;

    public listProcessingAdapterClass(Context context, listProcessingHolderClass[] holderClasses) {
        this.context = context;
        this.holderClasses = holderClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.processing_order_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(holderClasses[position].getOrderedProductName());
        holder.productImage.setImageResource(holderClasses[position].getImageStr());
        holder.servingCount.setText(String.valueOf(holderClasses[position].getServingNumber()));
        holder.viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CompletedOrdersActivity.class);
                intent.putExtra("ValCheck",11);
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                context.startActivity(intent, bndlAnimation);
            }
        });
        holder.cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return holderClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage,ellipse_1,ellipse_2,ellipse_3,ellipse_4,ellipse_5,line_1,line_2,line_3,line_4;
        TextView productName,servingCount,checkDelOrPickup,orderReceived,orderConfirmed,processingOrder,deliveringOrder,orderDelivered;
        Button viewOrder,cancelOrder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productImage = itemView.findViewById(R.id.productImg);
            this.ellipse_1 = itemView.findViewById(R.id.ellipse_1);
            this.ellipse_2 = itemView.findViewById(R.id.ellipse_2);
            this.ellipse_3 = itemView.findViewById(R.id.ellipse_3);
            this.ellipse_4 = itemView.findViewById(R.id.ellipse_4);
            this.ellipse_5 = itemView.findViewById(R.id.ellipse_5);
            this.line_1 = itemView.findViewById(R.id.line_1);
            this.line_2 = itemView.findViewById(R.id.line_2);
            this.line_3 = itemView.findViewById(R.id.line_3);
            this.line_4 = itemView.findViewById(R.id.line_4);
            this.productName = itemView.findViewById(R.id.productName);
            this.servingCount = itemView.findViewById(R.id.productServingCount);
            this.checkDelOrPickup = itemView.findViewById(R.id.ProcessingDeliveryAndPickup);
            this.orderReceived = itemView.findViewById(R.id.orderRecieved);
            this.orderConfirmed = itemView.findViewById(R.id.orderConfirmed);
            this.processingOrder = itemView.findViewById(R.id.ProcessingOrder);
            this.deliveringOrder = itemView.findViewById(R.id.DeliveringOrder);
            this.orderDelivered = itemView.findViewById(R.id.OrderDelivered);
            this.viewOrder = itemView.findViewById(R.id.viewOrder);
            this.cancelOrder = itemView.findViewById(R.id.cancelOrderBtn);

        }
    }

}
