package com.lutongbahay.main.fragments.choose_category;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.choose_category.mvvm.ChooseCategoryView;
import com.lutongbahay.main.fragments.choose_category.mvvm.ChooseCategoryViewModel;

public class ChooseCategoryFragment extends Fragment {
    private ChooseCategoryView view;
    private ChooseCategoryViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(ChooseCategoryViewModel.class);
        view = new ChooseCategoryView(context,viewModel);
        return view;
    }

}
