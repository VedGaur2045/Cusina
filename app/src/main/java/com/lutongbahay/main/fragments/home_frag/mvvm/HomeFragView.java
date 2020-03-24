package com.lutongbahay.main.fragments.home_frag.mvvm;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.Task;
import com.lutongbahay.R;
import com.lutongbahay.adapter.MainHomeFoodMenuAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.helper.LocationTrackingHelper;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class HomeFragView extends FrameLayout {
    private final HomeFragViewModel viewModel;

    @BindView(R.id.food_menu_rv)
    RecyclerView foodMenuRv;
    @BindView(R.id._trayOnHome)
    RelativeLayout trayHome;
    @BindView(R.id.searchViewHome)
    SearchView searchViewHome;
    @BindView(R.id.locationName)
    TextView locationTxt;
    @BindView(R.id.favouriteImgBtn)
    ImageView favouriteImgBtn;
    @BindView(R.id.notificationImgBtn)
    ImageView notificationImgBtn;
    @BindView(R.id.filterImgBtn)
    ImageView filterImgBtn;

    private Geocoder geocoder;
    private List<Address> addressList = new ArrayList<>();
    public static final int PERMISSION_REQUEST_CODE = 902;
    Context context;
    private static boolean check = false;

    public HomeFragView(@NonNull Context context, HomeFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        inflate(context, R.layout.fragment_home, this);
        ButterKnife.bind(this, this);


        MainHomeFoodMenuAdapter mainHomeFoodMenuAdapter = new MainHomeFoodMenuAdapter(getContext());
        foodMenuRv.setAdapter(mainHomeFoodMenuAdapter);

        trayHome.setOnClickListener(v -> Navigation.findNavController(v).navigate(HomeFragmentDirections.openCartFragment()));

        locationTxt.setText("Current Location" );
        geocoder = new Geocoder(context, Locale.getDefault());

        if(CusinaApplication.getPreferenceManger().getLastSavedLocation() == null) {
            if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,CAMERA}, PERMISSION_REQUEST_CODE)) {
                fetchLocation();
            }
        } else {
            List<Address> addressList = new ArrayList<>();
            addressList = Collections.singletonList(CusinaApplication.getPreferenceManger().getLastSavedLocation());

            try {
                System.out.println(addressList.get(0).getAddressLine(0));

                locationTxt.setText(addressList.get(0).getAddressLine(0));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
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
                        locationTxt.setText(addressLine);
                        System.out.println("hajsg ? "+addressList.get(0));
                        check = true;
                        CusinaApplication.getPreferenceManger().putLastAddress(addressList.get(0));
                    }else {
                        check = false;
                        locationTxt.setText("");
                    }
                });

    }


}
