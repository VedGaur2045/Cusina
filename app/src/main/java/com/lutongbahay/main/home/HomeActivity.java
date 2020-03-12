package com.lutongbahay.main.home;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.utils.Logger;

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

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    public static void openHomeActivity(Context context) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent,bndlAnimation);
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
                    if (navController.getCurrentDestination().getId() != R.id.HomeFragment){
                        navController.navigate(R.id.HomeFragment);
                        navController.popBackStack(R.id.HomeFragment, false);
                    }
                break;
            case R.id.action_search_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.mapFragment){
                        navController.navigate(R.id.mapFragment);
                        navController.popBackStack(R.id.mapFragment, false);
                    }
                break;
            case R.id.action_order_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.MyOrderFragment){
                        navController.navigate(R.id.MyOrderFragment);
                        navController.popBackStack(R.id.MyOrderFragment, false);
                    }
                break;
            case R.id.action_reward_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.earnRewardsFragment){
                        navController.navigate(R.id.earnRewardsFragment);
                        navController.popBackStack(R.id.earnRewardsFragment, false);
                    }
                break;
            case R.id.action_account_frame:
                if (navController != null && navController.getCurrentDestination() != null)
                    if (navController.getCurrentDestination().getId() != R.id.profileFragment){
                        navController.navigate(R.id.profileFragment);
                        navController.popBackStack(R.id.profileFragment, false);
                    }
                break;
        }
    }

    public void handleBottomNavigationVisibility(boolean show){
        if (show){
            bottomNavigation.setVisibility(View.VISIBLE);
        }else{
            bottomNavigation.setVisibility(View.GONE);
        }
    }


    public void navigationHandler() {
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            Logger.DebugLog("Destination Controller", destination.getId() + "");
            if (destination.getId() == R.id.HomeFragment || destination.getId() == R.id.profileFragment || destination.getId() == R.id.MyOrderFragment
                    || destination.getId() == R.id.mapFragment || destination.getId() == R.id.earnRewardsFragment){
                handleBottomNavigationVisibility(true);
            }else
                handleBottomNavigationVisibility(false);

        });
    }
}
