package com.lutongbahay.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragment;
import com.lutongbahay.main.fragments.complete_details.mvvm.CompletedDetailsView;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseCategoryRecyclerAdapter extends RecyclerView.Adapter<ChooseCategoryRecyclerAdapter.ChooseCategoryViewHolder> {

    private ArrayList<String> dishCategoryList = new ArrayList<>();
    private ArrayList<String> dishImageList = new ArrayList<>();

    public ChooseCategoryRecyclerAdapter(Context context, ArrayList<String> dishCategoryList, ArrayList<String> dishImageList) {
        this.dishCategoryList = dishCategoryList;
        this.dishImageList = dishImageList;
    }

    @NonNull
    @Override
    public ChooseCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_category_list, parent, false);
        return new ChooseCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseCategoryViewHolder holder, int position) {

        holder.categoryName.setText(dishCategoryList.get(position));
        holder.categoryName.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("categoryName",holder.categoryName.getText().toString());
//            if (completedDetails != null){
//                Logger.ErrorLog("CALLBACK","RECEIVED");
//                completedDetails.mediaCallBack(dishImageList);
//            }
            Navigation.findNavController(view).navigate(R.id.CompletedDetailsFragment,bundle);
        });
    }

    @Override
    public int getItemCount() {
        return dishCategoryList.size();
    }

    class ChooseCategoryViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.categoryNameLayout)
        RelativeLayout categoryNameLayout;
        @BindView(R.id.categoryName)
        TextView categoryName;

        public ChooseCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
