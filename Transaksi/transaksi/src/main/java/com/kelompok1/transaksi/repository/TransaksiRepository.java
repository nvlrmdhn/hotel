package com.kelompok1.transaksi.repository;

import com.kelompok1.transaksi.entity.Transaksi;

public interface TransaksiRepository {

    int insertBooking(Transaksi transaksi);

    Transaksi getNewTransaksi(int memberId, int kamarId);

}
