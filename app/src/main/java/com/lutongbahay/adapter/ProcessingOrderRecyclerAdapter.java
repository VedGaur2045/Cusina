package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.processing_order.ProcessingOrderFragment;
import com.lutongbahay.main.fragments.processing_order.ProcessingOrderFragmentDirections;
import com.lutongbahay.main.fragments.processing_order.mvvm.ProcessingOrderView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProcessingOrderRecyclerAdapter extends RecyclerView.Adapter<ProcessingOrderRecyclerAdapter.ProcessingOrderViewHolder>{


    @NonNull
    @Override
    public ProcessingOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_processing_order, parent, false);
        return new ProcessingOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcessingOrderViewHolder holder, int position) {
        holder.viewOrder.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(ProcessingOrderFragmentDirections.toViewOrdersDetailsFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ProcessingOrderViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.viewOrder)
        Button viewOrder;

        public ProcessingOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
