package com.lutongbahay.main.fragments.home_frag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragView;
import com.lutongbahay.main.fragments.home_frag.mvvm.HomeFragViewModel;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(HomeFragViewModel.class);
        view = new HomeFragView(context,viewModel);
        return view;
    }
}
