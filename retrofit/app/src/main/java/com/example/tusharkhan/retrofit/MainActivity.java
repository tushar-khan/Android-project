package com.example.tusharkhan.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<hero> call = api.getHeroes();

        call.enqueue(new Callback<hero>() {
            @Override
            public void onResponse(Call<hero> call, Response<hero> response) {
                hero heroes = response.body();
                String[] s = new String[2];
                s[0] = heroes.getId().toString();
                s[1]= heroes.getPublicRepos().toString();
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s));
            }

            @Override
            public void onFailure(Call<hero> call, Throwable t) {

            }
        });

    }
}