/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import repository.QLhoaDon_repository;
import entity.HoaDon_entity;
import entity.HDCTmodel_entity;
/**
 *
 * @author DELL
 */
public class HoaDon_service {
    QLhoaDon_repository d= new QLhoaDon_repository();
    
    public ArrayList<HoaDon_entity> getListHD(){
        return d.getList();
    }
    
    public ArrayList<HDCTmodel_entity> getListHDCT(){
        return d.getHDCTList();
    }
}
