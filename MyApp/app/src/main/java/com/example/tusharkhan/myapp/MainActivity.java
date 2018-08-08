package com.example.tusharkhan.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView,txt;
    Button Ok,Ok2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.ShowtextView2);
        textView=findViewById(R.id.ShowtextView);
        Ok=findViewById(R.id.OkButton);
        Ok2=findViewById(R.id.OkButton2);
        Ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("Here I Am!!");
                Toast.makeText(MainActivity.this,
                        "Now Click Go Next!", Toast.LENGTH_LONG).show();
            }
        });
        }
}
