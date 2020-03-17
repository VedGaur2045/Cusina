package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;

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
        holder.itemView.setOnClickListener(v -> Navigation.findNavController(holder.itemView).navigate(ProfileFragmentDirections.openOrderProcess()));
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
