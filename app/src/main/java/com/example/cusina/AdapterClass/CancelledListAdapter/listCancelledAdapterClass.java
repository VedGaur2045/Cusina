package com.example.cusina.AdapterClass.CancelledListAdapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.Activities.CompletedOrdersActivity;
import com.example.cusina.R;

public class listCancelledAdapterClass extends RecyclerView.Adapter<listCancelledAdapterClass.ViewHolder> {
    private Context context;
    private listCancelledHolderClass[] cancelledHolderClasses;

    public listCancelledAdapterClass(Context context, listCancelledHolderClass[] cancelledHolderClasses) {
        this.context = context;
        this.cancelledHolderClasses = cancelledHolderClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View listView = LayoutInflater.from(context).inflate(R.layout.cancelled_list_item,parent,false);

        return new ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.totalPrice.setText(cancelledHolderClasses[position].getTotalPrice());
        holder.trayQuantity.setText(cancelledHolderClasses[position].getTrayQuantity()+" ");
        holder.transactionId.setText(cancelledHolderClasses[position].getTransactionId());
        holder.serverTxtName.setText(cancelledHolderClasses[position].getServerTxtName());
        holder.orderedNumber.setText(cancelledHolderClasses[position].getOrderedNumber());
        holder.orderedDate.setText(cancelledHolderClasses[position].getOrderedDate());

        holder.orderDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CompletedOrdersActivity.class);
                intent.putExtra("ValCheck",13);
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                context.startActivity(intent, bndlAnimation);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cancelledHolderClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView orderedNumber,orderedDate,serverTxtName,transactionId,trayQuantity,totalPrice;
        Button orderDetailsBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.orderedDate = itemView.findViewById(R.id.orderCancelledDate);
            this.orderedNumber = itemView.findViewById(R.id.orderNumber);
            this.serverTxtName = itemView.findViewById(R.id.ServerTxt);
            this.transactionId = itemView.findViewById(R.id.TransactionID);
            this.trayQuantity = itemView.findViewById(R.id.TrayQuantity);
            this.totalPrice = itemView.findViewById(R.id.totalAmount);
            this.orderDetailsBtn = itemView.findViewById(R.id.ORDER_DETAILS_Btn);

        }
    }

}
