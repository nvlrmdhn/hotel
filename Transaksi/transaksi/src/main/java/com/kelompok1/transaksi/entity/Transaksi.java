package com.kelompok1.transaksi.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Transaksi {
    
    private int transaksiId;
    private int kamarId;
    private int memberId;
    private Date checkin;
    private Date checkout;
    private Timestamp bookingDate;
    private String status;

    public int getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(int transaksiId) {
        this.transaksiId = transaksiId;
    }

    public int getKamarId() {
        return kamarId;
    }

    public void setKamarId(int kamarId) {
        this.kamarId = kamarId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
