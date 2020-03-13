package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.inbox.InboxFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InboxRecyclerAdapter extends RecyclerView.Adapter<InboxRecyclerAdapter.InboxViewHolder>{


    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_inbox, parent, false);
        return new InboxViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {
        holder.msgLayout.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(InboxFragmentDirections.openMessageDetail());
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class InboxViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.msgLayout)
        RelativeLayout msgLayout;
        @BindView(R.id.msgImg)
        ImageView msgImg;
        @BindView(R.id.unreadMsgId)
        ImageView unreadMsgId;
        @BindView(R.id.msgTxtId)
        TextView msgTxtId;
        @BindView(R.id.msgDateId)
        TextView msgDateId;

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
