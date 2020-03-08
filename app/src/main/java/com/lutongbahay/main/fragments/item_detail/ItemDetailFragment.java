package com.lutongbahay.main.fragments.item_detail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.item_detail.mvvm.ItemDetailView;
import com.lutongbahay.main.fragments.item_detail.mvvm.ItemDetailViewModel;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ItemDetailFragment extends Fragment {

    private ItemDetailView view;
    private ItemDetailViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ItemDetailViewModel.class);
        view = new ItemDetailView((AppCompatActivity) context,viewModel);
        return view;
    }
}
