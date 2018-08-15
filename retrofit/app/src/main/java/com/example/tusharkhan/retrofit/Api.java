package com.example.tusharkhan.retrofit;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://api.github.com/";
    @GET("users/{UserId}")
    Call<hero>getHeroes(@Path("UserId") String login);
}