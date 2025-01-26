package com.kelompok1.transaksi.observer;

import com.kelompok1.transaksi.entity.Payment;

public interface TransaksiObserver {
    void update(Payment payment);
}
