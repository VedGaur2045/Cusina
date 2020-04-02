package com.lutongbahay.adapter;

import android.content.Context;
import android.os.Bundle;
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
import com.lutongbahay.main.fragments.favourites.mvvm.FavouriteViewModel;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragView;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.rest.response.NearMeItem;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalHomeFoodMenuAdapter extends RecyclerView.Adapter<VerticalHomeFoodMenuAdapter.VerticalViewHolder> {

    private int TYPE_CLICK;
    public Context context;
    List<NearMeItem> nearMeItemList = new ArrayList<>();

    public VerticalHomeFoodMenuAdapter(int check,List<NearMeItem> nearMeItemList) {
        this.TYPE_CLICK = check ;
        this.nearMeItemList = nearMeItemList;
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

        holder.bindNearData(nearMeItemList.get(position));

        if(TYPE_CLICK == 1){
            holder.imageSection.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("itemId",nearMeItemList.get(position).getId());
                Navigation.findNavController(v).navigate(R.id.detailFragment,bundle);
            });
            holder.ratingImg.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(FavouritesFragmentDirections.toDishReviewFragment());
            });
        }

    }

    @Override
    public int getItemCount() {
        return nearMeItemList.size();
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

        public void bindNearData(NearMeItem nearMeItem) {
            System.out.println("Price : "+nearMeItem.getDeliveryPrice());
            productName.setText(nearMeItem.getName());
            productMinimumOrderCount.setText("" + nearMeItem.getMinQty());
            for(int i=0;i<nearMeItem.getImages().size();i++){
                GlideApp.with(context).load(nearMeItem.getImages().get(i)).placeholder(R.drawable.no_image_placeholder).into(productImg);
            }
            productServingLeft.setText(nearMeItem.getTotalQty()+" Serving Left");
            productTime.setText(nearMeItem.getPreparationTime() + " mins");
            productDeliveryFee.setText("Delivery Fee : PHP "+Integer.toString(nearMeItem.getDeliveryPrice()));
            productDeliveryDistance.setText(nearMeItem.getDistance());
            productRatingCount.setText(""+nearMeItem.getRating());
            if(nearMeItem.getKitchen() == null){
                productPlaceName.setText("");
            } else {
                productPlaceName.setText(nearMeItem.getKitchen().getName());
            }
            if(nearMeItem.getUser() == null){
                productShopName.setText("");
            } else {
                productShopName.setText("by "+nearMeItem.getUser().getName());
            }
            likeCount.setText(Integer.toString(nearMeItem.getLikes()));
        }
    }


    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }
}
