/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fgc;

import bo.Student;
import dao.StudentHandler;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import utils.GlobalData;
import utils.SQLUtil;
import javax.swing.JDialog;

/**
 *
 * @author vande
 */
public class FrmMain extends javax.swing.JFrame {

/**
     * Creates new form FrmMain
     */
    FrmLogin frmLogin = new FrmLogin();
    FrmAddStudent frmAddStudent = new FrmAddStudent();
    FrmUpdateStudent frmUpdateStudent = new FrmUpdateStudent();
    FrmAddMentor frmAddMentor = new FrmAddMentor();
    Map<String, JInternalFrame>  forms = new HashMap<>();
    
    private StudentHandler studentHandler = new StudentHandler();
    
    public void refreshTableStudents(){
        populateStudents();       
    }
    List<Student> students;
    private void populateStudents(){
        /*String[] colNames = new String[]{"samID", "name", "email", "date_of_birth", "Major", "Minor", "gpa", "mtrID"};
        DefaultTableModel tm = new DefaultTableModel (colNames,0) {
            @Override
            public boolean isCellEditable (int i, int i1){
                return false;
            }          
        };
        
        students = new StudentHandler().getStudents(keyword);
        
        students.forEach((s) -> {
            tm.addRow(s.getRow());
            
        });
        tblStudents.setModel(tm);*/
        
        String keyword = txtKeyword.getText();
        List<Student> students = studentHandler.loadStudents(keyword);
        String columns[] = new String[]{
            "samID", "name", "email", "date_of_birth", "Major", "Minor", "gpa", "mtrID" 
        };
        DefaultTableModel tblModel = new DefaultTableModel(columns,0) ;
        students.forEach((std)->{
            tblModel.addRow(std.getRow());
        });
        tblStudents.setModel(tblModel);
    }
    
