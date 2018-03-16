package com.example.binhnl.datn_ggmap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment m = (MapFragment) getFragmentManager().findFragmentById(R.id.myMap);
        m.getMapAsync(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng HN = new LatLng(21.0056183, 105.8433475);
//         googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HN, 13));
        googleMap.addMarker(new MarkerOptions()
                .title("HUST")
                .snippet("Trường đại học Bách khoa Hà Nội")
                .position(HN));
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
//        googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
    }

    public void Config(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
//        Toast.makeText(this, "Button click", Toast.LENGTH_LONG).show();
    }
}
