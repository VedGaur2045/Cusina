package com.lutongbahay.user_auth.fragments.sign_up_complete;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.sign_up_complete.mvvm.SignUpCompleteView;
import com.lutongbahay.user_auth.fragments.sign_up_complete.mvvm.SignUpCompleteViewModel;

public class SignUpCompleteFragment extends Fragment {

    private SignUpCompleteView view;
    private SignUpCompleteViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(SignUpCompleteViewModel.class);
        view = new SignUpCompleteView(context,viewModel);
        return view;
    }
}
