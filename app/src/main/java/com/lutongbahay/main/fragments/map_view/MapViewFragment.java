package com.lutongbahay.main.fragments.map_view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.lutongbahay.R;
import com.lutongbahay.app.BaseFragment;
import com.lutongbahay.main.fragments.map_view.mvvm.MapView;
import com.lutongbahay.main.fragments.map_view.mvvm.MapViewModel;

import butterknife.ButterKnife;

public class MapViewFragment extends BaseFragment {

    private MapView view;
    private MapViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(MapViewModel.class);
        view = new MapView(context,viewModel);
        return view;
    }

}
