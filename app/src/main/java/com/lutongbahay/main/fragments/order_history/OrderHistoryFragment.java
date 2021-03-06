package com.lutongbahay.main.fragments.order_history;

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
import com.lutongbahay.main.fragments.order_complete.mvvm.OrderCompleteView;
import com.lutongbahay.main.fragments.order_complete.mvvm.OrderCompleteViewModel;
import com.lutongbahay.main.fragments.order_history.mvvm.OrderHistoryView;
import com.lutongbahay.main.fragments.order_history.mvvm.OrderHistoryViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class OrderHistoryFragment extends Fragment {

    private OrderHistoryView view;
    private OrderHistoryViewModel viewModel;
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
                Navigation.findNavController(view).navigate(OrderHistoryFragmentDirections.toProfileFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(OrderHistoryViewModel.class);
        view = new OrderHistoryView(context,viewModel);
        return view;
    }
}
