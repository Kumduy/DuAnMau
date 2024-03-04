/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.SanPhamModel_view;
import entity.Thuoctinh;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class QlySP {

    DbConnection connection = new DbConnection();

    public ArrayList<SanPhamModel_view> getlist() {
        String sql = "SELECT * From SANPHAM\n"
                + "Inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "Inner join MAU on CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "Inner join SIZE on CHITIETSANPHAM.MaSize = Size.MaSize\n"
                + "Inner join DANHMUC on SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc\n"
                + "Where MaSanPham not in (select record_id from deleted_records where table_name = 'SANPHAM')";
        ArrayList<SanPhamModel_view> ml = new ArrayList<>();
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view smp = new SanPhamModel_view();
                smp.setDanhMuc(rs.getString("TenDanhMuc"));
                smp.setTrangThai(rs.getBoolean("TrangThai"));
                smp.setDonGia(rs.getDouble("Giaban"));
                smp.setMaSP(rs.getInt("MaSanPham"));
                smp.setMauSac(rs.getString("MauSac"));
                smp.setSize(rs.getDouble("Size"));
                smp.setSoLuong(rs.getInt("SoLuongTon"));
                smp.setTenSP(rs.getString("TenSanPham"));
                ml.add(smp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ml;
    }

    public ArrayList<SanPhamModel_view> getlistFull() {
        String sql = "SELECT * From SANPHAM\n"
                + "Inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "Inner join MAU on CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "Inner join SIZE on CHITIETSANPHAM.MaSize = Size.MaSize\n"
                + "Inner join DANHMUC on SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc";
        ArrayList<SanPhamModel_view> ml = new ArrayList<>();
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view smp = new SanPhamModel_view();
                smp.setDanhMuc(rs.getString("TenDanhMuc"));
                smp.setTrangThai(rs.getBoolean("TrangThai"));
                smp.setDonGia(rs.getDouble("Giaban"));
                smp.setMaSP(rs.getInt("MaSanPham"));
                smp.setMauSac(rs.getString("MauSac"));
                smp.setSize(rs.getDouble("Size"));
                smp.setSoLuong(rs.getInt("SoLuongTon"));
                smp.setTenSP(rs.getString("TenSanPham"));
                ml.add(smp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ml;
    }

    public boolean update(SanPhamModel_view sp) {
        String sqlSanPham = "UPDATE SANPHAM SET TenSanPham = ?, MaDanhMuc = ?, TrangThai = ? WHERE MaSanPham = ?";
        String sqlChiTietSanPham = "UPDATE CHITIETSANPHAM SET TenChiTietSanPham = ?, MaSize = ?, MaMau = ?, TrangThai = ?, GiaBan = ?, SoLuongTon = ? WHERE MaChiTietSanPham = ?";

        try (Connection conn = connection.getConnection(); PreparedStatement psSanPham = conn.prepareStatement(sqlSanPham); PreparedStatement psChiTietSanPham = conn.prepareStatement(sqlChiTietSanPham)) {

            // Cập nhật bảng SANPHAM
            psSanPham.setString(1, sp.getTenSP());
            psSanPham.setInt(2, Integer.parseInt(sp.getDanhMuc()));
            psSanPham.setBoolean(3, sp.isTrangThai());
            psSanPham.setInt(4, sp.getMaSP());

            int kqSanPham = psSanPham.executeUpdate();

            // Nếu cập nhật thành công, tiến hành cập nhật bảng CHITIETSANPHAM
            if (kqSanPham > 0) {
                psChiTietSanPham.setString(1, sp.getTenSP());
                psChiTietSanPham.setInt(2, (int) sp.getSize());
                psChiTietSanPham.setInt(3, Integer.parseInt(sp.getMauSac()));
                psChiTietSanPham.setBoolean(4, sp.isTrangThai());
                psChiTietSanPham.setDouble(5, sp.getDonGia());
                psChiTietSanPham.setInt(6, sp.getSoLuong());
                psChiTietSanPham.setInt(7, sp.getMaSP());

                int kqChiTietSanPham = psChiTietSanPham.executeUpdate();

                // Nếu cả hai cập nhật đều thành công, trả về true
                if (kqChiTietSanPham > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Delete(int id) {
        String sql = "INSERT INTO deleted_records (record_id,table_name) VALUES(?,'SANPHAM')\n"
                + "INSERT INTO deleted_records (record_id,table_name) VALUES(?,'CHITIETSANPHAM')";
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, id);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPhamModel_view> getlistbyId(int Id) {
        String sql = "SELECT * From SANPHAM\n"
                + "Inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "Inner join MAU on CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "Inner join SIZE on CHITIETSANPHAM.MaSize = Size.MaSize\n"
                + "Inner join DANHMUC on SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc\n"
                + "Where MaSanPham not in (select record_id from deleted_records where table_name = 'SANPHAM')\n"
                + "and MaSanPham = ?";
        ArrayList<SanPhamModel_view> ml = new ArrayList<>();
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view smp = new SanPhamModel_view();
                smp.setDanhMuc(rs.getString("TenDanhMuc"));
                smp.setTrangThai(rs.getBoolean("TrangThai"));
                smp.setDonGia(rs.getDouble("Giaban"));
                smp.setMaSP(rs.getInt("MaSanPham"));
                smp.setMauSac(rs.getString("MauSac"));
                smp.setSize(rs.getDouble("Size"));
                smp.setSoLuong(rs.getInt("SoLuongTon"));
                smp.setTenSP(rs.getString("TenSanPham"));
                ml.add(smp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ml;
    }
    
     public ArrayList<SanPhamModel_view> getlistbyName(String name) {
        String sql = "SELECT * From SANPHAM\n"
                + "Inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "Inner join MAU on CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "Inner join SIZE on CHITIETSANPHAM.MaSize = Size.MaSize\n"
                + "Inner join DANHMUC on SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc\n"
                + "Where MaSanPham not in (select record_id from deleted_records where table_name = 'SANPHAM')\n"
                + "and TenSanPham = ?";
        ArrayList<SanPhamModel_view> ml = new ArrayList<>();
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view smp = new SanPhamModel_view();
                smp.setDanhMuc(rs.getString("TenDanhMuc"));
                smp.setTrangThai(rs.getBoolean("TrangThai"));
                smp.setDonGia(rs.getDouble("Giaban"));
                smp.setMaSP(rs.getInt("MaSanPham"));
                smp.setMauSac(rs.getString("MauSac"));
                smp.setSize(rs.getDouble("Size"));
                smp.setSoLuong(rs.getInt("SoLuongTon"));
                smp.setTenSP(rs.getString("TenSanPham"));
                ml.add(smp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ml;
    }

    public boolean add(SanPhamModel_view sp) {
        String sql = "INSERT INTO SANPHAM (TenSanPham, MaDanhMuc, TrangThai) VALUES (?,?,?);";
        String sqlChiTiet = "INSERT INTO CHITIETSANPHAM (TenChiTietSanPham, MaSize, MaMau, SanPham, TrangThai, GiaBan, SoLuongTon) VALUES(?,?,?,?,?,?,?);";

        try (Connection conn = connection.getConnection(); PreparedStatement psSanPham = conn.prepareStatement(sql); PreparedStatement psChiTietSanPham = conn.prepareStatement(sqlChiTiet)) {

            psSanPham.setString(1, sp.getTenSP());
            psSanPham.setInt(2, Integer.parseInt(sp.getDanhMuc()));
            psSanPham.setBoolean(3, sp.isTrangThai());

            int kqSanPham = psSanPham.executeUpdate();

            if (kqSanPham > 0) {
                psChiTietSanPham.setString(1, sp.getTenSP());
                psChiTietSanPham.setInt(2, (int) sp.getSize());
                psChiTietSanPham.setInt(3, Integer.parseInt(sp.getMauSac()));
                psChiTietSanPham.setInt(4, sp.getMaSP());
                psChiTietSanPham.setBoolean(5, sp.isTrangThai());
                psChiTietSanPham.setDouble(6, sp.getDonGia());
                psChiTietSanPham.setInt(7, sp.getSoLuong());

                int kqChiTietSanPham = psChiTietSanPham.executeUpdate();

                if (kqChiTietSanPham > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   public ArrayList<Thuoctinh> getList(String thuocTinh, String tenCot) {
        ArrayList<Thuoctinh> list = new ArrayList<>();
        String sql = "SELECT * FROM " + thuocTinh + " WHERE " + tenCot + " NOT IN (SELECT record_id FROM deleted_records WHERE table_name = ?)";
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, thuocTinh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thuoctinh lh = new Thuoctinh();
                lh.setMaThuocTinh(rs.getInt(1));
                lh.setTenThuocTinh(rs.getString(2));
                list.add(lh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
