package com.example.cusina.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.cusina.Activities.Home;
import com.example.cusina.AdapterClass.viewPagerAdapter;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;
import com.google.android.material.tabs.TabLayout;

public class ordersFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_orders, container, false);

        root.findViewById(R.id.toolbarPageIcon).setVisibility(View.VISIBLE);
        root.findViewById(R.id.homePageIcon).setVisibility(View.GONE);
        root.findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        TextView titleName = root.findViewById(R.id.titleName);

        titleName.setText(getString(R.string.MyOrders));

        root.findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(getContext(), R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(intent,bndlAnimation);
                //getActivity().finish();
            }
        });

        viewPager = root.findViewById(R.id.viewpager);
        tabLayout = root.findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(3);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        try {
            if(getArguments().getInt("val") == 10){
                setupViewPagerOnCompletedFragment(viewPager,1);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return root;
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter adapter = new viewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ProcessingFragment(), getString(R.string.Processing));
        adapter.addFragment(new CompletedFragment(), getString(R.string.Completed));
        adapter.addFragment(new CancelledFragment(), getString(R.string.Cancelled));
        viewPager.setAdapter(adapter);
    }

    private void setupViewPagerOnCompletedFragment(ViewPager viewPager, int position) {

        viewPager.setCurrentItem(position);
    }

}