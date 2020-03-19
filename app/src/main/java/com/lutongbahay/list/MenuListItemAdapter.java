package com.lutongbahay.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.menu.MenuFragmentDirections;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MenuListItemAdapter extends BaseAdapter {
    private Context context;
    private boolean check;

//    public menuListItemOnProfileAdapter(Context context, ArrayList<menuListItemOnProfileModel> arrayListOfItem) {
//        this.context = context;
//        this.arrayListOfItem = arrayListOfItem;
//    }


    public MenuListItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View mView;

        if(view == null){
            mView = LayoutInflater.from(context).inflate(R.layout.adapter_menu_list_item_on_profile,null);

            ImageView blubImg = mView.findViewById(R.id.blubImg);
            TextView soldOut = mView.findViewById(R.id.soldOut);
            ImageView productImg = mView.findViewById(R.id.productImg);
            TextView productName = mView.findViewById(R.id.productName);
            TextView productPrice = mView.findViewById(R.id.productPrice);
            TextView productLike = mView.findViewById(R.id.likeCount);
            TextView productListedTime = mView.findViewById(R.id.productListTime);
            TextView productServingTime = mView.findViewById(R.id.servingCount);
            Button refillBtn = mView.findViewById(R.id.refillBtn);

            DecimalFormat dFormat = new DecimalFormat("#0.00");

            if(check){
                soldOut.setVisibility(View.GONE);
            } else {
                soldOut.setVisibility(View.VISIBLE);
            }

            refillBtn.setOnClickListener(view1 -> {
              //  Navigation.findNavController(view).navigate(MenuFragmentDirections.toCompletedDetails());
            });

        } else {
            mView = view;
        }

        return mView;
    }
}
