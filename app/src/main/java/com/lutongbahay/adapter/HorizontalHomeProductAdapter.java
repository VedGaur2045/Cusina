package com.lutongbahay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalHomeProductAdapter extends RecyclerView.Adapter<HorizontalHomeProductAdapter.ProductViewHolder> {
    private Context context;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_image_product_name, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        //homeList_TopRated((AppCompatActivity) context,Constants.LAT,Constants.LNG,Constants.TOKEN,holder,position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.productImg)
        ImageView productImg;
        @BindView(R.id.productName)
        TextView productName;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void homeList_TopRated(AppCompatActivity context, double lat, double lng, String token, ProductViewHolder holder, int position){
        HomeFragViewModel viewModel = new HomeFragViewModel();
        viewModel.homeList(context,token,lat,lng).observe(context,responseHomeList -> {
            if(responseHomeList == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.");
            } else {
                if (responseHomeList.getMessage() == null){
                    showErrorAlert(context, responseHomeList.getMessage());
                } else {
                    GlideApp.with(context).load(responseHomeList.getData().getTopRated().get(position).getImages()).placeholder(R.drawable.no_image_placeholder).into(holder.productImg);
                    holder.productName.setText(responseHomeList.getData().getTopRated().get(position).getName());
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
