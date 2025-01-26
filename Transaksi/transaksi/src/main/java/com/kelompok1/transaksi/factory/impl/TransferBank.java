package com.kelompok1.transaksi.factory.impl;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.factory.TransaksiFactory;

public class TransferBank implements TransaksiFactory{
    @Override
        public Payment prosesPembayaran(double jumlah) {
        Payment payment = new Payment();
        payment.setMethod("Transfer Bank VA BCA");
        payment.setPrice(jumlah);
        System.out.println("Pembayaran dengan transfer bank");
        return payment;
    }
}
