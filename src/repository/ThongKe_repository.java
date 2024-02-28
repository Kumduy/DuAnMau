/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.ThongKe_DoanhThu_Model;
import entity.SanPhamModel_view;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author ADMIN
 */
public class ThongKe_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<ThongKe_DoanhThu_Model> getList_DoanhThu() {
        String sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "WHERE TrangThai = N'Đã Thanh Toán'";
        ArrayList<ThongKe_DoanhThu_Model> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe_DoanhThu_Model tk = new ThongKe_DoanhThu_Model();
                tk.setMaHoaDon(rs.getInt("MaHoaDon"));
                tk.setTongTien(rs.getDouble("TongTien"));
                tk.setNgayTaoHoaDon(rs.getDate("NgayTaoHoaDon"));
                tk.setKhachHang(rs.getString("TenKhachHang"));
                ls.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<ThongKe_DoanhThu_Model> getList_DoanhThuByThoiGian(Date ngayBatDau, Date ngayKetThuc) {
        String sql = "SELECT MaHoaDon,TongTien,NgayTaoHoaDon\n"
                + "FROM HOADON\n"
                + "WHERE TrangThai = N'Đã Thanh Toán' and NgayTaoHoaDon Between ? and ?";
        ArrayList<ThongKe_DoanhThu_Model> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe_DoanhThu_Model tk = new ThongKe_DoanhThu_Model();
                tk.setMaHoaDon(rs.getInt("MaHoaDon"));
                tk.setTongTien(rs.getDouble("TongTien"));
                tk.setNgayTaoHoaDon(rs.getDate("NgayTaoHoaDon"));
                ls.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public int getList_DoanhThuThanhCong() {
        String sql = "SELECT COUNT(*) as N'Thành Công' FROM HOADON Where TrangThai = N'Đã Thanh Toán'";
        int thanhCong = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thanhCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhCong;
    }
    
    public int getList_DoanhThuThatBai() {
        String sql = "SELECT COUNT(*) as N'Thất Bại' FROM HOADON Where TrangThai = N'Đã Thanh Toán'";
        int thanhCong = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thanhCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhCong;
    }
    
    public int getList_DoanhThuThanhCongbyTime(Date ngayBatDau, Date ngayKetThuc ) {
        String sql = "SELECT COUNT(*) as N'Thành Công' FROM HOADON Where TrangThai = N'Đã Thanh Toán' and NgayTaoHoaDon Between ? and ?";
        int thanhCong = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
             ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thanhCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhCong;
    }

    public int getList_DoanhThuThatBaibyTime(Date ngayBatDau, Date ngayKetThuc) {
        String sql = "SELECT COUNT(*) as N'Thất Bại' FROM HOADON Where TrangThai = N'Hủy' and NgayTaoHoaDon Between ? and ?";
        int thatBai = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thatBai = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thatBai;
    }
    
    public ArrayList<SanPhamModel_view> getList_ThongKeSanPham() {
        String sql = "SELECT SP.MaSanPham,SP.TenSanPham,HDCT.SoLuong,M.MauSac,S.Size,DM.TenDanhMuc,CTSP.GiaBan\n"
                + "FROM SANPHAM SP\n"
                + "INNER JOIN DANHMUC DM ON SP.MaDanhMuc = DM.MaDanhMuc\n"
                + "INNER JOIN CHITIETSANPHAM CTSP ON SP.MaSanPham = CTSP.SanPham\n"
                + "INNER JOIN SIZE S ON CTSP.MaSize = S.MaSize\n"
                + "INNER JOIN MAU M ON CTSP.MaMau = M.MaMau\n"
                + "INNER JOIN HOADONCHITIET HDCT ON SP.MaSanPham = HDCT.MaSanPham\n"
                + "INNER JOIN HOADON HD ON HDCT.MaHoaDon = HD.MaHoaDon;";
        ArrayList<SanPhamModel_view> ls = new ArrayList<SanPhamModel_view>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view tksp = new SanPhamModel_view();
                tksp.setMaSP(rs.getInt(1));
                tksp.setTenSP(rs.getString(2));
                tksp.setSoLuong(rs.getInt(3));
                tksp.setMauSac(rs.getString(4));
                tksp.setSize(rs.getDouble(5));
                tksp.setDanhMuc(rs.getString(6));
                tksp.setDonGia(rs.getDouble(7));
                ls.add(tksp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

}
