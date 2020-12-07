package com.example.bank_sampah;

public class sampah {
    private String namasampah,jenissampah,urai;
    private Integer gambar;

    public Integer getGambar(){
        return  gambar;
    }

    public void setGambar(Integer gambar){
        this.gambar = gambar;
    }

    public sampah(String namasampah, String jenissampah, String urai, Integer gambar){
        this.namasampah = namasampah;
        this.jenissampah = jenissampah;
        this.urai =urai;
        this.gambar = gambar;
    }

    public String getNamasampah() {
        return namasampah;
    }

    public void setNamasampah(String namasampah) {
        this.namasampah = namasampah;
    }

    public String getJenissampah() {
        return jenissampah;
    }

    public void setJenissampah(String jenissampah) {
        this.jenissampah = jenissampah;
    }

    public String getUrai() {
        return urai;
    }

    public void setUrai(String urai) {
        this.urai = urai;
    }
}
