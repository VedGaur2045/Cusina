package com.lutongbahay.adapter;

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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseCategoryRecyclerAdapter extends RecyclerView.Adapter<ChooseCategoryRecyclerAdapter.ChooseCategoryViewHolder> {

    private ArrayList<String> dishCategoryList = new ArrayList<>();

    public ChooseCategoryRecyclerAdapter(ArrayList<String> dishCategoryList) {
        this.dishCategoryList = dishCategoryList;
    }

    @NonNull
    @Override
    public ChooseCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_category_list, parent, false);
        return new ChooseCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseCategoryViewHolder holder, int position) {

        for(int i=0;i<dishCategoryList.size();i++){
            holder.categoryName.setText(dishCategoryList.get(i));
        }

        holder.categoryNameLayout.setOnClickListener(view -> Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCompletedDetails()));
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
