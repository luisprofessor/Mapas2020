package com.example.mapas2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
    static final LatLng SANLUIS = new LatLng(-33.280576, -66.332482);
    static final LatLng ULP = new LatLng(-33.150720, -66.306864);
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(new MapaActual());

    }

    private class MapaActual implements OnMapReadyCallback {
        @Override
        public void onMapReady(GoogleMap mapa) {
            map = mapa;
            CameraPosition camPos = new CameraPosition.Builder().target(SANLUIS).zoom(19).bearing(45).tilt(70).build();
            CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);
            map.animateCamera(camUpdICT);

            map.addMarker(new MarkerOptions().position(SANLUIS)).setTitle("San Luis");
            map.addMarker(new MarkerOptions().position(ULP)).setTitle("ULP");
            //map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }


    }
}

