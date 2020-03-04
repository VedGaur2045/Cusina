package com.lutongbahay.main.fragments.dish_reviews;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.dish_reviews.mvvm.DishReviewView;
import com.lutongbahay.main.fragments.dish_reviews.mvvm.DishReviewViewModel;


public class DishReviewFragment extends Fragment {

    private DishReviewView view;
    private DishReviewViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(DishReviewViewModel.class);
        view = new DishReviewView(context,viewModel);
        return view;
    }
}
