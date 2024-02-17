/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ThongKe_DoanhThu_Model;
import entity.ThongKe_SanPham_model;
import repository.ThongKe_DoanhThu_repository;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class QuanLyThongKe_service {

    ThongKe_DoanhThu_repository thongKe_DoanhThu_repository = new ThongKe_DoanhThu_repository();

    
 
    public ArrayList<ThongKe_SanPham_model> getList_ThongKeSanPham(){
        return thongKe_DoanhThu_repository.getList_ThongKeSanPham();
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
    
    public int getList_DoanhThuThanhCongbyTime(Date ngayBatDau, Date ngayKetThuc){
        return thongKe_DoanhThu_repository.getList_DoanhThuThanhCongbyTime(ngayBatDau, ngayKetThuc);
    }
    
    public int getList_DoanhThuThatBaibyTime(Date ngayBatDau, Date ngayKetThuc){
        return thongKe_DoanhThu_repository.getList_DoanhThuThatBaibyTime(ngayBatDau, ngayKetThuc);
    }
    
   
    
}
