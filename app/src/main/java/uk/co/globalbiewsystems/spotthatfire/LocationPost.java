package uk.co.globalbiewsystems.spotthatfire;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LocationPost {
    public void postData(String Url, String body){ MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, body);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder()
                .addHeader("Authorization", "bearer " + authToken)
                .url(Url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("API Post", "Failed to send data to API!");
                postDataCallback.onFailure();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("API Post", "Data sent to API!");
                postDataCallback.onSuccess();
            }
        });
    }
}
