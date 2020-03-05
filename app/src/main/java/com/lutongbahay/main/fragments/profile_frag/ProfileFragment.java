package com.lutongbahay.main.fragments.profile_frag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.mvvm.ProfileFragView;
import com.lutongbahay.main.fragments.profile_frag.mvvm.ProfileFragViewModel;

public class ProfileFragment extends Fragment {

    private ProfileFragView view;
    private ProfileFragViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(ProfileFragViewModel.class);
        view = new ProfileFragView(context,viewModel);
        return view;
    }
}
