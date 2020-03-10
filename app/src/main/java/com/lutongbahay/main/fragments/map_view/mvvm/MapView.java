package com.lutongbahay.main.fragments.map_view.mvvm;

import android.content.Context;
import android.location.Address;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.lutongbahay.R;
import com.lutongbahay.adapter.HorizontalHomeFoodMenuAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.helper.LocationTrackingHelper;
import com.lutongbahay.utils.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapView extends FrameLayout implements OnMapReadyCallback {

    MapViewModel viewModel;
    Context context;
    GoogleMap googleMap;
    @BindView(R.id.list_item_horizontal_first)
    RecyclerView recyclerView;

    public MapView(@NonNull Context context, MapViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_mapview, this);
        ButterKnife.bind(this, this);

        ((SupportMapFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        LinearLayoutManager horizontalLayoutManager= new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        HorizontalHomeFoodMenuAdapter horizontalHomeFoodMenuAdapter = new HorizontalHomeFoodMenuAdapter();
        recyclerView.setAdapter(horizontalHomeFoodMenuAdapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setMyLocationEnabled(true);
        ZoomOnCurrentLocation();
    }


    private void ZoomOnCurrentLocation(){
        LatLng coordinate = new LatLng(26.264377, 72.9919383);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 19);
        googleMap.animateCamera(yourLocation);;
    }
}
