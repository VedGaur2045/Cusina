package com.lutongbahay.main.fragments.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.helper.MarshMallowPermission;

import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoView;
import com.lutongbahay.main.fragments.camera.mvvm.CameraView;
import com.lutongbahay.main.fragments.camera.mvvm.CameraViewModel;
import com.lutongbahay.utils.ToastUtils;

import static android.Manifest.permission.CAMERA;

import com.lutongbahay.utils.Logger;

import static com.lutongbahay.helper.MarshMallowPermission.checkPermission;
import static com.lutongbahay.main.fragments.camera.mvvm.CameraView.CAMERA_PERMISSION_REQUEST_CODE;

public class CameraFragment extends Fragment {

    private static final int CAMERA_PERMISSION_CODE = 109;

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
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CameraView.REQUEST_CAMERA_PERMISSION);
            return;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CameraViewModel.class);
        view = new CameraView((AppCompatActivity) context,viewModel);
        return view;
    }

    @Override
    public void onPause() {
        Log.e(view.TAG, "onPause");
        //closeCamera();
        view.stopBackgroundThread();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        Log.e(CameraView.TAG, "onResume");
        view.startBackgroundThread();
        if (view.camera_preview.isAvailable()) {
            view.openCamera();
        } else {
            view.camera_preview.setSurfaceTextureListener(view.textureListener);
        }
//        if(MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context,new String[]{CAMERA},CAMERA_PERMISSION_CODE)){
//            view.openCamera();
//        }
//
//        if (checkPermission(getActivity(), CAMERA)
//                == PackageManager.PERMISSION_GRANTED) {
//            Log.e(CameraView.TAG, "onResume");
//            view.startBackgroundThread();
//            if (view.camera_preview.isAvailable()) {
//                view.openCamera();
//            } else {
//                view.camera_preview.setSurfaceTextureListener(view.textureListener);
//            }
//            Logger.ErrorLog("PERMISSION ", " GRANTED");
//        }else{
//            Logger.ErrorLog("PERMISSION ", " NOT GRANTED");
//        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == CameraView.REQUEST_CAMERA_PERMISSION) {
//            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
//                // close the app
//                Log.e("ashjf : ","sdghfujgs");
//                //Toast.makeText(context, "Sorry!!!, you can't use this app without granting permission", Toast.LENGTH_LONG).show();
////                finish();
//            }
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case AddPhotoView.STORAGE_PERMISSION_CODE:
            case CameraView.REQUEST_CAMERA_PERMISSION:
                if (grantResults.length > 0) {
                    int counter = 0;
                    for (int result : grantResults) {
                        if (result != 0) {
                            boolean showRationale = true;
                            for (String permission : permissions) {
                                showRationale = shouldShowRequestPermissionRationale(permission);
                            }
                            DialogInterface.OnClickListener onClickListener = (dialogInterface, i) -> ToastUtils.shortToast(getResources().getString(R.string.camera_permission_deny));

                            if (showRationale) {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.camera_permission_required),
                                        getResources().getString(android.R.string.ok),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.takeCameraPermission(),
                                        onClickListener);

                            } else {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.camera_permission_settings),
                                        getResources().getString(R.string.goto_settings),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.openSettings(CameraView.SETTINGS_REQUEST_CODE_CAMERA),
                                        onClickListener);
                            }
                            return;
                        }

                        counter++;
                        if (counter == permissions.length) {
                            view.openCamera();
                        }
                    }
                    return;
                }
                break;

            //view.cameraOpen();

            default:
                break;
        }
    }

    public void openSettings(int requestCode) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
        intent.setData(uri);
        ((AppCompatActivity) getContext()).startActivityForResult(intent, requestCode);
    }

    private void takePermission(){
        if(MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context,new String[]{CAMERA},CAMERA_PERMISSION_CODE)){
            //view.cameraOpen();
        }
    }


}
