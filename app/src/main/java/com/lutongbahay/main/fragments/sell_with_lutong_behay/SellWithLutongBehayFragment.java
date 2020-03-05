package com.lutongbahay.main.fragments.sell_with_lutong_behay;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.sell_with_lutong_behay.mvvm.SellWithLutongBehayView;
import com.lutongbahay.main.fragments.sell_with_lutong_behay.mvvm.SellWithLutongBehayViewModel;

public class SellWithLutongBehayFragment extends Fragment {

    private SellWithLutongBehayView view;
    private SellWithLutongBehayViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(SellWithLutongBehayViewModel.class);
        view = new SellWithLutongBehayView(context,viewModel);
        return view;
    }
}
