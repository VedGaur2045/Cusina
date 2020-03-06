package com.lutongbahay.main.fragments.order_history;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.order_complete.mvvm.OrderCompleteView;
import com.lutongbahay.main.fragments.order_complete.mvvm.OrderCompleteViewModel;

public class OrderHistoryFragment extends Fragment {

    private OrderCompleteView view;
    private OrderCompleteViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(OrderCompleteViewModel.class);
        view = new OrderCompleteView(context,viewModel);
        return view;
    }
}
