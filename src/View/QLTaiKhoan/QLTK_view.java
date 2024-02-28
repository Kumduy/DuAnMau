/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.QLTaiKhoan;

import entity.User_entity;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Validate.Validate;
import service.QLTK_service;

/**
 *
 * @author DELL
 */
public class QLTK_view extends javax.swing.JPanel {

    Validate v = new Validate();

    public QLTK_view() {
        initComponents();
        myInfo(u);
        loadUser(qltk.getList());
        LoadData(qltk.getList_TaiKhoan());
    }

    QLTK_service qltk = new QLTK_service();

    public static User_entity u;

    public void myInfo(User_entity u) {
        txt_AccountIDInfo.setText(String.valueOf(u.getMaTaiKhoan()));
        txt_AccountNameInfo.setText(u.getTenNguoiDung());
        txt_GenderInfo.setText(u.getGioiTinh());
        txt_JobInfo.setText(u.getVaiTro());
        txt_NameInfo.setText(u.getTenNguoiDung());
        txt_PasswordInfo.setText(u.getMatKhau());
        txt_PhoneInfo.setText(u.getSDT());
        txt_UserIDInfo.setText(String.valueOf(u.getMaNguoiDung()));
    }

    public void LoadData(ArrayList<User_entity> lsTaiKhoan) {
        DefaultTableModel model = (DefaultTableModel) tbl_QuanLyTaiKhoan.getModel();
        model.setRowCount(0);
        for (User_entity tk : lsTaiKhoan) {
            model.addRow(new Object[]{
                tk.getMaNguoiDung(),
                tk.getTenTK(),
                tk.getMatKhau(),
                tk.getSDT(),
                tk.getGioiTinh(),
                tk.getVaiTro(),
                tk.getTenNguoiDung(),
                tk.getMaTaiKhoan()

            });
        }
    }

    public void resetColor() {
        txt_MaNguoiDung.setBackground(Color.WHITE);
        txt_TenDangNhap.setBackground(Color.WHITE);
        txt_MatKhau.setBackground(Color.WHITE);
    }

    public User_entity getModel() {
        User_entity tk = new User_entity();
        tk.setMaNguoiDung(Integer.parseInt(txt_MaNguoiDung.getText()));
        tk.setTenTK(txt_TenDangNhap.getText());
        tk.setMatKhau(txt_MatKhau.getText());
        return tk;
    }
    
    public User_entity getModelNV() {
        User_entity tk = new User_entity();
        tk.setTenNguoiDung(txt_TenNguoiDung.getText());
        tk.setGioiTinh(rdoMale.isSelected()? "Nam":"Nữ");
        tk.setSDT(txt_SDT.getText());
        tk.setVaiTro((String) cboRole.getSelectedItem());
        return tk;
    }

    public void LoadDataToModelUser(int pos) {
        User_entity tk = qltk.getList().get(pos);
        txt_TenNguoiDung.setText(tk.getTenNguoiDung());
        txt_SDT.setText(tk.getSDT());
        if (tk.getGioiTinh().equals("Nam")) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
        cboRole.setSelectedItem(tk.getVaiTro());
    }

    public void LoadDataToModel(int pos) {
        User_entity tk = qltk.getList_TaiKhoan().get(pos);
        txt_MaNguoiDung.setText(String.valueOf(tk.getMaNguoiDung()));
        txt_TenDangNhap.setText(tk.getTenTK());
        txt_MatKhau.setText(tk.getMatKhau());

    }

    public void loadUser(ArrayList<User_entity> ls) {
        DefaultTableModel model = (DefaultTableModel) tbl_User.getModel();
        model.setRowCount(0);
        for (User_entity l : ls) {
            Object[] data = new Object[5];
            data[0] = l.getMaTaiKhoan();
            data[1] = l.getTenNguoiDung();
            data[2] = l.getSDT();
            data[3] = l.getGioiTinh();
            data[4] = l.getVaiTro();
            model.addRow(data);
        }
    }

