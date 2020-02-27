package com.example.cusina.AdapterClass.CompletedOrdersListAdapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.Activities.CompletedOrdersActivity;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import java.text.DecimalFormat;

import hyogeun.github.com.colorratingbarlib.ColorRatingBar;

public class CompletedOrdersAdapterClass extends RecyclerView.Adapter<CompletedOrdersAdapterClass.ViewHolder> {
    private Context context;
    private CompletedOrdersModalClass[] modalClasses;
    private ImageButton closeImgBtn;
    private Button submitBtn;
    private ColorRatingBar ratingBar;
    private ViewStub viewStub;
    private Activity activity;

    public CompletedOrdersAdapterClass(Activity context, CompletedOrdersModalClass[] modalClasses) {
        this.activity = context;
        this.modalClasses = modalClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.completed_orders_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DecimalFormat dFormat = new DecimalFormat("#0.00");

        holder.productImg.setImageResource(modalClasses[position].getImageName());
        holder.prooductName.setText(modalClasses[position].getProductName());
        holder.productCount.setText(String.valueOf(modalClasses[position].getOrderCount()));
        holder.productPrice.setText(String.valueOf(dFormat.format(modalClasses[position].getProductPrice())));
        holder.productSubTotalPrice.setText(dFormat.format(modalClasses[position].getProductSubTotalPrice()));
        holder.deliveryFees.setText(dFormat.format(modalClasses[position].getDeliveryFees()));

        holder.rateDishBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View popUpView = inflater.inflate(R.layout.add_review_layout,null);

                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true;

                UtilClass.fullsreenui(activity,"#99000000");

                final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

                // Popup Object Id

                viewStub = popUpView.findViewById(R.id.layout_stub);

                viewStub.setLayoutResource(R.layout.set_review_layout_for_dish);
                View inflated = viewStub.inflate();

                closeImgBtn = popUpView.findViewById(R.id.closeImgBtn);
                submitBtn = popUpView.findViewById(R.id.submitBtn);
                ratingBar = inflated.findViewById(R.id.ratingBarDish);

                //float rating = ratingBar.getRating();

                //System.out.println(rating);

                popupWindow.showAtLocation(popUpView, Gravity.CENTER,0,0);

                popupWindow.setOutsideTouchable(false);

                closeImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        UtilClass.fullsreenui(activity,"#FFFFFF");
                    }
                });

                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        UtilClass.fullsreenui(activity,"#FFFFFF");
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return modalClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImg;
        TextView prooductName,productCount,productPrice, productSubTotalPrice,deliveryFees;
        Button rateDishBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productImg = itemView.findViewById(R.id.productImg);
            this.prooductName = itemView.findViewById(R.id.productName);
            this.productCount = itemView.findViewById(R.id.productCount);
            this.productPrice = itemView.findViewById(R.id.productPriceOrdered);
            this.productSubTotalPrice = itemView.findViewById(R.id.subTotal);
            this.deliveryFees = itemView.findViewById(R.id.DeliveryFees);
            this.rateDishBtn = itemView.findViewById(R.id.RateDish);
        }
    }

}
