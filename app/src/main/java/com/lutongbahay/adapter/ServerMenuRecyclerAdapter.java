package com.lutongbahay.adapter;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;

import java.io.File;

import butterknife.ButterKnife;

public class ServerMenuRecyclerAdapter extends RecyclerView.Adapter<ServerMenuRecyclerAdapter.MenuViewHolder> {


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_menu_list_item_on_profile,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigation.findNavController(holder.itemView).navigate(ProfileFragmentDirections.toCompletedDetails());
            }
        });

    }





    @Override
    public int getItemCount() {
        return 6;
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
