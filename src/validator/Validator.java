/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Validator {
    public static boolean isEmty(JTextField txtField,StringBuilder stb, String msg){
        if (txtField.getText().trim().equals("")) {
            stb.append(msg).append("\n");
            txtField.setBackground(Color.yellow);
            return false;
        }
        txtField.setBackground(Color.WHITE);
            return true;
    }
    public boolean isEmpty(JTextField txt, String msg, StringBuilder stb) {
        if (txt.getText().trim().isEmpty()) {
            txt.setBackground(Color.YELLOW);
            stb.append(msg).append("\n");
            return false;
        }
        txt.setBackground(Color.WHITE);
        return true;
    }
    
    public boolean isEmail(JTextField txt, String msg, StringBuilder stb) {
        if (!isEmpty(txt, msg, stb)) {
            return false;
        } else {
            String email = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
            if (txt.getText().trim().matches(email)) {
                txt.setBackground(Color.WHITE);
                return true;
            } else {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
    }
    
    public boolean isNumber(JTextField txt, String msg, StringBuilder stb, int type) {
        if (!isEmpty(txt, msg, stb)) {
            return false;
        } else {
            try {
                if (type > 0) {
                    Double numberD = Double.parseDouble(txt.getText().trim());
                } else {
                    int numberIn = Integer.parseInt(txt.getText().trim());
                }
            } catch (Exception e) {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
        txt.setBackground(Color.WHITE);
        return true;
    }
    
    public boolean NumberLimit(JTextField txt, String msg, StringBuilder stb, int type, int min, int max) {
        if (!isNumber(txt, msg, stb, type)) {
            return false;
        } else {
            double number = Double.parseDouble(txt.getText().trim());
            if (number < min || number > max) {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
        txt.setBackground(Color.WHITE);
        return true;
    }
    
    public boolean isNumberGreater(JTextField txt, String msg, StringBuilder stb, int type, int min) {
        if (!isNumber(txt, msg, stb, type)) {
            return false;
        } else {
            double number = Double.parseDouble(txt.getText().trim());
            if (number < min) {
                txt.setBackground(Color.YELLOW);
                stb.append(msg).append("\n");
                return false;
            }
        }
        txt.setBackground(Color.WHITE);
        return true;
    }


}
