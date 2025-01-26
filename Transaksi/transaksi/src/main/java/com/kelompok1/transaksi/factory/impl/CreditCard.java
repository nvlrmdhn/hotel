package com.kelompok1.transaksi.factory.impl;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.factory.TransaksiFactory;

public class CreditCard implements TransaksiFactory{
 @Override
        public Payment prosesPembayaran(double jumlah) {
        Payment payment = new Payment();
        payment.setMethod("Credit Card");
        payment.setPrice(jumlah);
        System.out.println("Pembayaran dengan Kartu Kredit: " + jumlah);
        return payment;
    }   
}
