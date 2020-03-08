package com.lutongbahay.main.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.lutongbahay.R;

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

    public static void openHomeActivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
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
    }

    @OnClick({R.id.action_home_frame, R.id.action_search_frame, R.id.action_order_frame, R.id.action_reward_frame, R.id.action_account_frame})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.action_home_frame:
                break;
            case R.id.action_search_frame:
                break;
            case R.id.action_order_frame:
                break;
            case R.id.action_reward_frame:
                break;
            case R.id.action_account_frame:
                break;
        }
    }
}
