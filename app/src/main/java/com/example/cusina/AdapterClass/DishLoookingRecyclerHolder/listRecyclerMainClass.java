package com.example.cusina.AdapterClass.DishLoookingRecyclerHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;

public class listRecyclerMainClass extends RecyclerView.Adapter<listRecyclerMainClass.ViewHolder> {
    private dishHolderClass[] holderClasses;
    Context context;

    public listRecyclerMainClass(dishHolderClass[] holderClasses, Context context) {
        this.holderClasses = holderClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listLayout = inflater.inflate(R.layout.paluto_dishes,parent,false);
        return new ViewHolder(listLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productImage.setImageResource(holderClasses[position].getProductImg());
        holder.productName.setText(holderClasses[position].getProductName());
        holder.productRating.setText(holderClasses[position].getProductRating());
        holder.productPlace.setText(holderClasses[position].getProductPlace());
        holder.productPrice.setText(holderClasses[position].getProductPrice());
        holder.productShopName.setText(holderClasses[position].getProductShopName());
        holder.distance.setText(holderClasses[position].getDistance());
        holder.productAvailibility.setText(holderClasses[position].getProductAvailibility());
        holder.pickUpOnly.setText(holderClasses[position].getPickUpOnly());
        //holder.preOrder.setText(holderClasses[position].getPreOrder());



    }

    @Override
    public int getItemCount() {
        return holderClasses.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage,favImg;
        TextView productName,productRating,productPrice,productPlace,productShopName;
        TextView distance,productAvailibility,pickUpOnly,preOrder;
        LinearLayout mainLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.productImage = itemView.findViewById(R.id.productImage);
            this.favImg = itemView.findViewById(R.id.favImage);
            this.productName = itemView.findViewById(R.id.productName);
            this.productRating = itemView.findViewById(R.id.productRatingCount);
            this.productPlace = itemView.findViewById(R.id.productPlaceName);
            this.productPrice = itemView.findViewById(R.id.productMoney);
            this.productShopName = itemView.findViewById(R.id.productShopName);
            this.distance = itemView.findViewById(R.id.productDeliveryDistance);
            this.productAvailibility = itemView.findViewById(R.id.productAvailibility);
            this.pickUpOnly = itemView.findViewById(R.id.productDeliveryPickUp);
            this.preOrder = itemView.findViewById(R.id.productPreOrder);
            this.mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
