package com.lutongbahay.main.fragments.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;
import com.lutongbahay.main.fragments.setting.mvvm.SettingView;
import com.lutongbahay.main.fragments.setting.mvvm.SettingViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class SettingFragment extends Fragment {

    private SettingView view;
    private SettingViewModel viewModel;
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
                Navigation.findNavController(view).navigate(SettingFragmentDirections.toProfileFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SettingViewModel.class);
        view = new SettingView(context,viewModel);
        return view;
    }
}
