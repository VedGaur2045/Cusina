package com.lutongbahay.user_auth.fragments.select_location.mvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.Task;
import com.lutongbahay.R;
import com.lutongbahay.adapter.GooglePlacesAutocompleteAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.helper.LocationTrackingHelper;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.rest.response.google_places_response.GooglePlacesAPIData;
import com.lutongbahay.rest.service.GooglePlacesServices;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.TextUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
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
    @BindView(R.id.searchViewLocation)
    EditText searchViewLocation;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.rv_search_result)
    ListView rv_search_result;
    @BindView(R.id.currentlocation)
    RelativeLayout currentlocation;
    private Geocoder geocoder;
    private List<Address> addressList = new ArrayList<>();
    private static boolean check = false;

    GooglePlacesAPIData googlePlacesAPIData;

    public SelectLocationFragmentView(@NonNull AppCompatActivity context, SelectLocationFragmentViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        inflate(context, R.layout.fragment_select_location, this);
        ButterKnife.bind(this, this);
        locationTextView.setText("Fetching Current Location \nPlease wait" );
        geocoder = new Geocoder(context, Locale.getDefault());

        rv_search_result.setVisibility(GONE);
        if (MarshMallowPermission.checkMashMallowPermissions(context, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,CAMERA}, PERMISSION_REQUEST_CODE)) {
            fetchLocation();
        }

        searchViewLocation.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchLocation(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

    }


    @OnClick({R.id.next, R.id.close})
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.next) {
            try {
                CusinaApplication.getPreferenceManger().putLastAddress(addressList.get(0));
            } catch (Exception e){
                e.printStackTrace();
            }
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
                        System.out.println("hajsg ? "+addressList.get(0));
                        check = true;
                        //CusinaApplication.getPreferenceManger().putLastAddress(addressList.get(0));
                    }else {
                        check = false;
                        locationTextView.setText("");
                    }
                });

    }


    public void searchLocation(String location){
        Call<GooglePlacesAPIData> googlePlacesAPIDataCall = GooglePlacesServices.getGooglePlacesRetrofitInstance().getPlacesData(location, "AIzaSyAmYQJFMFtI3CToUHQcyKTayysA2zicF4E");
        googlePlacesAPIDataCall.enqueue(new Callback<GooglePlacesAPIData>() {
            @Override
            public void onResponse(@NotNull Call<GooglePlacesAPIData> call, @NotNull Response<GooglePlacesAPIData> response) {
                googlePlacesAPIData = response.body();

                if (googlePlacesAPIData.predictions.size() > 0){
                    rv_search_result.setVisibility(VISIBLE);
                    currentlocation.setVisibility(GONE);
                }else{
                    rv_search_result.setVisibility(GONE);
                    currentlocation.setVisibility(VISIBLE);
                }

                Logger.ErrorLog("Data count ",googlePlacesAPIData.predictions.size() + "");
                GooglePlacesAutocompleteAdapter googlePlaceEditProfileListAdapter = new GooglePlacesAutocompleteAdapter(context, googlePlacesAPIData.predictions);
                rv_search_result.setAdapter(googlePlaceEditProfileListAdapter);

                rv_search_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        System.out.println(googlePlacesAPIData.predictions.get(i).description);
                        locationTextView.setText("Selected Location \n" + googlePlacesAPIData.predictions.get(i).description);
                        addressList.get(0).setAddressLine(0,googlePlacesAPIData.predictions.get(i).description);
                        addressList.get(0).setFeatureName(null);
                        addressList.get(0).setAdminArea(null);
                        addressList.get(0).setSubAdminArea(null);
                        addressList.get(0).setLocality(null);
                        addressList.get(0).setPostalCode(null);
                        addressList.get(0).setCountryCode(null);
                        addressList.get(0).setCountryName(null);
                        System.out.println("Aghgsxdhjb s   =   "+addressList.get(0).getAddressLine(0));
                        //CusinaApplication.getPreferenceManger().putLastAddress(addressList.get(0));
                        rv_search_result.setVisibility(GONE);
                        currentlocation.setVisibility(VISIBLE);
                    }
                });

            }

            @Override
            public void onFailure(Call<GooglePlacesAPIData> call, Throwable t) {
                Log.e("failed", t.toString());
            }
        });
    }


}
