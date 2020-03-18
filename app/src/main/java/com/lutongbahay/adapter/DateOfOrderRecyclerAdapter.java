package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DateOfOrderRecyclerAdapter extends RecyclerView.Adapter<DateOfOrderRecyclerAdapter.DateOfOrderViewHolder> {

    @NonNull
    @Override
    public DateOfOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_date_on_item_details,parent,false);
        return new DateOfOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateOfOrderViewHolder holder, int position) {
        holder.dayNameTxt.setText("Monday");
        holder.dateTxt.setText("21");
        holder.monthNameTxt.setText("April");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class DateOfOrderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dayNameTxt)
        TextView dayNameTxt;
        @BindView(R.id.dateTxt)
        TextView dateTxt;
        @BindView(R.id.monthNameTxt)
        TextView monthNameTxt;

        DateOfOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