    public FrmMain() {
        initComponents();
        populateStudents();
        forms.put("frmLogin", frmLogin);
        forms.put("frmAddStudent", frmAddStudent);
        forms.put("frmUpdateStudent", frmUpdateStudent);
        forms.put("frmAddMentor", frmAddMentor);
        //Add add these to the JDesktopPage
        forms.values().forEach((frm)->{
            jdpContainer.add(frm);
        });
        
    }
    private void showForm(String frmName){
        showForm(frmName,true);
    }
    private void showForm(String frmName, boolean checkLogin){
        if(checkLogin && GlobalData.mtr == null){
            showForm("frmLogin", false);
        }else{ 
             try {  
            //Do Authoorization
            if(forms.get(frmName).isClosed()){
                
                try {
                    //Create new
                   forms.put(frmName, forms.get(frmName).getClass().newInstance());
                   jdpContainer.add(forms.get(frmName));
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
            }
            forms.get(frmName).setVisible(true);
         
            forms.get(frmName).setSelected(true);
            } catch (PropertyVetoException ex) {
                java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
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

        jdpContainer = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtStudents = new java.awt.Label();
        btnRefresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileLogin = new javax.swing.JMenuItem();
        fileLogout = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        menuManage = new javax.swing.JMenu();
        mngStudent = new javax.swing.JMenu();
        mngStudentAdd = new javax.swing.JMenuItem();
        mngStudentUpdate = new javax.swing.JMenuItem();
        mngStudentDelete = new javax.swing.JMenuItem();
        mngMentor = new javax.swing.JMenu();
        mngMentorAdd = new javax.swing.JMenuItem();
        mngMentorUpdate = new javax.swing.JMenuItem();
        mngMentorDelete = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        viewTables = new javax.swing.JMenu();
        viewStudents = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        viewNotes = new javax.swing.JCheckBoxMenuItem();
        viewEvents = new javax.swing.JCheckBoxMenuItem();
        viewApplication = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpContainer.setBackground(new java.awt.Color(0, 0, 0));
        jdpContainer.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jdpContainer.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(245, 100, 35));

        tblStudents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudents.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblStudents);
        tblStudents.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeywordActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 73, 144), 10));

        txtStudents.setAlignment(java.awt.Label.CENTER);
        txtStudents.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        txtStudents.setText("Students");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtKeyword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnRefresh))
                .addContainerGap())
        );

        jdpContainer.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpContainerLayout = new javax.swing.GroupLayout(jdpContainer);
        jdpContainer.setLayout(jdpContainerLayout);
        jdpContainerLayout.setHorizontalGroup(
            jdpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpContainerLayout.createSequentialGroup()
                .addContainerGap(960, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(960, Short.MAX_VALUE))
        );
        jdpContainerLayout.setVerticalGroup(
            jdpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jdpContainer, java.awt.BorderLayout.CENTER);

        menuFile.setText("File");

        fileLogin.setText("Login");
        fileLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileLoginActionPerformed(evt);
            }
        });
        menuFile.add(fileLogin);

        fileLogout.setText("Logout");
        fileLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileLogoutActionPerformed(evt);
            }
        });
        menuFile.add(fileLogout);

        fileExit.setText("Exit Application");
        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        menuFile.add(fileExit);

        jMenuBar1.add(menuFile);

        menuManage.setText("Manage");

        mngStudent.setText("Student");

        mngStudentAdd.setText("Add");
        mngStudentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngStudentAddActionPerformed(evt);
            }
        });
        mngStudent.add(mngStudentAdd);

        mngStudentUpdate.setText("Update");
        mngStudentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngStudentUpdateActionPerformed(evt);
            }
        });
        mngStudent.add(mngStudentUpdate);

        mngStudentDelete.setText("Delete");
        mngStudentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngStudentDeleteActionPerformed(evt);
            }
        });
        mngStudent.add(mngStudentDelete);

        menuManage.add(mngStudent);

        mngMentor.setText("Mentor");

        mngMentorAdd.setText("Add");
        mngMentorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngMentorAddActionPerformed(evt);
            }
        });
        mngMentor.add(mngMentorAdd);

        mngMentorUpdate.setText("Update");
        mngMentorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngMentorUpdateActionPerformed(evt);
            }
        });
        mngMentor.add(mngMentorUpdate);

        mngMentorDelete.setText("Delete");
        mngMentorDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngMentorDeleteActionPerformed(evt);
            }
        });
        mngMentor.add(mngMentorDelete);

        menuManage.add(mngMentor);

        jMenuBar1.add(menuManage);

        menuView.setText("View");

        viewTables.setText("Tables");

        viewStudents.setSelected(true);
        viewStudents.setText("Students");
        viewTables.add(viewStudents);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Mentors");
        viewTables.add(jCheckBoxMenuItem1);

        viewNotes.setSelected(true);
        viewNotes.setText("Notes");
        viewTables.add(viewNotes);

        viewEvents.setSelected(true);
        viewEvents.setText("Events");
        viewTables.add(viewEvents);

        viewApplication.setSelected(true);
        viewApplication.setText("Application");
        viewTables.add(viewApplication);

        menuView.add(viewTables);

        jMenuBar1.add(menuView);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileLogoutActionPerformed

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_fileExitActionPerformed

    private void mngStudentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngStudentAddActionPerformed
        showForm("frmAddStudent");
        
        
    }//GEN-LAST:event_mngStudentAddActionPerformed

    private void mngStudentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngStudentUpdateActionPerformed
        showForm("frmUpdateStudent",true);
    }//GEN-LAST:event_mngStudentUpdateActionPerformed

    private void mngStudentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngStudentDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mngStudentDeleteActionPerformed

    private void mngMentorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngMentorAddActionPerformed
        showForm("frmAddMentor");
    }//GEN-LAST:event_mngMentorAddActionPerformed

    private void mngMentorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngMentorUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mngMentorUpdateActionPerformed

    private void mngMentorDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngMentorDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mngMentorDeleteActionPerformed

    private void fileLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileLoginActionPerformed
        showForm("frmLogin", false);
    }//GEN-LAST:event_fileLoginActionPerformed

    private void txtKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeywordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refreshTableStudents();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        populateStudents();
        refreshTableStudents();
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               FrmMain frmMain = new FrmMain();
               frmMain.setSize(Toolkit.getDefaultToolkit().getScreenSize());
               frmMain.setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileLogin;
    private javax.swing.JMenuItem fileLogout;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane jdpContainer;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuManage;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenu mngMentor;
    private javax.swing.JMenuItem mngMentorAdd;
    private javax.swing.JMenuItem mngMentorDelete;
    private javax.swing.JMenuItem mngMentorUpdate;
    private javax.swing.JMenu mngStudent;
    private javax.swing.JMenuItem mngStudentAdd;
    private javax.swing.JMenuItem mngStudentDelete;
    private javax.swing.JMenuItem mngStudentUpdate;
    public javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtKeyword;
    private java.awt.Label txtStudents;
    private javax.swing.JCheckBoxMenuItem viewApplication;
    private javax.swing.JCheckBoxMenuItem viewEvents;
    private javax.swing.JCheckBoxMenuItem viewNotes;
    private javax.swing.JCheckBoxMenuItem viewStudents;
    private javax.swing.JMenu viewTables;
    // End of variables declaration//GEN-END:variables
}
