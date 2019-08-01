package com.example.hospitalapps.activity.main;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.hospitalapps.R;
import com.example.hospitalapps.activity.ReservasiActivity;
import com.example.hospitalapps.activity.login.LoginActivity;
import com.example.hospitalapps.activity.registration.RegisterActivity;

public class MainActivity extends AppCompatActivity {
    RelativeLayout reLLay1;
    ImageView logo2;
    Button userLama, userBaru;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            reLLay1.setVisibility(View.VISIBLE);
            logo2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reLLay1 = findViewById(R.id.rellay1);
        logo2 = findViewById(R.id.logo_2);
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        userLama = findViewById(R.id.btn_UserLama);
        userLama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservasiActivity.class);
                startActivity(intent);
            }
        });
        userBaru = findViewById(R.id.btn_UserBaru);
        userBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
