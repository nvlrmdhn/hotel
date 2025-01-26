package com.kelompok1.transaksi.transaksiService;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.entity.Transaksi;

public interface TransaksiService {

    Transaksi booking(Transaksi transaksi);

    Payment payment(Double amount, String paymentType);

}
