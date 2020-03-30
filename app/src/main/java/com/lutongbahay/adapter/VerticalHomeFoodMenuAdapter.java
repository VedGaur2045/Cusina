package com.lutongbahay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.favourites.FavouritesFragmentDirections;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragView;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalHomeFoodMenuAdapter extends RecyclerView.Adapter<VerticalHomeFoodMenuAdapter.VerticalViewHolder> {

    private int TYPE_CLICK,CONDITION_CHECK;
    public Context context;

    public VerticalHomeFoodMenuAdapter(int check,int conditionCheck) {
        this.TYPE_CLICK = check ;
        this.CONDITION_CHECK = conditionCheck;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);
        return new VerticalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {

//        if(CONDITION_CHECK == 51){
//            homeList_NearMe((AppCompatActivity) context,Constants.LAT,Constants.LNG,Constants.TOKEN,holder,position);
//        } else if(CONDITION_CHECK == 52){
//            homeList_ScheduleMeals((AppCompatActivity) context,Constants.LAT,Constants.LNG,Constants.TOKEN,holder,position);
//        }

        if(TYPE_CLICK == 1){
            holder.imageSection.setOnClickListener(v -> {
                Navigation.findNavController(v).navigate(FavouritesFragmentDirections.openItemDetailFragment());
            });
            holder.ratingImg.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(FavouritesFragmentDirections.toDishReviewFragment());
            });
            //homeList((AppCompatActivity) context, Constants.LAT,Constants.LNG,Constants.TOKEN,holder,position);
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }


    class VerticalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgSet)
        RelativeLayout imageSection;
        @BindView(R.id.ratingImg)
        ImageView ratingImg;
        @BindView(R.id.productImg)
        ImageView productImg;
        @BindView(R.id.favouriteImg)
        ImageView  favouriteImg;
        @BindView(R.id.likeCount)
        TextView likeCount;
        @BindView(R.id.productTime)
        TextView productTime;
        @BindView(R.id.productName)
        TextView productName;
        @BindView(R.id.productRatingCount)
        TextView productRatingCount;
        @BindView(R.id.productShopName)
        TextView productShopName;
        @BindView(R.id.productPlaceName)
        TextView productPlaceName;
        @BindView(R.id.productPrice)
        TextView productPrice;
        @BindView(R.id.productServingLeft)
        TextView productServingLeft;
        @BindView(R.id.productMinimumOrderCount)
        TextView productMinimumOrderCount;
        @BindView(R.id.productDeliveryDistance)
        TextView productDeliveryDistance;
        @BindView(R.id.productDeliveryFee)
        TextView productDeliveryFee;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void homeList_NearMe(AppCompatActivity context, double lat, double lng, String token, VerticalViewHolder holder, int position){
        HomeFragViewModel viewModel = new HomeFragViewModel();
        viewModel.homeList(context,token,lat,lng).observe(context,responseHomeList -> {
            if(responseHomeList == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.");
            } else {
                if (responseHomeList.getMessage() == null){
                    showErrorAlert(context, responseHomeList.getMessage());
                } else {
                    holder.likeCount.setText(responseHomeList.getData().getNearMe().get(position).getLikes());
                    holder.productDeliveryDistance.setText(responseHomeList.getData().getNearMe().get(position).getDistance());
                    holder.productDeliveryFee.setText("Delivery Fee : PHP "+responseHomeList.getData().getNearMe().get(position).getDeliveryPrice());
                    GlideApp.with(context).load(responseHomeList.getData().getNearMe().get(position).getImages()).placeholder(R.drawable.no_image_placeholder).into(holder.productImg);
                    holder.productMinimumOrderCount.setText(responseHomeList.getData().getNearMe().get(position).getMinQty());
                    holder.productName.setText(responseHomeList.getData().getNearMe().get(position).getName());
                    holder.productPrice.setText(responseHomeList.getData().getNearMe().get(position).getPrice());
                    holder.productTime.setText(responseHomeList.getData().getNearMe().get(position).getPreparationTime()+" mins");
                    holder.productRatingCount.setText(responseHomeList.getData().getNearMe().get(position).getRating()+".0");
                    holder.productServingLeft.setText(responseHomeList.getData().getNearMe().get(position).getTotalQty()+" Serving Left");
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    private void homeList_ScheduleMeals(AppCompatActivity context, double lat, double lng, String token, VerticalViewHolder holder, int position){
        HomeFragViewModel viewModel = new HomeFragViewModel();
        viewModel.homeList(context,token,lat,lng).observe(context,responseHomeList -> {
            if(responseHomeList == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.");
            } else {
                if (responseHomeList.getMessage() == null){
                    showErrorAlert(context, responseHomeList.getMessage());
                } else {
                    holder.likeCount.setText(responseHomeList.getData().getScheduleMeals().get(position).getLikes());
                    holder.productDeliveryDistance.setText(responseHomeList.getData().getScheduleMeals().get(position).getDistance());
                    holder.productDeliveryFee.setText("Delivery Fee : PHP "+responseHomeList.getData().getScheduleMeals().get(position).getDeliveryPrice());
                    GlideApp.with(context).load(responseHomeList.getData().getScheduleMeals().get(position).getImages()).placeholder(R.drawable.no_image_placeholder).into(holder.productImg);
                    holder.productMinimumOrderCount.setText(responseHomeList.getData().getScheduleMeals().get(position).getMinQty());
                    holder.productName.setText(responseHomeList.getData().getScheduleMeals().get(position).getName());
                    holder.productPrice.setText(responseHomeList.getData().getScheduleMeals().get(position).getPrice());
                    holder.productTime.setText(responseHomeList.getData().getScheduleMeals().get(position).getPreparationTime()+" mins");
                    holder.productRatingCount.setText(responseHomeList.getData().getScheduleMeals().get(position).getRating()+".0");
                    holder.productServingLeft.setText(responseHomeList.getData().getScheduleMeals().get(position).getTotalQty()+" Serving Left");
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
