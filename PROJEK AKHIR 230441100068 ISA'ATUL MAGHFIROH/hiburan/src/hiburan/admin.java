/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hiburan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class admin extends javax.swing.JFrame {
     Connection conn;
     private DefaultTableModel model;

    /**
     * Creates new form Hiburann
     */
    public admin() {
    initComponents();
    conn = koneksi.getConnection();
        
    model = new DefaultTableModel();
    tblmusik.setModel(model);
    

    model.addColumn("ID");
    model.addColumn("Genre");
    model.addColumn("Judul");

    loadData();
    loadData2();
    txtid.setVisible(false);
    id.setVisible(false);
    btnupdatelagu.setVisible(false);
    btntambahlagu.setVisible(false);
    btndeletelagu.setVisible(false);
    }

private void loadData() {
    // Menghapus baris yang sudah ada di model
    model.setRowCount(0);

    try {
        // Query SQL untuk menggabungkan tabel musik dan genre serta mendapatkan nama genre, bukan id
        String sql = "SELECT m.id_musik, g.nama_genre, m.judul " +
                     "FROM musik m " +
                     "JOIN genre g ON m.id_genre = g.id_genre";
        PreparedStatement ps = conn.prepareStatement(sql);  // Menyiapkan query
        ResultSet rs = ps.executeQuery();  // Mengeksekusi query

        // Loop melalui hasil query dan menambahkan baris ke model tabel
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_musik"),
                rs.getString("nama_genre"),  // Menampilkan nama genre, bukan id
                rs.getString("judul")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}

    //end Load Data
   
    
    private void loadData2() {
 
    String hiburan = "SELECT nama_genre FROM genre"; 
    cbxgenre.removeAllItems();
    cbxgenremusik.removeAllItems();
   
    
    try (PreparedStatement psHiburan = conn.prepareStatement(hiburan);
         ResultSet rsHiburan = psHiburan.executeQuery()) {

        while (rsHiburan.next()) {
            String namaGenre = rsHiburan.getString("nama_genre");
            cbxgenre.addItem(namaGenre);
            cbxgenremusik.addItem(namaGenre);
            
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmusik = new javax.swing.JTable();
        btncari = new javax.swing.JButton();
        cbxgenremusik = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtjudul = new javax.swing.JTextField();
        btntambahlagu = new javax.swing.JButton();
        btndeletelagu = new javax.swing.JButton();
        btnupdatelagu = new javax.swing.JButton();
        cbxgenre = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JRadioButton();
        btn_delete = new javax.swing.JRadioButton();
        btnlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel3.setText("ENTERTAIMENT NEWS$$$");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 0, 300, 80);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 80));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jTabbedPane2.setBackground(new java.awt.Color(204, 51, 0));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setText("PILIHLAH  JENIS MUSIC GENRE YANG INGIN ANDA LIHAT !");

        tblmusik.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblmusik);

        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        cbxgenremusik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(cbxgenremusik, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btncari)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncari)
                    .addComponent(cbxgenremusik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("MUSIC", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));

        id.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        id.setText("Id");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("Genre");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("Judul Lagu");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        btntambahlagu.setText("TAMBAH");
        btntambahlagu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahlaguActionPerformed(evt);
            }
        });

        btndeletelagu.setText("DELETE");
        btndeletelagu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletelaguActionPerformed(evt);
            }
        });

        btnupdatelagu.setText("UPDATE");
        btnupdatelagu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatelaguActionPerformed(evt);
            }
        });

        cbxgenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(btn_tambah);
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_delete);
        btn_delete.setText("Update/Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 39, Short.MAX_VALUE)
                        .addComponent(btntambahlagu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnupdatelagu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndeletelagu)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtjudul, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbxgenre, javax.swing.GroupLayout.Alignment.TRAILING, 0, 226, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_tambah)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxgenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_tambah))
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambahlagu)
                    .addComponent(btndeletelagu)
                    .addComponent(btnupdatelagu))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("FORM", jPanel5);

        btnlogout.setText("LOGOUT");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnlogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlogout)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 460, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btntambahlaguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahlaguActionPerformed
