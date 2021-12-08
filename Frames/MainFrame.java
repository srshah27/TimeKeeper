/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.awt.Color;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.*;

/**
 *
 * @author RSSH
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/timekeeper", "root", "srshah");

            jPanel3.removeAll();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from events where completed = 0 and DueDate>=curdate() order by Important desc, DueDate;");
            rs.next();
            Statement curtime = con.createStatement();

            ResultSet rstime = curtime.executeQuery("select curtime(), curdate();");
            rstime.next();
            //System.out.println(rstime.getTime("curtime()").before(rs.getTime("DueTime")));
            while (rs.getInt("Important") == 1) {
                System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                if (dateFormat.format(rstime.getDate("curdate()")).equals(dateFormat.format(rs.getDate("DueDate")))) {
                    System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                    if (rstime.getTime("curtime()").after(rs.getTime("DueTime"))) {

                        System.out.println("2" + rs.getDate("DueDate") + "" + rs.getTime("DueTime"));

                        rs.next();
                        continue;
                    }
                }
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.btnDelete.setVisible(true);
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                Panel.btnComplete.setVisible(true);

                //Panel.lblDateTime.setText(Time.rs.getTime("DueTime"));
                Panel.setBackground(new Color(255, 234, 167));
                jPanel3.add(Panel);
                i++;
                rs.next();
            }
            do {
                if (dateFormat.format(rstime.getDate("curdate()")).equals(dateFormat.format(rs.getDate("DueDate")))) {
                    System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                    if (rstime.getTime("curtime()").after(rs.getTime("DueTime"))) {

                        System.out.println("2" + rs.getDate("DueDate") + "" + rs.getTime("DueTime"));

                        rs.next();
                        continue;
                    }
                }
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                Panel.btnComplete.setVisible(true);
                if (i % 2 != 0) {
                    Panel.setBackground(new Color(178, 190, 195));
                }
                jPanel3.add(Panel);
                i++;
            } while (rs.next());
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to perform the action.\nPlease try again");
        }
        jScrollPane2.setViewportView(jPanel3);
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        MainAdd = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        MainUpcoming = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TimeKeeper");

        jPanel1.setBackground(new java.awt.Color(0, 206, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 206, 201));

        MainAdd.setBackground(new java.awt.Color(255, 255, 255));
        MainAdd.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        MainAdd.setText("ADD");
        MainAdd.setBorder(null);
        MainAdd.setContentAreaFilled(false);
        MainAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainAddActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton3.setText("MISSED");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton4.setText("EXIT");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        MainUpcoming.setBackground(new java.awt.Color(255, 255, 255));
        MainUpcoming.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        MainUpcoming.setText("UPCOMING");
        MainUpcoming.setBorder(null);
        MainUpcoming.setContentAreaFilled(false);
        MainUpcoming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainUpcomingActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton6.setText("COMPLETED");
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainUpcoming, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUpcoming, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(129, 236, 236));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 1500));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 798, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //MainUpcomingActionPerformed(evt);
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/timekeeper", "root", "srshah");
            jPanel3.removeAll();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from events where completed = 0 and DueDate<=curdate() order by Important desc, DueDate;");
            Statement curtime = con.createStatement();
            ResultSet rstime = curtime.executeQuery("select curtime(), curdate();");
            rstime.next();
            while (rs.next()) {
                if (dateFormat.format(rstime.getDate("curdate()")).equals(dateFormat.format(rs.getDate("DueDate")))) {
                    if (rstime.getTime("curtime()").before(rs.getTime("DueTime"))) {
                        continue;
                    }
                }
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.btnDelete.setVisible(true);
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                //Panel.lblDateTime.setText(Time.rs.getTime("DueTime"));
                //Panel.setBackground(new Color(255, 234, 167));
                jPanel3.add(Panel);
                i++;
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to perform the action.\nPlease try again");
        }
        jScrollPane2.setViewportView(jPanel3);
        revalidate();
        repaint();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void MainUpcomingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainUpcomingActionPerformed
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/timekeeper", "root", "srshah");

            jPanel3.removeAll();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from events where completed = 0 and DueDate>=curdate() order by Important desc, DueDate;");
            rs.next();
            Statement curtime = con.createStatement();

            ResultSet rstime = curtime.executeQuery("select curtime(), curdate();");
            rstime.next();
            //System.out.println(rstime.getTime("curtime()").before(rs.getTime("DueTime")));
            while (rs.getInt("Important") == 1) {
                System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                if (dateFormat.format(rstime.getDate("curdate()")).equals(dateFormat.format(rs.getDate("DueDate")))) {
                    System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                    if (rstime.getTime("curtime()").after(rs.getTime("DueTime"))) {

                        System.out.println("2" + rs.getDate("DueDate") + "" + rs.getTime("DueTime"));

                        rs.next();
                        continue;
                    }
                }
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                Panel.btnComplete.setVisible(true);

                //Panel.lblDateTime.setText(Time.rs.getTime("DueTime"));
                Panel.setBackground(new Color(255, 234, 167));
                jPanel3.add(Panel);
                i++;
                rs.next();
            }
            do {
                if (dateFormat.format(rstime.getDate("curdate()")).equals(dateFormat.format(rs.getDate("DueDate")))) {
                    System.out.println(rs.getDate("DueDate") + "" + rs.getTime("DueTime"));
                    if (rstime.getTime("curtime()").after(rs.getTime("DueTime"))) {

                        System.out.println("2" + rs.getDate("DueDate") + "" + rs.getTime("DueTime"));

                        rs.next();
                        continue;
                    }
                }
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                Panel.btnComplete.setVisible(true);
                if (i % 2 != 0) {
                    Panel.setBackground(new Color(178, 190, 195));
                }
                jPanel3.add(Panel);
                i++;
            } while (rs.next());
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to perform the action.\nPlease try again");
        }
        jScrollPane2.setViewportView(jPanel3);
        revalidate();
        repaint();
    }//GEN-LAST:event_MainUpcomingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("hh:mm:ss");
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/timekeeper", "root", "srshah");

            jPanel3.removeAll();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from events where completed = 1 order by Important desc, DueDate;");
            while (rs.next()) {
                ContentPane Panel = new ContentPane();
                Panel.setBounds(50, 50 + (i * 100), 700, 100);
                Panel.btnDelete.setVisible(true);
                Panel.lblID.setText(Integer.toString(rs.getInt("ID")));
                Panel.lblEventName.setText(rs.getString("EventName"));
                Panel.lblDueDate.setText(dateFormat.format(rs.getDate("DueDate")));
                Panel.lblDueTime.setText(time.format(rs.getTime("DueTime")));
                Panel.lblCategoryName.setText(rs.getString("Category"));
                Panel.Important.setText(Integer.toString(rs.getInt("Important")));
                Panel.btnComplete.setVisible(false);
                if (i % 2 != 0) {
                    Panel.setBackground(new Color(178, 190, 195));
                }
                //Panel.lblDateTime.setText(Time.rs.getTime("DueTime"));
                jPanel3.add(Panel);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to perform the action.\nPlease try again");
        }
        jScrollPane2.setViewportView(jPanel3);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void MainAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainAddActionPerformed
        EventDesc ed = new EventDesc();
        ed.setVisible(true);
        ed.btnAddEvent.setVisible(true);
        ed.btnCancel.setVisible(true);
        ed.txtEventName.setEditable(true);
        ed.txtCategoryName.setEditable(true);
        ed.chbImportant.setEnabled(true);
        ed.cmbDD.setEnabled(true);
        ed.cmbMM.setEnabled(true);
        ed.cmbYYYY.setEnabled(true);
        ed.cmbHours.setEnabled(true);
        ed.cmbMinutes.setEnabled(true);
        ed.cmbSeconds.setEnabled(true);
    }//GEN-LAST:event_MainAddActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

    }//GEN-LAST:event_jPanel1FocusGained

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        //JOptionPane.showMessageDialog(null, "Hello World");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/timekeeper", "root", "srshah");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Events");
            while (rs.next()) {

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to perform the action.\nPlease try again");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainAdd;
    public javax.swing.JButton MainUpcoming;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
