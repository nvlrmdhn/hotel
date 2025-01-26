package com.kelompok1.kamar.service;

import java.util.List;

import com.kelompok1.kamar.entity.Kamar;

public interface KamarService {
    
    Kamar checkKamar(Integer id, String nama, Double harga, String status, Integer nomorKamar);

    List<Kamar> checkSemuaKamar(String nama, Double harga, String status, Integer nomorKamar);

    Kamar updateKamar(Integer id, String nama, Double harga, String status);
}
