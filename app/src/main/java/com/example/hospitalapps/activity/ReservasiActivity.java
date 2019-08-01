package com.example.hospitalapps.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.hospitalapps.R;
import com.example.hospitalapps.RuangPoliPresenter;
import com.example.hospitalapps.RuangPoliView;
import com.example.hospitalapps.api.ApiService;
import com.example.hospitalapps.api.UtilsApi;
import com.example.hospitalapps.model.LayananItem;
import com.example.hospitalapps.model.ResponLayanan;
import com.example.hospitalapps.model.poli_ruangan;
import com.kosalgeek.android.json.JsonConverter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservasiActivity extends AppCompatActivity implements RuangPoliView {
    private Spinner jenisKelamin, jenisLayanan, jam, dokter, asuransi1, asuransi2;
    Context mContext;
    ApiService mApiService;


    final String[] jeniskelamin = {
            "Laki - Laki",
            "Perempuan"
    };

    final String[] asuransi1item ={
            "Pilih",
            "BPJS Kesehatan",
            "AXA",
            "Prudential",
            "BNI Life",
            "AIA",
            "Simas Sehat",
            "Jamkesda",
            "BPJS Ketenagakerjaan",
            "Krishna Life",
            "Manulife",
            "Mega Insurance",
            "Bringin Life",
            "Allianz",
            "Jiwasraya",
            "BumiPutera 1912",
            "Avrist"
    };

    final String[] asuransi2item ={
            "Pilih",
            "BPJS Kesehatan",
            "AXA",
            "Prudential",
            "BNI Life",
            "AIA",
            "Simas Sehat",
            "Jamkesda",
            "BPJS Ketenagakerjaan",
            "Krishna Life",
            "Manulife",
            "Mega Insurance",
            "Bringin Life",
            "Allianz",
            "Jiwasraya",
            "BumiPutera 1912",
            "Avrist"
    };



    Spinner spinnerLayanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasi);

        jenisKelamin = findViewById(R.id.spin_jenisKel);
        jenisLayanan = findViewById(R.id.spin_jenisLayanan);
        jam = findViewById(R.id.spin_jam);
        dokter = findViewById(R.id.spin_dokter);
        asuransi1 = findViewById(R.id.spin_Asuransi1);
        asuransi2 = findViewById(R.id.spin_Asuransi2);
        spinnerLayanan = findViewById(R.id.spin_layanan);
        ButterKnife.bind(this);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

//        initSpinnerItem(spinnerLayanan);

        RuangPoliPresenter ruangPoliPresenter = new RuangPoliPresenter(this);
        ruangPoliPresenter.getResponseCoba(mApiService);


        spinnerLayanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //inisialisasi Spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, jeniskelamin);
        jenisKelamin.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, asuransi1item);
        asuransi1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, asuransi2item);
        asuransi2.setAdapter(arrayAdapter2);




    }
//    Spinner spinner
    private void initSpinner(List<poli_ruangan> list){

        ArrayList<poli_ruangan> array = new ArrayList<>();
        array.addAll(list);

        List<String> listspinner = new ArrayList<>();
        for (int i = 0; i < array.size() ; i++) {
            listspinner.add(array.get(i).getNama_poliruangan());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, listspinner);
        spinnerLayanan.setAdapter(adapter);
    }

//    private void initSpinnerItem(final Spinner spinner){
//
//        mApiService.getRuangpoli().enqueue(new Callback<List<poli_ruangan>>() {
//            @Override
//            public void onResponse(Call<List<poli_ruangan>> call, Response<List<poli_ruangan>> response) {
//                if (response.isSuccessful()){
//                    initSpinner(spinner, response.body());
//                    Log.d("Response", response.body().get(0).getNama_poliruangan());
//                    Toast.makeText(mContext,"Hasil ",Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<poli_ruangan>> call, Throwable t) {
//                Toast.makeText(mContext,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
//
//            }
//
//
//        });
//    }


    @Override
    public void onShowDialog() {

    }

    @Override
    public void onHideDialog() {

    }

    @Override
    public void onSucces(List<poli_ruangan> data) {
        initSpinner(data);
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void isEmpty() {

    }
}
