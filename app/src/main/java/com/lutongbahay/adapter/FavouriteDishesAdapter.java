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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.favourites.FavouritesFragmentDirections;
import com.lutongbahay.rest.response.DataItem;
import com.lutongbahay.rest.response.DataItemKitchenMenu;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteDishesAdapter extends RecyclerView.Adapter<FavouriteDishesAdapter.FavouriteDishesHolder> {
    private int TYPE_CLICK;
    public Context context;
    List<DataItem> dataItemList = new ArrayList<>();

    public FavouriteDishesAdapter(int check,List<DataItem> dataItemList) {
        this.TYPE_CLICK = check ;
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public FavouriteDishesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);
        return new FavouriteDishesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteDishesHolder holder, int position) {
        System.out.println("Size : "+dataItemList.size());
        holder.bindNearData(dataItemList.get(position));

        if(TYPE_CLICK == 1){
            holder.imageSection.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("itemId",dataItemList.get(position).getId());
                Navigation.findNavController(v).navigate(R.id.detailFragment,bundle);
            });
            holder.ratingImg.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(FavouritesFragmentDirections.toDishReviewFragment());
            });
        }

    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }


    class FavouriteDishesHolder extends RecyclerView.ViewHolder{

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

        public FavouriteDishesHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindNearData(@NotNull DataItem dataItem) {
            System.out.println("Price : "+dataItem.getDeliveryPrice());
            productName.setText(dataItem.getName());
            productMinimumOrderCount.setText("" + dataItem.getMinQty());
            for(int i=0;i<dataItem.getImages().size();i++){
                GlideApp.with(context).load(dataItem.getImages().get(i)).placeholder(R.drawable.no_image_placeholder).into(productImg);
            }
            productServingLeft.setText(dataItem.getTotalQty()+" Serving Left");
            productTime.setText(dataItem.getPreparationTime() + " mins");
            productDeliveryFee.setText("Delivery Fee : PHP "+Integer.toString(dataItem.getDeliveryPrice()));
            productDeliveryDistance.setText(dataItem.getDistance());
            productRatingCount.setText(""+dataItem.getRating());
            if(dataItem.getKitchen() == null){
                productPlaceName.setText("");
            } else {
                productPlaceName.setText("by "+dataItem.getKitchen());
            }
            if(dataItem.getUser() == null){
                productShopName.setText("");
            } else {
                productShopName.setText(dataItem.getUser().getName());
            }
            likeCount.setText(Integer.toString(dataItem.getLikes()));
        }
    }


    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }
}
