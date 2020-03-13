package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListRecyclerAdapter extends RecyclerView.Adapter<OrderListRecyclerAdapter.OrderlistViewHolder> {

    @NonNull
    @Override
    public OrderlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_list_fragment,parent,false);
        return new OrderlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderlistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class OrderlistViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.gridViewMenuList)
        TextView gridViewMenuList;
        @BindView(R.id.orderTxt)
        TextView orderTxt;
        @BindView(R.id.estimateTimeTxt)
        TextView estimateTimeTxt;
        @BindView(R.id.callImgBtn)
        ImageButton callImgBtn;
        @BindView(R.id.messageImgBtn)
        ImageButton messageImgBtn;
        @BindView(R.id.orderCountFirst)
        TextView orderCountFirst;
        @BindView(R.id.orderPriceFirst)
        TextView orderPriceFirst;
        @BindView(R.id.orderCountSecond)
        TextView orderCountSecond;
        @BindView(R.id.orderPriceSecond)
        TextView orderPriceSecond;
        @BindView(R.id.seeMoreTxt)
        TextView seeMoreTxt;
        @BindView(R.id.processOrder)
        Button processOrder;

        public OrderlistViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
