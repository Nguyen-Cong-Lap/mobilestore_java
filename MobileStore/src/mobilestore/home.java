package mobilestore;

import java.awt.Image;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
public class home extends javax.swing.JFrame {
    Connect cn = new Connect();
    Connection conn= cn.getConnection();
    private String imagePath;
    public home() {
        initComponents();
        getData_NhanVien();
        getData_SanPham();
        getData_Kho();
        getData_Luong();
        getdata_MatKhau();
        setLocationRelativeTo(null);
        getData_HoaDon();
        TongSoTienLuong();
        
    }
    public void getData_NhanVien(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from NhanVien");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvnhanvien.setModel(tbn);
            }
            dgvnhanvien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    DefaultTableModel tbn=new DefaultTableModel();
                    if(dgvnhanvien.getSelectedRow()>=0){
                        txtmanv.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 0)+"");
                        txttennv.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 1)+"");
                        txtngaysinh.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 2)+"");
                        txtgioitinh.setSelectedItem(dgvnhanvien.getModel().getValueAt(dgvnhanvien.getSelectedRow(), 3)+"");
                        txtsdt.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 4)+"");
                        txtquequan.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 5)+"");
                        txtluongcoban.setText(dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 6)+"");
                        String path = dgvnhanvien.getValueAt(dgvnhanvien.getSelectedRow(), 7).toString();
                        imagePath=path;
                        anhnv.setIcon(ImageAdjust(path, null));
                        txtmanv.setEnabled(false);
                        btnthemnv.setEnabled(false);
                    }
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void getData_SanPham(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from SanPham");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvsp.setModel(tbn);
            }
            dgvsp.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(dgvsp.getSelectedRow()>=0){
                        txtmasp.setText(dgvsp.getValueAt(dgvsp.getSelectedRow(), 0)+"");
                        txttensp.setText(dgvsp.getValueAt(dgvsp.getSelectedRow(), 1)+"");
                        txtngaysx.setText(dgvsp.getValueAt(dgvsp.getSelectedRow(), 2)+"");
                        cbbaohanh.setSelectedItem(dgvsp.getModel().getValueAt(dgvsp.getSelectedRow(), 3)+"");
                        txtnhasx.setText(dgvsp.getValueAt(dgvsp.getSelectedRow(), 4)+"");
                        txtgiaban.setText(dgvsp.getValueAt(dgvsp.getSelectedRow(), 5)+"");
                        txtmasp.setEnabled(false);
                        btnthemsp.setEnabled(false);
                        String path = dgvsp.getValueAt(dgvsp.getSelectedRow(), 6).toString();
                        imagePath=path;
                        anhsp.setIcon(ImageAdjust(path, null));
                    }
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void getData_Kho(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from Kho");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvkho.setModel(tbn);
            }
            dgvkho.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(dgvkho.getSelectedRow()>=0){
                        txtmasp_kho.setText(dgvkho.getValueAt(dgvkho.getSelectedRow(), 0)+"");
                        txtngaynhap.setText(dgvkho.getValueAt(dgvkho.getSelectedRow(), 1)+"");
                        txtsoluong.setText(dgvkho.getValueAt(dgvkho.getSelectedRow(), 2)+"");
                        txtdongia.setText(dgvkho.getValueAt(dgvkho.getSelectedRow(), 3)+"");
                        txtmasp_kho.setEnabled(false);
                        btnthemkho.setEnabled(false);
                        String path = dgvkho.getValueAt(dgvkho.getSelectedRow(), 4).toString();
                        imagePath=path;
                        anhspkho.setIcon(ImageAdjust(path, null));
                    }
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void getData_Luong(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select NhanVien.manv,tennv,Luong.songaycong,(NhanVien.luongcoban/30)*Luong.songaycong as LuongThucNhan from NhanVien,Luong where NhanVien.manv=Luong.manv");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 

            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvLuong.setModel(tbn);
            }
            dgvLuong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(dgvLuong.getSelectedRow()>=0){
                        txtluongmanv.setText(dgvLuong.getValueAt(dgvLuong.getSelectedRow(), 0)+"");
                        txtluongsongaycong.setText(dgvLuong.getValueAt(dgvLuong.getSelectedRow(), 2)+"");
                        txtluongmanv.setEnabled(false);
                    }
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void getData_HoaDon(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select  HoaDon1.*,HoaDon1.soluong*HoaDon1.giaban as TongThanhToan from HoaDon1,SanPham where HoaDon1.masp=SanPham.masp");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 

            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvhoadon.setModel(tbn);
            }
            dgvhoadon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(dgvhoadon.getSelectedRow()>=0){
                        txtHDmahoadon.setText(dgvhoadon.getValueAt(dgvhoadon.getSelectedRow(), 0)+"");
                        txtHDngayxuat.setText(dgvhoadon.getValueAt(dgvhoadon.getSelectedRow(), 1)+"");
                        txtHDmasp.setText(dgvhoadon.getValueAt(dgvhoadon.getSelectedRow(), 2)+"");
                        txtHDsoluong.setText(dgvhoadon.getValueAt(dgvhoadon.getSelectedRow(), 3)+"");
                        txtHDgiaban.setText(dgvhoadon.getValueAt(dgvhoadon.getSelectedRow(), 4)+"");
                        txtHDmahoadon.setEnabled(false);
                    }
                }
            });
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btndangxuat = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtquequan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        txtgioitinh = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvnhanvien = new javax.swing.JTable();
        txttimkiemnv = new javax.swing.JTextField();
        btntimkiemnv = new javax.swing.JButton();
        btnthemnv = new javax.swing.JButton();
        btnxoanv = new javax.swing.JButton();
        btnsuanv = new javax.swing.JButton();
        btnlammoinv = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnthemanhnv = new javax.swing.JButton();
        btnxoatknv = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtluongcoban = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        anhnv = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnxoatksp = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtgiaban = new javax.swing.JTextField();
        btnthemsp = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnxoasp = new javax.swing.JButton();
        txtmasp = new javax.swing.JTextField();
        txtnhasx = new javax.swing.JTextField();
        btnsuasp = new javax.swing.JButton();
        cbbaohanh = new javax.swing.JComboBox<>();
        btnlammoisp = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvsp = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        anhsp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txttimkiemsp = new javax.swing.JTextField();
        btnthemanhsp = new javax.swing.JButton();
        btntimkiemsp = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtngaysx = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnxoatkkho = new javax.swing.JButton();
        btnthemkho = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnxoakho = new javax.swing.JButton();
        txtmasp_kho = new javax.swing.JTextField();
        txtdongia = new javax.swing.JTextField();
        btnsuakho = new javax.swing.JButton();
        btnlammoikho = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtngaynhap = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        dgvkho = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        anhspkho = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttimkiemkho = new javax.swing.JTextField();
        btnthemanhspkho = new javax.swing.JButton();
        btntimkiemkho = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        dgvthongke = new javax.swing.JTable();
        cbthongke = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtthongke = new javax.swing.JTextField();
        btnthongke = new javax.swing.JButton();
        lbsoluongmay = new javax.swing.JLabel();
        lbdoanhso = new javax.swing.JLabel();
        lblai = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTextField22 = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        dgvLuong = new javax.swing.JTable();
        btncapnhatluong = new javax.swing.JButton();
        txtluongmanv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtluongsongaycong = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        lbtongluong = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lbmahd = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtHDmahoadon = new javax.swing.JTextField();
        txtHDngayxuat = new javax.swing.JTextField();
        txtHDsoluong = new javax.swing.JTextField();
        txtHDgiaban = new javax.swing.JTextField();
        txtHDtimkiem = new javax.swing.JTextField();
        btntimkiemkho1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        dgvhoadon = new javax.swing.JTable();
        btnHDthem = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtHDmasp = new javax.swing.JTextField();
        btnHDcapnhat = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        dgvtaikhoan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btncapnhatTK = new javax.swing.JButton();
        txtmkcu = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtmkmoi = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtnhaplaimk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("                       MOBILE STORE");

        btndangxuat.setBackground(new java.awt.Color(0, 204, 204));
        btndangxuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndangxuat.setText("Đăng Xuất");
        btndangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btndangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(51, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Nhân Viên :");

        txtmanv.setName("txtmanv"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tên Nhân Viên :");

        txttennv.setName("txttennv"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Giới Tính :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Ngày Sinh :");

        txtngaysinh.setName("txtngaysinh"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Quê Quán :");

        txtquequan.setName("txtquequan"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Số Điện Thoại :");

        txtsdt.setName("txtsdt"); // NOI18N

        txtgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nam", "nu" }));
        txtgioitinh.setName("txtgioitinh"); // NOI18N

        dgvnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(dgvnhanvien);

        txttimkiemnv.setName("txttimkiemnv"); // NOI18N

        btntimkiemnv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntimkiemnv.setText("Tìm Kiếm");
        btntimkiemnv.setName("btnthemanh"); // NOI18N
        btntimkiemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemnvActionPerformed(evt);
            }
        });

        btnthemnv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemnv.setText("Thêm TT");
        btnthemnv.setName("btnthemnv"); // NOI18N
        btnthemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemnvActionPerformed(evt);
            }
        });

        btnxoanv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoanv.setText("Xóa TT");
        btnxoanv.setName("btnxoanv"); // NOI18N
        btnxoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoanvActionPerformed(evt);
            }
        });

        btnsuanv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsuanv.setText("Sửa TT");
        btnsuanv.setName("btnsuanv"); // NOI18N
        btnsuanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanvActionPerformed(evt);
            }
        });

        btnlammoinv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlammoinv.setText("Làm Mới");
        btnlammoinv.setName("btnlammoinv"); // NOI18N
        btnlammoinv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoinvActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Hình Ảnh");

        btnthemanhnv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemanhnv.setText("Thêm Ảnh");
        btnthemanhnv.setName("btnthemanhnv"); // NOI18N
        btnthemanhnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemanhnvActionPerformed(evt);
            }
        });

        btnxoatknv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoatknv.setText("Xóa");
        btnxoatknv.setName("btnxoatknv"); // NOI18N
        btnxoatknv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatknvActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Lương Cơ Bản :");

        txtluongcoban.setName("txtluong"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhnv, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhnv, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(txttimkiemnv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntimkiemnv)
                        .addGap(37, 37, 37)
                        .addComponent(btnxoatknv)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtquequan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtluongcoban, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnthemanhnv, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(31, 31, 31)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(btnthemnv)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoanv)
                                .addGap(18, 18, 18)
                                .addComponent(btnsuanv)
                                .addGap(18, 18, 18)
                                .addComponent(btnlammoinv)
                                .addGap(164, 164, 164)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttimkiemnv, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoatknv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btntimkiemnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmanv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthemnv, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnxoanv, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnsuanv, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnlammoinv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttennv)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtngaysinh)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsdt)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtquequan)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtluongcoban)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnthemanhnv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("QL Nhân Viên", jPanel3);

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));

        btnxoatksp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoatksp.setText("Xóa");
        btnxoatksp.setName("btnxoa"); // NOI18N
        btnxoatksp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatkspActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Giá Bán :");

        txtgiaban.setName("txtgiaban"); // NOI18N

        btnthemsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemsp.setText("Thêm TT");
        btnthemsp.setName("btnthemsp"); // NOI18N
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nhà Sản Xuất :");

        btnxoasp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoasp.setText("Xóa TT");
        btnxoasp.setName("btnxoasp"); // NOI18N
        btnxoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaspActionPerformed(evt);
            }
        });

        txtmasp.setName("txtmasp"); // NOI18N

        txtnhasx.setName("txtnhasx"); // NOI18N

        btnsuasp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsuasp.setText("Sửa TT");
        btnsuasp.setName("btnsuasp"); // NOI18N
        btnsuasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaspActionPerformed(evt);
            }
        });

        cbbaohanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12 tháng", "24 tháng" }));
        cbbaohanh.setName("txtbaohanh"); // NOI18N

        btnlammoisp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlammoisp.setText("Làm Mới");
        btnlammoisp.setName("btnlammoisp"); // NOI18N
        btnlammoisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoispActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Tên Sản Phẩm :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Hình Ảnh");

        txttensp.setName("txttensp"); // NOI18N

        dgvsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Ngày Sản Xuất", "Bảo Hành", "Nhà Sản Xuất", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(dgvsp);
        if (dgvsp.getColumnModel().getColumnCount() > 0) {
            dgvsp.getColumnModel().getColumn(2).setHeaderValue("Ngày Sinh");
            dgvsp.getColumnModel().getColumn(3).setHeaderValue("Giới Tính");
            dgvsp.getColumnModel().getColumn(4).setHeaderValue("Số Điện Thoại");
            dgvsp.getColumnModel().getColumn(5).setHeaderValue("Quê Quán");
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhsp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhsp, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã Sản Phẩm  :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Bảo Hành :");

        txttimkiemsp.setName("txttimkiem"); // NOI18N

        btnthemanhsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemanhsp.setText("Thêm Ảnh");
        btnthemanhsp.setName("btnthemanh"); // NOI18N
        btnthemanhsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemanhspActionPerformed(evt);
            }
        });

        btntimkiemsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntimkiemsp.setText("Tìm Kiếm");
        btntimkiemsp.setName("btntimkiem"); // NOI18N
        btntimkiemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemspActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Ngày Sản Xuất :");

        txtngaysx.setName("txtngaysx"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(txttimkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntimkiemsp)
                        .addGap(37, 37, 37)
                        .addComponent(btnxoatksp)
                        .addGap(0, 168, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtngaysx, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbbaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtnhasx, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnthemanhsp, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnthemsp)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoasp)
                                .addGap(18, 18, 18)
                                .addComponent(btnsuasp)
                                .addGap(18, 18, 18)
                                .addComponent(btnlammoisp)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttimkiemsp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoatksp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btntimkiemsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmasp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthemsp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnxoasp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnsuasp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnlammoisp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttensp)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtngaysx)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnhasx)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtgiaban)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnthemanhsp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("QL Sản Phẩm", jPanel5);

        jPanel10.setBackground(new java.awt.Color(153, 255, 204));

        btnxoatkkho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoatkkho.setText("Xóa");
        btnxoatkkho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatkkhoActionPerformed(evt);
            }
        });

        btnthemkho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemkho.setText("Thêm TT");
        btnthemkho.setName("btnthemkho"); // NOI18N
        btnthemkho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemkhoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Đơn Giá :");

        btnxoakho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoakho.setText("Xóa TT");
        btnxoakho.setName("btnxoakho"); // NOI18N
        btnxoakho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoakhoActionPerformed(evt);
            }
        });

        txtmasp_kho.setName("txtmasp"); // NOI18N

        txtdongia.setName("txtdongia"); // NOI18N

        btnsuakho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsuakho.setText("Sửa TT");
        btnsuakho.setName("btnsuakho"); // NOI18N
        btnsuakho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuakhoActionPerformed(evt);
            }
        });

        btnlammoikho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlammoikho.setText("Làm Mới");
        btnlammoikho.setName("btnlammoikh"); // NOI18N
        btnlammoikho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoikhoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Ngày Nhập :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Hình Ảnh");

        txtngaynhap.setName("txtngaynhap"); // NOI18N

        dgvkho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Ngày Nhập", "Số Lượng", "Đơn Giá"
            }
        ));
        jScrollPane3.setViewportView(dgvkho);
        if (dgvkho.getColumnModel().getColumnCount() > 0) {
            dgvkho.getColumnModel().getColumn(0).setHeaderValue("Mã Sản Phẩm");
            dgvkho.getColumnModel().getColumn(1).setHeaderValue("Ngày Nhập");
            dgvkho.getColumnModel().getColumn(2).setHeaderValue("Ngày Sinh");
            dgvkho.getColumnModel().getColumn(3).setHeaderValue("Giới Tính");
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhspkho, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anhspkho, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã Sản Phẩm :");

        txttimkiemkho.setName("txttimkiem"); // NOI18N

        btnthemanhspkho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthemanhspkho.setText("Thêm Ảnh");
        btnthemanhspkho.setName("btnthemanh"); // NOI18N
        btnthemanhspkho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemanhspkhoActionPerformed(evt);
            }
        });

        btntimkiemkho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntimkiemkho.setText("Tìm Kiếm");
        btntimkiemkho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemkhoActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Số Lượng :");

        txtsoluong.setName("txtsoluong"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnthemanhspkho, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmasp_kho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(txttimkiemkho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntimkiemkho)
                        .addGap(37, 37, 37)
                        .addComponent(btnxoatkkho)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthemkho)
                .addGap(18, 18, 18)
                .addComponent(btnxoakho)
                .addGap(18, 18, 18)
                .addComponent(btnsuakho)
                .addGap(18, 18, 18)
                .addComponent(btnlammoikho)
                .addGap(177, 177, 177))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmasp_kho)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtngaynhap)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsoluong)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdongia)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnthemanhspkho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttimkiemkho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnxoatkkho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btntimkiemkho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemkho, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnxoakho, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnsuakho, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnlammoikho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("QL Kho", jPanel9);

        jPanel13.setBackground(new java.awt.Color(153, 255, 204));

        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton22.setText("Làm Mới");
        jButton22.setName("btnlammoi"); // NOI18N

        dgvthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(dgvthongke);

        cbthongke.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Tháng", "Theo Năm", "Theo Sản Phẩm" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Thống kê theo");
        jLabel7.setPreferredSize(new java.awt.Dimension(96, 30));

        btnthongke.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthongke.setText("Thống kê");
        btnthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongkeActionPerformed(evt);
            }
        });

        lbsoluongmay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbsoluongmay.setText("Số máy bán ra :");
        lbsoluongmay.setPreferredSize(new java.awt.Dimension(96, 30));

        lbdoanhso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbdoanhso.setText("Doanh Số :");
        lbdoanhso.setPreferredSize(new java.awt.Dimension(96, 30));

        lblai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblai.setText("Lãi :");
        lblai.setPreferredSize(new java.awt.Dimension(96, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbdoanhso, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbsoluongmay, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblai, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnthongke)
                                .addGap(66, 66, 66))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdoanhso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsoluongmay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống Kê", jPanel12);

        jPanel15.setBackground(new java.awt.Color(153, 255, 204));

        jTextField22.setName("txttimkiem"); // NOI18N

        jButton31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton31.setText("Tìm Kiếm");
        jButton31.setName("btntimkiem"); // NOI18N

        dgvLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(dgvLuong);

        btncapnhatluong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncapnhatluong.setText("Cập Nhật");
        btncapnhatluong.setName("btncapnhat"); // NOI18N
        btncapnhatluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatluongActionPerformed(evt);
            }
        });

        txtluongmanv.setName("txtngaycong"); // NOI18N
        txtluongmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtluongmanvActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã Nhân Viên :");
        jLabel5.setPreferredSize(new java.awt.Dimension(96, 30));

        txtluongsongaycong.setName("txtngaycong"); // NOI18N
        txtluongsongaycong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtluongsongaycongActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Số Ngày Công :");
        jLabel24.setPreferredSize(new java.awt.Dimension(96, 30));

        lbtongluong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbtongluong.setText("Tổng Số Tiền Chi Cho Lương NV:");
        lbtongluong.setPreferredSize(new java.awt.Dimension(96, 30));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtluongmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btncapnhatluong))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtluongsongaycong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton31)
                        .addGap(227, 227, 227))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbtongluong, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField22)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtluongmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtluongsongaycong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(btncapnhatluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lbtongluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lương NV", jPanel14);

        jPanel17.setBackground(new java.awt.Color(153, 255, 204));

        jPanel18.setBackground(new java.awt.Color(153, 255, 204));

        lbmahd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbmahd.setText("Mã Hoá Đơn");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Ngày Xuất Hoá Đơn:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Số Lượng :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Giá Bán:");

        txtHDmahoadon.setName("txtmasp"); // NOI18N

        txtHDngayxuat.setName("txtngaynhap"); // NOI18N

        txtHDsoluong.setName("txtsoluong"); // NOI18N

        txtHDgiaban.setName("txtdongia"); // NOI18N

        txtHDtimkiem.setName("txttimkiem"); // NOI18N

        btntimkiemkho1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntimkiemkho1.setText("Tìm Kiếm");
        btntimkiemkho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemkho1ActionPerformed(evt);
            }
        });

        dgvhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(dgvhoadon);

        btnHDthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHDthem.setText("Thêm Hoá Đơn");
        btnHDthem.setName("btnthemkho"); // NOI18N
        btnHDthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDthemActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Mã Sản Phẩm");

        txtHDmasp.setName("txtsoluong"); // NOI18N

        btnHDcapnhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHDcapnhat.setText("Cập Nhật ");
        btnHDcapnhat.setName("btnthemkho"); // NOI18N
        btnHDcapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDcapnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHDgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHDsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtHDmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHDcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHDthem, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtHDtimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiemkho1)
                .addGap(289, 289, 289))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHDngayxuat, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(txtHDmahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addContainerGap(681, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHDmasp)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHDsoluong)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHDgiaban)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(btnHDthem, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHDcapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHDtimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntimkiemkho1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHDmahoadon)
                        .addComponent(lbmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHDngayxuat)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 988, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("QL Hóa Đơn", jPanel7);

        jPanel20.setBackground(new java.awt.Color(153, 255, 204));

        dgvtaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tài Khoản", "Mật Khẩu"
            }
        ));
        jScrollPane6.setViewportView(dgvtaikhoan);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mật Khẩu Cũ");

        btncapnhatTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncapnhatTK.setText("Cập Nhật");
        btncapnhatTK.setName("btncapnhat"); // NOI18N
        btncapnhatTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatTKActionPerformed(evt);
            }
        });

        txtmkcu.setName("txtmkcu"); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Mật Khẩu Mới");

        txtmkmoi.setName("txtmkmoi"); // NOI18N

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Nhập Lại Mật Khẩu");

        txtnhaplaimk.setName("txtnhaplaimk"); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmkcu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmkmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnhaplaimk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncapnhatTK))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmkcu)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmkmoi)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnhaplaimk)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btncapnhatTK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("QL Tài Khoản", jPanel16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangxuatActionPerformed
        int a= JOptionPane.showConfirmDialog(this, "Ban muon dang xuat?","chon",JOptionPane.YES_NO_OPTION);
        if(a==0){
            this.dispose();
        }
    }//GEN-LAST:event_btndangxuatActionPerformed

    private void txtluongmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtluongmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtluongmanvActionPerformed

    private void btnthemnvActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try{
            if(txtmanv.getText().equals("")||txttennv.getText().equals("")||txtngaysinh.getText().equals("")||txtgioitinh.getSelectedItem().equals("")||txtsdt.getText().equals("")||txtquequan.getText().equals("")||txtluongcoban.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }
            else{
                StringBuffer sb=new StringBuffer();
                String sql_check ="select*from NhanVien where manv='"+txtmanv.getText()+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(sql_check);
                if(rs.next()){
                    sb.append("Nhan Vien nay da ton tai");
                }if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="insert into NhanVien values('"+txtmanv.getText()+
                        "','"+txttennv.getText()+
                        "','"+txtngaysinh.getText()+
                        "','"+txtgioitinh.getSelectedItem()+
                        "','"+txtsdt.getText()+
                        "','"+txtquequan.getText()+
                        "','"+txtluongcoban.getText()+
                        "','"+imagePath.formatted(toString())+"')";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"them thanh cong");
                        btnlammoinv.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }                                         


    private void btnlammoinvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoinvActionPerformed
        txtmanv.setText(null);
        txttennv.setText(null);
        txtngaysinh.setText(null);
        txtgioitinh.setSelectedIndex(0);
        txtsdt.setText(null);
        txtquequan.setText(null);
        txtluongcoban.setText(null);
        getData_NhanVien();
        txtmanv.setEnabled(true);
        btnthemnv.setEnabled(true);
        txttimkiemnv.setText(null);
        anhnv.setIcon(null);
    }//GEN-LAST:event_btnlammoinvActionPerformed

    

    private void btnxoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoanvActionPerformed
        try{
            if(txtmanv.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="delete NhanVien where manv='"+txtmanv.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"xoa thanh cong");
                        btnlammoinv.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnxoanvActionPerformed
    
    public void TongDoanhThu(){
        DecimalFormat x= new DecimalFormat("###,###,###");
        int tongdt=0;
        for(int i=0;i<dgvthongke.getRowCount();i++){
            tongdt+=Float.parseFloat(dgvthongke.getValueAt(i, 5).toString());
        }
        lbdoanhso.setText("Tổng Doanh Số: "+x.format(tongdt)+" VND");
    }
    
    public void TongSoMay(){
        int tongsomay=0;
        for(int i=0;i<dgvthongke.getRowCount();i++){
            tongsomay+=Integer.parseInt(dgvthongke.getValueAt(i, 3).toString());
        }
        lbsoluongmay.setText("Số máy bán ra: "+tongsomay+" Máy");
    }
    public void TongSoTienLuong(){
        int tongsotienluong=0;
        DecimalFormat x= new DecimalFormat("###,###,###");
        for(int i=0;i<dgvLuong.getRowCount();i++){
            tongsotienluong+=Float.parseFloat(dgvLuong.getValueAt(i, 3).toString());
        }
        lbtongluong.setText("Tổng Số Tiền Chi Cho Lương NV: "+x.format(tongsotienluong)+" VND");
    }
    
    public void TongLoiNhuan(){
        DecimalFormat x= new DecimalFormat("###,###,###");
        int tongln=0;
        for(int i=0;i<dgvthongke.getRowCount();i++){
            tongln+=Float.parseFloat(dgvthongke.getValueAt(i, 6).toString());
        }
        lblai.setText("Lợi Nhuận: "+x.format(tongln)+" VND");
    }
    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        try{
            if(txtmasp.getText().equals("")||txttensp.getText().equals("")||txtngaysx.getText().equals("")||cbbaohanh.getSelectedItem().equals("")||txtnhasx.getText().equals("")||txtgiaban.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }
            else{
                StringBuffer sb=new StringBuffer();
                String sql_check ="select*from SanPham where masp='"+txtmasp.getText()+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(sql_check);
                if(rs.next()){
                    sb.append("SanPham nay da ton tai");
                }if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="insert into SanPham values('"+txtmasp.getText()+
                        "','"+txttensp.getText()+
                        "','"+txtngaysx.getText()+
                        "','"+cbbaohanh.getSelectedItem()+
                        "','"+txtnhasx.getText()+
                        "','"+txtgiaban.getText()+
                        "','"+imagePath.formatted(toString())+"')";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"them thanh cong");
                        btnlammoisp.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnxoaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaspActionPerformed
        try{
            if(txtmasp.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="delete SanPham where masp='"+txtmasp.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"xoa thanh cong");
                        btnlammoisp.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnxoaspActionPerformed

    private void btnsuaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaspActionPerformed
        try{
            if(txtmasp.getText().equals("")||txttensp.getText().equals("")||txtngaysx.getText().equals("")||cbbaohanh.getSelectedItem().equals("")||txtnhasx.getText().equals("")||txtgiaban.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="update SanPham set tensp='"+txttensp.getText()+
                            "', ngaysx='"+txtngaysx.getText()+
                            "', baohanh='"+cbbaohanh.getSelectedItem()+
                            "', nhasx='"+txtnhasx.getText()+
                            "', giaban='"+txtgiaban.getText()+
                            "', hinhanh='"+imagePath.formatted(toString())+
                            "' where masp='"+txtmasp.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"sua thanh cong");
                        btnlammoisp.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnsuaspActionPerformed
    

    private void btnlammoikhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoikhoActionPerformed
        txtmasp_kho.setText(null);
        txtngaynhap.setText(null);
        txtsoluong.setText(null);
        txtdongia.setText(null);
        getData_Kho();
        txtmasp_kho.setEnabled(true);
        btnthemkho.setEnabled(true);
        txttimkiemkho.setText(null);
        anhspkho.setIcon(null);
    }//GEN-LAST:event_btnlammoikhoActionPerformed

    private void btnthemkhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemkhoActionPerformed
        try{
            if(txtmasp_kho.getText().equals("")||txtngaynhap.getText().equals("")||txtsoluong.getText().equals("")||txtdongia.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }
            else{
                StringBuffer sb=new StringBuffer();
                String sql_check ="select*from SanPham where masp='"+txtmasp_kho.getText()+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(sql_check);
                if(rs.next()){
                    sb.append("SanPham nay da ton tai");
                }if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="insert into Kho values('"+txtmasp.getText()+
                        "','"+txtngaynhap.getText()+
                        "','"+txtsoluong.getText()+
                        "','"+txtdongia.getText()+
                        "','"+imagePath.formatted(toString())+"')";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"them thanh cong");
                        btnlammoikho.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnthemkhoActionPerformed

    private void btnxoakhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoakhoActionPerformed
        try{
            if(txtmasp_kho.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="delete Kho where masp='"+txtmasp_kho.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"xoa thanh cong");
                        btnlammoikho.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnxoakhoActionPerformed

    private void btnsuakhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuakhoActionPerformed
        try{
            if(txtmasp_kho.getText().equals("")||txtngaynhap.getText().equals("")||txtsoluong.getText().equals("")||txtdongia.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="update Kho set ngaynhap='"+txtngaynhap.getText()+
                            "', soluong='"+txtsoluong.getText()+
                            "', dongia='"+txtdongia.getText()+
                            "', hinhanh='"+imagePath.formatted(toString())+
                            "' where masp='"+txtmasp_kho.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"sua thanh cong");
                        btnlammoikho.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnsuakhoActionPerformed

    private void btntimkiemnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemnvActionPerformed
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from NhanVien where manv like '%"+txttimkiemnv.getText()+"%'");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvnhanvien.setModel(tbn);
                btnthemnv.setEnabled(false);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btntimkiemnvActionPerformed

    private void btnsuanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanvActionPerformed
        try{
            if(txtmanv.getText().equals("")||txttennv.getText().equals("")||txtngaysinh.getText().equals("")||txtgioitinh.getSelectedItem().equals("")||txtsdt.getText().equals("")||txtquequan.getText().equals("")||txtluongcoban.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="update NhanVien set tennv='"+txttennv.getText()+
                            "', ngaysinh='"+txtngaysinh.getText()+
                            "', gioitinh='"+txtgioitinh.getSelectedItem()+
                            "', sodt='"+txtsdt.getText()+
                            "', quequan='"+txtquequan.getText()+
                            "', luongcoban='"+txtluongcoban.getText()+
                            "', hinhanh='"+imagePath.formatted(toString())+
                            "' where manv='"+txtmanv.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"sua thanh cong");
                        btnlammoinv.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnsuanvActionPerformed

    private void btnxoatknvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatknvActionPerformed
        txttimkiemnv.setText(null);
    }//GEN-LAST:event_btnxoatknvActionPerformed

    private void btntimkiemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemspActionPerformed
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from SanPham where masp like '%"+txttimkiemsp.getText()+"%'");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvsp.setModel(tbn);
                btnthemsp.setEnabled(false);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btntimkiemspActionPerformed

    private void btntimkiemkhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemkhoActionPerformed
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from Kho where masp like '%"+txttimkiemkho.getText()+"%'");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvkho.setModel(tbn);
                btnthemkho.setEnabled(false);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btntimkiemkhoActionPerformed

    private void btnxoatkspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatkspActionPerformed
        txttimkiemsp.setText(null);
    }//GEN-LAST:event_btnxoatkspActionPerformed

    private void btnxoatkkhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatkkhoActionPerformed
        txttimkiemkho.setText(null);
    }//GEN-LAST:event_btnxoatkkhoActionPerformed

    private void btnlammoispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoispActionPerformed
        txtmasp.setText(null);
        txttensp.setText(null);
        txtngaysx.setText(null);
        cbbaohanh.setSelectedIndex(0);
        txtnhasx.setText(null);
        txtgiaban.setText(null);
        getData_SanPham();
        txtmasp.setEnabled(true);
        btnthemsp.setEnabled(true);
        txttimkiemsp.setText(null);
        anhsp.setIcon(null);
    }//GEN-LAST:event_btnlammoispActionPerformed

    private void txtluongsongaycongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtluongsongaycongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtluongsongaycongActionPerformed

    public void getdata_MatKhau(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select taikhoan from NguoiDung");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvtaikhoan.setModel(tbn);
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    public void getData_TaiKhoan(){
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            Statement st = conn.createStatement();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st2 = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from NguoiDung");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 

            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvtaikhoan.setModel(tbn);
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    private void btncapnhatTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatTKActionPerformed
        try{
            if(txtmkcu.getText().equals("")||txtmkmoi.getText().equals("")||txtnhaplaimk.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="select*from NguoiDung where matkhau='"+txtmkcu.getText()+"'";
                    st=conn.createStatement();
                    ResultSet kq=st.executeQuery(sql);
                    if(kq.next()){
                        Statement st1=conn.createStatement();
                        if(txtmkmoi.getText().equals(txtnhaplaimk.getText())){
                            String sql1="update NguoiDung set matkhau='"+txtmkmoi.getText()+"'";
                            st1=conn.createStatement();
                            int kq1=st.executeUpdate(sql1);
                            if(kq1>0){
                                JOptionPane.showMessageDialog(this,"da doi mat khau");
                                txtmkcu.setText(null);
                                txtmkmoi.setText(null);
                                txtnhaplaimk.setText(null);
                                getData_TaiKhoan();
                            }else{
                                JOptionPane.showMessageDialog(this,"that bai");
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"mat khau khong trung khop");
                            txtnhaplaimk.setText(null);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this,"mat khau cu khong dung");
                        txtmkcu.setText(null);
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btncapnhatTKActionPerformed

    private void btnthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongkeActionPerformed
        try {
            if(cbthongke.getSelectedItem()=="Theo Tháng"){
                DefaultTableModel tbn=new DefaultTableModel();
                int number;
                Vector row,column;
                column = new Vector();
                Statement st = conn.createStatement();
                ResultSet rs= st.executeQuery("select  HoaDon1.*,HoaDon1.soluong*HoaDon1.giaban as TongThanhToan,(HoaDon1.soluong*HoaDon1.giaban)-(HoaDon1.soluong*Kho.dongia) as TienLai from HoaDon1,Kho where Kho.masp=HoaDon1.masp and month(ngayxuat)='"+txtthongke.getText()+"'");
                ResultSetMetaData metadata = rs.getMetaData();
                number= metadata.getColumnCount();

                for(int i =1;i<=number;i++){
                    column.add(metadata.getColumnName(i));
                }
                tbn.setColumnIdentifiers(column);
                while(rs.next()){
                    row = new Vector();
                    for(int i=1;i<=number;i++){
                        row.addElement(rs.getString(i));
                    }
                    tbn.addRow(row);
                    dgvthongke.setModel(tbn);
                }
            }
            if(cbthongke.getSelectedItem()=="Theo Năm"){
                DefaultTableModel tbn=new DefaultTableModel();
                int number;
                Vector row,column;
                column = new Vector();
                Statement st = conn.createStatement();
                ResultSet rs= st.executeQuery("select  HoaDon1.*,HoaDon1.soluong*HoaDon1.giaban as TongThanhToan,(HoaDon1.soluong*HoaDon1.giaban)-(HoaDon1.soluong*Kho.dongia) as TienLai from HoaDon1,Kho where Kho.masp=HoaDon1.masp and year(ngayxuat)='"+txtthongke.getText()+"'");
                ResultSetMetaData metadata = rs.getMetaData();
                number= metadata.getColumnCount();

                for(int i =1;i<=number;i++){
                    column.add(metadata.getColumnName(i));
                }
                tbn.setColumnIdentifiers(column);
                while(rs.next()){
                    row = new Vector();
                    for(int i=1;i<=number;i++){
                        row.addElement(rs.getString(i));
                    }
                    tbn.addRow(row);
                    dgvthongke.setModel(tbn);
                }
            }
            if(cbthongke.getSelectedItem()=="Theo Sản Phẩm"){
                DefaultTableModel tbn=new DefaultTableModel();
                int number;
                Vector row,column;
                column = new Vector();
                Statement st = conn.createStatement();
                ResultSet rs= st.executeQuery("select  HoaDon1.*,HoaDon1.soluong*HoaDon1.giaban as TongThanhToan,(HoaDon1.soluong*HoaDon1.giaban)-(HoaDon1.soluong*Kho.dongia) as TienLai from HoaDon1,Kho where Kho.masp=HoaDon1.masp and HoaDon1.masp='"+txtthongke.getText()+"'");
                ResultSetMetaData metadata = rs.getMetaData();
                number= metadata.getColumnCount();

                for(int i =1;i<=number;i++){
                    column.add(metadata.getColumnName(i));
                }
                tbn.setColumnIdentifiers(column);
                while(rs.next()){
                    row = new Vector();
                    for(int i=1;i<=number;i++){
                        row.addElement(rs.getString(i));
                    }
                    tbn.addRow(row);
                    dgvthongke.setModel(tbn);
                }
            }
            TongDoanhThu();
            TongSoMay();
            TongLoiNhuan();
        }
        catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnthongkeActionPerformed

    private void btncapnhatluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatluongActionPerformed
       try{
            if(txtluongmanv.getText().equals("")||txtluongsongaycong.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }
            else{
                StringBuffer sb=new StringBuffer();
                Statement st=conn.createStatement();
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="update Luong set songaycong='"+txtluongsongaycong.getText()+"' where manv='"+txtluongmanv.getText()+"'";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"so ngay cong da duoc cap nhat");
                        getData_Luong();
                    }else{
                        JOptionPane.showMessageDialog(this,"cap nhat that bai");
                    }
                }
            }
            TongSoTienLuong();
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
       
    }//GEN-LAST:event_btncapnhatluongActionPerformed

    private void btntimkiemkho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemkho1ActionPerformed
        try{
            DefaultTableModel tbn=new DefaultTableModel();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select * from HoaDon1 where mahd like '%"+txtHDtimkiem.getText()+"%'");
            ResultSetMetaData metadata = rs.getMetaData();
            number= metadata.getColumnCount(); 
            
            for(int i =1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                dgvhoadon.setModel(tbn);
                btnHDthem.setEnabled(false);
                txtHDmahoadon.setEnabled(false);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btntimkiemkho1ActionPerformed

    private void btnHDthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDthemActionPerformed
         try{
            if(txtHDmahoadon.getText().equals("")||txtHDngayxuat.getText().equals("")||txtHDmasp.getText().equals("")||txtHDsoluong.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ban can nhap du cac truong !!");
            }
            else{
                StringBuffer sb=new StringBuffer();
                String sql_check ="select*from HoaDon1 where mahd='"+txtHDmahoadon.getText()+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(sql_check);
                if(rs.next()){
                    sb.append("Hoá đơn này đã có !!");
                }if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString());
                }else{
                    String sql="insert into HoaDon1 values('"+txtHDmahoadon.getText()+"','"+txtHDngayxuat.getText()+"','"+txtHDmasp.getText()+"','"+txtHDsoluong.getText()+"','"+txtHDgiaban.getText()+"')";
                    st=conn.createStatement();
                    int kq=st.executeUpdate(sql);
                    if(kq>0){
                        JOptionPane.showMessageDialog(this,"them hoa don thanh cong");
                        btnHDcapnhat.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this,"that bai");
                    }
                }
            }
        }catch(Exception  ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnHDthemActionPerformed
    private void CapNhatSoLuong(){
        try{
        Statement st1=conn.createStatement();
        String sql1= "update Kho set Kho.soluong = Kho.soluong- HoaDon1.soluong from Kho,HoaDon1  where HoaDon1.masp=Kho.masp and HoaDon1.mahd='"+txtHDmahoadon+"' ";
        st1=conn.createStatement();
        int kq1=st1.executeUpdate(sql1);
        if(kq1>0){
            JOptionPane.showMessageDialog(this,"s");
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    private void btnHDcapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDcapnhatActionPerformed
        getData_HoaDon();
        txtHDmasp.setText(null);
        txtHDmahoadon.setText(null);
        txtHDgiaban.setText(null);
        txtHDngayxuat.setText(null);
        txtHDsoluong.setText(null);
        txtHDmahoadon.setEnabled(true);
        StringBuffer sb=new StringBuffer();
//        
    }//GEN-LAST:event_btnHDcapnhatActionPerformed

    private void btnthemanhnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemanhnvActionPerformed
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("*.image","jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int output=fileChooser.showSaveDialog(fileChooser);
        if(output==JFileChooser.APPROVE_OPTION){
            File selectFile= fileChooser.getSelectedFile();
            String path=selectFile.getAbsolutePath();
            anhnv.setIcon(ImageAdjust(path,null));
            imagePath=path;
        }
        
    }//GEN-LAST:event_btnthemanhnvActionPerformed

    private void btnthemanhspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemanhspActionPerformed
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("*.image","jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int output=fileChooser.showSaveDialog(fileChooser);
        if(output==JFileChooser.APPROVE_OPTION){
            File selectFile= fileChooser.getSelectedFile();
            String path=selectFile.getAbsolutePath();
            anhsp.setIcon(ImageAdjust(path,null));
            imagePath=path;
        }
    }//GEN-LAST:event_btnthemanhspActionPerformed

    private void btnthemanhspkhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemanhspkhoActionPerformed
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("*.image","jpg","png");
        fileChooser.addChoosableFileFilter(filter);
        int output=fileChooser.showSaveDialog(fileChooser);
        if(output==JFileChooser.APPROVE_OPTION){
            File selectFile= fileChooser.getSelectedFile();
            String path=selectFile.getAbsolutePath();
            anhspkho.setIcon(ImageAdjust(path,null));
            imagePath=path;
        }
    }//GEN-LAST:event_btnthemanhspkhoActionPerformed
    
    private ImageIcon ImageAdjust(String path,byte [] pic){
         ImageIcon myImage=null;
         if(path !=null){
             myImage=new ImageIcon(path);
         }else{
             myImage= new ImageIcon(pic);
         }
         Image img=myImage.getImage();
         Image newImage=img.getScaledInstance(anhnv.getWidth(), anhnv.getHeight(), Image.SCALE_SMOOTH);
         ImageIcon icon=new ImageIcon(newImage);
         return  icon;
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhnv;
    private javax.swing.JLabel anhsp;
    private javax.swing.JLabel anhspkho;
    private javax.swing.JButton btnHDcapnhat;
    private javax.swing.JButton btnHDthem;
    private javax.swing.JButton btncapnhatTK;
    private javax.swing.JButton btncapnhatluong;
    private javax.swing.JButton btndangxuat;
    private javax.swing.JButton btnlammoikho;
    private javax.swing.JButton btnlammoinv;
    private javax.swing.JButton btnlammoisp;
    private javax.swing.JButton btnsuakho;
    private javax.swing.JButton btnsuanv;
    private javax.swing.JButton btnsuasp;
    private javax.swing.JButton btnthemanhnv;
    private javax.swing.JButton btnthemanhsp;
    private javax.swing.JButton btnthemanhspkho;
    private javax.swing.JButton btnthemkho;
    private javax.swing.JButton btnthemnv;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnthongke;
    private javax.swing.JButton btntimkiemkho;
    private javax.swing.JButton btntimkiemkho1;
    private javax.swing.JButton btntimkiemnv;
    private javax.swing.JButton btntimkiemsp;
    private javax.swing.JButton btnxoakho;
    private javax.swing.JButton btnxoanv;
    private javax.swing.JButton btnxoasp;
    private javax.swing.JButton btnxoatkkho;
    private javax.swing.JButton btnxoatknv;
    private javax.swing.JButton btnxoatksp;
    private javax.swing.JComboBox<String> cbbaohanh;
    private javax.swing.JComboBox<String> cbthongke;
    private javax.swing.JTable dgvLuong;
    private javax.swing.JTable dgvhoadon;
    private javax.swing.JTable dgvkho;
    private javax.swing.JTable dgvnhanvien;
    private javax.swing.JTable dgvsp;
    private javax.swing.JTable dgvtaikhoan;
    private javax.swing.JTable dgvthongke;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton31;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JLabel lbdoanhso;
    private javax.swing.JLabel lblai;
    private javax.swing.JLabel lbmahd;
    private javax.swing.JLabel lbsoluongmay;
    private javax.swing.JLabel lbtongluong;
    private javax.swing.JTextField txtHDgiaban;
    private javax.swing.JTextField txtHDmahoadon;
    private javax.swing.JTextField txtHDmasp;
    private javax.swing.JTextField txtHDngayxuat;
    private javax.swing.JTextField txtHDsoluong;
    private javax.swing.JTextField txtHDtimkiem;
    private javax.swing.JTextField txtdongia;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JComboBox<String> txtgioitinh;
    private javax.swing.JTextField txtluongcoban;
    private javax.swing.JTextField txtluongmanv;
    private javax.swing.JTextField txtluongsongaycong;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtmasp_kho;
    private javax.swing.JTextField txtmkcu;
    private javax.swing.JTextField txtmkmoi;
    private javax.swing.JTextField txtngaynhap;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtngaysx;
    private javax.swing.JTextField txtnhaplaimk;
    private javax.swing.JTextField txtnhasx;
    private javax.swing.JTextField txtquequan;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txtthongke;
    private javax.swing.JTextField txttimkiemkho;
    private javax.swing.JTextField txttimkiemnv;
    private javax.swing.JTextField txttimkiemsp;
    // End of variables declaration//GEN-END:variables
}
