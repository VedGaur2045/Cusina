package com.example.cusina.AdapterClass.productListRecyclerAdapterPackage;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.Activities.ViewItemActivity;
import com.example.cusina.R;

public class adapterFile extends RecyclerView.Adapter<adapterFile.ViewHolder> {

    private viewHolderFile[] viewHolderFiles;
    private Context context;

    public adapterFile(viewHolderFile[] viewHolderFiles, Context context) {
        this.viewHolderFiles = viewHolderFiles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View productLayout = inflater.inflate(R.layout.product_layout,parent,false);
        return new ViewHolder(productLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(viewHolderFiles[position].getProductName());
        holder.time.setText(viewHolderFiles[position].getTime()+" mins");
        holder.productShopName.setText(viewHolderFiles[position].getProductShopName());
        holder.productPlaceName.setText(viewHolderFiles[position].getProductPlace());
        holder.productRatingCount.setText(viewHolderFiles[position].getProductRating());
        holder.productPrice.setText("PHP "+viewHolderFiles[position].getProductPrice());
        holder.productServing.setText(viewHolderFiles[position].getServingLeft()+" Serving Left");
        holder.productMinimumServe.setText("Minimum order: "+viewHolderFiles[position].getMinimumOrder()+" Serving");
        holder.productDistance.setText(viewHolderFiles[position].getDistance()+" KM");
        holder.productDeliveryFee.setText("Delivery Fee: Php "+viewHolderFiles[position].getDeliveryFee());
        holder.productFavCount.setText(viewHolderFiles[position].getProductFavCount());
        holder.productImg.setImageResource(viewHolderFiles[position].getProductImage());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                context.startActivity(new Intent(context, ViewItemActivity.class),bndlAnimation);
            }
        });

    }

    @Override
    public int getItemCount() {
        return viewHolderFiles.length;  // 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImg,favImg;
        TextView time,productName,productShopName,productPlaceName,productRatingCount,productPrice,productServing,productMinimumServe,productFavCount;
        TextView productDistance,productDeliveryFee;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productName = itemView.findViewById(R.id.productName);
            this.time = itemView.findViewById(R.id.productTime);
            this.productShopName = itemView.findViewById(R.id.productShopName);
            this.productPlaceName = itemView.findViewById(R.id.productPlaceName);
            this.productRatingCount= itemView.findViewById(R.id.productRatingCount);
            this.productPrice = itemView.findViewById(R.id.productPrice);
            this.productServing = itemView.findViewById(R.id.productServingLeft);
            this.productMinimumServe = itemView.findViewById(R.id.productMinimumOrder);
            this.productDistance = itemView.findViewById(R.id.productDeliveryDistance);
            this.productDeliveryFee = itemView.findViewById(R.id.productDeliveryFee);
            this.productImg = itemView.findViewById(R.id.productImg);
            this.favImg = itemView.findViewById(R.id.favouriteImg);
            this.productFavCount = itemView.findViewById(R.id.favouriteProductCount);
            this.mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
