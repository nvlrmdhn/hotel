package com.kelompok1.transaksi.factory.impl;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.factory.TransaksiFactory;

public class Ewallet implements TransaksiFactory{
 
     @Override
        public Payment prosesPembayaran(double jumlah) {
        Payment payment = new Payment();
        payment.setMethod("E wallet");
        payment.setPrice(jumlah);
        System.out.println("Pembayaran dengan E wallet: " + jumlah);
        return payment;
    }   
}
