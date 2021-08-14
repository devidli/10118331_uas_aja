package com.example.uas_aja_10118331;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {

 ImageButton cimahi;
 ImageButton bandung;
 ImageButton bandungbarat;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.cimahi).setOnClickListener(v->{
            Intent intent = new Intent(requireContext(), wisata.class);
            intent.putExtra("kota", "Kota Cimahi");
            startActivity(intent);
        });
        view.findViewById(R.id.bandung).setOnClickListener(v->{
            Intent intent = new Intent(requireContext(), wisata.class);
            intent.putExtra("kota", "Kota Bandung");
            startActivity(intent);
        });
        view.findViewById(R.id.bandungbarat).setOnClickListener(v->{
            Intent intent = new Intent(requireContext(), wisata.class);
            intent.putExtra("kota", "Bandung Barat");
            startActivity(intent);
        });
    }
}

// 13 Agustus 2021
// 10118331
// Devidli Setiawan
//IF-8