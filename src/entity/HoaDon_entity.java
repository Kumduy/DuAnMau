/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class HoaDon_entity {
    private int maHD,maNV,maKH;
    private double tongTien;
    private java.sql.Date ngayTao;
    private boolean trangThai;

    public HoaDon_entity(int maHD, int maNV, int maKH, double tongTien, Date ngayTao, boolean trangThai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon_entity() {
    }

    public int getMaHD() {
        return maHD;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
