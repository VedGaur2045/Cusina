package com.lutongbahay.main.fragments.view_order_details;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.view_order_details.mvvm.ViewOrderDetailsView;
import com.lutongbahay.main.fragments.view_order_details.mvvm.ViewOrderDetailsViewModel;

public class ViewOrdersDetailsFragment extends Fragment {

    private ViewOrderDetailsView view;
    private ViewOrderDetailsViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(ViewOrderDetailsViewModel.class);
        view = new ViewOrderDetailsView(context,viewModel);
        return view;
    }
}
