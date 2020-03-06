package com.lutongbahay.main.fragments.process_order_from_seller;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.process_order_from_seller.mvvm.ProcessOrderView;
import com.lutongbahay.main.fragments.process_order_from_seller.mvvm.ProcessOrderViewModel;

public class ProcessOrderFragment extends Fragment {
    private ProcessOrderView view;
    private ProcessOrderViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(ProcessOrderViewModel.class);
        view = new ProcessOrderView(context,viewModel);
        return view;
    }
}
