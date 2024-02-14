/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.ThongKe_DoanhThu_Model;
import entity.ThongKe_SanPham_model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ThongKe_SanPham_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<ThongKe_SanPham_model> getList_ThongKeSanPham() {
        String sql = "SELECT SP.MaSanPham,SP.TenSanPham,HDCT.SoLuong,M.MauSac,S.Size,DM.TenDanhMuc,CTSP.GiaBan\n"
                + "FROM SANPHAM SP\n"
                + "INNER JOIN DANHMUC DM ON SP.MaDanhMuc = DM.MaDanhMuc\n"
                + "INNER JOIN CHITIETSANPHAM CTSP ON SP.MaSanPham = CTSP.SanPham\n"
                + "INNER JOIN SIZE S ON CTSP.MaSize = S.MaSize\n"
                + "INNER JOIN MAU M ON CTSP.MaMau = M.MaMau\n"
                + "INNER JOIN HOADONCHITIET HDCT ON SP.MaSanPham = HDCT.MaSanPham\n"
                + "INNER JOIN HOADON HD ON HDCT.MaHoaDon = HD.MaHoaDon;";
        ArrayList<ThongKe_SanPham_model> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe_SanPham_model tksp = new ThongKe_SanPham_model();
                tksp.setMaSanPham(rs.getInt(1));
                tksp.setTenSanPham(rs.getString(2));
                tksp.setSoLuong(rs.getInt(3));
                tksp.setMauSac(rs.getString(4));
                tksp.setSize(rs.getDouble(5));
                tksp.setTenDanhMuc(rs.getString(6));
                tksp.setGiaBan(rs.getDouble(7));
                ls.add(tksp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

}
