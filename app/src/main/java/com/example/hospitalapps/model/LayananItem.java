package com.example.hospitalapps.model;

import com.google.gson.annotations.SerializedName;

public class LayananItem {

    @SerializedName("kelaspelayanan_id")
    private String id;

    @SerializedName("kelaspelayanan_nama")
    private String namapelayanan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamapelayanan() {
        return namapelayanan;
    }

    public void setNamapelayanan(String namapelayanan) {
        this.namapelayanan = namapelayanan;
    }

    public LayananItem(String id, String namapelayanan) {
        this.id = id;
        this.namapelayanan = namapelayanan;
    }
}
