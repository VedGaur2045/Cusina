package com.lutongbahay.main.fragments.message_location.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.lutongbahay.R;
import com.lutongbahay.main.fragments.message_location.MessageLocationFragment;
import com.lutongbahay.main.fragments.message_location.MessageLocationFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageLocationView extends FrameLayout implements OnMapReadyCallback {

    private final MessageLocationViewModel viewModel;
    GoogleMap googleMap;
    public SupportMapFragment mapFragment;

    public MessageLocationView(@NonNull Context context, MessageLocationViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_message_location,this);
        ButterKnife.bind(this,this);

        mapFragment =  ((SupportMapFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

    }

    @OnClick(R.id.closeImgBtn)
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(v).navigateUp();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setMyLocationEnabled(true);
        ZoomOnCurrentLocation();
    }


    private void ZoomOnCurrentLocation(){
        LatLng coordinate = new LatLng(26.264377, 72.9919383);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 15);
        googleMap.animateCamera(yourLocation);;
    }
}
