package com.lutongbahay.main.fragments.add_photo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.interfaces.DocumentMediaInterface;
import com.lutongbahay.interfaces.SignUpInterface;
import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoView;
import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoViewModel;
import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

import static com.lutongbahay.user_auth.fragments.select_location.mvvm.SelectLocationFragmentView.PERMISSION_REQUEST_CODE;

public class AddPhotoFragment extends Fragment {

    private AddPhotoView view;
    private AddPhotoViewModel viewModel;
    private Context context;
    public static DocumentMediaInterface documentMediaInterface;
    public static SignUpInterface signUpInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar((Activity) context);
        }
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigateUp();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int val = getArguments().getInt("openPhotos");
        String titleName = getArguments().getString("titleName");
        String text1 = getArguments().getString("text_1");
        String text2 = getArguments().getString("text_2");
        String text3 = getArguments().getString("text_3");
        viewModel = new ViewModelProvider(this).get(AddPhotoViewModel.class);
        view = new AddPhotoView(context,viewModel,val,titleName,text1,text2,text3,documentMediaInterface,signUpInterface);
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
