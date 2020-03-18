package com.lutongbahay.main.fragments.profile_frag;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.mvvm.ProfileFragView;
import com.lutongbahay.main.fragments.profile_frag.mvvm.ProfileFragViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class ProfileFragment extends Fragment {

    private ProfileFragView view;
    private ProfileFragViewModel viewModel;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ProfileFragViewModel.class);
        if (view == null)
        view = new ProfileFragView(context,viewModel,getChildFragmentManager());
        return view;
    }
}
