package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin
 */
import entity.SanPhamModel_view;
import entity.Thuoctinh;
import java.util.ArrayList;
import repository.QlySP;

public class Sp_service {

    QlySP sp = new QlySP();

    public ArrayList<SanPhamModel_view> loaddate() {
        return sp.getlist();
    }
    
    public ArrayList<SanPhamModel_view> getListFull() {
        return sp.getlistFull();
    }

    public ArrayList<SanPhamModel_view> timkiem(int Id) {
        return sp.getlistbyId(Id);
    }

    public ArrayList<Thuoctinh> thuoctinh(String thuoctinh,String tenCot) {
        return sp.getList(thuoctinh,tenCot);
    }

    public String add(SanPhamModel_view tt) {
        boolean check = sp.add(tt);
        if (check == true) {
            return "Added";
        } else {
            return "False";
        }
    }

    public String Delete(int id) {
        boolean check = sp.Delete(id);
        if (check == true) {
            return "Deleted";
        } else {
            return "False";
        }
    }

    public String Update(SanPhamModel_view tt) {
        boolean check = sp.update(tt);
        if (check == true) {
            return "Updated";
        } else {
            return "False";
        }
    }
}
