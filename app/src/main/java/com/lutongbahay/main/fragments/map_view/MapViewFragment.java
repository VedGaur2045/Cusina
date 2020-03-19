package com.lutongbahay.main.fragments.map_view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.app.BaseFragment;
import com.lutongbahay.dialogs.DialogHelperClass;
import com.lutongbahay.main.fragments.add_photo.mvvm.AddPhotoView;
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.main.fragments.map_view.mvvm.MapView;
import com.lutongbahay.main.fragments.map_view.mvvm.MapViewModel;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar((Activity) context);
        }
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(MapViewFragmentDirections.HomeFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MapViewModel.class);
        if (view == null)
        view = new MapView(context,viewModel);
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MapView.LOCATION_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    int counter = 0;
                    for (int result : grantResults) {
                        if (result != 0) {
                            boolean showRationale = true;
                            for (String permission : permissions) {
                                showRationale = shouldShowRequestPermissionRationale(permission);
                            }
                            DialogInterface.OnClickListener onClickListener = (dialogInterface, i) -> ToastUtils.shortToast(getResources().getString(R.string.location_deny));

                            if (showRationale) {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.location_permission_required_map),
                                        getResources().getString(android.R.string.ok),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.takeLocationPermission(),
                                        onClickListener);

                            } else {
                                DialogHelperClass.showMessageOKCancel(getContext(),
                                        getResources().getString(R.string.location_permission_required_map),
                                        getResources().getString(R.string.goto_settings),
                                        getResources().getString(android.R.string.cancel),
                                        (dialogInterface, i) -> view.openSettings(MapView.SETTINGS_REQUEST_CODE_LOCATION),
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null && view.mapFragment != null){
            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().remove(view.mapFragment).commit();
        }
    }
}
