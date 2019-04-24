package duplicate;

import java.awt.Color;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Homepage extends javax.swing.JFrame {

    public Homepage() {
        initComponents();
        jComboBox3.removeAllItems();
        load_dbs();
        createLog();
        loadBox();
    }

//    public void testPop() {
//        JLabel lb[] = new JLabel[4];
//        for (int i = 0; i < lb.length; i++) {
//            lb[i] = new JLabel("Hello");
//            lb[i].setSize(jPanel4.getWidth(), 50);
//            lb[i].setBackground(Color.red);
//            lb[i].setVisible(true);
//            jPanel4.add(lb[i]);
//        }
//    }
    JFileChooser fc;
    public static Connection con;
    public static Statement stm;
    public static ResultSet rst;

// <editor-fold defaultstate="collapsed" desc="Default Load Codes">  
    private void createLog() {
        File file = new File("C:\\Duplicate_Log\\");
        try {
            //  boolean create=file.createNewFile();
            if (!file.exists()) {
                if (file.mkdir()) {
                    message("Directory Log Created Successfully", "Message", im);
                } else {
                    message(" Error in Log Creation ", "Message", em);
                }
            } else {
                // message("File Quarantine Already Exists",wm,"Message");
            }
        } catch (Exception ex) {
            message(" Error in Log Creation: " + ex, "Message", im);
            ex.printStackTrace();
        }
    }

    public static void connect(String cnt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cnt, "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load_dbs() {
        connect("jdbc:mysql://localhost:3306");
        try {
            rst = stm.executeQuery("SHOW DATABASES;");
            jComboBox1.removeAllItems();
            while (rst.next()) {
                jComboBox1.addItem(rst.getObject(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBox() {
        jComboBox2.removeAllItems();
        File fl = null;
        fl = new File("C:\\Duplicate_Log\\");
        String foldername = fl.getPath();
        File folder = new File(foldername);
        File[] paths = folder.listFiles();
        for (File file : paths) {
//            System.out.println(file.toString());
            jComboBox2.addItem(file.getPath());
        }
    }
// </editor-fold>   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Record Duplicate Detection Application");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setText("Select Database:");
        jLabel1.setOpaque(true);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 153));
        jTabbedPane1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton6.setText("Refresh APP");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton7.setText("Optimize");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel3.setText("Record Fetched:  ; Duplicate Recored: ;");
        jLabel3.setOpaque(true);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Reports");
        jLabel4.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Table");
        jLabel5.setOpaque(true);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Files", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel2.setText("Reports:");
        jLabel2.setOpaque(true);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton3.setText("Fetch");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Database Name:\n\nTable Selected:\n\nTotal Number of Records:\n\nTotal Number of Duplicates:\n\nAction Performed:\n");
        jScrollPane1.setViewportView(jTextArea1);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel3);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton8.setText("Fetch Tables");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel6.setText("Select Tables:");
        jLabel6.setOpaque(true);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton9.setText("Check Duplicates");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File fl = null;
        String line;
        jTextArea1.setText(null);
        fl = new File(jComboBox2.getSelectedItem().toString());
        BufferedReader br;
        FileReader fr;
        try {
            br = new BufferedReader(fr = new FileReader(fl));
            line = br.readLine();
            while (line != null) {
                jTextArea1.append(line + "\n");
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            connect("jdbc:mysql://localhost:3306/" + jComboBox1.getSelectedItem().toString().trim());
            DatabaseMetaData md = con.getMetaData();
            rst = md.getTables(null, null, "%", null);
            jComboBox3.removeAllItems();
            while (rst.next()) {
//                System.out.println(rst.getString(3));
                jComboBox3.addItem(rst.getString(3));
            }
//           stm.execute("USE "+jComboBox1.getSelectedItem().toString().trim());
//            rst = stm.executeQuery("SHOW TABLES");
//            ResultSetMetaData md=rst.getMetaData();
//            jComboBox2.removeAllItems();
////            for (int i = 1; i < rst.getRow(); i++) {
////            System.out.println(md.getTableName(i)+"--\n");
////                jComboBox2.addItem(md.getTableName(i));
////            }
//            while (rst.next()) {
//                jComboBox2.addItem(rst.getObject(1));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    String dbase = "", tbl = "";
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ResultSetMetaData md;
            DefaultTableModel dtm = new DefaultTableModel();
            connect("jdbc:mysql://localhost:3306/" + jComboBox1.getSelectedItem().toString().trim());
            rst = stm.executeQuery("SELECT * FROM " + jComboBox3.getSelectedItem().toString().trim());
            dbase = jComboBox1.getSelectedItem().toString().trim();
            tbl = jComboBox3.getSelectedItem().toString().trim();
            md = rst.getMetaData();
//            DatabaseMetaData dbmd = con.getMetaData();
            Integer ccount = md.getColumnCount();
            String records[][], records2[][];
            Integer counter = 0;
            while (rst.next()) {
                counter++;
            }
            for (int i = 0; i < ccount; i++) {
                dtm.addColumn(md.getColumnName(i + 1));
            }
            records = new String[counter][ccount];
            records2 = new String[counter][ccount];
            rst = stm.executeQuery("SELECT * FROM " + jComboBox3.getSelectedItem().toString().trim());
            counter = 0;
            while (rst.next()) {
                Object row[] = new Object[ccount];
                for (int i = 0; i < ccount; i++) {
                    records2[counter][i] = records[counter][i] = rst.getString(i + 1);
                    row[i] = records2[counter][i];
                }
                dtm.addRow(row);
                counter++;
            }
            jTable1.setModel(dtm);
            jLabel5.setText(jComboBox3.getSelectedItem().toString().trim());
            Integer acount = 0, bcount = 0;
            String duplicStr = "";
            for (int i = 0; i < records.length - 1; i++) {
                for (int j = i + 1; j < records2.length; j++) {
                    for (int k = 1; k < records[0].length; k++) {
                        Simil sm = new Simil(records[i][k].trim().toLowerCase());
//                        if (records[i][k].trim().equalsIgnoreCase(
//                                records2[j][k].trim())) {
//                           bcount++; //System.out.println("b--"+bcount);
//                        }
                        Double simv = ((double) sm.getSimilarityInPercentFor(records2[j][k].trim().toLowerCase()) / 100);
                        if (simv > 0.95 && simv <= 1.00) {
                            bcount++;
                        }
                    }
                    bcount += 1;
                    if (bcount == records[0].length) {
//                        System.out.println("f--" + bcount);
                        if (duplicStr.contains(("$" + i + "-")) || duplicStr.contains(("-" + i + "$"))) {
                            duplicStr += "($" + i + "-" + j + "$)";
                            continue;
                        }
                        duplicStr += "($" + i + "-" + j + "$)";
                        acount++;
//                        System.out.println("a--" + acount);
                    }
                    bcount = 0;
                }

            }
            jTextArea2.setText("Database Name: " + jComboBox1.getSelectedItem().toString().trim() + "\n"
                    + "\n"
                    + "Table Selected: " + jComboBox3.getSelectedItem().toString().trim() + "\n"
                    + "\n"
                    + "Total Number of Records: " + jTable1.getRowCount() + "\n"
                    + "\n"
                    + "Total Number of Duplicates: " + acount + "\n"
                    + "\n"
                    + "Action Performed:none");
            jLabel3.setText("Record Fetched: " + jTable1.getRowCount() + " ; Duplicate Recored: " + acount + " ;");

//            while (rst.next()) {
//                System.out.println(rst.getString(3));
//                jComboBox3.addItem(rst.getString(3));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        off();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            PrinterJob pj;
            Properties p = new Properties();

            String printData = jTextArea1.getText();
            pj = PrinterJob.getPrinterJob();
            pj.setPrintable(new Printer(printData));
            boolean doPrint = pj.printDialog();
            if (doPrint) {
                jTextArea1.print();
            }
        } catch (Exception e) {
            message("Printing Error Check Printer ", "Error", em);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    GregorianCalendar gc;
    Calendar cal;
    Integer hr, mi, se, yr, dy, mn;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        File fl = null;
        BufferedWriter bw;
        String fileName;
        gc = new GregorianCalendar();
        yr = gc.get(cal.YEAR);
        mn = gc.get(cal.MONTH) + 1;
        dy = gc.get(cal.DAY_OF_MONTH);
        hr = gc.get(cal.HOUR_OF_DAY);
        mi = gc.get(cal.MINUTE);
        se = gc.get(cal.SECOND);
        fileName = input("Supply Name to Save Log With", "Input", qm);
        if (fileName.isEmpty() || jTextArea2.getText().trim().isEmpty()) {
            message("Empty Value is Not Supported", "Warning", wm);
            return;
        }
        fileName = fileName + "_" + yr + "_" + mn + "_" + dy + "_" + hr + "_" + mi + "_" + se;
        fl = new File("C:\\Duplicate_Log\\" + fileName + ".txt.dpl");
        try {
            if (fl == null) {
                return;
            }
            bw = new BufferedWriter(new FileWriter(fl));
            jTextArea2.write(bw);
            bw.close();
            if (fl != null) {
                bw.close();
            }
            fl.setReadOnly();
            message("File Successfully Saved", "Message", im);
        } catch (Exception e) {
            message(" Error in Saving File: " + e, "Message", em);
            e.printStackTrace();
        }
        loadBox();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jComboBox3.removeAllItems();
        load_dbs();
        createLog();
        loadBox();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Integer conf = confirm("Are You Sure to Optimize?", "Question", qm);
        if (conf == yes) {
            if (dbase.trim().isEmpty() || tbl.trim().isEmpty()) {
                message("Duplicate need to be Checked before Optimization", "Warning", wm);
                return;
            } else {
                try {
                    ResultSetMetaData md;
                    DefaultTableModel dtm = new DefaultTableModel();
                    connect("jdbc:mysql://localhost:3306/" + dbase);
                    rst = stm.executeQuery("SELECT * FROM " + tbl);
                    md = rst.getMetaData();
//            DatabaseMetaData dbmd = con.getMetaData();
                    Integer ccount = md.getColumnCount();
                    String records[][], records2[][];
                    Integer counter = 0;
                    while (rst.next()) {
                        counter++;
                    }
                    for (int i = 0; i < ccount; i++) {
                        dtm.addColumn(md.getColumnName(i + 1));
                    }
                    records = new String[counter][ccount];
                    records2 = new String[counter][ccount];
                    rst = stm.executeQuery("SELECT * FROM " + tbl);
                    counter = 0;
                    while (rst.next()) {
                        Object row[] = new Object[ccount];
                        for (int i = 0; i < ccount; i++) {
                            records2[counter][i] = records[counter][i] = rst.getString(i + 1);
                            row[i] = records2[counter][i];
                        }
                        dtm.addRow(row);
                        counter++;
                    }
                    jTable1.setModel(dtm);
                    jLabel5.setText(jComboBox3.getSelectedItem().toString().trim());
                    Integer acount = 0, bcount = 0;
                    String duplicStr = "";
                    for (int i = 0; i < records.length - 1; i++) {
                        for (int j = i + 1; j < records2.length; j++) {
                            for (int k = 1; k < records[0].length; k++) {
                                Simil sm = new Simil(records[i][k].trim().toLowerCase());
                                Double simv = ((double) sm.getSimilarityInPercentFor(records2[j][k].trim().toLowerCase()) / 100);
                                if (simv > 0.95 && simv <= 1.00) {
                                    bcount++;
                                }
                            }
                            bcount += 1;
                            if (bcount == records[0].length) {
//                                System.out.println("f--" + bcount);
                                stm.executeUpdate("DELETE FROM "+tbl+" WHERE id='"+records2[j][0]+"';");
                                message("Optimization Successfull on Record "+records2[j][0], "Message", im);
                                if (duplicStr.contains(("$" + i + "-")) || duplicStr.contains(("-" + i + "$"))) {
                                    duplicStr += "($" + i + "-" + j + "$)";
                                    continue;
                                }
                                duplicStr += "($" + i + "-" + j + "$)";
                                
                                acount++;
//                                System.out.println("a--" + acount);
                            }
                            bcount = 0;
                        }
                    }
                    jTextArea2.setText("Database Name: " + jComboBox1.getSelectedItem().toString().trim() + "\n"
                            + "\n"
                            + "Table Selected: " + jComboBox3.getSelectedItem().toString().trim() + "\n"
                            + "\n"
                            + "Total Number of Records: " + jTable1.getRowCount() + "\n"
                            + "\n"
                            + "Total Number of Duplicates: " + acount + "\n"
                            + "\n"
                            + "Action Performed:(Delete:Optimization)");
                    jLabel3.setText("Record Fetched: " + jTable1.getRowCount() + " ; Number of Optimized Record(s): " + acount + " ;");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextArea2.setText("");
        jLabel3.setText("");
        jLabel5.setText("Table");
        jTextArea1.setText("");
        jTable1.setModel(null);
        jComboBox3.removeAllItems();
        jComboBox1.setSelectedIndex(0);
        load_dbs();
        createLog();
        loadBox();
    }//GEN-LAST:event_jButton6ActionPerformed

    // <editor-fold defaultstate="collapsed" desc="JOptionPane Dialogs">    
    private Integer off() {
        Integer exit = confirm("This Application is About to Exit\n Press Yes to Confirm Exit of No to Revert", "Exit?", qm);
        if (exit == yes) {
            try {
                Thread.sleep(4000);
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return 0;
        }
        return 0;
    }

    private Integer confirm(String message, String title, Integer ic) {
        return jp.showConfirmDialog(null, message, title, dec, ic);
    }

    private void message(String message, String title, Integer ic) {
        jp.showMessageDialog(null, message, title, ic);
    }

    private String input(String message, String title, Integer ic) {
        return jp.showInputDialog(null, message, title, ic);
    }
    javax.swing.JOptionPane jp = new javax.swing.JOptionPane();
    Integer yes = jp.YES_OPTION, no = jp.NO_OPTION, im = jp.INFORMATION_MESSAGE, wm = jp.WARNING_MESSAGE, qm = jp.QUESTION_MESSAGE, dec = jp.YES_NO_OPTION, okC = jp.OK_CANCEL_OPTION, em = jp.ERROR_MESSAGE;
//</editor-fold>

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
