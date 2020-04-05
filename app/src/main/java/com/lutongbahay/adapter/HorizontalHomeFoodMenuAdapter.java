package com.lutongbahay.adapter;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
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
import com.lutongbahay.rest.response.PreOrderedItem;
import com.lutongbahay.utils.Constants;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalHomeFoodMenuAdapter extends RecyclerView.Adapter<HorizontalHomeFoodMenuAdapter.HorizontalHomeViewHolder>{
    private Context context;
    List<PreOrderedItem> preOrderedItemList;

    public HorizontalHomeFoodMenuAdapter(Context context, List<PreOrderedItem> preOrderedItemList) {
        this.context = context;
        this.preOrderedItemList = preOrderedItemList;
    }

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

        holder.bindPreOrder(preOrderedItemList.get(position));

        holder.itemView.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(MapViewFragmentDirections.openItemDetailFragment());
        });
    }

    @Override
    public int getItemCount() {
        return preOrderedItemList.size();
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

        public void bindPreOrder(PreOrderedItem preOrderedItem){
            productName.setText(preOrderedItem.getName());
            for(int i=0;i<preOrderedItem.getImages().size();i++){
                GlideApp.with(context).load(preOrderedItem.getImages().get(i)).placeholder(R.drawable.no_image_placeholder).into(productImage);
            }
            productRatingCount.setText(Integer.toString(preOrderedItem.getRating()));
            productMoney.setText("PHP "+preOrderedItem.getPrice());
            productDeliveryDistance.setText(preOrderedItem.getDistance());
            if(preOrderedItem.getKitchen() == null){
                productPlaceName.setText("");
            } else {
                productPlaceName.setText(preOrderedItem.getKitchen().getName());
            }
            if(preOrderedItem.getUser() == null){
                productShopName.setText("");
            } else {
                productShopName.setText("by "+preOrderedItem.getUser().getName());
            }
            productPlaceName.setOnClickListener(view -> {
                Bundle bundle = new Bundle();
                bundle.putInt("check",15);
                bundle.putString("titleName",preOrderedItem.getKitchen().getName()+" Kitchen Menu");
                bundle.putInt("kitchen_id",preOrderedItem.getKitchen().getId());
                Navigation.findNavController(view).navigate(R.id.FavouritesFragment,bundle);
            });

        }
    }


}
