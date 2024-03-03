/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.SanPhamDaMua_model;
import entity.KhachHangModel;
import java.util.ArrayList;
import repository.KhachHang_repository;

/**
 *
 * @author DELL
 */
public class QLKH_service {

    KhachHang_repository khachHang_repository = new KhachHang_repository();

    public ArrayList<KhachHangModel> getList_KhachHang() {
        return khachHang_repository.getList_KhachHang();
    }

    public ArrayList<SanPhamDaMua_model> getList_HoaDonDaMua(int maKH) {
        return khachHang_repository.getList_HoaDonDaMua(maKH);
    }

    public String AddNew_KhachHang(KhachHangModel kh) {
        if (khachHang_repository.getList_KhachHangBySDT(kh.getSoDienThoai()).size() > 0) {
            return "Số điện thoại đã tồn tại";
        }else{
            Boolean check = khachHang_repository.AddNew_KhachHang(kh);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
        }
    }

    public String Update_KhachHang(KhachHangModel kh, int maKH) {
        Boolean check = khachHang_repository.Update_KhachHang(kh, maKH);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    public String Xoa_KhachHang(int maKh) {
        Boolean check = khachHang_repository.An_KhachHang(maKh);
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }
}
