/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.QLTK_repository;
import entity.User_entity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QLTK_service {

    QLTK_repository login_repository = new QLTK_repository();

    public ArrayList<User_entity> getList() {
        return login_repository.getListUser();
    }

    public Boolean check(String tenTK, String matKhau) {
        if (login_repository.getTK(tenTK, matKhau).size() > 0) {
            return true;
        }
        return false;
    }
public String AddNew_TaiKhoan(User_entity tkModel){
        Boolean check = login_repository.AddNew_TaiKhoan(tkModel);
        if (check == true) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    
    public String Update_TaiKhoan(User_entity tkModel,int maTK){
        Boolean check = login_repository.Update_TaiKhoan(tkModel, maTK);
        if (check == true) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }
    public String Xoa_TaiKhoan(int maTK){
        Boolean check = login_repository.Xoa_TaiKhoan(maTK) ;
        if (check == true) {
            return " Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }
    public User_entity getUser(String tenTK, String matKhau) {
        if (check(tenTK, matKhau)) {
            return login_repository.getTK(tenTK, matKhau).get(0);
        }
        return null;
    }

    public String add(User_entity tt) {
        boolean check = login_repository.Add(tt);
        if (check == true) {
            return "Added";
        } else {
            return "False";
        }
    }

    public String Delete(int id) {
        boolean check = login_repository.Delete(id);
        if (check == true) {
            return "Deleted";
        } else {
            return "False";
        }
    }

    public String Update(User_entity tt,int id) {
        boolean check = login_repository.Update(tt,id);
        if (check == true) {
            return "Updated";
        } else {
            return "False";
        }
    }

     public ArrayList<User_entity> getList_TaiKhoan(){
        return login_repository.getList_TaiKhoan();
    }
}
