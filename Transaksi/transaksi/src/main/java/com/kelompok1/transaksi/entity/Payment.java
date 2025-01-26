package com.kelompok1.transaksi.entity;

public class Payment {
    
    String method;
    Double price;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }    
}
