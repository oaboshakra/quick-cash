package com.example.quickcash.ui.Gmaps;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import android.widget.Toast;

import com.example.quickcash.R;
import com.example.quickcash.util.AppConstants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    SearchView searchView;
    /**
     * This method is called when the activity is first created.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        searchView = findViewById(R.id.idSearchView);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                if (location != null && !location.isEmpty()) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (addressList != null && !addressList.isEmpty()) {
                        Address address = addressList.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9));
                    } else {
                        Toast.makeText(MapsActivity.this, "Location not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MapsActivity.this, "Please enter a location", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This currently sets the location of Halifax since most of our users from halifax.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng halifax = getHalifaxLatLong();
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(halifax).title("You are currently here in Halifax"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(halifax));
    }
    /**
     * @return a the Coordinates of Halifax.
     */
    private LatLng getHalifaxLatLong() {
        return new LatLng(AppConstants.HALIFAX_LATITUDE, AppConstants.HALIFAX_LONGITUDE);
    }
}
