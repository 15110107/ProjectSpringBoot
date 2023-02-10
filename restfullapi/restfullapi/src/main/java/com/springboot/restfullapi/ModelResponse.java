package com.springboot.restfullapi;

public class ModelResponse {
    private int SapXep;
    private String CodeValue;
    private String ThongTinNhom;
    private double SoTien;

    public int getSapXep(){return SapXep;}  
    public void setSapXep(int SapXep){this.SapXep = SapXep;}  

    public String getCodeValue(){return CodeValue;}  
    public void setCodeValue(String CodeValue){this.CodeValue = CodeValue;}  

    public String getThongTinNhom(){return ThongTinNhom;}  
    public void setThongTinNhom(String ThongTinNhom){this.ThongTinNhom = ThongTinNhom;}

    public double getSoTien(){return SoTien;}  
    public void setSoTien(Double SoTien){this.SoTien = SoTien;}
}
