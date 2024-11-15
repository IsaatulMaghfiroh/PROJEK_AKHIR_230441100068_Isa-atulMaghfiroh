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
public class Hiburann extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    int iid;
    
    /**
     * Creates new form Hiburann
     */
    public Hiburann(int id) {
        initComponents();
    conn = koneksi.getConnection();
        
    model = new DefaultTableModel();
    tblmusik.setModel(model);
    this.iid = id;
    

    model.addColumn("ID");
    model.addColumn("Genre");
    model.addColumn("Judul");
    
    model1 = new DefaultTableModel();
    tblfavorit.setModel(model1);
    this.iid = id;
    
    
    model1.addColumn("ID_Favorit");
    model1.addColumn("ID_User");
    model1.addColumn("ID_Musik");
    model1.addColumn("Genre");
    model1.addColumn("Judul");

    loadData();
    loadData1();
    loadData2();
    loadData3();
    loadData4();
 
    }

    private void loadData() {
        model.setRowCount(0); // Menghapus data lama di model tabel musik

        try {
            // Query untuk mengambil data dari tabel musik dengan genre
            String sql = "SELECT m.id_musik, g.nama_genre, m.judul "
                       + "FROM musik m "
                       + "JOIN genre g ON m.id_genre = g.id_genre";  // Bergabung dengan tabel genre
            PreparedStatement ps = conn.prepareStatement(sql); // Menyiapkan query
            ResultSet rs = ps.executeQuery(); // Menyimpan hasil query

            // Loop untuk menambahkan hasil query ke model tabel musik
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_musik"),  // ID musik
                    rs.getString("nama_genre"),  // Nama genre
                    rs.getString("judul")   // Judul musik
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    //end Load Data
    
// Memuat ID musik ke ComboBox cbxid
    private void loadData1() {
        String hiburan = "SELECT id_musik FROM musik"; 
        cbxid.removeAllItems(); // Menghapus item lama dari combobox

        try (PreparedStatement psHiburan = conn.prepareStatement(hiburan);
             ResultSet rsHiburan = psHiburan.executeQuery()) {

            while (rsHiburan.next()) {
                String idmusik = rsHiburan.getString("id_musik");
                cbxid.addItem(idmusik); // Menambahkan item ID musik ke combobox
            }
        } catch (SQLException e) {
            System.out.println("Error loading ID musik: " + e.getMessage());
        }
    }

    // Memuat nama genre ke ComboBox cbxgenre
    private void loadData2() {
        String hiburan = "SELECT nama_genre FROM genre"; 
        cbxgenre.removeAllItems(); // Menghapus item lama dari combobox

        try (PreparedStatement psHiburan = conn.prepareStatement(hiburan);
             ResultSet rsHiburan = psHiburan.executeQuery()) {

            while (rsHiburan.next()) {
                String namaGenre = rsHiburan.getString("nama_genre");
                cbxgenre.addItem(namaGenre); // Menambahkan item genre ke combobox
            }
        } catch (SQLException e) {
            System.out.println("Error loading genre: " + e.getMessage());
        }
    }

    
    
    // load data buat tabel favorit
    private void loadData4() {
        model1.setRowCount(0); // Menghapus data lama di model tabel favorit

        try {
            // Query untuk mengambil data dari tabel favorit, termasuk genre dan judul dari tabel musik
            String sql = "SELECT f.id_favorit, f.id_user, f.id_musik, g.nama_genre, m.judul "
                       + "FROM favorit f "
                       + "JOIN musik m ON f.id_musik = m.id_musik "
                       + "JOIN genre g ON m.id_genre = g.id_genre";  // Bergabung dengan tabel genre
            PreparedStatement ps = conn.prepareStatement(sql); // Menyiapkan query
            ResultSet rs = ps.executeQuery(); // Menyimpan hasil query

            // Loop untuk menambahkan hasil query ke model tabel favorit
            while (rs.next()) {
                model1.addRow(new Object[]{
                    rs.getInt("id_favorit"), // ID favorit
                    rs.getInt("id_user"),     // ID user
                    rs.getInt("id_musik"),    // ID musik
                    rs.getString("nama_genre"), // Genre musik (diambil dari tabel genre)
                    rs.getString("judul")     // Judul musik (diambil dari tabel musik)
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading favorit data: " + e.getMessage());
        }
    }

private void loadData3() {
    cbxfavorit.removeAllItems(); // Menghapus semua item sebelumnya di combo box

    try {
        // Query untuk mengambil id_musik dan judul dari tabel favorit
        String sql = "SELECT f.id_musik, m.judul "
                   + "FROM favorit f "
                   + "JOIN musik m ON f.id_musik = m.id_musik";
        PreparedStatement ps = conn.prepareStatement(sql); // Menyiapkan query
        ResultSet rs = ps.executeQuery(); // Menyimpan hasil query

        // Loop untuk menambahkan id_musik dan judul lagu ke dalam combo box
        while (rs.next()) {
            int idMusik = rs.getInt("id_musik"); // Ambil id_musik
            String judulLagu = rs.getString("judul"); // Ambil judul lagu

            // Gabungkan id_musik dan judul menjadi format yang ditampilkan
            cbxfavorit.addItem(idMusik + " - " + judulLagu); // Menambahkan ke combo box
        }
    } catch (SQLException e) {
        System.out.println("Error loading data to combo box: " + e.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblfavorit = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxfavorit = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxgenre = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmusik = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxid = new javax.swing.JComboBox<>();
        btncari = new javax.swing.JButton();
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

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));

        jLabel8.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jLabel8.setText("MUSIC FAVORIT ANDA");

        tblfavorit.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblfavorit);

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Judul Lagu");

        cbxfavorit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btndelete)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxfavorit, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxfavorit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndelete)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("FAVORIT", jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setText("PILIHLAH  JENIS MUSIC GENRE YANG INGIN ANDA LIHAT !");

        cbxgenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        btntambah.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setText("id");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("TAMBAHKAN FAVORITE");

        cbxid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntambah)
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(cbxgenre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxid, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxgenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(btntambah)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("MUSIC", jPanel3);

        btnlogout.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnlogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogout)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 460, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
            try {
        int selectedRow = tblmusik.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih musik dari tabel terlebih dahulu.");
            return;
        }

        // Get selected music ID, genre, and title from the selected row in the table
        String selectedId = tblmusik.getValueAt(selectedRow, 0).toString();  // Get the id_musik from the first column
        String genre = tblmusik.getValueAt(selectedRow, 1).toString();        // Genre from the second column
        String judul = tblmusik.getValueAt(selectedRow, 2).toString();        // Title from the third column

        // Verify that the user ID exists in the user table
        String checkUserSQL = "SELECT id_user FROM user WHERE id_user = ?";
        try (PreparedStatement psCheckUser = conn.prepareStatement(checkUserSQL)) {
            psCheckUser.setInt(1, iid); // 'iid' is the user ID being used

            try (ResultSet rsUser = psCheckUser.executeQuery()) {
                if (!rsUser.next()) {
                    JOptionPane.showMessageDialog(this, "User tidak ditemukan!");
                    return;
                }
            }
        }

        // Check if the music is already in the user's favorites
        String checkFavoriteSQL = "SELECT id_favorit FROM favorit WHERE id_musik = ? AND id_user = ?";
        try (PreparedStatement psCheckFavorite = conn.prepareStatement(checkFavoriteSQL)) {
            psCheckFavorite.setString(1, selectedId);
            psCheckFavorite.setInt(2, iid);

            try (ResultSet rsFavorite = psCheckFavorite.executeQuery()) {
                if (rsFavorite.next()) {
                    JOptionPane.showMessageDialog(this, "Musik ini sudah ada dalam daftar favorit.");
                    return;  // Stop if the music is already in the favorites
                }
            }
        }

        // Insert the selected music into the favorite table for the user
        String sqlInsert = "INSERT INTO favorit (id_musik, id_user, genre, judul) VALUES (?, ?, ?, ?)";
        try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
            psInsert.setString(1, selectedId);
            psInsert.setInt(2, iid);
            psInsert.setString(3, genre);
            psInsert.setString(4, judul);

            // Execute the insert query
            psInsert.executeUpdate();
        }

        // Reload the favorite table after insertion
        loadFavoritTable();
        loadData4();
        loadData3();
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan ke favorit.");
    } catch (SQLException e) {
        System.out.println("Error menambahkan ke favorit: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan ke favorit.");
    }
     }

     // Method to load the favorit table data into the JTable
     private void loadFavoritTable() {
         try {
             // SQL query untuk mengambil data dari tabel favorit
             String sqlSelect = "SELECT f.id_favorit, f.id_musik, f.id_user, m.genre, m.judul "
                              + "FROM favorit f "
                              + "JOIN musik m ON f.id_musik = m.id_musik";
             PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
             ResultSet rs = psSelect.executeQuery();

             // Bersihkan baris yang ada di model tabel favorit
             DefaultTableModel model = (DefaultTableModel) tblfavorit.getModel();
             model.setRowCount(0);

             // Loop melalui hasil query dan tambahkan baris ke model tabel favorit
             while (rs.next()) {
                 model.addRow(new Object[]{
                     rs.getInt("id_favorit"),    // ID favorit dari tabel favorit
                     rs.getInt("id_user"),       // ID user dari tabel favorit
                     rs.getInt("id_musik"),      // ID musik dari tabel favorit
                     rs.getString("genre"),      // Genre dari tabel musik
                     rs.getString("judul")       // Judul dari tabel musik
                 });
             }
         } catch (SQLException e) {
             System.out.println("Error loading favorites table: " + e.getMessage());
         }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
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
        try {
        // Mendapatkan nilai genre yang dipilih dari combo box
        String selectedGenre = cbxgenre.getSelectedItem().toString();

        // Query SQL untuk mencari data berdasarkan genre yang dipilih
        // Menambahkan JOIN dengan tabel genre untuk mendapatkan nama genre, bukan hanya ID
        String sql = "SELECT m.id_musik, g.nama_genre, m.judul "
                   + "FROM musik m "
                   + "JOIN genre g ON m.id_genre = g.id_genre "  // Bergabung dengan tabel genre
                   + "WHERE g.nama_genre = ?";  // Memfilter berdasarkan nama genre yang dipilih
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, selectedGenre);  // Menggunakan genre yang dipilih

        // Menjalankan query
        ResultSet rs = ps.executeQuery();

        // Menghapus baris yang ada di model tabel
        DefaultTableModel model = (DefaultTableModel) tblmusik.getModel();
        model.setRowCount(0);

        // Menghapus item yang ada di combo box ID
        cbxid.removeAllItems();

        // Memasukkan data hasil pencarian ke dalam tabel dan combo box
        while (rs.next()) {
            // Menambahkan data ke dalam tabel musik
            model.addRow(new Object[]{
                rs.getInt("id_musik"),     // ID musik
                rs.getString("nama_genre"), // Nama genre dari tabel genre
                rs.getString("judul")      // Judul lagu
            });

            // Menambahkan id_musik ke combo box ID
            cbxid.addItem(rs.getString("id_musik"));
        }

    } catch (SQLException e) {
        System.out.println("Error searching data: " + e.getMessage());
    }

    }//GEN-LAST:event_btncariActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    try {
        // Dapatkan id_musik dari item yang dipilih di combo box
        String selectedItem = cbxfavorit.getSelectedItem().toString();
        
        // Pastikan item dipilih dan id_musik tersedia
        if (selectedItem == null || selectedItem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data favorit yang akan dihapus.");
            return;
        }

        // Ambil id_musik dari combo box yang dipilih
        String[] parts = selectedItem.split(" - "); // Memisahkan id_musik dan judul
        int idMusik = Integer.parseInt(parts[0].trim()); // id_musik adalah bagian pertama

        // SQL query untuk menghapus data dari tabel favorit berdasarkan id_musik
        String sql = "DELETE FROM favorit WHERE id_musik = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        // Set parameter id_musik
        ps.setInt(1, idMusik);

        // Eksekusi query
        int rowsAffected = ps.executeUpdate();

        // Tampilkan pesan sukses jika ada data yang dihapus
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus dari favorit.");
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan di favorit.");
        }

        // Refresh data di tabel favorit setelah penghapusan
        loadData4();
        loadData3();

    } catch (SQLException e) {
        System.out.println("Error saat menghapus data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.");
    }   
    }//GEN-LAST:event_btndeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Hiburann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hiburann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hiburann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hiburann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hiburann(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbxfavorit;
    private javax.swing.JComboBox<String> cbxgenre;
    private javax.swing.JComboBox<String> cbxid;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblfavorit;
    private javax.swing.JTable tblmusik;
    // End of variables declaration//GEN-END:variables
}
