package com.example.tusharkhan.altitudewithretrofit;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface Api {
    String BASE_URL = "http://shafayatsnest.com/sunposition/";
    @GET("get-altitude/")
    Call<hero>getHeroes(@Query("timezone") int timezone,@Query("latitude") double latitude,@Query("longitude") double longitude);
}
