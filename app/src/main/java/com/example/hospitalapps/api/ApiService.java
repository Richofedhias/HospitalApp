package com.example.hospitalapps.api;

import com.example.hospitalapps.model.LayananItem;
import com.example.hospitalapps.model.ResponLayanan;
import com.example.hospitalapps.model.poli_ruangan;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Login.php")
    Call<ResponseBody> loginRequest(
            @Field("no_rekam_medis") String no_rekam_medis,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("Register.php")
    Call<ResponseBody> registerRequest(
            @Field("nama") String nama,
            @Field("telpon") String telpon,
            @Field("nomorktp") String nomorktp);

    @GET("coba.php")
    Call<List<poli_ruangan>> getRuangpoli();
}
