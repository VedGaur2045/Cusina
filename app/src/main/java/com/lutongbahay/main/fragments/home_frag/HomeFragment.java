package com.lutongbahay.main.fragments.home_frag;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragView;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;
import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;
import com.lutongbahay.user_auth.activity.SplashActivity;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

import static com.lutongbahay.user_auth.fragments.select_location.mvvm.SelectLocationFragmentView.PERMISSION_REQUEST_CODE;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class HomeFragment extends Fragment {

    private HomeFragView view;
    private HomeFragViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar((Activity) context);
        }
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                SplashActivity.openSplashActivity(context);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        this.requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(HomeFragViewModel.class);
        view = new HomeFragView(context,viewModel);
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                int counter = 0;
                for (int result : grantResults) {
                    if (result != 0) {

                        boolean showRationale = true;
                        for (String permission : permissions) {
                            showRationale = ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity)context, permission);
                        }

                        if (showRationale) {
                            DialogHelperClass.showMessageOKCancel(context,
                                    getResources().getString(R.string.location_permission_required_map),
                                    getResources().getString(android.R.string.ok),
                                    getResources().getString(android.R.string.cancel),
                                    (dialogInterface, i) -> view.checkAccess(),
                                    (dialogInterface, i) -> ToastUtils.shortToast("Permission denied"));
                        }

                        return;
                    }

                    counter++;
                    if (counter == permissions.length) {
                        view.checkAccess();
                    }
                }
            }
        }
    }


}
