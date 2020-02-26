package com.example.cusina.AdapterClass.CompletedListAdapter;

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
import com.example.cusina.Activities.Login;
import com.example.cusina.Activities.Privacy_policy;
import com.example.cusina.R;

public class listCompletedAdapterClass extends RecyclerView.Adapter<listCompletedAdapterClass.ViewHolder> {

    private listCompletedHolderClass[] completedHolderClasses;
    private Context context;

    public listCompletedAdapterClass(listCompletedHolderClass[] completedHolderClasses, Context context) {
        this.completedHolderClasses = completedHolderClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View listLayout = LayoutInflater.from(context).inflate(R.layout.completed_list_item,parent,false);

        return new ViewHolder(listLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.totalPrice.setText(completedHolderClasses[position].getTotalPrice());
        holder.trayQuantity.setText(completedHolderClasses[position].getTrayQuantity()+" ");
        holder.transactionId.setText(completedHolderClasses[position].getTransactionId());
        holder.serverTxtName.setText(completedHolderClasses[position].getServerTxtName());
        holder.orderedNumber.setText(completedHolderClasses[position].getOrderedNumber());
        holder.orderedDate.setText(completedHolderClasses[position].getOrderedDate());

        holder.orderDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CompletedOrdersActivity.class);
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                context.startActivity(intent, bndlAnimation);
            }
        });

    }

    @Override
    public int getItemCount() {
        return completedHolderClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView orderedNumber,orderedDate,serverTxtName,transactionId,trayQuantity,totalPrice;
        Button orderDetailsBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.orderedDate = itemView.findViewById(R.id.orderCompletedDate);
            this.orderedNumber = itemView.findViewById(R.id.orderNumber);
            this.serverTxtName = itemView.findViewById(R.id.ServerTxt);
            this.transactionId = itemView.findViewById(R.id.TransactionID);
            this.trayQuantity = itemView.findViewById(R.id.TrayQuantity);
            this.totalPrice = itemView.findViewById(R.id.totalAmount);
            this.orderDetailsBtn = itemView.findViewById(R.id.ORDER_DETAILS_Btn);

        }
    }

}
