/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.HDCTmodel_entity;
import entity.HoaDonModel;
import entity.HoaDon_entity;
import entity.SanPhamModel_view;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QLhoaDon_repository {

    DbConnection dbconnection = new DbConnection();

    public ArrayList<String> getTrangThai() {
        String sql = "select TrangThai from HOADON WHERE TrangThai != N'Hủy' \n"
                + "GROUP BY TrangThai";
        ArrayList<String> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tt = rs.getString("TrangThai");
                ls.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

        public ArrayList<HoaDonModel> getList() {
        String sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE TrangThai != N'Hủy'";
        ArrayList<HoaDonModel> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setKhachHang(rs.getString("TenKhachHang"));
                hd.setNgayDatHang(rs.getDate("NgayTaoHoaDon"));
                hd.setNguoiDung(rs.getString("TenNguoiDung"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setTienTra(rs.getDouble("TienKhachTra"));
                if (rs.getDouble("TienKhachTra") >= rs.getDouble("TongTien")) {
                    hd.setTienThua(rs.getDouble("TienKhachTra") - rs.getDouble("TongTien"));
                } else {
                    hd.setTienThua(0);
                }
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
        
        public HoaDonModel getListByID(int id) {
        String sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE MaHoaDon = ? AND TrangThai != N'Hủy'";
        HoaDonModel hd = new HoaDonModel();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setKhachHang(rs.getString("TenKhachHang"));
                hd.setNgayDatHang(rs.getDate("NgayTaoHoaDon"));
                hd.setNguoiDung(rs.getString("TenNguoiDung"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setTienTra(rs.getDouble("TienKhachTra"));
                if (rs.getDouble("TienKhachTra") >= rs.getDouble("TongTien")) {
                    hd.setTienThua(rs.getDouble("TienKhachTra") - rs.getDouble("TongTien"));
                } else {
                    hd.setTienThua(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }
        
         public ArrayList<HoaDonModel> getListBySreach(String TypeData,String data ) {
        String sql ;
             if (TypeData.equals("Mã hóa đơn")) {
                 sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE TrangThai != N'Hủy' AND MaHoaDon = ?";
             } else if(TypeData.equals("Tên khách hàng")) {
                 sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE TrangThai != N'Hủy' AND TenKhachHang = ?";
             }else {
                 sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE TrangThai != N'Hủy' AND TenNguoiDung = ?";
             }
        ArrayList<HoaDonModel> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setKhachHang(rs.getString("TenKhachHang"));
                hd.setNgayDatHang(rs.getDate("NgayTaoHoaDon"));
                hd.setNguoiDung(rs.getString("TenNguoiDung"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setTienTra(rs.getDouble("TienKhachTra"));
                if (rs.getDouble("TienKhachTra") >= rs.getDouble("TongTien")) {
                    hd.setTienThua(rs.getDouble("TienKhachTra") - rs.getDouble("TongTien"));
                } else {
                    hd.setTienThua(0);
                }
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<HoaDonModel> getHDbyTT(String trangThai) {
        String sql = "select * from HOADON \n"
                + "INNER JOIN KHACHHANG on HOADON.MaKhachHang = KHACHHANG.MaKhachHang\n"
                + "INNER JOIN NGUOIDUNG ON HOADON.MaNguoiDung = NGUOIDUNG.MaNguoiDung\n"
                + "WHERE TrangThai != N'Hủy' AND TrangThai = ?";
        ArrayList<HoaDonModel> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setKhachHang(rs.getString("TenKhachHang"));
                hd.setNgayDatHang(rs.getDate("NgayTaoHoaDon"));
                hd.setNguoiDung(rs.getString("TenNguoiDung"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setTienTra(rs.getDouble("TienKhachTra"));
                if (rs.getDouble("TienKhachTra") >= rs.getDouble("TongTien")) {
                    hd.setTienThua(rs.getDouble("TienKhachTra") - rs.getDouble("TongTien"));
                } else {
                    hd.setTienThua(0);
                }
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<HoaDon_entity> getHDbyID(int maHD) {
        String sql = "select * from HOADON where MaHoaDon = ? AND TrangThai != N'Hủy'";
        ArrayList<HoaDon_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_entity hd = new HoaDon_entity(rs.getInt("MaHoaDon"),
                        rs.getInt("MaNguoiDung"),
                        rs.getInt("MaKhachHang"),
                        rs.getDouble("TongTien"),
                        rs.getDate("NgayTaoHoaDon"),
                        rs.getString("TrangThai"));
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<HDCTmodel_entity> getHDCTList(int maHD) {
        String sql = "select HOADONCHITIET.MaHoaDon,HOADONCHITIET.MaHoaDonChiTiet,HOADONCHITIET.SoLuong,HOADONCHITIET.MaSanPham,SanPham.TenSanPham,CHITIETSANPHAM.GiaBan,HOADONCHITIET.SoLuong,CHITIETSANPHAM.TrangThai from HOADONCHITIET inner join (SANPHAM inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham) on HOADONCHITIET.MaSanPham = SANPHAM.MaSanPham \n "
                + "where HOADONCHITIET.MaHoaDonChiTiet NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'HOADONCHITIET') AND MaHoaDon = " + maHD;
        ArrayList<HDCTmodel_entity> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDCTmodel_entity HDCT = new HDCTmodel_entity(rs.getInt("MaHoaDon"),
                        rs.getInt("MaHoaDonChiTiet"),
                        rs.getInt("MaSanPham"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("GiaBan"),
                        rs.getBoolean("TrangThai") ? "second hand" : "New",
                        rs.getString("TenSanPham"));
                ls.add(HDCT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<SanPhamModel_view> getSP() {
        String sql = "SELECT \n"
                + "    SANPHAM.*, \n"
                + "    CHITIETSANPHAM.MaChiTietSanPham, \n"
                + "    CHITIETSANPHAM.TenChiTietSanPham, \n"
                + "    CHITIETSANPHAM.GiaBan, \n"
                + "    CHITIETSANPHAM.SoLuongTon, \n"
                + "    MAU.MauSac, \n"
                + "    SIZE.Size, \n"
                + "    DANHMUC.TenDanhMuc\n"
                + "FROM \n"
                + "    SANPHAM\n"
                + "INNER JOIN \n"
                + "    CHITIETSANPHAM ON SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "INNER JOIN \n"
                + "    MAU ON CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "INNER JOIN \n"
                + "    SIZE ON CHITIETSANPHAM.MaSize = SIZE.MaSize\n"
                + "INNER JOIN \n"
                + "    DANHMUC ON SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc\n"
                + "WHERE SANPHAM.MaSanPham NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'SANPHAM');";
        ArrayList<SanPhamModel_view> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view sp1 = new SanPhamModel_view(rs.getInt("MaChiTietSanPham"),
                        rs.getInt("SoLuongTon"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenDanhMuc"),
                        rs.getString("MauSac"),
                        rs.getDouble("GiaBan"),
                        rs.getDouble("Size"),
                        rs.getBoolean("TrangThai"));
                ls.add(sp1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<SanPhamModel_view> getSPbyID(int id) {
        String sql = "SELECT \n"
                + "    SANPHAM.*, \n"
                + "    CHITIETSANPHAM.MaChiTietSanPham, \n"
                + "    CHITIETSANPHAM.TenChiTietSanPham, \n"
                + "    CHITIETSANPHAM.GiaBan, \n"
                + "    CHITIETSANPHAM.SoLuongTon, \n"
                + "    MAU.MauSac, \n"
                + "    SIZE.Size, \n"
                + "    DANHMUC.TenDanhMuc\n"
                + "FROM \n"
                + "    SANPHAM\n"
                + "INNER JOIN \n"
                + "    CHITIETSANPHAM ON SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham\n"
                + "INNER JOIN \n"
                + "    MAU ON CHITIETSANPHAM.MaMau = MAU.MaMau\n"
                + "INNER JOIN \n"
                + "    SIZE ON CHITIETSANPHAM.MaSize = SIZE.MaSize\n"
                + "INNER JOIN \n"
                + "    DANHMUC ON SANPHAM.MaDanhMuc = DANHMUC.MaDanhMuc\n"
                + "WHERE SANPHAM.MaSanPham NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'SANPHAM') AND MaSanPham = " + id;
        ArrayList<SanPhamModel_view> ls = new ArrayList<>();
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel_view sp1 = new SanPhamModel_view(rs.getInt("MaChiTietSanPham"),
                        rs.getInt("SoLuongTon"),
                        rs.getString("TenSanPham"),
                        rs.getString("TenDanhMuc"),
                        rs.getString("MauSac"),
                        rs.getDouble("GiaBan"),
                        rs.getDouble("Size"),
                        rs.getBoolean("TrangThai"));
                ls.add(sp1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public Boolean addHD(HoaDon_entity hd) {
        String sql = "INSERT INTO HOADON (MaKhachHang, MaNguoiDung, TongTien, NgayTaoHoaDon, TrangThai) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(hd.getMaKH()));
            ps.setString(2, String.valueOf(hd.getMaNV()));
            ps.setString(3, String.valueOf(hd.getTongTien()));
            ps.setString(4, String.valueOf(hd.getNgayTao()));
            ps.setString(5, hd.getTrangThai());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhapTongTien(int idHD) {
        String sql = "select HOADONCHITIET.MaHoaDon,HOADONCHITIET.MaHoaDonChiTiet,HOADONCHITIET.SoLuong,HOADONCHITIET.MaSanPham,SanPham.TenSanPham,CHITIETSANPHAM.GiaBan,HOADONCHITIET.SoLuong,CHITIETSANPHAM.TrangThai from HOADONCHITIET inner join (SANPHAM inner join CHITIETSANPHAM on SANPHAM.MaSanPham = CHITIETSANPHAM.SanPham) on HOADONCHITIET.MaSanPham = SANPHAM.MaSanPham \n"
                + "where HOADONCHITIET.MaHoaDonChiTiet NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'HOADONCHITIET') AND MaHoaDon = " + idHD;
        double tongTien = 0;
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double money = rs.getInt("SoLuong") * rs.getDouble("GiaBan");
                tongTien = tongTien + money;
            }
            String sqlUpdate = "UPDATE HOADON SET TongTien = ? WHERE MaHoaDon = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdate);
            ps2.setDouble(1, tongTien);
            ps2.setInt(2, idHD);
            int kq = ps2.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean huyHD(int idHD) {
        String sqlDelete = "UPDATE HOADON SET TrangThai = N'Hủy' WHERE MaHoaDon = " + idHD;
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlDelete)) {
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaHDCT(int idHDCT) {
        String sqlDelete = "INSERT INTO deleted_records (record_id,table_name) VALUES(?,'HOADONCHITIET')";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlDelete)) {
            ps.setInt(1, idHDCT);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateHDCT(int idHDCT,int soLuong) {
        String sqlDelete = "UPDATE HOADONCHITIET SET SoLuong = ? WHERE MaHoaDonChiTiet = ?";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlDelete)) {
            ps.setInt(1, soLuong);
            ps.setInt(2, idHDCT);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean themSanPhamVaoHoaDonChiTiet(int idHD, int idSP, int soLuongMua, double giaban) {
        String sqlSelect = "SELECT * FROM HOADONCHITIET WHERE MaHoaDon = ? AND MaSanPham = ? AND HOADONCHITIET.MaHoaDonChiTiet NOT IN (SELECT record_id FROM deleted_records WHERE table_name = 'HOADONCHITIET')";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlSelect)) {
            ps.setInt(1, idHD);
            ps.setInt(2, idSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int soLuongHienTai = rs.getInt("SoLuong");
                int soLuongMoi = soLuongHienTai + soLuongMua;
                String sqlUpdate = "UPDATE HOADONCHITIET SET SoLuong = ?,GiaBan =? WHERE MaHoaDon = ? AND MaSanPham = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlUpdate);
                ps2.setInt(1, soLuongMoi);
                ps2.setDouble(2, giaban);
                ps2.setInt(3, idHD);
                ps2.setInt(4, idSP);
                ps2.executeUpdate();
            } else {
                String sqlInsert = "INSERT INTO HOADONCHITIET (MaHoaDon, MaSanPham, SoLuong,GiaBan) VALUES (?, ?, ?, ?)";
                PreparedStatement ps3 = conn.prepareStatement(sqlInsert);
                ps3.setInt(1, idHD);
                ps3.setInt(2, idSP);
                ps3.setInt(3, soLuongMua);
                ps3.setDouble(4, giaban);
                ps3.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean updateHD(HoaDon_entity hd) {
        String sql = "UPDATE HOADON SET MaKhachHang = ?, TongTien = ?,MaNguoiDung = ?,NgayTaoHoaDon = ? WHERE MaHoaDon = ?";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hd.getMaKH());
            ps.setDouble(2, hd.getTongTien());
            ps.setInt(3, hd.getMaNV());
            ps.setDate(4, hd.getNgayTao());
            ps.setInt(5, hd.getMaHD());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSL(int soLuong, int ma) {
        String sql = "UPDATE CHITIETSANPHAM set SoLuongTon = ? WHERE MaChiTietSanPham = ?";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, soLuong);
            ps.setInt(2, ma);
            int kq = ps.executeUpdate();
            return kq > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTrangThaiHD(int idHD, double  tienTra) {
        String sql = "UPDATE HOADON SET TienKhachTra = ? ,TrangThai = N'Đã thanh toán' WHERE MaHoaDon = ?";
        try (Connection conn = dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, tienTra);
            ps.setInt(2, idHD);
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
