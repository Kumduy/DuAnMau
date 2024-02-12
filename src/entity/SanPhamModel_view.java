/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class SanPhamModel_view {
    private int maSP,soLuong;
    private String tenSP,danhMuc,mauSac;
    private double donGia,size;
    private boolean trangThai;

    public SanPhamModel_view(int maSP, int soLuong, String tenSP, String danhMuc, String mauSac, double donGia, double size, boolean trangThai) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
        this.danhMuc = danhMuc;
        this.mauSac = mauSac;
        this.donGia = donGia;
        this.size = size;
        this.trangThai = trangThai;
    }

    public SanPhamModel_view() {
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
