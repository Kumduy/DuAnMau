/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ThongKe_DoanhThu_Model {

    private int maHoaDon;
    private double tongTien;
    private Date ngayTaoHoaDon;
    private String khachHang;

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public ThongKe_DoanhThu_Model() {
    }

    public ThongKe_DoanhThu_Model(int maHoaDon, double tongTien, Date ngayTaoHoaDon) {
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }


}
