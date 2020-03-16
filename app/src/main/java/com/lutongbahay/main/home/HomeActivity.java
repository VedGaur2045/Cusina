package com.lutongbahay.main.home;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.action_home_frame)
    FrameLayout actionHomeFrame;
    @BindView(R.id.action_search_frame)
    FrameLayout actionSearchFrame;
    @BindView(R.id.action_order_frame)
    FrameLayout actionOrderFrame;
    @BindView(R.id.action_reward_frame)
    FrameLayout actionRewardFrame;
    @BindView(R.id.action_account_frame)
    FrameLayout actionAccountFrame;
    @BindView(R.id.bottom_navigation)
    RelativeLayout bottomNavigation;
    @BindView(R.id.home_tv)
    TextView homeTv;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.orders_tv)
    TextView ordersTv;
    @BindView(R.id.rewards_tv)
    TextView rewardsTv;
    @BindView(R.id.account_tv)
    TextView accountTv;

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 211;
    public static final int SETTINGS_REQUEST_CODE_LOCATION = 212;

    public static void openHomeActivity(Context context) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent, bndlAnimation);
        ((AppCompatActivity) context).finish();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        navController = Navigation.findNavController(this, R.id.nav_host_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        navigationHandler();

        if (Constants.openProfile){
            Constants.openProfile = false;
            Constants.isRegistered = true;
            navController.navigate(R.id.profileFragment);
        }
    }


    //help? https://developer.android.com/topic/libraries/architecture/navigation/navigation-ui
    @Override
    public boolean onSupportNavigateUp() {
        return navController != null ? NavigationUI.navigateUp(navController, appBarConfiguration) : super.onSupportNavigateUp();
    }

    @OnClick({R.id.action_home_frame, R.id.action_search_frame, R.id.action_order_frame, R.id.action_reward_frame, R.id.action_account_frame})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.action_home_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.HomeFragment) {
                        navController.navigate(R.id.HomeFragment);
                        navController.popBackStack(R.id.HomeFragment, false);
                    }
                break;
            case R.id.action_search_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.mapFragment) {
                        navController.navigate(R.id.mapFragment);
                        navController.popBackStack(R.id.mapFragment, false);
                    }
                break;
            case R.id.action_order_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.MyOrderFragment) {
                        navController.navigate(R.id.MyOrderFragment);
                        navController.popBackStack(R.id.MyOrderFragment, false);
                    }
                break;
            case R.id.action_reward_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.earnRewardsFragment) {
                        navController.navigate(R.id.earnRewardsFragment);
                        navController.popBackStack(R.id.earnRewardsFragment, false);
                    }
                break;
            case R.id.action_account_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.profileFragment) {
                        navController.navigate(R.id.profileFragment);
                        navController.popBackStack(R.id.profileFragment, false);
                    }
                break;
        }
    }

    public void handleBottomNavigationVisibility(boolean show) {
        if (show) {
            bottomNavigation.setVisibility(View.VISIBLE);
        } else {
            bottomNavigation.setVisibility(View.GONE);
        }
    }


    public void setSelection(String type) {

        setBackGround(homeTv,R.drawable.ic_action_home);
        setBackGround(searchTv,R.drawable.ic_action_search);
        setBackGround(ordersTv,R.drawable.ic_action_orders);
        setBackGround(rewardsTv,R.drawable.ic_action_rewards);
        setBackGround(accountTv,R.drawable.ic_action_profile);
        homeTv.setTextColor(Color.parseColor("#000000"));
        searchTv.setTextColor(Color.parseColor("#000000"));
        ordersTv.setTextColor(Color.parseColor("#000000"));
        rewardsTv.setTextColor(Color.parseColor("#000000"));
        accountTv.setTextColor(Color.parseColor("#000000"));

        if (type.equalsIgnoreCase("HOME")) {
            setBackGround(homeTv,R.drawable.ic_action_home_selected);
            homeTv.setTextColor(Color.parseColor("#FF8500"));
        } else if (type.equalsIgnoreCase("SEARCH")) {
            setBackGround(searchTv,R.drawable.ic_action_search_selected);
            searchTv.setTextColor(Color.parseColor("#FF8500"));
        } else if (type.equalsIgnoreCase("ORDERS")) {
            setBackGround(ordersTv,R.drawable.ic_action_orders_selected);
            ordersTv.setTextColor(Color.parseColor("#FF8500"));
        } else if (type.equalsIgnoreCase("EARN REWARDS")) {
            setBackGround(rewardsTv,R.drawable.ic_action_rewards_selected);
            rewardsTv.setTextColor(Color.parseColor("#FF8500"));
        } else if (type.equalsIgnoreCase("ACCOUNT")) {
            setBackGround(accountTv,R.drawable.ic_action_profile_selected);
            accountTv.setTextColor(Color.parseColor("#FF8500"));
        }


    }

    public void setBackGround(TextView textView, int drawable) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, drawable, 0, 0);
    }

    public void navigationHandler() {
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            Logger.DebugLog("Destination Controller", destination.getId() + "");

            if (destination.getId() == R.id.HomeFragment){
                handleBottomNavigationVisibility(true);
                setSelection("HOME");
            }else if (destination.getId() == R.id.profileFragment){
                handleBottomNavigationVisibility(true);
                setSelection("ACCOUNT");
            }else if (destination.getId() == R.id.MyOrderFragment){
                handleBottomNavigationVisibility(true);
                setSelection("ORDERS");
            }else if (destination.getId() == R.id.mapFragment){
                handleBottomNavigationVisibility(true);
                setSelection("SEARCH");
            }else if (destination.getId() == R.id.earnRewardsFragment){
                handleBottomNavigationVisibility(true);
                setSelection("EARN REWARDS");
            }else{
                setSelection("");
                handleBottomNavigationVisibility(false);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_main);
        if (navHostFragment != null) {
            List<Fragment> fragmentList = navHostFragment.getChildFragmentManager().getFragments();
            for (Fragment fragment : fragmentList) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                int counter = 0;
                for (int result : grantResults) {
                    if (result != 0) {
                        boolean showRationale = true;
                        for (String permission : permissions) {
                            showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                        }

                        if (showRationale) {
                            DialogHelperClass.showMessageOKCancel(this,
                                    getResources().getString(R.string.location_permission_required),
                                    getResources().getString(android.R.string.ok),
                                    getResources().getString(android.R.string.cancel),
                                    (dialogInterface, i) -> ToastUtils.shortToast(""),
                                    (dialogInterface, i) -> {

                                    });
                        } else {
                            DialogHelperClass.showMessageOKCancel(this,
                                    getResources().getString(R.string.location_permission_settings),
                                    getResources().getString(R.string.goto_settings),
                                    getResources().getString(android.R.string.cancel),
                                    (dialogInterface, i) -> openSettings(),
                                    (dialog, which) -> {
                                        ToastUtils.shortToast(getResources().getString(R.string.location_permission_deny));
                                    });
                        }
                        return;
                    }

                    counter++;

                }
                return;
            }
        }


        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_main);
        if (navHostFragment != null) {
            List<Fragment> fragmentList = navHostFragment.getChildFragmentManager().getFragments();
            for (Fragment fragment : fragmentList) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    // navigating user to app settings
    public void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, SETTINGS_REQUEST_CODE_LOCATION);
    }

}
