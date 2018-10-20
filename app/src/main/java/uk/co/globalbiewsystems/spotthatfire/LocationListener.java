package uk.co.globalbiewsystems.spotthatfire;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

public class LocationListener implements android.location.LocationListener {

    private Context c;
    public double lat ;
    public double lng;
    public LocationListener(Context context) {
        c = context;
        this.lat = 0;
        this.lng = 0;
    }
    @Override
    public void onLocationChanged(Location location) {
        this.lat = location.getLatitude();
        this.lng = location.getLatitude();

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
