package View.khachHang;

import Validate.Validate;
import entity.KhachHangModel;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import service.QLKH_service;
import entity.SanPhamDaMua_model;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class khachHang_view extends javax.swing.JPanel {

    /**
     * Creates new form khachHang_view
     */
    public khachHang_view() {
        initComponents();
        setIcon();
        LoadData_KhachHang(qlService.getList_KhachHang());

        
    }
    Validate v = new Validate();
    QLKH_service qlService = new QLKH_service();

    public void LoadData_KhachHang(ArrayList<KhachHangModel> lsKhachHang) {
        DefaultTableModel model = (DefaultTableModel) tbl_KhachHang.getModel();
        model.setRowCount(0);
        for (KhachHangModel kh : lsKhachHang) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getSoDienThoai()
            });
        }
    }

    public void LoadData_HoaDon(ArrayList<SanPhamDaMua_model> lsHoaDonDaMua) {
        DefaultTableModel model = (DefaultTableModel) tbl_HoaDonDaMua.getModel();
        model.setRowCount(0);
        for (SanPhamDaMua_model hd : lsHoaDonDaMua) {
            model.addRow(new Object[]{
                hd.getMaSanPham(),
                hd.getTenSanPham(),
                hd.getMauSac(),
                hd.getSize(),
                hd.getTenDanhMuc(),
                hd.getSoLuong(),
                hd.getDonGia(),
                hd.getMaHoaDon()

            });
        }
    }

    public KhachHangModel getModel() {
        KhachHangModel kh = new KhachHangModel();
        kh.setTenKhachHang(txt_HoTen.getText());
        kh.setSoDienThoai(txt_SoDienThoai.getText());
        return kh;
    }

    public void resetColor() {
        txt_MaKhachHang.setBackground(Color.WHITE);
        txt_HoTen.setBackground(Color.WHITE);
        txt_SoDienThoai.setBackground(Color.WHITE);
    }

    public void LoadDataToModel_KhachHang(int pos) {
        KhachHangModel kh = qlService.getList_KhachHang().get(pos);
        txt_MaKhachHang.setText(String.valueOf(kh.getMaKhachHang()));
        txt_HoTen.setText(kh.getTenKhachHang());
        txt_SoDienThoai.setText(kh.getSoDienThoai());
        LoadData_HoaDon(qlService.getList_HoaDonDaMua(kh.getMaKhachHang()));

    }

    public void New() {
        txt_MaKhachHang.setText("");
        txt_HoTen.setText("");
        txt_SoDienThoai.setText("");
        resetColor();
    }

    public void setIcon() {
        Icon iconn = this.icon.getIcon();
        ImageIcon imageIcon = (ImageIcon) iconn;
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Icon resizedIcon = new ImageIcon(newImg);
        this.icon.setIcon(resizedIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDonDaMua = new javax.swing.JTable();
        txt_MaKhachHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_Sửa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_Xóa = new javax.swing.JButton();
        txt_HoTen = new javax.swing.JTextField();
        btn_New = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        txt_SoDienThoai = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1028, 500));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane2.setOpaque(false);

        tbl_HoaDonDaMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Màu sắc", "Size", "Danh Mục", "Số Lượng", " Đơn giá", "Mã hóa đơn"
            }
        ));
        tbl_HoaDonDaMua.setOpaque(false);
        tbl_HoaDonDaMua.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_HoaDonDaMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonDaMuaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_HoaDonDaMua);

        txt_MaKhachHang.setEditable(false);
        txt_MaKhachHang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_MaKhachHang.setBorder(null);
        txt_MaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaKhachHangActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Họ tên :");

        jLabel1.setText("Danh sách khách hàng");

        btn_Them.setText("Thêm");
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });

        jLabel2.setText("Đơn hàng đã mua");

        btn_Sửa.setText("Sửa");
        btn_Sửa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SửaMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Mã KH : ");

        btn_Xóa.setText("Xóa");
        btn_Xóa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XóaMouseClicked(evt);
            }
        });

        txt_HoTen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_HoTen.setBorder(null);
        txt_HoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HoTenActionPerformed(evt);
            }
        });

        btn_New.setText("Làm mới");
        btn_New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NewMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("SĐT :");

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/HomePage/Icon/icons8-customer-24.png"))); // NOI18N

        txt_SoDienThoai.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txt_SoDienThoai.setBorder(null);
        txt_SoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoDienThoaiActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setOpaque(false);

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "SDT"
            }
        ));
        tbl_KhachHang.setOpaque(false);
        tbl_KhachHang.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel8))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(jLabel9)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_Xóa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                            .addComponent(btn_New, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_Sửa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(btn_Sửa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Xóa)
                            .addComponent(btn_New))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_HoaDonDaMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonDaMuaMouseClicked

    }//GEN-LAST:event_tbl_HoaDonDaMuaMouseClicked

    private void txt_MaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaKhachHangActionPerformed

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        StringBuilder stb = new StringBuilder();
        if (!v.isEmpty(txt_HoTen,  "Vui long nhap ho ten khach hang muon them",stb)
                && !v.isPhoneNumber(txt_SoDienThoai,  "Vui long nhap so dien thoai muon them",stb)) {
            JOptionPane.showMessageDialog(this, stb);
        } else {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon them khong?", "Xac nhan", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                String kq = qlService.AddNew_KhachHang(getModel());
                JOptionPane.showMessageDialog(this, kq);
                LoadData_KhachHang(qlService.getList_KhachHang());
                resetColor();
            } else if (confirmResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Ban da huy bo them moi");
            }

        }
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void btn_SửaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SửaMouseClicked
        StringBuilder stb = new StringBuilder();
        if (!v.isEmpty(txt_HoTen,  "Vui long nhap ho ten khach hang muon them",stb)
                && !v.isPhoneNumber(txt_SoDienThoai,  "Vui long nhap so dien thoai muon them",stb)) {
            JOptionPane.showMessageDialog(this, stb);
        } else {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon sua khong?", "Xac nhan", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                String kq = qlService.Update_KhachHang(getModel(), Integer.parseInt(txt_MaKhachHang.getText()));
                JOptionPane.showMessageDialog(this, kq);
                LoadData_KhachHang(qlService.getList_KhachHang());
                resetColor();
            } else if (confirmResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Ban da huy bo sua moi");
            }

        }
    }//GEN-LAST:event_btn_SửaMouseClicked

    private void btn_XóaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XóaMouseClicked
        StringBuilder stb = new StringBuilder();
        int confirmResult = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa khong?", "Xac nhan", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            String kq = qlService.Xoa_KhachHang(Integer.parseInt(txt_MaKhachHang.getText()));
            JOptionPane.showMessageDialog(this, kq);
            LoadData_KhachHang(qlService.getList_KhachHang());
            resetColor();
        } else if (confirmResult == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Ban da huy bo xoa bo");
        }
    }//GEN-LAST:event_btn_XóaMouseClicked

    private void txt_HoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoTenActionPerformed

    private void btn_NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NewMouseClicked
        New();
    }//GEN-LAST:event_btn_NewMouseClicked

    private void txt_SoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoDienThoaiActionPerformed

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        int pos = tbl_KhachHang.getSelectedRow();
        LoadDataToModel_KhachHang(pos);
    }//GEN-LAST:event_tbl_KhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_New;
    private javax.swing.JButton btn_Sửa;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xóa;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbl_HoaDonDaMua;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_HoTen;
    private javax.swing.JTextField txt_MaKhachHang;
    private javax.swing.JTextField txt_SoDienThoai;
    // End of variables declaration//GEN-END:variables
}
