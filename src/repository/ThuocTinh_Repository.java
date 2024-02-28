/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Thuoctinh;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author hieul
 */
public class ThuocTinh_Repository {

    DbConnection dbConnection;

    public ArrayList<Thuoctinh> getList_Mau() {
        String sql = "SELECT * FROM MAU WHERE MaMau NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'MAU')";
        ArrayList<Thuoctinh> list = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thuoctinh tte = new Thuoctinh();
                tte.setMaThuocTinh(rs.getInt("MaMau"));
                tte.setTenThuocTinh(rs.getString("MauSac"));
                list.add(tte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public ArrayList<Thuoctinh> getList_Size() {
        String sql = "SELECT * FROM SIZE WHERE MaSize NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'SIZE')";
        ArrayList<Thuoctinh> list = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thuoctinh tte = new Thuoctinh();
                tte.setMaThuocTinh(rs.getInt("MaSize"));
                tte.setTenThuocTinh(rs.getString("Size"));
                list.add(tte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Thuoctinh> getList_DanhMuc() {
        String sql = "SELECT * FROM DANHMUC WHERE MaDanhMuc NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'DANHMUC')";
        ArrayList<Thuoctinh> list = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thuoctinh tte = new Thuoctinh();
                tte.setMaThuocTinh(rs.getInt("MaDanhMuc"));
                tte.setTenThuocTinh(rs.getString("TenDanhMuc"));
                list.add(tte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean AddNew_Mau(Thuoctinh tte) {
        String sql = "INSERT INTO MAU (MauSac) VALUES (?)";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Update_Mau(Thuoctinh tte, int maMau) {
        String sql = "UPDATE MAU SET MauSac = ? WHERE MaMau = " + maMau;
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Delete_Mau(int maMau) {
        String sql = "INSERT INTO deleted_records(table_name,record_id) VALUES ('MAU','" + maMau + "')";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean AddNew_Size(Thuoctinh tte) {
        String sql = "INSERT INTO SIZE (Size) VALUES (?)";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Update_Size(Thuoctinh tte, int maSize) {
        String sql = "Update SIZE Set Size = ? Where MaSize = " + maSize;
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Delete_Size(int maSize) {
        String sql = "INSERT INTO deleted_records(table_name,record_id) VALUES ('SIZE','" + maSize + "')";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean AddNew_DanhMuc(Thuoctinh tte) {
        String sql = "INSERT INTO DANHMUC (TenDanhMuc) VALUES (?)";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Update_DanhMuc(Thuoctinh tte, int maDanhMuc) {
        String sql = "Update DANHMUC Set TenDanhMuc = ? Where MaDanhMuc = " + maDanhMuc;
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tte.getTenThuocTinh());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Delete_DanhMuc(int maDanhMuc) {
        String sql = "INSERT INTO deleted_records(table_name,record_id) VALUES ('DANHMUC','" + maDanhMuc + "')";
        ArrayList<Thuoctinh> ls = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
