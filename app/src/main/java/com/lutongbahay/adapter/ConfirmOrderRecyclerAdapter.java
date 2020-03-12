package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmOrderRecyclerAdapter extends RecyclerView.Adapter<ConfirmOrderRecyclerAdapter.ConfirmOrderViewHolder> {

    @NonNull
    @Override
    public ConfirmOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_confirm_order_item,parent,false);
        return new ConfirmOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }



    class ConfirmOrderViewHolder extends RecyclerView.ViewHolder{



        public ConfirmOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
