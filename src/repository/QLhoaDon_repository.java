/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import entity.HDCTmodel_entity;
import entity.HoaDon_entity;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class QLhoaDon_repository {
    DbConnection dbconnection = new DbConnection();

    public ArrayList<HoaDon_entity> getList() {
        String sql = "select * from HOADON";
        ArrayList<HoaDon_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_entity hd = new HoaDon_entity(rs.getInt("MaHoaDon")
                        , rs.getInt("MaNguoiDung")
                        , rs.getInt("MaKhachHang")
                        , rs.getDouble("TongTien")
                        , rs.getDate("NgayTaoHoaDon")
                        , rs.getBoolean("TrangThai"));
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<HDCTmodel_entity> getHDCTList() {
        String sql = "select HOADONCHITIET.MaHoaDon,HOADONCHITIET.MaHoaDonChiTiet,HOADONCHITIET.SoLuong,HOADONCHITIET.MaSanPham,SanPham.TenSanPham,CHITIETSANPHAM.GiaBan,HOADONCHITIET.SoLuong,CHITIETSANPHAM.TrangThai from HOADONCHITIET inner join (SANPHAM inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham) on HOADONCHITIET.MaSanPham = SANPHAM.MaSanPham";
        ArrayList<HDCTmodel_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDCTmodel_entity HDCT = new HDCTmodel_entity(rs.getInt("MaHoaDon"),
                        rs.getInt("MaHoaDonChiTiet"), 
                        rs.getInt("MaSanPham"), 
                        rs.getInt("SoLuong")
                        , rs.getDouble("GiaBan")
                        , rs.getBoolean("TrangThai") ? "Chưa qua sử dụng" : "Đã sử dụng", 
                        rs.getString("TenSanPham"));
                ls.add(HDCT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
