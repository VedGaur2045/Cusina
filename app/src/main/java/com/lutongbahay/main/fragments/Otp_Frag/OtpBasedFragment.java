package com.lutongbahay.main.fragments.Otp_Frag;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.Otp_Frag.mvvm.OtpBasedView;
import com.lutongbahay.main.fragments.Otp_Frag.mvvm.OtpBasedViewModel;
import com.lutongbahay.user_auth.activity.splash.SplashActivity;
import com.lutongbahay.utils.StatusBarUtils;

public class OtpBasedFragment extends Fragment {

    private OtpBasedView view;
    private OtpBasedViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                SplashActivity.openSplashActivity(context);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(OtpBasedViewModel.class);
        view = new OtpBasedView(context,viewModel);
        return view;
    }
}
