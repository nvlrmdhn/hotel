package com.kelompok1.kamar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok1.kamar.entity.Kamar;
import com.kelompok1.kamar.repository.KamarRepository;
import com.kelompok1.kamar.service.KamarService;

@Service
public class KamarServiceImpl implements KamarService{

    @Autowired
    KamarRepository kamarRepository;

    @Override
    public Kamar checkKamar(Integer id, String nama, Double harga, String status, Integer nomorKamar){

        Kamar kamar = kamarRepository.getKamar(id,nama,harga,status, nomorKamar);

        return kamar;
    }

    @Override
    public List<Kamar> checkSemuaKamar(String nama, Double harga, String status, Integer nomorKamar){

        List<Kamar> kamar = kamarRepository.getAllKamar(nama,harga,status, nomorKamar);

        return kamar;
    }
    
    @Override
    public Kamar updateKamar(Integer id, String nama, Double harga, String status){
        Kamar kamar = new Kamar();

        kamar = kamarRepository.getKamar(id,null,null,null, null);
        if (kamar == null) {
            return kamar;
        }

        int result = kamarRepository.updateKamar(id,nama,harga,status);

        if (result > 0) {
            kamar = kamarRepository.getKamar(id,nama,harga,status, null);
        }

        return kamar;
    }
}
