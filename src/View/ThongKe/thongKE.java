/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.ThongKe;

import entity.ThongKe_DoanhThu_Model;
import entity.SanPhamModel_view;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import service.QuanLyThongKe_service;

/**
 *
 * @author DELL
 */
public class thongKE extends javax.swing.JPanel {

    QuanLyThongKe_service qlService = new QuanLyThongKe_service();

    public thongKE() {
        initComponents();
        LoadData_SanPham(qlService.getList_ThongKeSanPham());
        LoadData_DoanhThu(qlService.getList_ThongKeDoanhThu());
        trangThai();
    }

    public void LoadData_SanPham(ArrayList<SanPhamModel_view> tkSanPham) {
        DefaultTableModel model = (DefaultTableModel) tbl_SanPham.getModel();
        model.setRowCount(0);
        for (SanPhamModel_view tksp : tkSanPham) {
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                tksp.getMaSP(),
                tksp.getTenSP(),
                tksp.getSoLuong(),
                tksp.getMauSac(),
                tksp.getSize(),
                tksp.getDanhMuc(),
                tksp.getDonGia()
            });
        }
    }

    public void LoadData_DoanhThu(ArrayList<ThongKe_DoanhThu_Model> tkDoanhThu) {
        DefaultTableModel model1 = (DefaultTableModel) tbl_DoanhThu.getModel();
        model1.setRowCount(0);
        for (ThongKe_DoanhThu_Model tkdt : tkDoanhThu) {
            model1.addRow(new Object[]{
                tkdt.getMaHoaDon(),
                tkdt.getTongTien(),
                tkdt.getNgayTaoHoaDon(),
                tkdt.getKhachHang()
            });
        }
    }

    public void tongDoanhThu(ArrayList<ThongKe_DoanhThu_Model> tkdt, JLabel lbl) {
        double tongDoanhThu = 0;
        for (ThongKe_DoanhThu_Model tk : tkdt) {
            tongDoanhThu = tongDoanhThu + tk.getTongTien();
        }
        lbl.setText(tongDoanhThu + "VND");

    }

    public void trangThai() {
        lbl_DonHang1.setText(qlService.getList_ThongKeDoanhThu().size() + " đơn hàng");
        lbl_ThanhCong.setText("" + qlService.getList_DoanhThuThanhCong());
        lbl_ThatBai.setText("" + qlService.getList_DoanhThuThatBai());

        LocalDate ngayHienTai = LocalDate.now();
        java.sql.Date begin = java.sql.Date.valueOf(ngayHienTai.atStartOfDay().toLocalDate());
        java.sql.Date end = java.sql.Date.valueOf(ngayHienTai.atTime(23, 59, 59).toLocalDate());

        lbl_ThanhCong1.setText("" + qlService.getList_DoanhThuThanhCongbyTime(begin, end));
        lbl_ThatBai1.setText("" + qlService.getList_DoanhThuThatBaibyTime(begin, end));
        tongDoanhThu(qlService.getList_DoanhThuByThoiGian(begin, end), lbl_TongDoanhThu1);

        LocalDate ngayBatDau = LocalDate.now().withDayOfMonth(1);
        LocalDate ngayKetThuc = YearMonth.now().atEndOfMonth();
        java.sql.Date beginMonth = java.sql.Date.valueOf(ngayBatDau);
        java.sql.Date endMonth = java.sql.Date.valueOf(ngayKetThuc);
        
        lbl_ThanhCong2.setText("" + qlService.getList_DoanhThuThanhCongbyTime(beginMonth, endMonth));
        lbl_ThatBai2.setText("" + qlService.getList_DoanhThuThatBaibyTime(beginMonth, endMonth));
        tongDoanhThu(qlService.getList_DoanhThuByThoiGian(beginMonth, endMonth), lbl_TongDoanhThu2);

        LocalDate ngayBatDau1 = LocalDate.now().withDayOfYear(1);
        LocalDate ngayKetThuc1 = LocalDate.now().withDayOfYear(365);
        java.sql.Date beginYear = java.sql.Date.valueOf(ngayBatDau1);
        java.sql.Date endYear = java.sql.Date.valueOf(ngayKetThuc1);

        lbl_ThanhCong3.setText("" + qlService.getList_DoanhThuThanhCongbyTime(beginYear, endYear));
        lbl_ThatBai3.setText("" + qlService.getList_DoanhThuThatBaibyTime(beginYear, endYear));
        tongDoanhThu(qlService.getList_DoanhThuByThoiGian(beginYear, endYear), lbl_TongDoanhThu3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sortByDay3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btn_TimKiem3 = new javax.swing.JButton();
        dc_NgayBatDau = new com.toedter.calendar.JDateChooser();
        dc_NgayKetThuc = new com.toedter.calendar.JDateChooser();
        ThongKeTheoNam = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_ThanhCong3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_TongDoanhThu3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_ThatBai3 = new javax.swing.JLabel();
        ThongKeTheoThang = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_ThanhCong2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_TongDoanhThu2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_ThatBai2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DoanhThu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        ThongKeTheoNgay = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_ThatBai1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_TongDoanhThu1 = new javax.swing.JLabel();
        lbl_ThanhCong1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        soDonHangDaBan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_DonHang1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_ThanhCong = new javax.swing.JLabel();
        lbl_ThatBai = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1028, 500));

        sortByDay3.setOpaque(false);

        jLabel37.setText("Ngày bắt đầu");

        jLabel38.setText("Ngày kết thúc");

        btn_TimKiem3.setText("tìm kiếm");
        btn_TimKiem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiem3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sortByDay3Layout = new javax.swing.GroupLayout(sortByDay3);
        sortByDay3.setLayout(sortByDay3Layout);
        sortByDay3Layout.setHorizontalGroup(
            sortByDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortByDay3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dc_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dc_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimKiem3)
                .addContainerGap())
        );
        sortByDay3Layout.setVerticalGroup(
            sortByDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortByDay3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sortByDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sortByDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_TimKiem3)
                        .addGroup(sortByDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dc_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)))
                    .addComponent(dc_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThongKeTheoNam.setBackground(new java.awt.Color(255, 0, 0));
        ThongKeTheoNam.setMinimumSize(new java.awt.Dimension(170, 110));
        ThongKeTheoNam.setPreferredSize(new java.awt.Dimension(150, 100));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Tổng doanh thu / năm");

        lbl_ThanhCong3.setText("0");

        jLabel25.setText("Thất bại");

        lbl_TongDoanhThu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TongDoanhThu3.setText("0 VND");

        jLabel27.setText("Thành công");

        lbl_ThatBai3.setText("0");

        javax.swing.GroupLayout ThongKeTheoNamLayout = new javax.swing.GroupLayout(ThongKeTheoNam);
        ThongKeTheoNam.setLayout(ThongKeTheoNamLayout);
        ThongKeTheoNamLayout.setHorizontalGroup(
            ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                        .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                                .addComponent(lbl_ThanhCong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18))
                            .addComponent(lbl_ThatBai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                        .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TongDoanhThu3))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ThongKeTheoNamLayout.setVerticalGroup(
            ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel23)
                .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                        .addComponent(lbl_TongDoanhThu3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(lbl_ThanhCong3)))
                    .addGroup(ThongKeTheoNamLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongKeTheoNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lbl_ThatBai3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        ThongKeTheoThang.setBackground(new java.awt.Color(8, 202, 59));
        ThongKeTheoThang.setMinimumSize(new java.awt.Dimension(170, 110));
        ThongKeTheoThang.setPreferredSize(new java.awt.Dimension(150, 100));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Tổng doanh thu / tháng");

        lbl_ThanhCong2.setText("0");

        jLabel18.setText("Thất bại");

        lbl_TongDoanhThu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TongDoanhThu2.setText("0 VND");

        jLabel17.setText("Thành công");

        lbl_ThatBai2.setText("0");

        javax.swing.GroupLayout ThongKeTheoThangLayout = new javax.swing.GroupLayout(ThongKeTheoThang);
        ThongKeTheoThang.setLayout(ThongKeTheoThangLayout);
        ThongKeTheoThangLayout.setHorizontalGroup(
            ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                        .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                                .addComponent(lbl_ThanhCong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18))
                            .addComponent(lbl_ThatBai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                        .addComponent(lbl_TongDoanhThu2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        ThongKeTheoThangLayout.setVerticalGroup(
            ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                        .addComponent(lbl_TongDoanhThu2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lbl_ThanhCong2)))
                    .addGroup(ThongKeTheoThangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbl_ThatBai2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tbl_DoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tổng tiền", "Thời Gian", "Khách hàng"
            }
        ));
        jScrollPane2.setViewportView(tbl_DoanhThu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Doanh thu", jPanel1);

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán", "Màu sắc", "Size", "Danh mục", "Giá"
            }
        ));
        jScrollPane1.setViewportView(tbl_SanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        ThongKeTheoNgay.setBackground(new java.awt.Color(66, 107, 255));
        ThongKeTheoNgay.setPreferredSize(new java.awt.Dimension(170, 110));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng doanh thu / ngày");

        lbl_ThatBai1.setText("0");

        jLabel11.setText("Thành công");

        lbl_TongDoanhThu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TongDoanhThu1.setText("0 VND");

        lbl_ThanhCong1.setText("0");

        jLabel14.setText("Thất bại");

        javax.swing.GroupLayout ThongKeTheoNgayLayout = new javax.swing.GroupLayout(ThongKeTheoNgay);
        ThongKeTheoNgay.setLayout(ThongKeTheoNgayLayout);
        ThongKeTheoNgayLayout.setHorizontalGroup(
            ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                        .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                                .addComponent(lbl_ThanhCong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18))
                            .addComponent(lbl_ThatBai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                        .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TongDoanhThu1))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ThongKeTheoNgayLayout.setVerticalGroup(
            ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                        .addComponent(lbl_TongDoanhThu1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lbl_ThanhCong1)))
                    .addGroup(ThongKeTheoNgayLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongKeTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_ThatBai1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        soDonHangDaBan.setBackground(new java.awt.Color(121, 107, 255));
        soDonHangDaBan.setPreferredSize(new java.awt.Dimension(170, 110));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tổng đơn hàng");

        lbl_DonHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DonHang1.setText("0 đơn hàng");

        jLabel4.setText("Thành công");

        jLabel5.setText("Thất bại");

        lbl_ThanhCong.setText("0");

        lbl_ThatBai.setText("0");

        javax.swing.GroupLayout soDonHangDaBanLayout = new javax.swing.GroupLayout(soDonHangDaBan);
        soDonHangDaBan.setLayout(soDonHangDaBanLayout);
        soDonHangDaBanLayout.setHorizontalGroup(
            soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soDonHangDaBanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_DonHang1)
                    .addGroup(soDonHangDaBanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(soDonHangDaBanLayout.createSequentialGroup()
                        .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ThanhCong, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(lbl_ThatBai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        soDonHangDaBanLayout.setVerticalGroup(
            soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soDonHangDaBanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addComponent(lbl_DonHang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_ThanhCong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(soDonHangDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_ThatBai))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(soDonHangDaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ThongKeTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ThongKeTheoThang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ThongKeTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sortByDay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ThongKeTheoNam, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(soDonHangDaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(ThongKeTheoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(ThongKeTheoThang, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(sortByDay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiem3MouseClicked
        java.util.Date utilDate1 = dc_NgayBatDau.getDate();
        java.util.Date utilDate2 = dc_NgayKetThuc.getDate();
        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
        ArrayList<ThongKe_DoanhThu_Model> ls = qlService.getList_DoanhThuByThoiGian(sqlDate1, sqlDate2);
        LoadData_DoanhThu(ls);
    }//GEN-LAST:event_btn_TimKiem3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ThongKeTheoNam;
    private javax.swing.JPanel ThongKeTheoNgay;
    private javax.swing.JPanel ThongKeTheoThang;
    private javax.swing.JButton btn_TimKiem3;
    private com.toedter.calendar.JDateChooser dc_NgayBatDau;
    private com.toedter.calendar.JDateChooser dc_NgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_DonHang1;
    private javax.swing.JLabel lbl_ThanhCong;
    private javax.swing.JLabel lbl_ThanhCong1;
    private javax.swing.JLabel lbl_ThanhCong2;
    private javax.swing.JLabel lbl_ThanhCong3;
    private javax.swing.JLabel lbl_ThatBai;
    private javax.swing.JLabel lbl_ThatBai1;
    private javax.swing.JLabel lbl_ThatBai2;
    private javax.swing.JLabel lbl_ThatBai3;
    private javax.swing.JLabel lbl_TongDoanhThu1;
    private javax.swing.JLabel lbl_TongDoanhThu2;
    private javax.swing.JLabel lbl_TongDoanhThu3;
    private javax.swing.JPanel soDonHangDaBan;
    private javax.swing.JPanel sortByDay3;
    private javax.swing.JTable tbl_DoanhThu;
    private javax.swing.JTable tbl_SanPham;
    // End of variables declaration//GEN-END:variables
}
