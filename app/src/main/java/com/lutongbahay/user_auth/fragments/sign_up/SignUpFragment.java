package com.lutongbahay.user_auth.fragments.sign_up;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.sign_up.mvvm.SignUpView;
import com.lutongbahay.user_auth.fragments.sign_up.mvvm.SignUpViewModel;

public class SignUpFragment extends Fragment {

    private SignUpView view;
    private SignUpViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        view = new SignUpView(context,viewModel);
        return view;
    }
}
