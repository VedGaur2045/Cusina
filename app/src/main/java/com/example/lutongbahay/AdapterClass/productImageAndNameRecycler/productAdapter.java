package com.example.lutongbahay.AdapterClass.productImageAndNameRecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutongbahay.R;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ViewHolder> {
    private productHolder[] productHolders;
    private Context context;

    public productAdapter(productHolder[] productHolders, Context context) {
        this.productHolders = productHolders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View productLayout = inflater.inflate(R.layout.image_product_name_layout,parent,false);
        //productLayout.setLayoutParams(ViewGroup.LayoutParams((parent.width * 0.7).toInt(),ViewGroup.LayoutParams.MATCH_PARENT));
        ViewHolder viewHolder = new ViewHolder(productLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productImg.setImageResource(productHolders[position].getProductImgArr());
        holder.productNameTxt.setText(productHolders[position].getProductNameArr());
    }

    @Override
    public int getItemCount() {
        return productHolders.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImg;
        TextView productNameTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productImg = itemView.findViewById(R.id.productImg);
            this.productNameTxt = itemView.findViewById(R.id.productName);
        }
    }

}
