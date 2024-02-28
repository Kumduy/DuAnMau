/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class SanPhamDaMua_model {

    private int maSanPham;
    private String tenSanPham;
    private String mauSac;
    private double size;
    private String tenDanhMuc;
    private int soLuong;
    private double donGia;
    private int maHoaDon;
    private int maKhachHang;

    public SanPhamDaMua_model() {
    }

    public SanPhamDaMua_model(int maSanPham, String tenSanPham, String mauSac, double size, String tenDanhMuc, int soLuong, double donGia, int maHoaDon, int maKhachHang) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.size = size;
        this.tenDanhMuc = tenDanhMuc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
    }


    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    
    
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

   

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

}
