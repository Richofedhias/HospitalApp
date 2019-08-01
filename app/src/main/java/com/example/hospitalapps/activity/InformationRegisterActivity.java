package com.example.hospitalapps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hospitalapps.R;

public class InformationRegisterActivity extends AppCompatActivity {
    Button btn_Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_register);
        btn_Info = findViewById(R.id.btn_Next);
        btn_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationRegisterActivity.this, BerandaActivity.class);
                startActivity(intent);
            }
        });
    }
}
