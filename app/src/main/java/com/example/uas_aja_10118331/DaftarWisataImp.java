package com.example.uas_aja_10118331;

import android.os.Build;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaftarWisataImp implements DaftarWisataInterfaces {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private DataAlamListener dataAlamListener;

    public void setDataAlamListener(DataAlamListener listener) {
        this.dataAlamListener = listener;

    }

    @Override
    public void getListWisata(String kota) {
        ArrayList<ListWisata> result = new ArrayList<ListWisata>();
        myRef.child(kota).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                HashMap<String, Object> explrObject = (HashMap<String, Object>) task.getResult().getValue();
                String nama = (String) explrObject.get("nama");
                String desc = (String) explrObject.get("deskripsi");
                String gambar = (String) explrObject.get("gambar");
                String latitude = String.valueOf(explrObject.get("latitude"));
                String longtitude = String.valueOf(explrObject.get("longtitude"));
                ListWisata listWisata = new ListWisata(nama, desc, gambar, new LatLng(Double.parseDouble(latitude), Double.parseDouble(longtitude)));
                result.add(listWisata);
            }
            dataAlamListener.onSuccess(result);
        });
    }
    public interface DataAlamListener {

        void onSuccess(List<ListWisata> result);
    }
}
// 13 Agustus 2021
// 10118331
// Devidli Setiawan
//IF-8