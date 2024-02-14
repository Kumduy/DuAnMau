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
}
