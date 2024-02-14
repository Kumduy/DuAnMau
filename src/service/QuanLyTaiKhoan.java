/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.NguoiDungModel;
import entity.TaiKhoanModel;
import entity.ThongKe_DoanhThu_Model;
import entity.ThongKe_SanPham_model;
import repository.NguoiDung_repository;
import repository.TaiKhoan_repository;
import repository.ThongKe_DoanhThu_repository;
import repository.ThongKe_SanPham_repository;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class QuanLyTaiKhoan {
    NguoiDung_repository nguoiDung_repository = new NguoiDung_repository();
    TaiKhoan_repository taiKhoan_repository = new TaiKhoan_repository();
    ThongKe_SanPham_repository thongKe_SanPham_repository = new ThongKe_SanPham_repository();
    ThongKe_DoanhThu_repository thongKe_DoanhThu_repository = new ThongKe_DoanhThu_repository();
    
    public ArrayList<NguoiDungModel> getList_NguoiDung(){
        return nguoiDung_repository.getList_NguoiDung();
    }
    
    public ArrayList<TaiKhoanModel> getList_TaiKhoan(){
        return taiKhoan_repository.getList_TaiKhoan();
    }
    
    public ArrayList<ThongKe_SanPham_model> getList_ThongKeSanPham(){
        return thongKe_SanPham_repository.getList_ThongKeSanPham();
    }
    
    public NguoiDungModel getId(String ten_NguoiDung){
        return nguoiDung_repository.getById(ten_NguoiDung);
    }
    
    public ArrayList<ThongKe_DoanhThu_Model> getList_ThongKeDoanhThu(){
        return thongKe_DoanhThu_repository.getList_DoanhThu();
    }
    
    public ArrayList<ThongKe_DoanhThu_Model> getList_DoanhThuByThoiGian(Date ngayBatDau,Date ngayKetThuc){
        return thongKe_DoanhThu_repository.getList_DoanhThuByThoiGian(ngayBatDau, ngayKetThuc);
    }
    
    public int getList_DoanhThuThanhCong(){
        return thongKe_DoanhThu_repository.getList_DoanhThuThanhCong();
    }
    
    public int getList_DoanhThuThatBai(){
        return thongKe_DoanhThu_repository.getList_DoanhThuThatBai();
    }
    
    public String AddNew_TaiKhoan(TaiKhoanModel tkModel){
        Boolean check = taiKhoan_repository.AddNew_TaiKhoan(tkModel);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    
    public String Update_TaiKhoan(TaiKhoanModel tkModel){
        Boolean check = taiKhoan_repository.Update_TaiKhoan(tkModel);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }
    public String Xoa_TaiKhoan(String tenDangNhap){
        Boolean check = taiKhoan_repository.Xoa_TaiKhoan(tenDangNhap) ;
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }
    
}
