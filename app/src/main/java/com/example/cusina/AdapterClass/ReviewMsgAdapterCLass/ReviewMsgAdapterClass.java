package com.example.cusina.AdapterClass.ReviewMsgAdapterCLass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;

public class ReviewMsgAdapterClass extends RecyclerView.Adapter<ReviewMsgAdapterClass.ViewHolder> {

    private Context context;
    private ReviewMsgModalClass[] msgModalClasses;

    public ReviewMsgAdapterClass(Context context, ReviewMsgModalClass[] msgModalClasses) {
        this.context = context;
        this.msgModalClasses = msgModalClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.review_msg_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.reviewedUserName.setText(msgModalClasses[position].getReviewedUserName());
        holder.reviewedTime.setText(msgModalClasses[position].getReviewedTime());
        holder.rating.setText(String.valueOf(msgModalClasses[position].getRating()));
        holder.message.setText(msgModalClasses[position].getMessage());
    }

    @Override
    public int getItemCount() {
        return msgModalClasses.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView reviewedUserName,reviewedTime,message,rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.message = itemView.findViewById(R.id.message);
            this.rating = itemView.findViewById(R.id._given_review_count);
            this.reviewedTime = itemView.findViewById(R.id.reviewedTime);
            this.reviewedUserName = itemView.findViewById(R.id.reviewedUserName);
        }
    }
}
