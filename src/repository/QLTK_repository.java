/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.HoaDon_entity;
import java.util.ArrayList;
import java.sql.*;
import entity.User_entity;
/**
 *
 * @author DELL
 */
public class QLTK_repository {
    DbConnection dbconnection = new DbConnection();

    public ArrayList<User_entity> getTK(String tenTK, String matKhau) {
        String sql = "select * from TAIKHOAN inner join NGUOIDUNG on TAIKHOAN.MaNguoiDung = NGUOIDUNG.MaNguoiDung where TAIKHOAN.TenDangNhap = ? AND TAIKHOAN.MatKhau =?";
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenTK);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_entity u = new User_entity(rs.getString("TenDangNhap")
                        , rs.getString("MatKhau")
                        , rs.getString("TenNguoiDung")
                        , rs.getString("SDT")
                        , rs.getBoolean("VaiTro")? "Quản lý":"Nhân viên"
                        , rs.getBoolean("GioiTinh")? "Nam":"Nữ"
                        , rs.getInt("MaNguoiDung")
                        , rs.getInt("MaTaiKhoan"));
                ls.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    
}
