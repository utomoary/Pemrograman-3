/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Akademik;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhamad Ary Utomo.P
 */
public class MataKuliah extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form MataKuliah
     */
    public MataKuliah() {
        initComponents();
        tabell();
        tampil();
        col();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        BtnClose = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        txtMk = new javax.swing.JTextField();
        txtSks = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mata Kuliah");
        setMinimumSize(new java.awt.Dimension(488, 431));
        getContentPane().setLayout(null);

        jLabel1.setText("Kode MataKuliah :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 110, 14);

        jLabel2.setText("Nama MataKuliah :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(16, 105, 110, 14);

        jLabel3.setText("Jumlah SKS :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(45, 136, 80, 14);

        btnSimpan.setText("Simpan");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(361, 65, 80, 23);

        btnUpdate.setText("Update");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(361, 94, 80, 23);

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(361, 120, 80, 23);

        BtnClose.setText("Logout");
        BtnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(BtnClose);
        BtnClose.setBounds(361, 149, 80, 23);
        getContentPane().add(txtKode);
        txtKode.setBounds(136, 66, 80, 25);
        getContentPane().add(txtMk);
        txtMk.setBounds(136, 102, 166, 25);

        txtSks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSksKeyTyped(evt);
            }
        });
        getContentPane().add(txtSks);
        txtSks.setBounds(135, 133, 70, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Mata Kuliah");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 11, 108, 22);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 452, 180);

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(273, 150, 80, 23);

        setSize(new java.awt.Dimension(488, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clear(){
            txtKode.setText("");
            txtMk.setText("");
            txtSks.setText("");
            txtKode.requestFocus();
    }
    
    private void tabell(){
        model = new DefaultTableModel();
        jTable2.setModel(model);
        model.addColumn("Kode");
        model.addColumn("Matakuliah");
        model.addColumn("Sks");
    }
    
    private void tampil(){
            String sql = "SELECT * FROM matakuliah";
        try{
            Connection con = new koneksi().getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o;
                o = new Object[3];
                o[0] = rs.getString("kode");
                o[1] = rs.getString("matkul");
                o[2] = rs.getString("sks");
                model.addRow(o);
            }
            con.close();
                st.close();
        }
        catch(SQLException e){
            System.out.println("Ada Error");
        }
    }
    
    private void col(){
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(330);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(20);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSksKeyTyped
        if(txtSks.getText().length()>0){
            JOptionPane.showMessageDialog(this,"Sks Hanya Boleh 1 Digit","SKS",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtSksKeyTyped

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        txtKode.setText(jTable2.getValueAt(row, 0).toString());
        txtMk.setText(jTable2.getValueAt(row, 1).toString());
        txtSks.setText(jTable2.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseClicked
        this.dispose();
        Menu menu = new Menu();
        menu.show();
    }//GEN-LAST:event_BtnCloseMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        int pilih = JOptionPane.showConfirmDialog(this,"Anda Yakin Untuk Menghapus Data?","Hapus Data",JOptionPane.OK_CANCEL_OPTION);
        if(pilih==JOptionPane.OK_OPTION){
            String sql = "DELETE FROM matakuliah WHERE matkul='"+txtMk.getText()+"'";
        try{
            Connection con = new koneksi().getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus","Hapus Data",JOptionPane.INFORMATION_MESSAGE);
            clear();
            tabell();
            tampil();
            col();
            con.close();
            st.close();
        }
        catch(Exception e){
            
        }
        }
        else{
            clear();
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        String sql = "UPDATE matakuliah SET matkul='"+txtMk.getText()+"',sks='"+txtSks.getText()+
                "' WHERE kode='"+txtKode.getText()+"'";
        try{
            Connection con = new koneksi().getCon();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update","Update",JOptionPane.INFORMATION_MESSAGE);
            clear();
            st.close();
            con.close();
            tabell();
            tampil();
            col();
        }
        catch(Exception e){
           System.out.println("Ada Error");
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        String kode = "SELECT * FROM matakuliah WHERE kode='"+txtKode.getText()+"'";
        String sql = "INSERT INTO matakuliah VALUES('"+txtKode.getText()+"','"+txtMk.getText()+"','"+txtSks.getText()+"')";
        try{
        Connection con = new koneksi().getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(kode);
        if(rs.next()){
         JOptionPane.showMessageDialog(this,"Kode Sudah Ada","Peringatan",JOptionPane.WARNING_MESSAGE);
         txtKode.setText("");
         txtMk.setText("");
         txtSks.setText("");
         txtKode.requestFocus();
        }
        else{
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data Berhasil Di Tambahkan","Data Masuk",JOptionPane.INFORMATION_MESSAGE);
        clear();
        tabell();
        tampil();
        col();
        st.close();
        con.close();
        txtKode.setText("");
        txtMk.setText("");
        txtSks.setText("");
        txtKode.requestFocus();
        }
        }
        catch(Exception e){
         System.out.println("Ada Error");
        }
    }//GEN-LAST:event_btnSimpanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MataKuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMk;
    private javax.swing.JTextField txtSks;
    // End of variables declaration//GEN-END:variables
}