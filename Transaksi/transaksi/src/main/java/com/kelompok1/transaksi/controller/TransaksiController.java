package com.kelompok1.transaksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.entity.Transaksi;
import com.kelompok1.transaksi.transaksiService.TransaksiService;

@RestController
@RequestMapping("transaksi")
public class TransaksiController {

    @Autowired
    TransaksiService transaksiService;

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<Object> memberRegister(@RequestBody Transaksi transaksi){
        
        Transaksi transaksiResp = transaksiService.booking(transaksi);
        if(transaksiResp != null){
            return new ResponseEntity<Object>(transaksiResp, HttpStatus.OK);
        } else{
            return new ResponseEntity<Object>(transaksiResp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public Payment payment(@RequestParam String paymentType, @RequestParam Double amount){
        Payment payment = new Payment();

        payment = transaksiService.payment(amount,paymentType);

        return payment;
    }
    
}
