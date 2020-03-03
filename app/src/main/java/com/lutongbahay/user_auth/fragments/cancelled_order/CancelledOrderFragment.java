package com.lutongbahay.user_auth.fragments.cancelled_order;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.cancelled_order.mvvm.CancelledOrderView;
import com.lutongbahay.user_auth.fragments.cancelled_order.mvvm.CancelledOrderViewModel;
import com.lutongbahay.user_auth.fragments.completed_order.mvvm.CompletedOrderView;
import com.lutongbahay.user_auth.fragments.completed_order.mvvm.CompletedOrderViewModel;

public class CancelledOrderFragment extends Fragment {

    private CancelledOrderView view;
    private CancelledOrderViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CancelledOrderViewModel.class);
        view = new CancelledOrderView(context,viewModel);
        return view;
    }
}
