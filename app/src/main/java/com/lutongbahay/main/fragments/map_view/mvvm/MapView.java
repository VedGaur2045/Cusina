package com.lutongbahay.main.fragments.map_view.mvvm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
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

    public SupportMapFragment mapFragment;


    public MapView(@NonNull Context context, MapViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        inflate(context, R.layout.fragment_mapview, this);
        ButterKnife.bind(this, this);

        mapFragment =  ((SupportMapFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

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
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 17);
        googleMap.animateCamera(yourLocation);;
        addCustomMarkers();
    }

    private void addCustomMarkers(){
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.264377, 72.9919383))
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.mipmap.product_img_item))));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.265093, 72.991343))
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.mipmap.product_img_item))));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.265313, 72.992809))
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.mipmap.product_img_item))));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.265188, 72.990687))
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.mipmap.product_img_item))));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(26.263075, 72.989180))
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.mipmap.product_img_item))));
    }


    private Bitmap getMarkerBitmapFromView(@DrawableRes int resId) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customMarkerView = inflater.inflate(R.layout.custom_marker_view, null);

       // View customMarkerView = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker_view, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }

}
