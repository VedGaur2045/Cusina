package com.lutongbahay.app;

import androidx.fragment.app.Fragment;

import com.lutongbahay.main.home.HomeActivity;

public abstract class BaseFragment extends Fragment {

    protected void showBottomNavigationBar(boolean show) {
        if (getActivity() != null && getActivity() instanceof HomeActivity) {
            ((HomeActivity) getActivity()).handleBottomNavigationVisibility(show);
        }
    }
}

