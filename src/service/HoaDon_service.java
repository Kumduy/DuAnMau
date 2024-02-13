/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import repository.QLhoaDon_repository;
import entity.HoaDon_entity;
import entity.HDCTmodel_entity;
import entity.SanPhamModel_view;

/**
 *
 * @author DELL
 */
public class HoaDon_service {

    QLhoaDon_repository d = new QLhoaDon_repository();

    public ArrayList<HoaDon_entity> getListHD() {
        return d.getList();
    }

    public ArrayList<HoaDon_entity> getListHDbyID(int id) {
        return d.getHDbyID(id);
    }

    public ArrayList<HoaDon_entity> getListHDbyTT(boolean trangThai) {
        return d.getHDbyTT(trangThai);
    }

    public ArrayList<HDCTmodel_entity> getListHDCT(int ID) {
        return d.getHDCTList(ID);
    }

    public ArrayList<SanPhamModel_view> getListSP() {
        return d.getSP();
    }
    
    public ArrayList<SanPhamModel_view> getListSPbyID(int id) {
        return d.getSPbyID(id);
    }

    public String addHD(HoaDon_entity hd) {
        boolean check = d.addHD(hd);
        if (check) {
            return "Tạo hóa đơn thành công";
        } else {
            return "Tạo hóa đơn thất bại";
        }
    }

    public String updateHD(HoaDon_entity hd) {
        boolean check = d.updateHD(hd);
        if (check) {
            return "Cập nhập hóa đơn thành công";
        } else {
            return "Cập nhập hóa đơn thất bại";
        }
    }
    
    public String huyHD(int id) {
        boolean check = d.huyHD(id);
        if (check) {
            return "Hủy hóa đơn thành công";
        } else {
            return "Hủy hóa đơn thất bại";
        }
    }

    public String updateSP(int sl, int ma) {
        boolean check = d.updateSL(sl, ma);
        if (check) {
            return "Cập nhập số lượng thành công";
        } else {
            return "Cập nhập số lượng thất bại";
        }
    }
    
    public String xoaHDCT(int idHDCT,int idHD){
        boolean check = d.xoaHDCT(idHDCT,idHD);
        if (check) {
            boolean check2 = d.capNhapTongTien(idHD);
            if (check2) {
                return "Xóa sản phẩm hóa đơn thành công";
            } else {
                return "Xóa sản phẩm hóa đơn thất bại";
            }
        } else {
            return "Xóa sản phẩm hóa đơn thất bại";
        }
    }

    public String themSanPhamVaoHoaDonChiTiet(int idHD, int idSP, int soLuongMua, double giaban) {
        boolean check = d.themSanPhamVaoHoaDonChiTiet(idHD, idSP, soLuongMua, giaban);
        if (check) {
            boolean check2 = d.capNhapTongTien(idHD);
            if (check2) {
                return "Thêm sản phẩm hóa đơn thành công";
            } else {
                return "Thêm sản phẩm hóa đơn thất bại";
            }
        } else {
            return "Thêm sản phẩm hóa đơn thất bại";
        }
    }

    public String updateTrangThai(String trangThai, int idHD) {
        if (trangThai.equals("Đã thanh toán")) {
            return "Sản phẩm này đã được thanh toán";
        } else {
            boolean check = d.updateTrangThaiHD(idHD);
            if (check) {
                return "Cập nhập trạng thái hóa đơn thành công";
            } else {
                return "Cập nhập trạng thái hóa đơn thất bại";
            }
        }
    }
}
