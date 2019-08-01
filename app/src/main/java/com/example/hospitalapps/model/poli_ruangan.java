package com.example.hospitalapps.model;

import com.google.gson.annotations.SerializedName;

public class poli_ruangan {

    public String getPoliruangan_id() {
        return poliruangan_id;
    }

    public void setPoliruangan_id(String poliruangan_id) {
        this.poliruangan_id = poliruangan_id;
    }

    public String getNama_poliruangan() {
        return nama_poliruangan;
    }

    public void setNama_poliruangan(String nama_poliruangan) {
        this.nama_poliruangan = nama_poliruangan;
    }

    public String getInstalasi_id() {
        return instalasi_id;
    }

    public void setInstalasi_id(String instalasi_id) {
        this.instalasi_id = instalasi_id;
    }

    @SerializedName("poliruangan_id")
    private String poliruangan_id;

    public poli_ruangan(String poliruangan_id, String nama_poliruangan, String instalasi_id) {
        this.poliruangan_id = poliruangan_id;
        this.nama_poliruangan = nama_poliruangan;
        this.instalasi_id = instalasi_id;
    }

    @SerializedName("nama_poliruangan")
    private String nama_poliruangan;

    @SerializedName("instalasi_id")
    private String instalasi_id;


}
