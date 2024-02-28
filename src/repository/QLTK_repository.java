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
                User_entity u = new User_entity(rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("TenNguoiDung"),
                        rs.getString("SDT"),
                        rs.getBoolean("VaiTro") ? "Quản lý" : "Nhân viên",
                        rs.getBoolean("GioiTinh") ? "Nam" : "Nữ",
                        rs.getInt("MaNguoiDung"),
                        rs.getInt("MaTaiKhoan"));
                ls.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<User_entity> getListUser() {
        String sql = "SELECT *\n"
                + "FROM NGUOIDUNG\n"
                + "WHERE MaNguoiDung NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'NGUOIDUNG');";
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_entity u = new User_entity();
                u.setMaTaiKhoan(rs.getInt("MaNguoiDung"));
                u.setGioiTinh(rs.getBoolean("GioiTinh") ? "Nam" : "Nữ");
                u.setSDT(rs.getString("SDT"));
                u.setTenNguoiDung(rs.getString("TenNguoiDung"));
                u.setVaiTro(rs.getBoolean("VaiTro") ? "Quản lý" : "Nhân viên");
                ls.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public boolean Add(User_entity u) {
        String sql = "INSERT INTO NGUOIDUNG (TenNguoiDung, SDT, VaiTro, GioiTinh) VALUES\n"
                + "(?,?,?,?)";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getTenNguoiDung());
            ps.setString(2, u.getSDT());
            ps.setBoolean(3, u.getVaiTro().equals("Quản lý") ? true : false);
            ps.setBoolean(4, u.getGioiTinh().equals("Nam") ? true : false);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Update(User_entity u,int id) {
        String sql = "UPDATE NGUOIDUNG SET TenNguoiDung = ?, SDT = ?, VaiTro = ?, GioiTinh = ? "
                + "WHERE MaNguoiDung = "+id;
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getTenNguoiDung());
            ps.setString(2, u.getSDT());
            ps.setBoolean(3, u.getVaiTro().equals("Quản lý"));
            ps.setBoolean(4, u.getGioiTinh().equals("Nam"));
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Delete(int id) {
        String sql = "INSERT INTO deleted_records (record_id,table_name) VALUES(?,'NGUOIDUNG')";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<User_entity> getList_TaiKhoan() {
        String sql = "SELECT ng.MaNguoiDung,tk.TenDangNhap,tk.MatKhau,ng.SDT,ng.GioiTinh,ng.VaiTro,ng.TenNguoiDung,tk.MaTaiKhoan  FROM  NGUOIDUNG ng \n"
                + "                               INNER JOIN TAIKHOAN tk ON\n"
                + "                +              ng.MaNguoiDung = tk.MaNguoiDung\n"
                + "WHERE tk.MaTaiKhoan NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'TAIKHOAN');";
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_entity tk = new User_entity();
                tk.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                tk.setTenTK(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setSDT(rs.getString("SDT"));
                tk.setGioiTinh(rs.getBoolean("GioiTinh") ? "Nam" : "Nữ");
                tk.setVaiTro(rs.getBoolean("VaiTro") ? "Quản lý" : "Nhân viên");
                tk.setTenNguoiDung(rs.getString("TenNguoiDung"));
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));

                ls.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public Boolean AddNew_TaiKhoan(User_entity tkModel) {
        String sql = "INSERT INTO TAIKHOAN (TenDangNhap, MatKhau, MaNguoiDung) VALUES (?,?,?)";
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(3, tkModel.getMaNguoiDung());
            ps.setObject(1, tkModel.getTenTK());
            ps.setObject(2, tkModel.getMatKhau());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean Update_TaiKhoan(User_entity tkModel, int maTK) {
        String sql = "UPDATE TAIKHOAN SET MaNguoiDung = ?, TenDangNhap = ? ,MatKhau = ? WHERE MaTaiKhoan = " +maTK;
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tkModel.getMaNguoiDung());
            ps.setObject(2, tkModel.getTenTK());
            ps.setObject(3, tkModel.getMatKhau());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean Xoa_TaiKhoan(int maTK) {
        String sql = "INSERT INTO deleted_records(table_name,record_id) VALUES ('TAIKHOAN','" + maTK + "')";
        ArrayList<User_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
