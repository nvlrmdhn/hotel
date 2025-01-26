package com.kelompok1.transaksi.factory.impl;

import com.kelompok1.transaksi.factory.TransaksiFactory;

public class PembayaranFactory {
    public static TransaksiFactory getTransaksi(String tipePembayaran) {
        if ("Debit".equalsIgnoreCase(tipePembayaran)) {
            return new TransferBank();
        } else if ("CC".equalsIgnoreCase(tipePembayaran)) {
            return new CreditCard();
        } else if ("EWallet".equalsIgnoreCase(tipePembayaran)) {
            return new Ewallet();
        } else {
            throw new IllegalArgumentException("Tipe Pembayaran tidak dikenali");
       
        }
    }
}
