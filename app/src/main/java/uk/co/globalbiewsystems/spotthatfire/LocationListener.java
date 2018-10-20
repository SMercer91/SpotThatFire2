package uk.co.globalbiewsystems.spotthatfire;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class LocationListener implements android.location.LocationListener {

    private Context c;
    public double lat ;
    public double lng;
    public float bearing;
    public LocationListener(Context context) {
        c = context;
        this.lat = 0;
        this.lng = 0;
        this.bearing = 0;
    }
    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: fired");
        this.lat =  location.getLatitude();
        this.lng = location.getLatitude();
        this.bearing = location.getBearing();

        String longitude = "Longitude: " + location.getLongitude();
        Log.v(TAG, longitude);
        String latitude = "Latitude: " + location.getLatitude();
        Log.v(TAG, latitude);
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