    public void New() {
        txt_MaNguoiDung.setText("");
        txt_TenDangNhap.setText("");
        txt_MatKhau.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaNguoiDung = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_TenDangNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_MatKhau = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_An = new javax.swing.JButton();
        btn_Moi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_QuanLyTaiKhoan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_NameInfo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_PhoneInfo = new javax.swing.JTextField();
        txt_UserIDInfo = new javax.swing.JTextField();
        txt_GenderInfo = new javax.swing.JTextField();
        txt_JobInfo = new javax.swing.JTextField();
        txt_AccountNameInfo = new javax.swing.JTextField();
        txt_AccountIDInfo = new javax.swing.JTextField();
        txt_PasswordInfo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        pic = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_TenNguoiDung = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        cboRole = new javax.swing.JComboBox<>();
        btn_Them1 = new javax.swing.JButton();
        btn_An1 = new javax.swing.JButton();
        btn_Sua1 = new javax.swing.JButton();
        btn_Moi1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_User = new javax.swing.JTable();
        txt_SDT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1028, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setOpaque(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã người dùng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        btn_Them.setText("Thêm");
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaMouseClicked(evt);
            }
        });

        btn_An.setText("Xóa");
        btn_An.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AnMouseClicked(evt);
            }
        });

        btn_Moi.setText("Mới");
        btn_Moi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Moi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_An, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_MaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_MaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them)
                    .addComponent(btn_An))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Moi)
                    .addComponent(btn_Sua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_QuanLyTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Tên TK", "Mật khẩu", "SĐT", "Giới tính", "Vai trò", "Tên NV"
            }
        ));
        tbl_QuanLyTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_QuanLyTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_QuanLyTaiKhoan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Quản lý tài khoản", jPanel2);

        jPanel3.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Họ tên :");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("SĐT :");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Giới tính :");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Vai trò :");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("ID người dùng :");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("ID tài khoản :");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("Tên đăng nhập :");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Mật khẩu :");

        txt_NameInfo.setEditable(false);
        txt_NameInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_NameInfo.setBorder(null);
        txt_NameInfo.setOpaque(true);
        txt_NameInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameInfoActionPerformed(evt);
            }
        });

        txt_PhoneInfo.setEditable(false);
        txt_PhoneInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_PhoneInfo.setBorder(null);
        txt_PhoneInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PhoneInfoActionPerformed(evt);
            }
        });

        txt_UserIDInfo.setEditable(false);
        txt_UserIDInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_UserIDInfo.setBorder(null);
        txt_UserIDInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserIDInfoActionPerformed(evt);
            }
        });

        txt_GenderInfo.setEditable(false);
        txt_GenderInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_GenderInfo.setBorder(null);
        txt_GenderInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GenderInfoActionPerformed(evt);
            }
        });

        txt_JobInfo.setEditable(false);
        txt_JobInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_JobInfo.setBorder(null);
        txt_JobInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_JobInfoActionPerformed(evt);
            }
        });

        txt_AccountNameInfo.setEditable(false);
        txt_AccountNameInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_AccountNameInfo.setBorder(null);
        txt_AccountNameInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AccountNameInfoActionPerformed(evt);
            }
        });

        txt_AccountIDInfo.setEditable(false);
        txt_AccountIDInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_AccountIDInfo.setBorder(null);
        txt_AccountIDInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AccountIDInfoActionPerformed(evt);
            }
        });

        txt_PasswordInfo.setEditable(false);
        txt_PasswordInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_PasswordInfo.setBorder(null);
        txt_PasswordInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordInfoActionPerformed(evt);
            }
        });

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_NameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_PhoneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_UserIDInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_GenderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_JobInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AccountNameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AccountIDInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_PasswordInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_NameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_PhoneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_GenderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_JobInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_UserIDInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_AccountIDInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_AccountNameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_PasswordInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("My info", jPanel3);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tên người dùng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Số điện thoại");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Vai trò");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Giới tính");

        buttonGroup1.add(rdoMale);
        rdoMale.setText("Nam");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Nữ");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));

        btn_Them1.setText("Thêm");
        btn_Them1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Them1MouseClicked(evt);
            }
        });

        btn_An1.setText("Xóa");
        btn_An1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_An1MouseClicked(evt);
            }
        });

        btn_Sua1.setText("Sửa");
        btn_Sua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Sua1MouseClicked(evt);
            }
        });

        btn_Moi1.setText("Mới");
        btn_Moi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Moi1MouseClicked(evt);
            }
        });

        tbl_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User ID", "Tên người dung", "SĐT", "Giới tính", "Vai trò"
            }
        ));
        tbl_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_UserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_User);

        txt_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Them1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Sua1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Moi1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_An1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addGap(33, 33, 33)
                                .addComponent(rdoFemale))
                            .addComponent(txt_TenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_TenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them1)
                    .addComponent(btn_An1))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Moi1)
                    .addComponent(btn_Sua1))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel5);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel16.setText("Quản lý tài khoản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NameInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameInfoActionPerformed

    private void txt_PhoneInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PhoneInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PhoneInfoActionPerformed

    private void txt_UserIDInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserIDInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UserIDInfoActionPerformed

    private void txt_GenderInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GenderInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GenderInfoActionPerformed

    private void txt_JobInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_JobInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_JobInfoActionPerformed

    private void txt_AccountNameInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AccountNameInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AccountNameInfoActionPerformed

    private void txt_AccountIDInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AccountIDInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AccountIDInfoActionPerformed

    private void txt_PasswordInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordInfoActionPerformed

    private void txt_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SDTActionPerformed

    private void btn_Them1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Them1MouseClicked
        String kq = qltk.add(getModelNV());
        JOptionPane.showMessageDialog(this, kq);
        loadUser(qltk.getList());
    }//GEN-LAST:event_btn_Them1MouseClicked

    private void btn_An1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_An1MouseClicked
        String kq = qltk.Delete((int) tbl_User.getValueAt(tbl_User.getSelectedRow(), 0));
        JOptionPane.showMessageDialog(this, kq);
        loadUser(qltk.getList());
    }//GEN-LAST:event_btn_An1MouseClicked

    private void btn_Sua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Sua1MouseClicked
        User_entity u = getModelNV();
        int id =(int) tbl_User.getValueAt(tbl_User.getSelectedRow(), 0);
        String kq = qltk.Update(getModelNV(),id);
        JOptionPane.showMessageDialog(this, kq);
        loadUser(qltk.getList());
    }//GEN-LAST:event_btn_Sua1MouseClicked

    private void btn_Moi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Moi1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Moi1MouseClicked

    private void tbl_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_UserMouseClicked
        int pos = tbl_User.getSelectedRow();
        LoadDataToModelUser(pos);
    }//GEN-LAST:event_tbl_UserMouseClicked

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        StringBuilder stb = new StringBuilder();
        if (!v.isEmpty(txt_MaNguoiDung, "Vui long nhap ma nguoi dung muon them", stb)
                && !v.isEmpty(txt_TenDangNhap, "Vui long nhap ten dang nhap muon them", stb)
                && !v.isEmpty(txt_MatKhau, "Vui long nhap mat khau muon them", stb)) {
            JOptionPane.showMessageDialog(this, stb);
        } else {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon them khong?", "Xac nhan", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                String kq = qltk.AddNew_TaiKhoan(getModel());
                JOptionPane.showMessageDialog(this, kq);
                LoadData(qltk.getList_TaiKhoan());
                resetColor();
            } else if (confirmResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Ban da huy bo them moi");
            }

        }
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void btn_SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaMouseClicked

        StringBuilder stb = new StringBuilder();
        int pos = tbl_QuanLyTaiKhoan.getSelectedRow();

        if (!v.isEmpty(txt_MaNguoiDung, "Vui long nhap ma nguoi dung muon sua", stb)
                && !v.isEmpty(txt_TenDangNhap, "Vui long nhap ten dang nhap muon sua", stb)
                && !v.isEmpty(txt_MatKhau, "Vui long nhap mat khau muon sua", stb)) {
            JOptionPane.showMessageDialog(this, stb);
        } else {
            int maTK = qltk.getList_TaiKhoan().get(pos).getMaTaiKhoan();
            String kq = qltk.Update_TaiKhoan(getModel(), maTK);
            JOptionPane.showMessageDialog(this, kq);
            LoadData(qltk.getList_TaiKhoan());
            resetColor();
            System.out.println(maTK);

        }
    }//GEN-LAST:event_btn_SuaMouseClicked

    private void btn_AnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AnMouseClicked
        StringBuilder stb = new StringBuilder();
        int pos = tbl_QuanLyTaiKhoan.getSelectedRow();
        if (!v.isEmpty(txt_TenDangNhap, "Vui long nhap ten dang nhap muon xoa", stb)) {
            JOptionPane.showMessageDialog(this, stb);
        } else {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa khong?", "Xac nhan", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                int maTK = qltk.getList_TaiKhoan().get(pos).getMaTaiKhoan();
                String kq = qltk.Xoa_TaiKhoan(maTK);
                JOptionPane.showMessageDialog(this, kq);
                LoadData(qltk.getList_TaiKhoan());
                resetColor();
            } else if (confirmResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Ban da huy bo xoa bo");
            }
        }

    }//GEN-LAST:event_btn_AnMouseClicked

    private void btn_MoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MoiMouseClicked
        New();
    }//GEN-LAST:event_btn_MoiMouseClicked

    private void tbl_QuanLyTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_QuanLyTaiKhoanMouseClicked
        int pos = tbl_QuanLyTaiKhoan.getSelectedRow();
        LoadDataToModel(pos);
    }//GEN-LAST:event_tbl_QuanLyTaiKhoanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_An;
    private javax.swing.JButton btn_An1;
    private javax.swing.JButton btn_Moi;
    private javax.swing.JButton btn_Moi1;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Sua1;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Them1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel pic;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tbl_QuanLyTaiKhoan;
    private javax.swing.JTable tbl_User;
    private javax.swing.JTextField txt_AccountIDInfo;
    private javax.swing.JTextField txt_AccountNameInfo;
    private javax.swing.JTextField txt_GenderInfo;
    private javax.swing.JTextField txt_JobInfo;
    private javax.swing.JTextField txt_MaNguoiDung;
    private javax.swing.JTextField txt_MatKhau;
    private javax.swing.JTextField txt_NameInfo;
    private javax.swing.JTextField txt_PasswordInfo;
    private javax.swing.JTextField txt_PhoneInfo;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenDangNhap;
    private javax.swing.JTextField txt_TenNguoiDung;
    private javax.swing.JTextField txt_UserIDInfo;
    // End of variables declaration//GEN-END:variables
}
