package com.example.lutongbahay.AdapterClass.ordersMyTrayRecyclerListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutongbahay.R;

import java.text.DecimalFormat;

public class ordersAdapterClass extends RecyclerView.Adapter<ordersAdapterClass.ViewHolder> {
    private Context context;
    private ordersHolderClass[] holderClasses;

    private static Integer count=1;

    public ordersAdapterClass(ordersHolderClass[] holderClasses, Context context) {
        this.holderClasses = holderClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        DecimalFormat dFormat = new DecimalFormat("#0.00");

        holder.notAvailable.setVisibility(View.GONE);
        holder.productName.setText(holderClasses[position].getProductName());
        holder.subTotal.setText(dFormat.format(holderClasses[position].getSubTotal()));
        holder.productPriceOrdered.setText(dFormat.format(holderClasses[position].getProductPriceOrdered()));
        holder.quantityProduct.setText(String.valueOf(holderClasses[position].getQuantityProduct()));
        holder.DeliveryFees.setText(dFormat.format(holderClasses[position].getDeliveryFees()));

//        if(holder.forDeliveryCheck.isChecked()){
//            holder.forPickUpCheck.setChecked(false);
//        } else if(holder.forPickUpCheck.isChecked()){
//            holder.forDeliveryCheck.setChecked(false);
//        }

        holder.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Integer.valueOf(holder.quantityProduct.getText().toString())-1;

                double price = Double.parseDouble(holder.productPriceOrdered.getText().toString());

                if(count<1)
                {
                    count = 1;
                    holder.quantityProduct.setText(String.valueOf(count));
                    calculatePrice(count,price,holder);
                }
                else {
                    holder.quantityProduct.setText(String.valueOf(count));
                    calculatePrice(count,price,holder);
                }
            }
        });
        holder.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double price = Double.parseDouble(holder.productPriceOrdered.getText().toString());
                count=Integer.valueOf(holder.quantityProduct.getText().toString())+1;

                holder.quantityProduct.setText(String.valueOf(count));
                calculatePrice(count,price,holder);
            }
        });

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
        TextView quantityProduct,productPriceOrdered,subTotal,DeliveryFees,notAvailable,productName;
        RadioButton forDeliveryCheck,forPickUpCheck;
        RelativeLayout minusBtn,plusBtn,count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productName = itemView.findViewById(R.id.productNameOrdered);
            this.DeliveryFees = itemView.findViewById(R.id.DeliveryFees);
            this.forDeliveryCheck = itemView.findViewById(R.id.forDeliveryCheck);
            this.forPickUpCheck = itemView.findViewById(R.id.forPickUpCheck);
            this.minusBtn = itemView.findViewById(R.id.minus);
            this.plusBtn = itemView.findViewById(R.id.plus);
            this.quantityProduct = itemView.findViewById(R.id.quantityProduct);
            this.productPriceOrdered = itemView.findViewById(R.id.productPriceOrdered);
            this.subTotal = itemView.findViewById(R.id.subTotal);
            this.notAvailable = itemView.findViewById(R.id.notAvailable);
            this.count = itemView.findViewById(R.id.count);

        }
    }

}
