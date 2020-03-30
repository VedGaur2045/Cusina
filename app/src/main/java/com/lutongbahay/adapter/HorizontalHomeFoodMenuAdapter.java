package com.lutongbahay.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.Api;
import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.main.fragments.map_view.MapViewFragmentDirections;
import com.lutongbahay.utils.Constants;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalHomeFoodMenuAdapter extends RecyclerView.Adapter<HorizontalHomeFoodMenuAdapter.HorizontalHomeViewHolder>{
    private Context context;

    @NonNull
    @Override
    public HorizontalHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_paluto_dishes, parent, false);
        return new HorizontalHomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalHomeViewHolder holder, int position) {
        //homeList_PreOrdered((AppCompatActivity) context, Constants.LAT,Constants.LNG,Constants.TOKEN,holder,position);

        holder.itemView.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(MapViewFragmentDirections.openItemDetailFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class HorizontalHomeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.productImage)
        ImageView productImage;
        @BindView(R.id.productName)
        TextView productName;
        @BindView(R.id.productRatingCount)
        TextView productRatingCount;
        @BindView(R.id.productShopName)
        TextView productShopName;
        @BindView(R.id.productPlaceName)
        TextView productPlaceName;
        @BindView(R.id.productAvailibility)
        TextView productAvailibility;
        @BindView(R.id.productDeliveryDistance)
        TextView productDeliveryDistance;
        @BindView(R.id.productDeliveryPickUp)
        TextView productDeliveryPickUp;
        @BindView(R.id.productMoney)
        TextView productMoney;
        @BindView(R.id.productPreOrder)
        TextView productPreOrder;

        public HorizontalHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void homeList_PreOrdered(AppCompatActivity context, double lat, double lng, String token, HorizontalHomeViewHolder holder, int position){
        HomeFragViewModel viewModel = new HomeFragViewModel();
        viewModel.homeList(context,token,lat,lng).observe(context,responseHomeList -> {
            if(responseHomeList == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.");
            } else {
                if (responseHomeList.getMessage() == null){
                    showErrorAlert(context, responseHomeList.getMessage());
                } else {
                    GlideApp.with(context).load(responseHomeList.getData().getPreOrdered().get(position).getImages()).placeholder(R.drawable.no_image_placeholder).into(holder.productImage);
                    holder.productName.setText(responseHomeList.getData().getPreOrdered().get(position).getName());
                    holder.productRatingCount.setText(responseHomeList.getData().getPreOrdered().get(position).getRating());
                    holder.productDeliveryDistance.setText(responseHomeList.getData().getPreOrdered().get(position).getDistance());
                    holder.productMoney.setText(responseHomeList.getData().getPreOrdered().get(position).getPrice());
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
