/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Thuoctinh;
import repository.ThuocTinh_Repository;
import java.util.ArrayList;

/**
 *
 * @author hieul
 */
public class ThuocTinh_Service {

    ThuocTinh_Repository ttr = new ThuocTinh_Repository();

    public ArrayList<Thuoctinh> getList_Mau() {
        return ttr.getList_Mau();
    }

    public ArrayList<Thuoctinh> getList_Size() {
        return ttr.getList_Size();
    }

    public ArrayList<Thuoctinh> getList_DanhMuc() {
        return ttr.getList_DanhMuc();
    }

    public String AddNew_Mau(Thuoctinh tte) {
        Boolean check = ttr.AddNew_Mau(tte);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    public String Update_Mau(Thuoctinh tte, int maMau) {
        Boolean check = ttr.Update_Mau(tte, maMau);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    public String Xoa_Mau(int maMau) {
        Boolean check = ttr.Delete_Mau(maMau);
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

    public String AddNew_Size(Thuoctinh tte) {
        Boolean check = ttr.AddNew_Size(tte);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    public String Update_Size(Thuoctinh tte, int maSize) {
        Boolean check = ttr.Update_Size(tte, maSize);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    public String Xoa_Size(int maSize) {
        Boolean check = ttr.Delete_Size(maSize);
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

    public String AddNew_DanhMuc(Thuoctinh tte) {
        Boolean check = ttr.AddNew_DanhMuc(tte);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    public String Update_DanhMuc(Thuoctinh tte, int maDanhMuc) {
        Boolean check = ttr.Update_DanhMuc(tte, maDanhMuc);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    public String Xoa_DanhMuc(int maDanhMuc) {
        Boolean check = ttr.Delete_DanhMuc(maDanhMuc);
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }
}
