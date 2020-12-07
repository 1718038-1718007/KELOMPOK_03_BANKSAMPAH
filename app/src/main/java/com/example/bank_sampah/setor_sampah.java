package com.example.bank_sampah;

public class setor_sampah {
    private String id,nama,alamat,sampah,berat;

    public setor_sampah(String id, String nama, String alamat, String sampah, String berat){
        this.id= id;
        this.nama = nama;
        this.alamat = alamat;
        this.sampah = sampah;
        this.berat = berat;
    }

    public  setor_sampah(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSampah() {
        return sampah;
    }

    public void setSampah(String sampah) {
        this.sampah = sampah;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }
}
