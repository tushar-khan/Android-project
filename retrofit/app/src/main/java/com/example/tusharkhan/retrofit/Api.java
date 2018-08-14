package com.example.tusharkhan.retrofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.github.com/users/";
    @GET("tushar-khan")
    Call<hero>getHeroes();
}