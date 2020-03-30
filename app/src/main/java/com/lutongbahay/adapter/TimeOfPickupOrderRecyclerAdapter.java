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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeOfPickupOrderRecyclerAdapter extends RecyclerView.Adapter<TimeOfPickupOrderRecyclerAdapter.TimeOfPickupOrderViewHolder> {
    private static int checkedPosition = 0;
    @NonNull
    @Override
    public TimeOfPickupOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_pickup_time_on_item_details,parent,false);
        return new TimeOfPickupOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeOfPickupOrderViewHolder holder, int position) {
        holder.bind(holder.mainLayout);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class TimeOfPickupOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.timeStartTxt_1)
        TextView timeStartTxt_1;
        @BindView(R.id.timeStartTxt_2)
        TextView timeStartTxt_2;
        @BindView(R.id.timeEndTxt_1)
        TextView timeEndTxt_1;
        @BindView(R.id.timeEndTxt_2)
        TextView timeEndTxt_2;
        @BindView(R.id.time_AM)
        TextView time_AM;
        @BindView(R.id.timeEnd_AM)
        TextView timeEnd_AM;
        @BindView(R.id.mainLayout)
        RelativeLayout mainLayout;

        TimeOfPickupOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(final RelativeLayout employee) {
            if (checkedPosition == -1) {
                mainLayout.setBackgroundResource(R.drawable.bg_black_border_border_nine);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    mainLayout.setBackgroundResource(R.drawable.selected_item_time_date_drawable);
                } else {
                    mainLayout.setBackgroundResource(R.drawable.bg_black_border_border_nine);
                }
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainLayout.setBackgroundResource(R.drawable.selected_item_time_date_drawable);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }

    }
//
//    public Employee getSelected() {
//        if (checkedPosition != -1) {
//            return employees.get(checkedPosition);
//        }
//        return null;
//    }
}
