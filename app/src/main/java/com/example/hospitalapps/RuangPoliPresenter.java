package com.example.hospitalapps;

import android.util.Log;
import android.widget.Toast;

import com.example.hospitalapps.api.ApiService;
import com.example.hospitalapps.model.poli_ruangan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RuangPoliPresenter {

    RuangPoliView responseView;

    public RuangPoliPresenter(RuangPoliView responseView) {
        this.responseView = responseView;
    }

    public void getResponseCoba(ApiService mApiService){
        responseView.onShowDialog();
        mApiService.getRuangpoli().enqueue(new Callback<List<poli_ruangan>>() {
            @Override
            public void onResponse(Call<List<poli_ruangan>> call, Response<List<poli_ruangan>> response) {
                if (response.isSuccessful()){
                    responseView.onHideDialog();
                    responseView.onSucces(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<poli_ruangan>> call, Throwable t) {
                responseView.onHideDialog();
                responseView.onFailed(t.getLocalizedMessage());
            }


        });


    }


}
