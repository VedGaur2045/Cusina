package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.main.fragments.map_view.MapViewFragmentDirections;

public class HorizontalHomeFoodMenuAdapter extends RecyclerView.Adapter<HorizontalHomeFoodMenuAdapter.HorizontalHomeViewHolder>{


    @NonNull
    @Override
    public HorizontalHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_paluto_dishes, parent, false);
        return new HorizontalHomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalHomeViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(MapViewFragmentDirections.openItemDetailFragment());
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class HorizontalHomeViewHolder extends RecyclerView.ViewHolder{

        public HorizontalHomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
