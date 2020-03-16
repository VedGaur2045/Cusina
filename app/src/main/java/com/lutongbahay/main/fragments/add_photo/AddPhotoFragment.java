package com.lutongbahay.main.fragments.add_photo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoView;
import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoViewModel;
import com.lutongbahay.utils.ToastUtils;

import static com.lutongbahay.user_auth.fragments.select_location.mvvm.SelectLocationFragmentView.PERMISSION_REQUEST_CODE;

public class AddPhotoFragment extends Fragment {

    private AddPhotoView view;
    private AddPhotoViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(AddPhotoViewModel.class);
        view = new AddPhotoView(context,viewModel);
        return view;
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case AddPhotoView.STORAGE_PERMISSION_CODE:
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
                                        (dialogInterface, i) -> view.takeStoragePermission(),
                                        onClickListener);

                            } else {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.storage_permission_settings),
                                        getResources().getString(R.string.goto_settings),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.openSettings(AddPhotoView.SETTINGS_REQUEST_CODE_STORAGE),
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
