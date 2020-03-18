package com.lutongbahay.main.fragments.camera;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.fragments.camera.mvvm.CameraView;
import com.lutongbahay.main.fragments.camera.mvvm.CameraViewModel;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.ToastUtils;

import static android.Manifest.permission.CAMERA;
import static androidx.core.content.PermissionChecker.checkSelfPermission;
import static com.lutongbahay.helper.MarshMallowPermission.checkPermission;
import static com.lutongbahay.main.fragments.camera.mvvm.CameraView.CAMERA_PERMISSION_REQUEST_CODE;

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

        if (checkPermission(getActivity(), CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            view.cameraOpen();
            Logger.ErrorLog("PERMISSION ", " GRANTED");
        }else{
            Logger.ErrorLog("PERMISSION ", " NOT GRANTED");
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_PERMISSION_REQUEST_CODE:
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
                            view.onPermissionGranted();
                        }
                    }
                    return;
                }
                break;

            case CameraView.STORAGE_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    int counter = 0;
                    for (int result : grantResults) {
                        if (result != 0) {
                            boolean showRationale = true;
                            for (String permission : permissions) {
                                showRationale = shouldShowRequestPermissionRationale(permission);
                            }
                            DialogInterface.OnClickListener onClickListener = (dialogInterface, i) -> ToastUtils.shortToast(getResources().getString(R.string.storage_permission_deny));

                            if (showRationale) {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.storage_permission_required),
                                        getResources().getString(android.R.string.ok),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.takeCameraPermission(),
                                        onClickListener);

                            } else {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.storage_permission_settings),
                                        getResources().getString(R.string.goto_settings),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.openSettings(CameraView.SETTINGS_REQUEST_CODE_STORAGE),
                                        onClickListener);
                            }
                            return;
                        }

                        counter++;
                        if (counter == permissions.length) {
                            view.onPermissionGranted();
                        }
                    }
                    return;
                }
                break;

            default:
                break;
        }
    }

}
