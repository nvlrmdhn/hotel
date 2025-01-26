package com.kelompok1.transaksi.factory;

import com.kelompok1.transaksi.entity.Payment;

public interface TransaksiFactory {
    Payment prosesPembayaran(double jumlah);
}
