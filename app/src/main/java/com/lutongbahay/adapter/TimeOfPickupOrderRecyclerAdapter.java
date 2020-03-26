package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeOfPickupOrderRecyclerAdapter extends RecyclerView.Adapter<TimeOfPickupOrderRecyclerAdapter.TimeOfPickupOrderViewHolder> {
    @NonNull
    @Override
    public TimeOfPickupOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_pickup_time_on_item_details,parent,false);
        return new TimeOfPickupOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeOfPickupOrderViewHolder holder, int position) {
        if(position == 0){
            holder.mainLayout.setOnClickListener(view -> {
                holder.mainLayout.setBackgroundResource(R.drawable.selected_item_time_date_drawable);
            });
        } else {
            holder.mainLayout.setOnClickListener(view -> {
                holder.mainLayout.setBackgroundResource(R.drawable.bg_black_border_border_nine);
            });
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class TimeOfPickupOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.timeStartTxt)
        TextView timeStartTxt;
        @BindView(R.id.timeEndTxt)
        TextView timeEndTxt;
        @BindView(R.id.mainLayout)
        RelativeLayout mainLayout;

        TimeOfPickupOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
