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

public class DishReviewRecyclerAdapter extends RecyclerView.Adapter<DishReviewRecyclerAdapter.DishReviewViewHolder> {

    @NonNull
    @Override
    public DishReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review_msg_list,parent,false);
        return new DishReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishReviewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class DishReviewViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.reviewedUserName)
        TextView reviewedUserName;
        @BindView(R.id.reviewedTime)
        TextView reviewedTime;
        @BindView(R.id._given_review_count)
        TextView _given_review_count;
        @BindView(R.id.reviewMessage)
        TextView reviewMessage;

        DishReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
