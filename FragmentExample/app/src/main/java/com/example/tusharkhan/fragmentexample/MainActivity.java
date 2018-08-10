package com.example.tusharkhan.fragmentexample;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button3);
        btn2=findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(view);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(view);
            }
        });
    }

    public void change(View view)
    {
       Fragment1 f1=new Fragment1();
       Fragment2 f2=new Fragment2();
       if(view==findViewById(R.id.button3))
       {

           FragmentManager fm=getSupportFragmentManager();
           FragmentTransaction ft=fm.beginTransaction();
           ft.add(R.id.fragment,f1);
           ft.commit();

       }
        if(view==findViewById(R.id.button4))
        {

            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.add(R.id.fragment,f2);
            ft.commit();

        }
    }
}
