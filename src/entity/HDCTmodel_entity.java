/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class HDCTmodel_entity {
    private int maHD,maHDCT,maSP,soLuong;
    private double donGia;
    private String trangThai,tenSP;

    public HDCTmodel_entity(int maHD, int maHDCT, int maSP, int soLuong, double donGia, String trangThai, String tenSP) {
        this.maHD = maHD;
        this.maHDCT = maHDCT;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.tenSP = tenSP;
    }

    public HDCTmodel_entity() {
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getMaHD() {
        return maHD;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getTenSP() {
        return tenSP;
    }
    
}
