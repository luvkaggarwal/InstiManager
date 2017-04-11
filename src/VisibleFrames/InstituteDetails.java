/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisibleFrames;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author luv
 */
public class InstituteDetails extends javax.swing.JFrame {

    /**
     * Creates new form InstituteDetails
     */
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public InstituteDetails() {
        initComponents();
        conn = FunctionClasses.DataBaseConnection.ConnectDB();
        DisplayData();
        fillCombos();
    }

    private void fillCombos(){
        try{
            
            String sql = "select contact from phone where u_id = ( select org_id as u_id from organisation where org_name = '" + tvName.getText() + "' );";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            cbPhone.removeAllItems();
            while( rs.next() )
                cbPhone.addItem(rs.getString("contact"));
            
            sql = "select dept_name from department;";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            cbDepartment.removeAllItems();
            while( rs.next() )
                cbDepartment.addItem(rs.getString("dept_name"));
            
            if( cbDepartment.getSelectedItem() != null ){
                sql = "select distinct(job) from user where u_id in ( select u_id from belongsTo where dept_id = ( select dept_id from department where dept_name = '" + cbDepartment.getSelectedItem().toString() + "') );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbDesignation.removeAllItems();
                while( rs.next() )
                    cbDesignation.addItem(rs.getString("job"));
            }
            
            if( cbDesignation.getSelectedItem() !=null ){
                sql = "select concat(fname,' ',lname) as userName from user where job = '" + cbDesignation.getSelectedItem().toString() + "';";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbUsers.removeAllItems();
                while( rs.next() )
                    cbUsers.addItem(rs.getString("userName"));
            }
            
            sql = "select course_name from course;";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            cbCourse.removeAllItems();
            while( rs.next() )
                cbCourse.addItem(rs.getString("course_name"));
            
            if( cbCourse.getSelectedItem() !=null ){
                sql = "select distinct(sem_no) from courseSubjects where course_id = ( select course_id from course where course_name = '" + cbCourse.getSelectedItem().toString() + "' );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbSemester.removeAllItems();
                while( rs.next() )
                    cbSemester.addItem(rs.getString("sem_no"));
            }
            
            if( cbSemester.getSelectedItem() !=null ){
                sql = "select sub_name from subjects where sub_id in ( select sub_id from courseSubjects where course_id = 'BE' and sem_no = '" + Integer.parseInt(cbSemester.getSelectedItem().toString()) + "');";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbSubjects.removeAllItems();
                while( rs.next() )
                    cbSubjects.addItem(rs.getString("sub_name"));
            }
            
            if( cbSubjects.getSelectedItem() !=null ){
                sql = "select concat(fname,' ',lname) as userName from user where u_id in ( select u_id from teacher where sub_id = ( select sub_id from subjects where sub_name = '" + cbSubjects.getSelectedItem().toString() + "' ) );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbTeachers.removeAllItems();
                while( rs.next() )
                    cbTeachers.addItem(rs.getString("userName"));
            }    
            
        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();    
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }
    
    private void DisplayData(){
        try{
            String sql = " select org_name,address from organisation where org_id = 'MERIJKP';";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            if( rs.next() ){
                tvName.setText( rs.getString("org_name") );
                tvAddress.setText( rs.getString("address") );
            }
                
        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();    
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
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

        jPanel2 = new javax.swing.JPanel();
        lName = new javax.swing.JLabel();
        lAddress = new javax.swing.JLabel();
        tvAddress = new javax.swing.JTextField();
        lSubjects = new javax.swing.JLabel();
        lPhone = new javax.swing.JLabel();
        lCourse = new javax.swing.JLabel();
        lDepartment = new javax.swing.JLabel();
        semester = new javax.swing.JLabel();
        tvName = new javax.swing.JTextField();
        cbSemester = new javax.swing.JComboBox();
        cbPhone = new javax.swing.JComboBox();
        cbSubjects = new javax.swing.JComboBox();
        cbDepartment = new javax.swing.JComboBox();
        lDesignation = new javax.swing.JLabel();
        cbDesignation = new javax.swing.JComboBox();
        lUsers = new javax.swing.JLabel();
        cbUsers = new javax.swing.JComboBox();
        cbCourse = new javax.swing.JComboBox();
        lTeacher = new javax.swing.JLabel();
        cbTeachers = new javax.swing.JComboBox();
        jPanel25 = new javax.swing.JPanel();
        btReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lName.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lName.setText("NAME");

        lAddress.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAddress.setText("ADDRESS");

        tvAddress.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tvAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tvAddress.setEnabled(false);

        lSubjects.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lSubjects.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSubjects.setText("SUBJECTS");

        lPhone.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPhone.setText("PHONE");

        lCourse.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCourse.setText("COURSE");

        lDepartment.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lDepartment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDepartment.setText("DEPARTMENT");

        semester.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        semester.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semester.setText("SEMESTER");

        tvName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tvName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tvName.setEnabled(false);

        cbSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        cbSemester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSemesterMouseClicked(evt);
            }
        });
        cbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSemesterActionPerformed(evt);
            }
        });

        cbSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSubjectsMouseClicked(evt);
            }
        });
        cbSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubjectsActionPerformed(evt);
            }
        });

        cbDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDepartmentMouseClicked(evt);
            }
        });
        cbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartmentActionPerformed(evt);
            }
        });

        lDesignation.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lDesignation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDesignation.setText("DESIGNATION");

        cbDesignation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDesignationMouseClicked(evt);
            }
        });
        cbDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDesignationActionPerformed(evt);
            }
        });

        lUsers.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUsers.setText("USERS");

        cbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCourseMouseClicked(evt);
            }
        });
        cbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseActionPerformed(evt);
            }
        });

        lTeacher.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        lTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTeacher.setText("TEACHER");

        jPanel25.setBackground(new java.awt.Color(0, 0, 102));
        jPanel25.setEnabled(false);

        btReturn.setBackground(new java.awt.Color(0, 0, 102));
        btReturn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btReturn.setForeground(new java.awt.Color(255, 255, 255));
        btReturn.setText("RETURN");
        btReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(btReturn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(semester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lDepartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lSubjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lDesignation, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDesignation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tvName)
                            .addComponent(cbPhone, 0, 710, Short.MAX_VALUE)
                            .addComponent(cbSubjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbDepartment, 0, 710, Short.MAX_VALUE)
                            .addComponent(cbUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTeachers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tvAddress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tvAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSemesterActionPerformed
        
    }//GEN-LAST:event_cbSemesterActionPerformed

    private void cbSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubjectsActionPerformed
        
    }//GEN-LAST:event_cbSubjectsActionPerformed

    private void cbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseActionPerformed
        
    }//GEN-LAST:event_cbCourseActionPerformed

    private void cbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartmentActionPerformed
        
    }//GEN-LAST:event_cbDepartmentActionPerformed

    private void cbDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDesignationActionPerformed
        
    }//GEN-LAST:event_cbDesignationActionPerformed

    private void btReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReturnActionPerformed
        // TODO add your handling code here:
        WindowEvent winClosingEvent = new WindowEvent( this , WindowEvent.WINDOW_CLOSING );
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }//GEN-LAST:event_btReturnActionPerformed

    private void cbDesignationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDesignationMouseClicked
        // TODO add your handling code here:
        try{

            if( cbDesignation.getSelectedItem() !=null ){
                String sql = "select concat(fname,' ',lname) as userName from user where job = '" + cbDesignation.getSelectedItem().toString() + "';";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbUsers.removeAllItems();
                while( rs.next() )
                    cbUsers.addItem(rs.getString("userName"));
            }

        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }//GEN-LAST:event_cbDesignationMouseClicked

    private void cbDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDepartmentMouseClicked
        // TODO add your handling code here:
        try{

            if( cbDepartment.getSelectedItem() !=null ){
                String sql = "select distinct(job) from user where u_id in ( select u_id from belongsTo where dept_id = ( select dept_id from department where dept_name = '" + cbDepartment.getSelectedItem().toString() + "') );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbDesignation.removeAllItems();
                while( rs.next() )
                    cbDesignation.addItem(rs.getString("job"));
            }
            
            if( cbDesignation.getSelectedItem() !=null ){
                String sql = "select concat(fname,' ',lname) as userName from user where job = '" + cbDesignation.getSelectedItem().toString() + "';";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbUsers.removeAllItems();
                while( rs.next() )
                    cbUsers.addItem(rs.getString("userName"));
            }

        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }//GEN-LAST:event_cbDepartmentMouseClicked

    private void cbSemesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSemesterMouseClicked
        // TODO add your handling code here:
        try{

            if( cbSemester.getSelectedItem() !=null ){
                String sql = "select sub_name from subjects where sub_id in ( select sub_id from courseSubjects where course_id = 'BE' and sem_no = '" + Integer.parseInt(cbSemester.getSelectedItem().toString()) + "');";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbSubjects.removeAllItems();
                while( rs.next() )
                    cbSubjects.addItem(rs.getString("sub_name"));
            }
            
            if( cbSubjects.getSelectedItem() !=null ){
                String sql = "select concat(fname,' ',lname) as userName from user where u_id in ( select u_id from teacher where sub_id = ( select sub_id from subjects where sub_name = '" + cbSubjects.getSelectedItem().toString() + "' ) );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbTeachers.removeAllItems();
                while( rs.next() )
                    cbTeachers.addItem(rs.getString("userName"));
            }   
            
        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }//GEN-LAST:event_cbSemesterMouseClicked

    private void cbCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCourseMouseClicked
        // TODO add your handling code here:
        try{

            if( cbCourse.getSelectedItem() !=null ){
                String sql = "select distinct(sem_no) from courseSubjects where course_id = ( select course_id from course where course_name = '" + cbCourse.getSelectedItem().toString() + "' );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbSemester.removeAllItems();
                while( rs.next() )
                    cbSemester.addItem(rs.getString("sem_no"));
            }
            
            if( cbSemester.getSelectedItem() !=null ){
                String sql = "select sub_name from subjects where sub_id in ( select sub_id from courseSubjects where course_id = 'BE' and sem_no = '" + Integer.parseInt(cbSemester.getSelectedItem().toString()) + "');";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbSubjects.removeAllItems();
                while( rs.next() )
                    cbSubjects.addItem(rs.getString("sub_name"));
            }
            
            if( cbSubjects.getSelectedItem() !=null ){
                String sql = "select concat(fname,' ',lname) as userName from user where u_id in ( select u_id from teacher where sub_id = ( select sub_id from subjects where sub_name = '" + cbSubjects.getSelectedItem().toString() + "' ) );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbTeachers.removeAllItems();
                while( rs.next() )
                    cbTeachers.addItem(rs.getString("userName"));
            }    

        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }//GEN-LAST:event_cbCourseMouseClicked

    private void cbSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSubjectsMouseClicked
        // TODO add your handling code here:
        try{

            if( cbSubjects.getSelectedItem() !=null ){
                String sql = "select concat(fname,' ',lname) as userName from user where u_id in ( select u_id from teacher where sub_id = ( select sub_id from subjects where sub_name = '" + cbSubjects.getSelectedItem().toString() + "' ) );";
                pst = conn.prepareStatement( sql );
                rs = pst.executeQuery();
                cbTeachers.removeAllItems();
                while( rs.next() )
                    cbTeachers.addItem(rs.getString("userName"));
            } 

        }catch( Exception e ){
            JOptionPane.showMessageDialog( null, e );
        }finally{
            try{
                rs.close();
                pst.close();
            }catch( Exception e ){
                JOptionPane.showMessageDialog( null, e );
            }
        }
    }//GEN-LAST:event_cbSubjectsMouseClicked

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
            java.util.logging.Logger.getLogger(InstituteDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstituteDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstituteDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstituteDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstituteDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReturn;
    private javax.swing.JComboBox cbCourse;
    private javax.swing.JComboBox cbDepartment;
    private javax.swing.JComboBox cbDesignation;
    private javax.swing.JComboBox cbPhone;
    private javax.swing.JComboBox cbSemester;
    private javax.swing.JComboBox cbSubjects;
    private javax.swing.JComboBox cbTeachers;
    private javax.swing.JComboBox cbUsers;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JLabel lAddress;
    private javax.swing.JLabel lCourse;
    private javax.swing.JLabel lDepartment;
    private javax.swing.JLabel lDesignation;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPhone;
    private javax.swing.JLabel lSubjects;
    private javax.swing.JLabel lTeacher;
    private javax.swing.JLabel lUsers;
    private javax.swing.JLabel semester;
    private javax.swing.JTextField tvAddress;
    private javax.swing.JTextField tvName;
    // End of variables declaration//GEN-END:variables
}
