/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.ThongKe_DoanhThu_Model;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author ADMIN
 */
public class ThongKe_DoanhThu_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<ThongKe_DoanhThu_Model> getList_DoanhThu() {
        String sql = "SELECT MaHoaDon,TongTien,NgayTaoHoaDon\n"
                + "FROM HOADON WHERE TrangThai = N'Đã Thanh Toán'";
        ArrayList<ThongKe_DoanhThu_Model> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe_DoanhThu_Model tk = new ThongKe_DoanhThu_Model();
                tk.setMaHoaDon(rs.getInt(1));
                tk.setTongTien(rs.getDouble(2));
                tk.setNgayTaoHoaDon(rs.getDate(3));
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
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                thanhCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhCong;
    }
    
    public int getList_DoanhThuThanhCongbyTime(Date Begin, Date end ) {
        String sql = "SELECT COUNT(*) as N'Thành Công' FROM HOADON Where TrangThai = N'Đã Thanh Toán' ";
        int thanhCong = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                thanhCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhCong;
    }

    public int getList_DoanhThuThatBai() {
        String sql = "SELECT COUNT(*) as N'Thất Bại' FROM HOADON Where TrangThai = N'Hủy'";
        int thatBai = 0;
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                thatBai = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thatBai;
    }

}
