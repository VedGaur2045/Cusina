package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragment;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragmentDirections;
import com.lutongbahay.main.fragments.cancelled_order.mvvm.CancelledOrderView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CancelledOrderRecyclerAdapter extends RecyclerView.Adapter<CancelledOrderRecyclerAdapter.CancelledOrderViewHolder> {


    @NonNull
    @Override
    public CancelledOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_completed_list_item, parent, false);
        return new CancelledOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledOrderViewHolder holder, int position) {
        holder.ORDER_DETAILS_Btn.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(CancelledOrderFragmentDirections.toViewOrdersDetailsFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class CancelledOrderViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ORDER_DETAILS_Btn)
        Button ORDER_DETAILS_Btn;

        public CancelledOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
