package com.example.hospitalapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponLayanan {
    @SerializedName("m_poli_ruangan")
    private List<poli_ruangan> semualayanan;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public ResponLayanan(List<poli_ruangan> semualayanan, boolean error, String message) {
        this.semualayanan = semualayanan;
        this.error = error;
        this.message = message;
    }

    public List<poli_ruangan> getSemualayanan() {
        return semualayanan;
    }

    public void setSemualayanan(List<poli_ruangan> semualayanan) {
        this.semualayanan = semualayanan;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
