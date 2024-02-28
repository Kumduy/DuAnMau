/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.SanPhamDaMua_model;
import entity.KhachHangModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class KhachHang_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<KhachHangModel> getList_KhachHang() {
        String sql = "SELECT [MaKhachHang]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[SDT]\n"
                + "  FROM [dbo].[KHACHHANG]"
                + "WHERE [MaKhachHang] NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'KHACHHANG');";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel();
                kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setSoDienThoai(rs.getString("SDT"));
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<KhachHangModel> getList_KhachHangBySDT(String SDT) {
        String sql = "SELECT [MaKhachHang]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[SDT]\n"
                + "  FROM [dbo].[KHACHHANG]"
                + "WHERE SDT = ? AND [MaKhachHang] NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'KHACHHANG');";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, SDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel();
                kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setSoDienThoai(rs.getString("SDT"));
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<KhachHangModel> getList_KhachHangByName(String SDT) {
        String sql = "SELECT [MaKhachHang]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[SDT]\n"
                + "  FROM [dbo].[KHACHHANG]"
                + "WHERE TenKhachHang = ? AND [MaKhachHang] NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'KHACHHANG');";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, SDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel();
                kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setSoDienThoai(rs.getString("SDT"));
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<SanPhamDaMua_model> getList_HoaDonDaMua(int maKH) {
        String sql = "SELECT \n"
                + "    HDC.MaHoaDon,\n"
                + "    SP.MaSanPham ,\n"
                + "    SP.TenSanPham,\n"
                + "    M.MauSac,\n"
                + "    S.Size,\n"
                + "    DM.TenDanhMuc,\n"
                + "    HDC.SoLuong,\n"
                + "    HDC.GiaBan, \n"
                + "    HD.MaKhachHang \n"
                + "FROM \n"
                + "    HOADONCHITIET HDC\n"
                + "INNER JOIN \n"
                + "    SANPHAM SP ON HDC.MaSanPham = SP.MaSanPham\n"
                + "INNER JOIN \n"
                + "    CHITIETSANPHAM CTSP ON HDC.MaSanPham = CTSP.SanPham\n"
                + "INNER JOIN \n"
                + "    MAU M ON CTSP.MaMau = M.MaMau\n"
                + "INNER JOIN \n"
                + "    SIZE S ON CTSP.MaSize = S.MaSize\n"
                + "INNER JOIN \n"
                + "    DANHMUC DM ON SP.MaDanhMuc = DM.MaDanhMuc\n"
                + "INNER JOIN \n"
                + "    HOADON HD ON HDC.MaHoaDon = HD.MaHoaDon\n"
                + "WHERE \n"
                + "    HD.TrangThai = N'Đã thanh toán'\n"
                + "    AND HD.MaKhachHang = '" + maKH + "';";
        ArrayList<SanPhamDaMua_model> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamDaMua_model hd = new SanPhamDaMua_model();
                hd.setMaSanPham(rs.getInt("MaSanPham"));
                hd.setTenSanPham(rs.getString("TenSanPham"));
                hd.setMauSac(rs.getString("MauSac"));
                hd.setSize(rs.getDouble("Size"));
                hd.setTenDanhMuc(rs.getString("TenDanhMuc"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setDonGia(rs.getDouble("GiaBan"));
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setMaKhachHang(rs.getInt("MaKhachHang"));
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public Boolean AddNew_KhachHang(KhachHangModel kh) {
        String sql = "INSERT INTO KHACHHANG (TenKhachHang, SDT) VALUES (?,?)";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, kh.getTenKhachHang());
            ps.setObject(2, kh.getSoDienThoai());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public Boolean Update_KhachHang(KhachHangModel kh, int maKH) {
        String sql = "Update KHACHHANG Set TenKhachHang = ?, SDT = ? Where MaKhachHang = ?";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, kh.getTenKhachHang());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, maKH);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public Boolean An_KhachHang(int maKH) {
        String sql = "INSERT INTO deleted_records(table_name,record_id) VALUES ('KHACHHANG','" + maKH + "')";
        ArrayList<KhachHangModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
