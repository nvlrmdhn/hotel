package com.kelompok1.kamar.entity;

public class Kamar {

        private int id;
        private String nama;
        private double harga;
        private String status;
        private int noKamar;
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getNama() {
            return nama;
        }
    
        public void setNama(String nama) {
            this.nama = nama;
        }
    
        public double getHarga() {
            return harga;
        }
    
        public void setHarga(double harga) {
            this.harga = harga;
        }
    
        public String getStatus() {
            return status;
        }
    
        public void setStatus(String status) {
            this.status = status;
        }
    
        public int getNoKamar() {
            return noKamar;
        }
    
        public void setNoKamar(int noKamar) {
            this.noKamar = noKamar;
        }
}
