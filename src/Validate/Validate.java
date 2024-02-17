/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validate;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author hieul
 */
public class Validate {

    
    public boolean isEmpty(JTextField txt, String msg, StringBuilder stb) {
        if (txt.getText().trim().isEmpty()) {
            txt.setBackground(Color.YELLOW);
            stb.append(msg).append("\n");
            return false;
        }
        txt.setBackground(Color.WHITE);
        return true;
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
