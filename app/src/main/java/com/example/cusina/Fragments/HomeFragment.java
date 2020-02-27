package com.example.cusina.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.Activities.Choose_address;
import com.example.cusina.Activities.MyTrayActivity;
import com.example.cusina.Activities.Privacy_policy;
import com.example.cusina.AdapterClass.productListRecyclerAdapterPackage.adapterFile;
import com.example.cusina.AdapterClass.productListRecyclerAdapterPackage.viewHolderFile;
import com.example.cusina.AdapterClass.DishLoookingRecyclerHolder.dishHolderClass;
import com.example.cusina.AdapterClass.DishLoookingRecyclerHolder.listRecyclerMainClass;
import com.example.cusina.AdapterClass.productImageAndNameRecycler.productAdapter;
import com.example.cusina.AdapterClass.productImageAndNameRecycler.productHolder;
import com.example.cusina.R;
import com.example.cusina.SessionClass.SessionmanagerPreferance;
import com.example.cusina.UtilClasses.UtilClass;

public class HomeFragment extends Fragment {

    private RecyclerView dishView,dishViewSecond,listViewNear,dishlistViewNear;
    private RelativeLayout _trayOnHome;

    SessionmanagerPreferance session;

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

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        session = new SessionmanagerPreferance(getContext());

        root.findViewById(R.id.toolbarPageIcon).setVisibility(View.GONE);
        root.findViewById(R.id.homePageIcon).setVisibility(View.VISIBLE);

        root.findViewById(R.id.backImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Choose_address.class);
                intent.putExtra("id","1");
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getContext(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(intent, bndlAnimation);
            }
        });

        TextView locationOnToolbar = root.findViewById(R.id.locationName);

        locationOnToolbar.setText(session.getCurrentAddress());

        setIdOfView(root);

        UtilClass.setDividerOnRecycler(listViewNear, getContext());
        UtilClass.setDividerOnRecycler(dishlistViewNear, getContext());

        UtilClass.listSetHorizontal(dishView,getContext());
        UtilClass.listSetHorizontal(dishViewSecond,getContext());
        //listSetHorizontal(listViewNear);

        dishHolderClass[] holderClasses = new dishHolderClass[]{
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
                new dishHolderClass(R.mipmap.fish_img_6,"abc","4.0","250","Jaipur","sadgh","0.100","Available Fridays","Pick-up Only"),
        };

        productHolder[] holders = new productHolder[]{
                new productHolder("Abc",R.mipmap.fish_img_6),
                new productHolder("Abc",R.mipmap.fish_img_6),
                new productHolder("Abc",R.mipmap.fish_img_6),
                new productHolder("Abc",R.mipmap.fish_img_6),
                new productHolder("Abc",R.mipmap.fish_img_6),
                new productHolder("Abc",R.mipmap.fish_img_6),
        };

        viewHolderFile[] viewHolderFiles = new viewHolderFile[]{
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
                new viewHolderFile(productName[0],productRating[0],productPrice[0],productServingLeft[0],productPlace[0],productShop[0],productMinimumOrder[0],productDistance[0],productDeliveryFee[0],productCount[0],productTime[0],productImage[0]),
        };

        listRecyclerMainClass adapterFisrt = new listRecyclerMainClass(holderClasses,getContext());
        productAdapter productAdapter = new productAdapter(holders,getContext());
        adapterFile adapterFile = new adapterFile(viewHolderFiles,getContext(),1);

        UtilClass.listFixedSize(listViewNear,getContext());
//        listFixedSize(dishView);
//        listFixedSize(dishViewSecond);
        UtilClass.listFixedSize(dishlistViewNear,getContext());

        listViewNear.setAdapter(adapterFile);
        dishView.setAdapter(productAdapter);
        dishViewSecond.setAdapter(adapterFisrt);
        dishlistViewNear.setAdapter(adapterFile);

        //listViewNear.setAdapter(new ListViewNearDishAdapterClass(getContext(),productName,productRating,productPrice,productServingLeft,productPlace,productShop,productMinimumOrder,productDistance,productDeliveryFee,productCount,productTime,productImage));

        //dishlistViewNear.setAdapter(new ListViewNearDishAdapterClass(getContext(),productName,productRating,productPrice,productServingLeft,productPlace,productShop,productMinimumOrder,productDistance,productDeliveryFee,productCount,productTime,productImage));

        _trayOnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getContext(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(new Intent(getContext(), MyTrayActivity.class), bndlAnimation);
            }
        });

        return root;
    }

    private void setIdOfView(View root){
        dishView = root.findViewById(R.id.list_item_horizontal_first);
        dishViewSecond = root.findViewById(R.id.list_item_horizontal_second);
        listViewNear = root.findViewById(R.id.list_item_vertical);
        dishlistViewNear = root.findViewById(R.id.second_list_item_vertical);
        _trayOnHome = root.findViewById(R.id._trayOnHome);
    }



}