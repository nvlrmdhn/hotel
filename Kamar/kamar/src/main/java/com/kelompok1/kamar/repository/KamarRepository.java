package com.kelompok1.kamar.repository;

import java.util.List;

import com.kelompok1.kamar.entity.Kamar;

public interface KamarRepository {
    
    Kamar getKamar(Integer id,String nama, Double harga, String status, Integer nomorKamar);

    List<Kamar> getAllKamar(String nama, Double harga, String status, Integer nomorKamar);

    int updateKamar(Integer id, String nama, Double harga, String status);

}
