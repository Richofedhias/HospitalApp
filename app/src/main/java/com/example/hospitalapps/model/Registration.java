package com.example.hospitalapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registration {

    @Expose
    @SerializedName("pendaftaran_id") private int pendaftaran_id;
    @Expose
    @SerializedName("nama") private String nama;
    @Expose
    @SerializedName("telpon") private String telpon;
    @Expose
    @SerializedName("nomorktp") private String nomorktp;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;

    public int getPendaftaran_id() {
        return pendaftaran_id;
    }

    public void setPendaftaran_id(int pendaftaran_id) {
        this.pendaftaran_id = pendaftaran_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getNomorktp() {
        return nomorktp;
    }

    public void setNomorktp(String nomorktp) {
        this.nomorktp = nomorktp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
