package com.example.uas_aja_10118331;

import com.google.android.gms.maps.model.LatLng;
public class ListWisata {
    String Nama;
    String Desc;
    String gambar;
    LatLng latLng;


    public ListWisata(String nama, String desc, String gambar, LatLng latLng) {
        Nama = nama;
        Desc = desc;
        this.gambar = gambar;
        this.latLng = latLng;

    }


    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) { Desc = desc; }

    public String getImg() {
        return gambar;
    }

    public void setImg(String img) {
        this.gambar = img;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public ListWisata(String desc, String gambar, LatLng latLng) {
        Desc = desc;
        this.gambar = gambar;
        this.latLng = latLng;
    }
}

// 14 Agustus 2021
// 10118331
// Devidli Setiawan
//IF-8