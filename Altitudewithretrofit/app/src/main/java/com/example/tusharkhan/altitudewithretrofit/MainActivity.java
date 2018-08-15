package com.example.tusharkhan.altitudewithretrofit;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity  {

    TextView tv;
    LocationManager lm;
    Location l;
    Button btn;
    TimeZone tz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.okbutton);
        tv = findViewById(R.id.textview);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        l = lm.getLastKnownLocation(lm.NETWORK_PROVIDER);

        //   tz = TimeZone.getDefault();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  int timezone = tz.getDisplayName(false, TimeZone.SHORT);
                Calendar calendar = Calendar.getInstance();

                double longitude = l.getLongitude();
                double latitude = l.getLatitude();
                getHeroes(calendar.get(Calendar.ZONE_OFFSET ),latitude,longitude);
                // tv.setText("Longitude: " + longitude + "\n" + "Latitude: " + latitude + "\n" + "Time Zone: " + s);
            }
        });

    }
    public void getHeroes(int timezone, double latitude,double longitude)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//String s="tushar-khan";
        Api api = retrofit.create(Api.class);
       Call <hero> call=api.getHeroes(timezone,latitude,longitude);
       call.enqueue(new Callback<hero>() {
           @Override
           public void onResponse(Call<hero> call, Response<hero> response) {
               hero object=response.body();
               tv.setText("Current Altitude: "+ object.getData());
           }

           @Override
           public void onFailure(Call<hero> call, Throwable t) {

           }
       });
    }

}
