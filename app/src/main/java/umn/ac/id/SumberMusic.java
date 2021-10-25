package umn.ac.id;

import java.io.Serializable;

public class SumberMusic implements Serializable {
    private String judul;
    private String keterangan;
    private int MusicURI;
    public SumberMusic(String judul, String keterangan,
                       int MusicURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.MusicURI = MusicURI;
    }
    public String getJudul() { return this.judul; }
    public String getKeterangan() { return this.keterangan; }
    public void setJudul(String judul){ this.judul = judul; }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public String toString() { return this.getJudul() + " => " + this.getKeterangan(); }
    public int getMusicURI(){
            return this.MusicURI;
    }
}
