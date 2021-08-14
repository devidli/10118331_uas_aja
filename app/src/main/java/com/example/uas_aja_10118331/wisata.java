package com.example.uas_aja_10118331;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class wisata extends AppCompatActivity implements OnMapReadyCallback {
    String kota;
    DaftarWisataImp daftarWisataImp;
    TextView nama;
    TextView wisata;
    ImageView gambar;
    double latitude;
    double longtitude;
    GoogleMap maps;
    LatLng latlng ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wisata);
        wisata = findViewById(R.id.deskripsi);
        nama = findViewById(R.id.kota);
        gambar = findViewById(R.id.gambar);
        kota = (getIntent().getStringExtra("kota"));
        daftarWisataImp = new DaftarWisataImp();
        daftarWisataImp.getListWisata(kota);
        daftarWisataImp.setDataAlamListener(result ->{
        nama.setText(result.get(0).getNama());
        Picasso.get().load(result.get(0).getImg()).into(gambar);
        wisata.setText(result.get(0).getDesc());
        longtitude = result.get(0).getLatLng().longitude;
        latitude = result.get(0).getLatLng().latitude;
            latlng = new LatLng(latitude,longtitude);
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.maps);
            mapFragment.getMapAsync(this);

        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        maps = googleMap;

        maps.addMarker(
                new MarkerOptions()
                        .position(latlng)
                        .title(kota)
        );
        maps.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f));
    }
}
// 14 Agustus 2021
// 10118331
// Devidli Setiawan
//IF-8