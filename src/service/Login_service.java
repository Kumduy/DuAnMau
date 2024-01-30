/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import repository.QLTK_repository;
import entity.User_entity;

/**
 *
 * @author DELL
 */
public class Login_service {
    QLTK_repository login_repository = new QLTK_repository();
    
    public Boolean check(String tenTK,String matKhau){
        if (login_repository.getTK(tenTK, matKhau).size() > 0) {
            return true;
        }
        return false;
    }
    
    public User_entity getUser(String tenTK,String matKhau){
        if (check(tenTK, matKhau)) {
            return login_repository.getTK(tenTK, matKhau).get(0);
        }
        return null;
    }
}
