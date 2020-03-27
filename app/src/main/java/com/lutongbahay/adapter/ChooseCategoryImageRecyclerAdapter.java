package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseCategoryImageRecyclerAdapter extends RecyclerView.Adapter<ChooseCategoryImageRecyclerAdapter.ChooseCategoryImageViewHolder> {

    @NonNull
    @Override
    public ChooseCategoryImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_choose_category,parent,false);
        return new ChooseCategoryImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseCategoryImageViewHolder holder, int position) {
        holder.imageFirst.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCameraSecondFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ChooseCategoryImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageFirst)
        ImageView imageFirst;
        public ChooseCategoryImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
