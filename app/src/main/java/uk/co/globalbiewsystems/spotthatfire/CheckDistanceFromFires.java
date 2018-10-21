package uk.co.globalbiewsystems.spotthatfire;

import android.location.Location;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CheckDistanceFromFires {

    public static void CheckDistance()
    {
        String url = "https://eonet.sci.gsfc.nasa.gov/api/v2.1/categories/8?status=open";
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            //json = new JSONObject(response.body().string());
           // Log.d("LOCATION", "onResponse:"+json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 0 ; i++) {
            //double latitude=lats[i];
            //double longitude=lngs[i];
            float distance=0;
            Location crntLocation=new Location("crntlocation");
            crntLocation.setLatitude(LocationListener.lat);
            crntLocation.setLongitude(LocationListener.lng);

            Location newLocation=new Location("newlocation");
            //newLocation.setLatitude(latitude);
            //newLocation.setLongitude(longitude);

            //float distance = crntLocation.distanceTo(newLocation);  in meters
            distance = crntLocation.distanceTo(newLocation) / 1000; // in km

        }

    }
}
