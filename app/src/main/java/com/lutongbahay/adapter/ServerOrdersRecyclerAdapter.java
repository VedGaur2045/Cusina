package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.orders.OrdersFragmentDirections;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServerOrdersRecyclerAdapter extends RecyclerView.Adapter<ServerOrdersRecyclerAdapter.OrderViewHolder> {


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_list_fragment,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.itemView.setOnClickListener(view -> Navigation.findNavController(holder.itemView).navigate(ProfileFragmentDirections.openOrderProcess()));
        holder.processOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(holder.itemView).navigate(ProfileFragmentDirections.toProcessOrderFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.customerNameTxt)
        TextView customerNameTxt;
        @BindView(R.id.orderNumber)
        TextView orderNumber;
        @BindView(R.id.callImgBtn)
        ImageButton callImgBtn;
        @BindView(R.id.messageImgBtn)
        ImageButton messageImgBtn;
        @BindView(R.id.estimateTimeTxt)
        TextView estimateTimeTxt;
        @BindView(R.id.orderCountFirst)
        TextView orderCountFirst;
        @BindView(R.id.orderCountSecond)
        TextView orderCountSecond;
        @BindView(R.id.orderPriceFirst)
        TextView orderPriceFirst;
        @BindView(R.id.orderPriceSecond)
        TextView orderPriceSecond;
        @BindView(R.id.seeMoreTxt)
        TextView seeMoreTxt;
        @BindView(R.id.processOrder)
        Button processOrder;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}