try {
        // Check if any required fields are empty
        if (cbxgenre.getSelectedItem() == null || txtjudul.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Stop the process if any field is empty
        }

        // Retrieve the genre id from the genre table based on the selected genre name
        String sqll = "SELECT id_genre FROM genre WHERE nama_genre = ?";
        PreparedStatement pss = conn.prepareStatement(sqll);
        pss.setString(1, cbxgenre.getSelectedItem().toString());  // Set selected genre name
        ResultSet rs = pss.executeQuery();

        int genreId = -1;
        if (rs.next()) {
            genreId = rs.getInt("id_genre");  // Get the genre id
        } else {
            JOptionPane.showMessageDialog(null, "Genre tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Stop if genre is not found
        }

        // Insert the new song into the musik table using the retrieved genre id
        String sql = "INSERT INTO musik (id_genre, judul) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, genreId);  // Use the retrieved genre id
        ps.setString(2, txtjudul.getText().trim());  // Set the song title
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");

        // Clear input fields after successful save
        txtid.setText("");
        cbxgenre.setSelectedIndex(-1); // Reset combo box
        txtjudul.setText("");

        // Refresh the table data (assuming loadData is a method for refreshing table data)
        loadData();

    } catch (SQLException e) {
        System.out.println("Error saving data: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data.");
    }
    }//GEN-LAST:event_btntambahlaguActionPerformed

    private void btnupdatelaguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatelaguActionPerformed

    try {
        // Cek apakah semua kolom sudah diisi
        if (cbxgenre.getSelectedItem() == null || txtjudul.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Menghentikan proses jika ada kolom yang kosong
        }

        // Mengambil id genre dari genre yang dipilih
        String sqll = "SELECT id_genre FROM genre WHERE nama_genre = ?";
        PreparedStatement pss = conn.prepareStatement(sqll);
        pss.setString(1, cbxgenre.getSelectedItem().toString());  // Set nama genre yang dipilih
        ResultSet rs = pss.executeQuery();

        int genreId = -1;
        if (rs.next()) {
            genreId = rs.getInt("id_genre");  // Mengambil id genre
        } else {
            JOptionPane.showMessageDialog(null, "Genre tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Jika genre tidak ditemukan, hentikan proses
        }

        // SQL query untuk memperbarui data lagu berdasarkan id_musik
        String sql = "UPDATE musik SET id_genre = ?, judul = ? WHERE id_musik = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, genreId);  // Gunakan id genre yang diambil
        ps.setString(2, txtjudul.getText().trim());  // Set judul lagu
        ps.setInt(3, Integer.parseInt(txtid.getText()));  // Set id lagu yang ingin diupdate

        // Eksekusi query untuk memperbarui data
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");

        // Mengosongkan kolom input setelah berhasil memperbarui data
        txtid.setText("");
        cbxgenre.setSelectedIndex(-1); // Reset ComboBox
        txtjudul.setText("");

        // Memuat ulang data agar perubahan terlihat
        loadData();

    } catch (SQLException e) {
        System.out.println("Error updating data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui data.");
    }


    }//GEN-LAST:event_btnupdatelaguActionPerformed

    private void btndeletelaguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletelaguActionPerformed
        // TODO add your handling code here:
    try {
        // Cek apakah ID lagu sudah diisi
        if (txtid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Lagu harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Hentikan proses jika ID kosong
        }

        // Konfirmasi sebelum menghapus
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Apakah Anda yakin ingin menghapus lagu ini?", 
                "Konfirmasi Hapus", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // SQL query untuk menghapus data lagu berdasarkan id_musik
            String sql = "DELETE FROM musik WHERE id_musik = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtid.getText()));  // Set id lagu yang ingin dihapus

            // Eksekusi query untuk menghapus data
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            } else {
                JOptionPane.showMessageDialog(this, "Lagu tidak ditemukan.");
            }

            // Mengosongkan kolom input setelah penghapusan
            txtid.setText("");
            cbxgenre.setSelectedIndex(-1); // Reset ComboBox
            txtjudul.setText("");

            // Memuat ulang data untuk memperbarui tabel
            loadData();
        }

    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.");
    }
    }//GEN-LAST:event_btndeletelaguActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
    // Menampilkan dialog konfirmasi logout
        int option = JOptionPane.showConfirmDialog(this, 
           "Apakah Anda yakin ingin logout?", 
           "Konfirmasi Logout", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

           if (option == JOptionPane.YES_OPTION) {
           // Jika pengguna memilih YES, logout dan kembali ke login
            new login().setVisible(true);
            dispose();  // Tutup main frame
                }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan genre yang dipilih dari ComboBox
            String selectedGenre = cbxgenremusik.getSelectedItem().toString();

            // SQL query untuk memfilter berdasarkan genre yang dipilih
            String sql = "SELECT m.id_musik, g.nama_genre, m.judul FROM musik m "
                       + "JOIN genre g ON m.id_genre = g.id_genre "
                       + "WHERE g.nama_genre = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, selectedGenre); // Set genre yang dipilih untuk filter

            // Eksekusi query
            ResultSet rs = ps.executeQuery();

            // Bersihkan baris yang ada di model tabel
            DefaultTableModel model = (DefaultTableModel) tblmusik.getModel();
            model.setRowCount(0);  // Menghapus data yang lama di tabel

            // Loop melalui hasil query dan tambahkan baris ke model tabel
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_musik"),    // ID musik dari tabel musik
                    rs.getString("nama_genre"), // Nama genre dari tabel genre
                    rs.getString("judul")      // Judul lagu dari tabel musik
                });
            }

        } catch (SQLException e) {
            System.out.println("Error searching data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari data.");
        }

    }//GEN-LAST:event_btncariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        if(btn_tambah.isSelected()){
            txtid.setVisible(false);
            id.setVisible(false);
            btnupdatelagu.setVisible(false);
            btntambahlagu.setVisible(true);
            btndeletelagu.setVisible(false);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(btn_delete.isSelected()){
            txtid.setVisible(true);
            id.setVisible(true);
            btnupdatelagu.setVisible(true);
            btntambahlagu.setVisible(false);
            btndeletelagu.setVisible(true);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_delete;
    private javax.swing.JRadioButton btn_tambah;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndeletelagu;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btntambahlagu;
    private javax.swing.JButton btnupdatelagu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxgenre;
    private javax.swing.JComboBox<String> cbxgenremusik;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblmusik;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjudul;
    // End of variables declaration//GEN-END:variables
}
