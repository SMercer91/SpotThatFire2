package uk.co.globalbiewsystems.spotthatfire;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            startGPSLocationService();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                   1340 );
        }
    }

    private void startGPSLocationService() {
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        android.location.LocationListener locationListener = new LocationListener(getApplicationContext());
        try {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
        } catch (SecurityException e) {
            Log.d("GPS ", "Error Initialising GPS");
        }
    }
}
