package com.example.cusina.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.cusina.Activities.Choose_address;
import com.example.cusina.Activities.SellFoodWithLutongBahayActivity;
import com.example.cusina.AdapterClass.viewPagerAdapter;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;
import com.google.android.material.tabs.TabLayout;

public class Profile_Fragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RelativeLayout setting_acc,saved_place,rewards,sell_food,fbButton,fbButtonSecond;
    private RatingBar AVL_rating;
    private View prfoileLayout,sellerProfilelayout;
    private ViewStub stub;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        setObjectId(root);

//        stub.setLayoutResource(R.layout.owner_detail_layout);
//        sellerProfileLayoutID(stub);
//        sellerProfileMethod();

        try {
            if(UtilClass.getVal == 12){
                stub.setLayoutResource(R.layout.owner_detail_layout);
                sellerProfileLayoutID(stub);
                sellerProfileMethod();
            } else {
                stub.setLayoutResource(R.layout.profile_layout);
                profileLayoutID(stub);
                defaultProfileWorkMethod();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return root;
    }

    private void defaultProfileWorkMethod(){
        setting_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensetting();
            }
        });

        saved_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedplace();
            }
        });

        sell_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellFood();
            }
        });

        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseAddress();
            }
        });

        fbButtonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseAddress();
            }
        });
    }

    private void sellerProfileMethod(){
        AVL_rating.setRating((float) 4.0);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new MenuListFragment(),getString(R.string.Menu));
        viewPagerAdapter.addFragment(new OrdersListFragment(),getString(R.string.orders));
        viewPagerAdapter.addFragment(new AboutFragment(),getString(R.string.About));
        viewPager.setAdapter(viewPagerAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void chooseAddress() {
        Intent intent=new Intent(getActivity(), Choose_address.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getActivity(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void sellFood() {
        Intent intent=new Intent(getActivity(), SellFoodWithLutongBahayActivity.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getActivity(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setObjectId(View root){

        stub = (ViewStub) root.findViewById(R.id.layout_stub);

    }

    private void profileLayoutID(ViewStub stub){

        View inflated = stub.inflate();

        setting_acc = inflated.findViewById(R.id.setting);
        saved_place = inflated.findViewById(R.id.savedplace);
        sell_food = inflated.findViewById(R.id.sellfood);
        rewards = inflated.findViewById(R.id.rewards);
        fbButton = inflated.findViewById(R.id.fbbuuton);
        fbButtonSecond = inflated.findViewById(R.id.fbButtonSecond);
    }

    private void sellerProfileLayoutID(ViewStub stub){

        View inflated = stub.inflate();

        AVL_rating = inflated.findViewById(R.id.AVL_rating);

        viewPager = inflated.findViewById(R.id.viewpager);
        tabLayout = inflated.findViewById(R.id.tabs);
    }


    private void opensetting(){
        Fragment setting = new Setting_Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.silde_in_left, R.animator.silde_out_left,
                R.animator.silde_out_right, R.animator.silde_in_right);
        transaction.replace(R.id.profile, setting );

        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void savedplace(){
        Intent intent=new Intent(getActivity(), Choose_address.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getActivity(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);

    }
}
