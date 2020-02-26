package com.example.cusina.AdapterClass.MenuListItemProfileAdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cusina.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class menuListItemOnProfileAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<menuListItemOnProfileModel> arrayListOfItem = new ArrayList<>();
    private boolean check;

    public menuListItemOnProfileAdapter(Context context, ArrayList<menuListItemOnProfileModel> arrayListOfItem) {
        this.context = context;
        this.arrayListOfItem = arrayListOfItem;
    }

    @Override
    public int getCount() {
        return arrayListOfItem.size();
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
            mView = LayoutInflater.from(context).inflate(R.layout.menu_list_item_on_profile_layout,null);

            check = arrayListOfItem.get(i).isCheck();

            ImageView blubImg = mView.findViewById(R.id.blubImg);
            TextView soldOut = mView.findViewById(R.id.soldOut);
            ImageView productImg = mView.findViewById(R.id.productImg);
            TextView productName = mView.findViewById(R.id.productName);
            TextView productPrice = mView.findViewById(R.id.productPrice);
            TextView productLike = mView.findViewById(R.id.likeCount);
            TextView productListedTime = mView.findViewById(R.id.productListTime);
            TextView productServingTime = mView.findViewById(R.id.servingCount);
            Button refillBtn = mView.findViewById(R.id.refillBtn);
            Button promoteBtn = mView.findViewById(R.id.promoteBtn);

            double price = arrayListOfItem.get(i).getProductPrice();

            DecimalFormat dFormat = new DecimalFormat("#0.00");

            productImg.setImageResource(arrayListOfItem.get(i).getImage());
            productName.setText(arrayListOfItem.get(i).getProductName());
            productPrice.setText(dFormat.format(price));
            productLike.setText(String.valueOf(arrayListOfItem.get(i).getLikesCount()+" "));
            productListedTime.setText(arrayListOfItem.get(i).getListtime());
            productServingTime.setText(String.valueOf(arrayListOfItem.get(i).getServingLeft()+" "));

            if(check){
                soldOut.setVisibility(View.GONE);
                refillBtn.setVisibility(View.GONE);
            } else {
                soldOut.setVisibility(View.VISIBLE);
                refillBtn.setVisibility(View.VISIBLE);
                promoteBtn.setVisibility(View.GONE);
            }

            refillBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            promoteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        } else {
            mView = view;
        }

        return mView;
    }

}
