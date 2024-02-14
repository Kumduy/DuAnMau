/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.NguoiDungModel;
import entity.TaiKhoanModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Kiệt
 */
public class TaiKhoan_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<TaiKhoanModel> getList_TaiKhoan() {
        String sql = "SELECT ng.MaNguoiDung,tk.TenDangNhap,tk.MatKhau,ng.SDT,ng.GioiTinh,ng.VaiTro,ng.TenNguoiDung FROM  NGUOIDUNG ng \n"
                + "                 INNER JOIN TAIKHOAN tk ON\n"
                + "                 ng.MaNguoiDung = tk.MaNguoiDung";
        ArrayList<TaiKhoanModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoanModel tk = new TaiKhoanModel();
                tk.setMaNguoiDung(rs.getInt(1));
                tk.setTenDangNhap(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setSoDienThoai(rs.getString(4));
                tk.setGioiTinh(rs.getBoolean(5));
                tk.setVaiTro(rs.getBoolean(6));
                tk.setTenNguoiDung(rs.getString(7));
                ls.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public Boolean AddNew_TaiKhoan(TaiKhoanModel tkModel) {
        String sql = "INSERT INTO TAIKHOAN (TenDangNhap, MatKhau, MaNguoiDung) VALUES (?,?,?)";
        ArrayList<TaiKhoanModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(3, tkModel.getMaNguoiDung());
            ps.setObject(1, tkModel.getTenDangNhap());
            ps.setObject(2, tkModel.getMatKhau());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean Update_TaiKhoan(TaiKhoanModel tkModel) {
        String sql = "UPDATE [dbo].[TAIKHOAN]SET [TenDangNhap] = ?,[MatKhau] = ? WHERE [MaNguoiDung] = ?";
        ArrayList<TaiKhoanModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(3, tkModel.getMaNguoiDung());
            ps.setObject(1, tkModel.getTenDangNhap());
            ps.setObject(2, tkModel.getMatKhau());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean Xoa_TaiKhoan(String tenDangNhap) {
        String sql = "DELETE FROM [dbo].[TAIKHOAN] WHERE [TenDangNhap] LIKE '" + tenDangNhap + "'";
        ArrayList<TaiKhoanModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int kq = ps.executeUpdate();

            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

}
