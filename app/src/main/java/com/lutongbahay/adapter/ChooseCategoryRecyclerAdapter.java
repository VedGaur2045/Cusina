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

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseCategoryRecyclerAdapter extends RecyclerView.Adapter<ChooseCategoryRecyclerAdapter.ChooseCategoryViewHolder> {

    @NonNull
    @Override
    public ChooseCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_category_list, parent, false);
        return new ChooseCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseCategoryViewHolder holder, int position) {
        holder.categoryNameLayout.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCompletedDetails());
        });
    }

    @Override
    public int getItemCount() {
        return 20;
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
