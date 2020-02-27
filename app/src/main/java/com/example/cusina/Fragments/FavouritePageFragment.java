package com.example.cusina.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cusina.AdapterClass.DishLoookingRecyclerHolder.listRecyclerMainClass;
import com.example.cusina.AdapterClass.productImageAndNameRecycler.productAdapter;
import com.example.cusina.AdapterClass.productListRecyclerAdapterPackage.adapterFile;
import com.example.cusina.AdapterClass.productListRecyclerAdapterPackage.viewHolderFile;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class FavouritePageFragment extends Fragment {
    private TextView titleBarTxt;
    private RecyclerView favDishListView;

    /* Recycler list code Array */

    private String[] productName = {"abc","ashj","sdjf","gsdtuyfu","sdahfj","sgdhjfg"};
    private String[] productShop = {"efrf","iouolj","iujhi","ioikp","uyhihik","i8i09"};
    private String[] productPlace = {"Jodhpur","Jaipur","Kota","Udaipur","Ajmer","Pali"};
    private String[] productPrice = {"250","300","600","400","120","800"};
    private String[] productServingLeft = {"2","3","2","12","2","1"};
    private String[] productMinimumOrder = {"8","5","2","6","4","3"};
    private String[] productDistance = {"0.50","0.20","0.30","4.00","0.35","0.60"};
    private String[] productDeliveryFee = {"50.00","20.00","30.00","40.00","25.00","60.00"};
    private String[] productTime = {"12","13","13","13","13","13"};
    private String[] productCount = {"56","322","65","78","96","100"};
    private String[] productRating = {"4.0","4.0","4.0","4.0","4.0","4.0"};
    private Integer[] productImage = {R.mipmap.fish_img_6,R.mipmap.fish_img_6,R.mipmap.fish_img_6,R.mipmap.fish_img_6,R.mipmap.fish_img_6,R.mipmap.fish_img_6};

    /* END */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite_page, container, false);

        setObjectId(view);

        titleBarTxt.setText(getString(R.string.favouriteTxt));
        view.findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        view.findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        setFavDishListViewMethod();

        return view;
    }

    private void setObjectId(View root){
        titleBarTxt = root.findViewById(R.id.titleName);
        favDishListView = root.findViewById(R.id.favDishListView);
    }

    private void setFavDishListViewMethod(){
        viewHolderFile[] viewHolderFiles = new viewHolderFile[]{
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
        };

        adapterFile adapterFile = new adapterFile(viewHolderFiles,getContext(),2);

        UtilClass.listFixedSize(favDishListView,getContext());

        UtilClass.setDividerOnRecycler(favDishListView, getContext());

        favDishListView.setAdapter(adapterFile);

    }

}
