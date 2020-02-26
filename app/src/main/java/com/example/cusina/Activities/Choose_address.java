package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cusina.R;
import com.example.cusina.SessionClass.SessionmanagerPreferance;
import com.example.cusina.UtilClasses.UtilClass;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Choose_address extends AppCompatActivity implements LocationListener {

    RelativeLayout search_address,current_location;
    Button next;
    ImageView close;
    TextView locationTxt;

    public LocationManager mLocManager;

    SessionmanagerPreferance session;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_address);
       // UtilClass.fullsreenui(this,"#A00000");
        UtilClass.redStatusBar(this);

        session = new SessionmanagerPreferance(this);

        search_address = findViewById(R.id.searchaddress);
        current_location = findViewById(R.id.currentlocation);
        next = findViewById(R.id.next);
        close = findViewById(R.id.close);
        locationTxt = findViewById(R.id.locationtext);


        //  Log.e("id", String.valueOf(getIntent().getExtras().getInt("id")));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("id")){
                    startloginscreen();
                }
            }
        });

        mLocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        } catch (Exception e) {
            Log.e("Permission Exception : ", e.toString());
            //UtilClass.showAlertBox(this, getString(R.string.alert), getString(R.string.permissionNotGranted));
        }

        if (mLocManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
            mLocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

        if (mLocManager.getAllProviders().contains(LocationManager.GPS_PROVIDER))
            mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);


        locationUpdate();

    }

    private void locationUpdate() {
        CellLocation.requestLocationUpdate();
    }

    public  void popup(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.placeorderpopup1, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view,Gravity.CENTER, 0, 0);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void startloginscreen(){
        Intent intent=new Intent(Choose_address.this, Home.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);

    }

    @Override
    public void onLocationChanged(Location location) {

        Geocoder geocoder;
        List<Address> addresses=null;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName();

//        Log.e("Address : ",address);
//        Log.e("city : ",city);
//        Log.e("state : ",state);
//        Log.e("country : ",country);
//        Log.e("postalCode : ",postalCode);
//        Log.e("knownName : ",knownName);

        String[] currentAddress = address.split(",");

        locationTxt.setText(address);

        session.setCurrentAddress(address);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
