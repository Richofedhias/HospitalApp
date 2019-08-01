package com.example.hospitalapps.api;

public class UtilsApi {
    public static final String BASE_URL_API = "http://33b604f9b931.sn.mynetname.net/webservice/";

    public static ApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
