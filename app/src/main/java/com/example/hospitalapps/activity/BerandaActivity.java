package com.example.hospitalapps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.hospitalapps.R;

public class BerandaActivity extends AppCompatActivity {
    GridLayout mainGrid;
    TextView tvMnamaPasien;
    String resultNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);

        //get data login
        initComponents();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultNama = extras.getString("result_nama");
            tvMnamaPasien.setText(resultNama);
    }

    private void initComponents() {
        tvMnamaPasien = findViewById(R.id.tv_ber_nama_pas);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent(BerandaActivity.this, ReservasiActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 1) {
                        Intent intent = new Intent(BerandaActivity.this, AntrianActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 2) {
                        Intent intent = new Intent(BerandaActivity.this, DaftarDokterActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 3) {
                        Intent intent = new Intent(BerandaActivity.this, ProfilActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
