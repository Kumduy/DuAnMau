/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.NguoiDungModel;
import entity.TaiKhoanModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class NguoiDung_repository {

    DbConnection Dbconnection = new DbConnection();

    public ArrayList<NguoiDungModel> getList_NguoiDung() {
        String sql = "SELECT [MaNguoiDung]\n"
                + "      ,[TenNguoiDung]\n"
                + "      ,[SDT]\n"
                + "      ,[VaiTro]\n"
                + "      ,[GioiTinh]\n"
                + "  FROM [dbo].[NGUOIDUNG]";
        ArrayList<NguoiDungModel> ls = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDungModel ng = new NguoiDungModel();
                ng.setMaNguoiDung(rs.getInt(1));
                ng.setTenNguoiDung(rs.getString(2));
                ng.setSoDienThoai(rs.getString(3));
                ng.setVaiTro(rs.getBoolean(4));
                ng.setGioiTinh(rs.getBoolean(5));
                ls.add(ng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public NguoiDungModel getById(String ten_NguoiDung) {
        String sql = "SELECT [MaNguoiDung]\n"
                + "      ,[TenNguoiDung]\n"
                + "      ,[SDT]\n"
                + "      ,[VaiTro]\n"
                + "      ,[GioiTinh]\n"
                + "  FROM [dbo].[NGUOIDUNG]"
                + "WHERE [TenNguoiDung] = '" + ten_NguoiDung + "' ";
        NguoiDungModel ndModel = new NguoiDungModel();
        try (Connection conn = Dbconnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getInt(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setSoDienThoai(rs.getString(3));
                nd.setVaiTro(rs.getBoolean(4));
                nd.setGioiTinh(rs.getBoolean(5));
                ndModel = nd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ndModel;
    }

}
