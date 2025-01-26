package com.kelompok1.transaksi.observer.impl;

import org.springframework.stereotype.Component;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.observer.TransaksiObserver;

@Component
public class NotificationObserver implements TransaksiObserver {
    @Override
    public void update(Payment payment) {
        System.out.println("Notifikasi: Pembayaran berhasil dengan metode " 
            + payment.getMethod() + " sebesar " + payment.getPrice());
    }
}
