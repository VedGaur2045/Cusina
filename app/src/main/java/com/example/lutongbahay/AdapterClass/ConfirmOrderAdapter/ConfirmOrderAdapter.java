package com.example.lutongbahay.AdapterClass.ConfirmOrderAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutongbahay.R;

import java.text.DecimalFormat;

public class ConfirmOrderAdapter extends RecyclerView.Adapter<ConfirmOrderAdapter.ViewHolder> {
    private Context context;
    private ConfirmOrderModel[] holderClasses;

    private static Integer count=1;

    public ConfirmOrderAdapter(ConfirmOrderModel[] holderClasses, Context context) {
        this.holderClasses = holderClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirm_order_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        DecimalFormat dFormat = new DecimalFormat("#0.00");

        holder.notAvailable.setVisibility(View.GONE);
        holder.productNameOrderedPlace.setText(holderClasses[position].getProductName());
        holder.subTotal.setText(dFormat.format(holderClasses[position].getSubTotal()));
        holder.productPriceOrdered.setText(dFormat.format(holderClasses[position].getProductPriceOrdered()));
        holder._2x_Txt.setText(String.valueOf(holderClasses[position].getQuantityProduct()+"x"));
        holder.DeliveryFees.setText(dFormat.format(holderClasses[position].getDeliveryFees()));

//        if(holder.forDeliveryCheck.isChecked()){
//            holder.forPickUpCheck.setChecked(false);
//        }
//
//        if(holder.forPickUpCheck.isChecked()){
//            holder.forDeliveryCheck.setChecked(false);
//        }

    }

    private void calculatePrice(Integer count, double price, ViewHolder holder) {
        System.out.println(price+"  "+count);

        double totalPrice = price * count;

        DecimalFormat dFormat = new DecimalFormat("#0.00");

        //holder.productPriceOrdered.setText(dFormat.format(totalPrice));
    }

    @Override
    public int getItemCount() {
        return holderClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView quantityProduct,productPriceOrdered,subTotal,DeliveryFees,notAvailable,_2x_Txt,productNameOrderedPlace;
        RadioButton forDeliveryCheck,forPickUpCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productNameOrderedPlace = itemView.findViewById(R.id.productNameOrderedPlace);
            this.DeliveryFees = itemView.findViewById(R.id.DeliveryFees);
            this.forDeliveryCheck = itemView.findViewById(R.id.forDeliveryCheckPlace);
            this.forPickUpCheck = itemView.findViewById(R.id.forPickUpCheckPlace);
            this.quantityProduct = itemView.findViewById(R.id.quantityProduct);
            this.productPriceOrdered = itemView.findViewById(R.id.productPriceOrderedPlace);
            this.subTotal = itemView.findViewById(R.id.subTotal);
            this.notAvailable = itemView.findViewById(R.id.notAvailablePlace);
            this._2x_Txt = itemView.findViewById(R.id._2x_Txt);

        }
    }

}

