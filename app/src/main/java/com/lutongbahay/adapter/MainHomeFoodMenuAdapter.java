package com.lutongbahay.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.rest.response.Data;
import com.lutongbahay.rest.response.NearMeItem;
import com.lutongbahay.utils.Constants;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainHomeFoodMenuAdapter extends RecyclerView.Adapter<MainHomeFoodMenuAdapter.MainHomeViewHolder> {

    Context context;
    Data data;

    public MainHomeFoodMenuAdapter(Context context, Data data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MainHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_main_home, parent, false);

        return new MainHomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHomeViewHolder holder, int position) {

        LinearLayoutManager horizontalLayoutManager= new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager verticalLayoutManager= new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        if (position == 0){
            holder.verticalRecycler.setLayoutManager(verticalLayoutManager);
            VerticalHomeFoodMenuAdapter verticalHomeFoodMenuAdapter = new VerticalHomeFoodMenuAdapter(1,data.getNearMe());
            holder.verticalRecycler.setAdapter(verticalHomeFoodMenuAdapter);
            holder.title.setText(CusinaApplication.getInstance().getResources().getString(R.string.BagongLutoNearMe));
            holder.subTitle.setText(CusinaApplication.getInstance().getResources().getString(R.string.BagongLutoNearMe));
            seeMoreClick(holder,11,holder.title.getText().toString());

        }else if (position == 1){
            holder.verticalRecycler.setLayoutManager(horizontalLayoutManager);
            HorizontalHomeProductAdapter horizontalHomeFoodMenuAdapter = new HorizontalHomeProductAdapter(context,data.getTopRated());
            holder.verticalRecycler.setAdapter(horizontalHomeFoodMenuAdapter);
            holder.title.setText(CusinaApplication.getInstance().getResources().getString(R.string.PatokNaPagkain));
            holder.subTitle.setText("");
            seeMoreClick(holder,12,holder.title.getText().toString());
        }else if (position == 2){
            holder.verticalRecycler.setLayoutManager(horizontalLayoutManager);
            HorizontalHomeFoodMenuAdapter horizontalHomeFoodMenuAdapter = new HorizontalHomeFoodMenuAdapter(context,data.getPreOrdered());
            holder.verticalRecycler.setAdapter(horizontalHomeFoodMenuAdapter);
            holder.title.setText(CusinaApplication.getInstance().getResources().getString(R.string.PalutoDishes));
            holder.subTitle.setText(CusinaApplication.getInstance().getResources().getString(R.string.shortTxtShort));
            seeMoreClick(holder,13,holder.title.getText().toString());
        }else if (position == 3){
            holder.verticalRecycler.setLayoutManager(verticalLayoutManager);
            VerticalHomeFoodMenuAdapter verticalHomeFoodMenuAdapter = new VerticalHomeFoodMenuAdapter(1,data.getScheduleMeals());
            holder.verticalRecycler.setAdapter(verticalHomeFoodMenuAdapter);
            holder.title.setText(CusinaApplication.getInstance().getResources().getString(R.string.IhahainSoonNearMe));
            holder.subTitle.setText(CusinaApplication.getInstance().getResources().getString(R.string.nearMeDishesTxtShort));
            seeMoreClick(holder,14,holder.title.getText().toString());
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MainHomeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.sub_title)
        TextView subTitle;
        @BindView(R.id.see_more)
        TextView seeMore;
        @BindView(R.id.vertical_recycler)
        RecyclerView verticalRecycler;


        public MainHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void seeMoreClick(MainHomeViewHolder holder,int val,String titleName){
        holder.seeMore.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("check",val);
            bundle.putString("titleName",titleName);
            Navigation.findNavController(view).navigate(R.id.FavouritesFragment,bundle);
        });
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
