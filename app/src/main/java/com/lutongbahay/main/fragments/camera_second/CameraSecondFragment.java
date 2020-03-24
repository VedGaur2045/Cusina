package com.lutongbahay.main.fragments.camera_second;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.camera_second.mvvm.CameraSecondView;
import com.lutongbahay.main.fragments.camera_second.mvvm.CameraSecondViewModel;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;

public class CameraSecondFragment extends Fragment {
    private CameraSecondView view;
    private CameraSecondViewModel viewModel;
    private Context context;
    AppCompatActivity compatActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        compatActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(CameraSecondFragmentDirections.toAddPhoto());
                compatActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
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
