package com.example.lutongbahay.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.lutongbahay.Fragments.Earn_Rewards_Fragment;
import com.example.lutongbahay.Fragments.HomeFragment;
import com.example.lutongbahay.Fragments.MapsActivity;
import com.example.lutongbahay.Fragments.Profile_Fragment;
import com.example.lutongbahay.Fragments.SearchFragment;
import com.example.lutongbahay.Fragments.fragmentUtils;
import com.example.lutongbahay.Fragments.ordersFragment;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    Fragment homeFrag = new HomeFragment();
    Fragment searchFrag = new SearchFragment();
    Fragment ordersFrag = new ordersFragment();
    Fragment earnRewardsFrag = new Earn_Rewards_Fragment();
    Fragment accountFrag = new Profile_Fragment();

    FragmentManager fm = getSupportFragmentManager();
    public Fragment active = homeFrag;

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.redStatusBar(this);
        }

        try{
            if(getIntent().getExtras().getInt("valFromTUPage") == 12){
                UtilClass.getVal = getIntent().getExtras().getInt("valFromTUPage");
            } else {
                UtilClass.getVal = 0;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        navView = findViewById(R.id.nav_view);

        navView.setSelectedItemId(R.id.navigation_home);
        navView.setEnabled(false);
        fm.beginTransaction().add(R.id.nav_host_fragment, accountFrag, "3").hide(accountFrag).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, earnRewardsFrag, "3").hide(earnRewardsFrag).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, ordersFrag, "3").hide(ordersFrag).commit();
        //fm.beginTransaction().add(R.id.nav_host_fragment, searchFrag, "2").hide(searchFrag).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment,homeFrag, "1").commit();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        try{
            if(getIntent().getExtras().getInt("valFromTUPage") == 12){
                Bundle bundle = new Bundle();
                bundle.putInt("val",11);
                Profile_Fragment profileFragment = new Profile_Fragment();
                profileFragment.setArguments(bundle);

                fm.beginTransaction().hide(active).show(profileFragment).commit();
                active = profileFragment;

                navView.setSelectedItemId(R.id.navigation_account);
            }
        } catch (Exception e){
            Log.e("Exception2 : ",e.toString());
        }

    }

    public void changeMenu(int menuId){
        navView.setSelectedItemId(menuId);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(homeFrag).commit();
                    active = homeFrag;
                    return true;
                case R.id.navigation_search:
//                    fm.beginTransaction().hide(active).show(searchFrag).commit();
//                    active = searchFrag;
                    Intent intent=new Intent(Home.this, MapsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    // selectedFragment = ItemTwoFragment.newInstance();

                    return true;
                case R.id.navigation_orders:
                    fm.beginTransaction().hide(active).show(ordersFrag).commit();
                    active = ordersFrag;
                    return true;
                case R.id.navigation_earn_rewards:
                    fm.beginTransaction().hide(active).show(earnRewardsFrag).commit();
                    active = earnRewardsFrag;
                    return true;
                case R.id.navigation_account:
                    fm.beginTransaction().hide(active).show(accountFrag).commit();
                    active = accountFrag;
                    return true;
            }
            return false;
        }
    };

}
