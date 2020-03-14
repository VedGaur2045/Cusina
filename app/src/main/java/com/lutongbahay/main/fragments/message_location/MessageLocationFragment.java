package com.lutongbahay.main.fragments.message_location;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.message_location.mvvm.MessageLocationView;
import com.lutongbahay.main.fragments.message_location.mvvm.MessageLocationViewModel;

public class MessageLocationFragment extends Fragment {

    private MessageLocationView view;
    private MessageLocationViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(MessageLocationViewModel.class);
        view = new MessageLocationView(context,viewModel);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null && view.mapFragment != null){
            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().remove(view.mapFragment).commit();
        }
    }
}
