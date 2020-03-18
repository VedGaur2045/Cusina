package com.lutongbahay.main.fragments.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.lutongbahay.main.fragments.camera.mvvm.CameraView;
import com.lutongbahay.main.fragments.camera.mvvm.CameraViewModel;

public class CameraFragment extends Fragment {

    private CameraView view;
    private CameraViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(CameraViewModel.class);
        view = new CameraView((AppCompatActivity) context,viewModel);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        //when on Pause, release camera in order to be used from other applications
        view.releaseCamera();
    }

    public void onResume() {
        super.onResume();
        view.cameraOpen();
    }




}
