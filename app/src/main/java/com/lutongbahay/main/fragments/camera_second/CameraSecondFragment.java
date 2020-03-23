package com.lutongbahay.main.fragments.camera_second;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.camera_second.mvvm.CameraSecondView;
import com.lutongbahay.main.fragments.camera_second.mvvm.CameraSecondViewModel;

public class CameraSecondFragment extends Fragment {
    private CameraSecondView view;
    private CameraSecondViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(CameraSecondViewModel.class);
        view = new CameraSecondView(context,viewModel);
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == view.REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(getContext(), "Sorry!!!, you can't use this app without granting permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(view.TAG, "onResume");
        view.startBackgroundThread();
        if (view.texture_view.isAvailable()) {
            view.openCamera();
        } else {
            view.texture_view.setSurfaceTextureListener(view.textureListener);
        }
    }

    @Override
    public void onPause() {
        Log.e(view.TAG, "onPause");
        //closeCamera();
        view.stopBackgroundThread();
        super.onPause();
    }


}
