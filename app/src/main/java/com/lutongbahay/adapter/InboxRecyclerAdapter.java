package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

public class InboxRecyclerAdapter extends RecyclerView.Adapter<InboxRecyclerAdapter.InboxViewHolder>{


    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_inbox, parent, false);
        return new InboxViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class InboxViewHolder extends RecyclerView.ViewHolder{

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
