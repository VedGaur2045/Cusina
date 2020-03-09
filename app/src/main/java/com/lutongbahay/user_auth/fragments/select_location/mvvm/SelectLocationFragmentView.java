package com.lutongbahay.user_auth.fragments.select_location.mvvm;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.Task;
import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.helper.LocationTrackingHelper;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by Abhishek Thanvi on 02/03/20.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class SelectLocationFragmentView extends FrameLayout {

    private final SelectLocationFragmentViewModel viewModel;
    public static final int PERMISSION_REQUEST_CODE = 902;
    Context context;
    @BindView(R.id.locationtext)
    TextView locationTextView;
    private Geocoder geocoder;
    private List<Address> addressList = new ArrayList<>();

    public SelectLocationFragmentView(@NonNull AppCompatActivity context, SelectLocationFragmentViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        inflate(context, R.layout.fragment_select_location, this);
        ButterKnife.bind(this, this);
        locationTextView.setText("Fetching Current Location \nPlease wait" );
        geocoder = new Geocoder(context, Locale.getDefault());
        if (MarshMallowPermission.checkMashMallowPermissions(context,
                new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE)) {
            fetchLocation();
        }

    }


    @OnClick({R.id.next, R.id.close})
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.next) {
            HomeActivity.openHomeActivity(getContext());
        } else if (id == R.id.close) {
            Navigation.findNavController(v).navigateUp();
        }
    }

    public void checkAccess() {
        LocationSettingsRequest locationSettingsRequest =
                new LocationSettingsRequest.Builder()
                        .addLocationRequest(new LocationRequest())
                        .setAlwaysShow(true).build();

        Task<LocationSettingsResponse> responseTask =
                LocationServices.getSettingsClient(context)
                        .checkLocationSettings(locationSettingsRequest);

        responseTask.addOnSuccessListener(locationSettingsResponse -> {
            Logger.DebugLog(TAG, "Location is ON");

            if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context,
                    new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE)) {
                //get current location

                fetchLocation();

            }
        });

        responseTask.addOnFailureListener(exception -> {
            ProgressDialogFragment.dismissProgressDialog(context);
            if (exception instanceof ResolvableApiException) {
                try {
                    ((ResolvableApiException) exception).startResolutionForResult((AppCompatActivity) context, PERMISSION_REQUEST_CODE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void fetchLocation() {

        LocationTrackingHelper.requestSingleUpdate(context,
                location -> {
                    Log.d("Location", "my location is " + location.latitude);
                    try {
                        addressList = geocoder.getFromLocation(location.latitude, location.longitude, 1);
                    } catch (Exception ignored) {
                        Logger.DebugLog("REVERSE GEO CODING EXCEPTION ",ignored.getLocalizedMessage());
                    }

                    if (addressList != null && !addressList.isEmpty()) {
                        String addressLine = addressList.get(0).getAddressLine(0);
                        locationTextView.setText("Current Location \n" + addressLine);
                        CusinaApplication.getPreferenceManger().putLastAddress(addressList.get(0));
                    }else {
                        locationTextView.setText("");
                    }
                });


    }
}
