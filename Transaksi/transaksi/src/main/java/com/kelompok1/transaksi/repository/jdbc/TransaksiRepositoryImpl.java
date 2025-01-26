package com.kelompok1.transaksi.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kelompok1.transaksi.entity.Transaksi;
import com.kelompok1.transaksi.repository.TransaksiRepository;

@Repository
public class TransaksiRepositoryImpl implements TransaksiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertBooking(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (kamar_id, member_id, checkin, checkout, booking_date) " +
                     "VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, transaksi.getKamarId(), transaksi.getMemberId(), transaksi.getCheckin(),
        transaksi.getCheckout(), transaksi.getBookingDate());
    }

    @Override
    public Transaksi getNewTransaksi(int memberId, int kamarId) {
         String sql = "SELECT id, kamar_id, member_id, checkin, checkout, booking_date, status FROM transaksi WHERE member_id = ? AND kamar_id = ? AND status = ?";
    
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Transaksi transaksi = new Transaksi();
                transaksi.setTransaksiId(rs.getInt("id"));
                transaksi.setKamarId(rs.getInt("kamar_id"));
                transaksi.setMemberId(rs.getInt("member_id"));
                transaksi.setCheckin(rs.getDate("checkin"));
                transaksi.setCheckout(rs.getDate("checkout"));
                transaksi.setBookingDate(rs.getTimestamp("booking_date"));
                transaksi.setStatus(rs.getString("status"));
                return transaksi;
            }, memberId, kamarId, "pending");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Tidak ada transaksi dengan member_id: " + memberId + ", kamar_id: " + kamarId + ", dan status: pending");
            return null;
        }
    }
    
}
