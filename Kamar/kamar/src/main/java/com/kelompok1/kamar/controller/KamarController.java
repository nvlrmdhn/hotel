package com.kelompok1.kamar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kelompok1.kamar.Logger;
import com.kelompok1.kamar.entity.Kamar;
import com.kelompok1.kamar.service.KamarService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("kamar")
public class KamarController {

    private final Logger logger = Logger.getInstance();

    @Autowired
    KamarService kamarService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Object> searchKamar(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String nama,
        @RequestParam(required = false) Double harga, 
        @RequestParam(required = false) String status, 
        @RequestParam(required = false) Integer nomorKamar){
        logger.info("Search kamar");

        Kamar kamar = kamarService.checkKamar(id, nama, harga, status, nomorKamar);

        return new ResponseEntity<>(kamar, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Object> searchAll(
        @RequestParam(required = false) String nama,
        @RequestParam(required = false) Double harga, 
        @RequestParam(required = false) String status, 
        @RequestParam(required = false) Integer nomorKamar){
        logger.info("Search semua kamar");

        List<Kamar> kamar = kamarService.checkSemuaKamar(nama, harga, status, nomorKamar);

        return new ResponseEntity<>(kamar, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updateKamar(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String nama,
        @RequestParam(required = false) Double harga, 
        @RequestParam(required = false) String status){
        logger.info("update kamar");

        Kamar kamar = kamarService.updateKamar(id, nama, harga, status);

        return new ResponseEntity<>(kamar, HttpStatus.OK);
    }

}
