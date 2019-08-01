package com.example.hospitalapps;

import com.example.hospitalapps.model.poli_ruangan;

import java.util.List;

public interface RuangPoliView {

    void onShowDialog();
    void onHideDialog();
    void onSucces(List<poli_ruangan> data);
    void onFailed(String message);
    void isEmpty();

}
