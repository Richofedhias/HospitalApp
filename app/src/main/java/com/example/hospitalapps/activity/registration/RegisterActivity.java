package com.example.hospitalapps.activity.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.hospitalapps.R;
import com.example.hospitalapps.activity.InformationRegisterActivity;
import com.example.hospitalapps.api.ApiService;
import com.example.hospitalapps.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity{

    Button btn_regis;
    EditText et_mNama;
    EditText et_mTelpon;
    EditText et_mNoKtp;

    ProgressDialog mLoading;
    Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponent();

    }

    private void initComponent() {
        et_mNama = findViewById(R.id.etRegis_Nama);
        et_mTelpon = findViewById(R.id.etRegis_NoTelp);
        et_mNoKtp = findViewById(R.id.etRegis_NoKTP);
        btn_regis = findViewById(R.id.btn_Register);

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoading = ProgressDialog.show(mContext,null,"Harap Tunggu...", true, false);
                requestRegister();
            }
        });
    }

    private void requestRegister() {
        final String nama = et_mNama.getText().toString();
        final String telpon = et_mTelpon.getText().toString();
        final String nomorktp = et_mNoKtp.getText().toString();
        mApiService.registerRequest(nama, telpon, nomorktp)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: Berhasil");
//                            startActivity(new Intent(mContext, InformationRegisterActivity.class));
                            mLoading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                Log.i("nama", nama);
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "Anda Berhasil Registrasi", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, InformationRegisterActivity.class));
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(mContext, "gagal", Toast.LENGTH_SHORT).show();
                            Log.i("debug", "onResponse: Tidak Berhasil");
                            mLoading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
