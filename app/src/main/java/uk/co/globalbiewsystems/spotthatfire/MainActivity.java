package uk.co.globalbiewsystems.spotthatfire;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.AWSStartupResult;

import java.util.Timer;
import java.util.TimerTask;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class MainActivity extends AppCompatActivity {
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar spinner = findViewById(R.id.progressBar);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onTimerComplete();
                    }
                }, 5000);
            }
        });

        AWSMobileClient.getInstance().initialize(this, new AWSStartupHandler() {
            @Override
            public void onComplete(AWSStartupResult awsStartupResult) {
                Log.d("YourMainActivity", "AWSMobileClient is instantiated and you are connected to AWS!");
            }
        }).execute();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            startGPSLocationService();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1340);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            startGPSLocationService();
        }
    }
    private void startGPSLocationService() {
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        android.location.LocationListener locationListener = new LocationListener(getApplicationContext());
        try {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
            //600000
        } catch (SecurityException e) {
            Log.d("GPS ", "Error Initialising GPS");
        }
    }

    private void onTimerComplete() {
        final customDialog custom = new customDialog(this);
        custom.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                custom.cancel();
                Fragment firePopup = new FireShow();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment, firePopup, "FirePopup");
                fragmentTransaction.commit();
            }
        }, 5000);
    }
}
