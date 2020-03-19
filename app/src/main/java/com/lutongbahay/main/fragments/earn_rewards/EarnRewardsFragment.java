package com.lutongbahay.main.fragments.earn_rewards;

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
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.main.fragments.earn_rewards.mvvm.EarnRewardsView;
import com.lutongbahay.main.fragments.earn_rewards.mvvm.EarnRewardsViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class EarnRewardsFragment extends Fragment {

    private EarnRewardsView view;
    private EarnRewardsViewModel viewModel;
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
        // After change with on Condition
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(EarnRewardsFragmentDirections.HomeFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel  = new ViewModelProvider(this).get(EarnRewardsViewModel.class);
        view = new EarnRewardsView(context,viewModel);
        return view;
    }
}
