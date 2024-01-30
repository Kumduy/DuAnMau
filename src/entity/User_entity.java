/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class User_entity {
    private String tenTK,matKhau,TenNguoiDung,SDT, VaiTro,GioiTinh;
    private int MaNguoiDung,MaTaiKhoan;

    public User_entity(String tenTK, String matKhau, String TenNguoiDung, String SDT, String VaiTro, String GioiTinh, int MaNguoiDung, int MaTaiKhoan) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.TenNguoiDung = TenNguoiDung;
        this.SDT = SDT;
        this.VaiTro = VaiTro;
        this.GioiTinh = GioiTinh;
        this.MaNguoiDung = MaNguoiDung;
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public User_entity() {
    }

    public String getTenTK() {
        return tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenNguoiDung() {
        return TenNguoiDung;
    }

    public String getSDT() {
        return SDT;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public int getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenNguoiDung(String TenNguoiDung) {
        this.TenNguoiDung = TenNguoiDung;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public void setMaTaiKhoan(int MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }
    
    
}
