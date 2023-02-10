package com.hometest.workhomeapi.account;

public class ModelAccount {
    private int userId;
    private int accountNumber;
    private String ThongTinNhom;
    private double SoTien;

    public int userId() {
        return userId;
    }

    public void userId(int userId) {
        this.userId = userId;
    }

    public int accountNumber() {
        return accountNumber;
    }

    public void accountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getThongTinNhom() {
        return ThongTinNhom;
    }

    public void setThongTinNhom(String ThongTinNhom) {
        this.ThongTinNhom = ThongTinNhom;
    }

    public double getSoTien() {
        return SoTien;
    }

    public void setSoTien(Double SoTien) {
        this.SoTien = SoTien;
    }
}
