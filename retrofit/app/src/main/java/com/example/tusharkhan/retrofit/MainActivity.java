package com.example.tusharkhan.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
   // ListView listView;
    TextView tv;
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //   listView = findViewById(R.id.listView);
       et=findViewById(R.id.editText1);
       btn=findViewById(R.id.getinfo);
       tv=findViewById(R.id.text);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String s=et.getText().toString();
               getHeroes(s);
           }
       });



    }
    public void getHeroes(String s)
    {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
//String s="tushar-khan";
    Api api = retrofit.create(Api.class);
    Call<hero> call = api.getHeroes(s);

        call.enqueue(new Callback<hero>() {
        @Override
        public void onResponse(Call<hero> call, Response<hero> response) {
            hero heroes = response.body();
            tv.setText(heroes.getLogin());
            tv.setText(heroes.getId().toString());
            tv.setText(heroes.getPublicRepos().toString());
         //  String[] s1 = new String[2];
         //  s1[0] = heroes.getId().toString();
         //  s[1]= heroes.getPublicRepos().toString();
          //  listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s1));
        }

        @Override
        public void onFailure(Call<hero> call, Throwable t) {

        }
    });
    }
}