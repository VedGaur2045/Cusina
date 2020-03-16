package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragment;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragmentDirections;
import com.lutongbahay.main.fragments.cancelled_order.mvvm.CancelledOrderView;
import com.lutongbahay.main.fragments.my_orders_frag.MyOrdersFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CancelledOrderRecyclerAdapter extends RecyclerView.Adapter<CancelledOrderRecyclerAdapter.CancelledOrderViewHolder> {

    private int TYPE_CANCEL;

    public CancelledOrderRecyclerAdapter(int cancel) {
        this.TYPE_CANCEL = cancel;
    }

    @NonNull
    @Override
    public CancelledOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_completed_list_item, parent, false);
        return new CancelledOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledOrderViewHolder holder, int position) {

        if (TYPE_CANCEL == 1){
            holder.status.setText(CusinaApplication.getInstance().getResources().getString(R.string.CANCELLED_Txt));
            holder.status.setTextColor(CusinaApplication.getInstance().getResources().getColor(R.color._EC0000));
        }else if (TYPE_CANCEL == 2){
            holder.status.setText(CusinaApplication.getInstance().getResources().getString(R.string.DELIVERED_Txt));
            holder.status.setTextColor(CusinaApplication.getInstance().getResources().getColor(R.color._7BCC86));
        }


        holder.ORDER_DETAILS_Btn.setOnClickListener(view -> {
            if (TYPE_CANCEL == 1){
                Navigation.findNavController(view).navigate(MyOrdersFragmentDirections.toViewOrdersDetailsFragment("Cancelled Order"));
            }else{
                Navigation.findNavController(view).navigate(MyOrdersFragmentDirections.toViewOrdersDetailsFragment("Delivered Order"));
            }

        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class CancelledOrderViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ORDER_DETAILS_Btn)
        Button ORDER_DETAILS_Btn;
        @BindView(R.id.deliveredTxt)
        TextView status;

        public CancelledOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
