package com.example.ph41626_1506;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String magv;
    private String hoten;
    private double luong;
    private int tuoi;

    public Teacher(String magv, String hoten, double luong, int tuoi) {
        this.magv = magv;
        this.hoten = hoten;
        this.luong = luong;
        this.tuoi = tuoi;
    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
