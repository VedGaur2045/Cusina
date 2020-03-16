package com.lutongbahay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderSummaryItemRecyclerAdapter extends RecyclerView.Adapter<OrderSummaryItemRecyclerAdapter.OrderSummaryViewHolder> {

    String type = "";
    Context context;
    public OrderSummaryItemRecyclerAdapter(Context context,String type) {
        this.type = type;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_orders_list_on_fragment_button, parent, false);
        return new OrderSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummaryViewHolder holder, int position) {
        holder.rateDish.setVisibility(View.GONE);
        if (type.equalsIgnoreCase("Cancelled Order")){
            holder.productNameCancelled.setVisibility(View.VISIBLE);
        }else if (type.equalsIgnoreCase("Delivered Order")){
            holder.productNameDelivered.setVisibility(View.VISIBLE);
            holder.rateDish.setVisibility(View.VISIBLE);
        }else if (type.equalsIgnoreCase("Processing Order")){
            holder.productNameProcessingDeliveryAndPickup.setVisibility(View.VISIBLE);
        }

        holder.rateDish.setOnClickListener(v -> openRateServer(context));
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class OrderSummaryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.productNameDelivered)
        TextView productNameDelivered;
        @BindView(R.id.productNameCancelled)
        TextView productNameCancelled;
        @BindView(R.id.productNameProcessingDeliveryAndPickup)
        TextView productNameProcessingDeliveryAndPickup;
        @BindView(R.id.RateDish)
        Button rateDish;

        public OrderSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    private void openRateServer(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.set_review_layout_for_dish, null);



        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setView(popupView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        assert window != null;

        dialog.show();
        ImageButton closeBtn = popupView.findViewById(R.id.closeImgBtn);
        Button getStarted = popupView.findViewById(R.id.submitBtn);

        closeBtn.setOnClickListener(v -> dialog.dismiss());
        getStarted.setOnClickListener(v -> dialog.dismiss());
    }
}
