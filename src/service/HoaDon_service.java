/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import entity.KhachHangModel;
import repository.QLhoaDon_repository;
import repository.KhachHang_repository;
import entity.HoaDon_entity;
import entity.HDCTmodel_entity;
import entity.HoaDonModel;
import entity.SanPhamModel_view;

/**
 *
 * @author DELL
 */
public class HoaDon_service {

    KhachHang_repository k = new KhachHang_repository();

    QLhoaDon_repository d = new QLhoaDon_repository();

    public ArrayList<KhachHangModel> getKhachHangBySDT(String SDT) {
        return k.getList_KhachHangBySDT(SDT);
    }

    public ArrayList<KhachHangModel> getKhachHangByName(String name) {
        return k.getList_KhachHangByName(name);
    }

    public ArrayList<HoaDonModel> getListHD() {
        return d.getList();
    }

    public ArrayList<HoaDonModel> getListBySreach(String TypeData, String data) {
        return d.getListBySreach(TypeData, data);
    }

    public HoaDonModel getListHDmodelbyID(int id) {
        return d.getListByID(id);
    }

    public ArrayList<HoaDon_entity> getListHDbyID(int id) {
        return d.getHDbyID(id);
    }

    public ArrayList<HoaDonModel> getListHDbyTT(String trangThai) {
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
        if (hd.getTrangThai().equals("Đã thanh toán")) {
            return "Sản phẩm này đã được thanh toán";
        } else {
            boolean check = d.updateHD(hd);
            if (check) {
                return "Cập nhập hóa đơn thành công";
            } else {
                return "Cập nhập hóa đơn thất bại";
            }
        }
    }

    public String huyHD(int id) {
        if (d.getHDbyID(id).get(0).getTrangThai().equals("Đã thanh toán")) {
            return "Sản phẩm này đã được thanh toán không thể hủy";
        } else {
            boolean check = d.huyHD(id);
            if (check) {
                return "Hủy hóa đơn thành công";
            } else {
                return "Hủy hóa đơn thất bại";
            }
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

    public String xoaHDCT(String trangThai, int idHDCT, int idHD) {
        if (trangThai.equals("Đã thanh toán")) {
            return "sửa";
        } else {
            boolean check = d.xoaHDCT(idHDCT);
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
    }
    
    public String updateHDCT(String trangThai,int idHDCT,int soLuong,int idHD) {
        if (trangThai.equals("Đã thanh toán")) {
            return "sửa";
        } else {
            boolean check = d.updateHDCT(idHDCT, soLuong);
            if (check) {
                boolean check2 = d.capNhapTongTien(idHD);
                if (check2) {
                    return "Cập nhập số lượng sản phẩm hóa đơn thành công";
                } else {
                    return "Cập nhập số lượng sản phẩm hóa đơn thất bại";
                }
            } else {
                return "Cập nhập số lượng phẩm hóa đơn thất bại";
            }
        }
    }

    public String themSanPhamVaoHoaDonChiTiet(String trangThai, int idHD, int idSP, int soLuongMua, double giaban) {
        if (trangThai.equals("Đã thanh toán")) {
            return "Sản phẩm này đã được thanh toán không thể hủy";
        } else {
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
    }

    public ArrayList<String> getTrangThaiList() {
        return d.getTrangThai();
    }

    public String updateTrangThai(int idHD, double tien) {
        if (d.getHDbyID(idHD).get(0).getTrangThai().equals("Đã thanh toán")) {
            return "Sản phẩm này đã được thanh toán";
        } else {
            if (d.getHDbyID(idHD).get(0).getTongTien() == 0) {
                return "Không có sản phẩm để thanh toán";
            } else {
                if (d.getHDbyID(idHD).get(0).getTongTien() > tien) {
                    return "Vui lòng nhập sô tiền trả phải lớn hơn tổng tiền";
                } else {
                    boolean check = d.updateTrangThaiHD(idHD, tien);
                    if (check) {
                        return "Cập nhập trạng thái hóa đơn thành công";
                    } else {
                        return "Cập nhập trạng thái hóa đơn thất bại";
                    }
                }
            }
        }
    }
}
