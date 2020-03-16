package com.lutongbahay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalHomeFoodMenuAdapter extends RecyclerView.Adapter<VerticalHomeFoodMenuAdapter.VerticalViewHolder> {

    private int TYPE_CLICK;

    public VerticalHomeFoodMenuAdapter(int check) {
        this.TYPE_CLICK = check ;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);
        return new VerticalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {

        if(TYPE_CLICK == 1){
            holder.imageSection.setOnClickListener(v -> {
                Navigation.findNavController(v).navigate(HomeFragmentDirections.openItemDetailFragment());
            });
            holder.ratingImg.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.toDishReviewFragment());
            });
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }


    class VerticalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgSet)
        RelativeLayout imageSection;
        @BindView(R.id.ratingImg)
        ImageView ratingImg;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
