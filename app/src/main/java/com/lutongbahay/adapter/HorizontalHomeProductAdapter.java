package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.ButterKnife;

public class HorizontalHomeProductAdapter extends RecyclerView.Adapter<HorizontalHomeProductAdapter.ProductViewHolder> {


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_image_product_name, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
