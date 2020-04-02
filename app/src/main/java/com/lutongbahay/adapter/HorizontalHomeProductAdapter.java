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
import com.lutongbahay.rest.response.PreOrderedItem;
import com.lutongbahay.rest.response.ScheduleMealsItem;
import com.lutongbahay.rest.response.TopRatedItem;
import com.lutongbahay.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalHomeProductAdapter extends RecyclerView.Adapter<HorizontalHomeProductAdapter.ProductViewHolder> {
    private Context context;

    List<TopRatedItem> mealsItems;

    public HorizontalHomeProductAdapter(Context context, List<TopRatedItem> mealsItems) {
        this.context = context;
        this.mealsItems = mealsItems;
    }

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
            holder.bindTopRated(mealsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mealsItems.size();
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


        public void bindTopRated(TopRatedItem topRatedItem){
            productName.setText(topRatedItem.getName());
            for(int i=0;i<topRatedItem.getImages().size();i++) {
                GlideApp.with(context).load(topRatedItem.getImages().get(i)).placeholder(R.drawable.no_image_placeholder).into(productImg);
            }
        }
    }




    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
