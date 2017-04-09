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
 * @author LUV
 */
public class EditBooks extends javax.swing.JFrame {

    private static String Accession_ID;
    private static String Command;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form EditBooks
     * @param AccessionID
     * @param command
     */
    public EditBooks( String AccessionID , String command ) {
        Accession_ID = AccessionID;
        Command = command;
        initComponents();
        conn = FunctionClasses.DataBaseConnection.ConnectDB();
        if( command.equals("EDIT") ){
            Button.setText("SAVE");
            DisplayData();
        }
        else if( command.equals("ADD") )
            Button.setText("ADD");
        fillCombos();
    }

    private void fillCombos(){
        try{
            String sql = "select Type from Status;";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            while( rs.next() )
                StatusCombo.addItem(rs.getString("Name"));
            
            sql = "select Name from Publisher;";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            while( rs.next() )
                PublisherCombo.addItem(rs.getString("Name"));
            
            sql = "select Subject from Course;";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            while( rs.next() )
                CourseCombo.addItem(rs.getString("Subject"));
            
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
            String sql = " select * from Books where AccessionID = '"+Accession_ID+"';";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            if( rs.next() ){
                AccessionIDText.setText( rs.getString("AccessionID") );
                TitleText.setText( rs.getString("Title") );
                Author1Text.setText( rs.getString("AuthorCode1") );
                Author2Text.setText( rs.getString("AuthorCode2") );
                CostText.setText( rs.getString("Cost") );
                LocationText.setText( rs.getString("PositionID") );
                EditionText.setText( rs.getString("Edition") );
                PublisherCombo.setSelectedItem( rs.getString("PublisherID"));
                BillNoText.setText( rs.getString("BillNo") );
                StatusCombo.setSelectedItem( rs.getString("Status") );
                PagesText.setText( rs.getString("Pages") );
                CourseCombo.setSelectedItem( rs.getString("SubjectID") );
                YearText.setText( rs.getString("Year") );
                BarcodeText.setText( rs.getString("BarCode") );
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
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent( this , WindowEvent.WINDOW_CLOSING );
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
        YearText = new javax.swing.JTextField();
        AccessionID = new javax.swing.JLabel();
        Cost = new javax.swing.JLabel();
        BillNoText = new javax.swing.JTextField();
        Author2 = new javax.swing.JLabel();
        CostText = new javax.swing.JTextField();
        Pages = new javax.swing.JLabel();
        Author2Text = new javax.swing.JTextField();
        Publisher = new javax.swing.JLabel();
        BillNo = new javax.swing.JLabel();
        PagesText = new javax.swing.JTextField();
        Course = new javax.swing.JLabel();
        LocationText = new javax.swing.JTextField();
        Title = new javax.swing.JLabel();
        Location = new javax.swing.JLabel();
        Year = new javax.swing.JLabel();
        TitleText = new javax.swing.JTextField();
        Status = new javax.swing.JLabel();
        EditionText = new javax.swing.JTextField();
        BarcodeText = new javax.swing.JTextField();
        AccessionIDText = new javax.swing.JTextField();
        Author1 = new javax.swing.JLabel();
        Barcode = new javax.swing.JLabel();
        Edition = new javax.swing.JLabel();
        Author1Text = new javax.swing.JTextField();
        StatusCombo = new javax.swing.JComboBox();
        PublisherCombo = new javax.swing.JComboBox();
        CourseCombo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        Button = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        YearText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        YearText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        AccessionID.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        AccessionID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccessionID.setText("ACCESSION ID");

        Cost.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Cost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cost.setText("COST");

        BillNoText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BillNoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Author2.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Author2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Author2.setText("AUTHOR 2");

        CostText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CostText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Pages.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Pages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pages.setText("PAGES");

        Author2Text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Author2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Author2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Author2TextActionPerformed(evt);
            }
        });

        Publisher.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Publisher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Publisher.setText("PUBLISHER");

        BillNo.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        BillNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BillNo.setText("BILL NO");

        PagesText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PagesText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Course.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Course.setText("COURSE");

        LocationText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LocationText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Title.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("TITLE");

        Location.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Location.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Location.setText("LOCATION");

        Year.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Year.setText("YEAR");

        TitleText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TitleText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Status.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText("STATUS");

        EditionText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        EditionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EditionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditionTextActionPerformed(evt);
            }
        });

        BarcodeText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BarcodeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        AccessionIDText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        AccessionIDText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Author1.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Author1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Author1.setText("AUTHOR 1");

        Barcode.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Barcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Barcode.setText("BARCODE");

        Edition.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        Edition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Edition.setText("EDITION");

        Author1Text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Author1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Author1Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Author1TextActionPerformed(evt);
            }
        });

        StatusCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        PublisherCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CourseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Course, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pages, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BillNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AccessionID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Edition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Publisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Author1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Author2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BillNoText)
                    .addComponent(BarcodeText)
                    .addComponent(YearText)
                    .addComponent(PagesText)
                    .addComponent(EditionText)
                    .addComponent(LocationText)
                    .addComponent(CostText)
                    .addComponent(Author2Text)
                    .addComponent(AccessionIDText)
                    .addComponent(TitleText)
                    .addComponent(Author1Text)
                    .addComponent(StatusCombo, 0, 500, Short.MAX_VALUE)
                    .addComponent(PublisherCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CourseCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccessionIDText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Author1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Author1Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Author2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Author2Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cost, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CostText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocationText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edition, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditionText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublisherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BillNoText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pages, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PagesText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YearText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarcodeText))
                .addContainerGap())
        );

        Button.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditionTextActionPerformed

    private void Author1TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Author1TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Author1TextActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void Author2TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Author2TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Author2TextActionPerformed

    private String EditQuery(){
        return "update Books set AccessionID='" + AccessionIDText.getText() + "' ,"
                    + "Title='" + TitleText.getText() + "' ,"
                    + "AuthorCode1='" + Author1Text.getText() + "' ,"
                    + "AuthorCode2='" + Author2Text.getText() + "' ,"
                    + "Cost='" + CostText.getText() + "' ,"
                    + "PositionID='" + LocationText.getText() + "' ,"
                    + "Edition='" + EditionText.getText() + "' ,"
                    + "PublisherID='" + PublisherCombo.getSelectedItem().toString() + "' ,"
                    + "BillNo='" + BillNoText.getText() + "' ,"
                    + "Status='" + StatusCombo.getSelectedItem().toString() + "' ,"
                    + "Pages='" + PagesText.getText() + "' ,"
                    + "SubjectID='" + CourseCombo.getSelectedItem().toString() + "' ,"
                    + "BarCode='" + BarcodeText.getText() + "' ,"
                    + "Year='" + YearText.getText() + "' "
                    + "where AccessionID='"+Accession_ID+"';";
    }

    private String AddQuery(){
        return "Insert into Books (AccessionID,Title,AuthorCode1,AuthorCode2,Cost,PositionID,Edition,PublisherID,BillNo,Status,Pages,SubjectID,BarCode,Year) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }
    
    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        // TODO add your handling code here:
        try{
            String sql;
            if( Button.getText().equals("EDIT") ){
                sql = EditQuery();
                pst = conn.prepareStatement(sql);
            }
            else if( Button.getText().equals("ADD") ){
                sql = AddQuery();
                pst = conn.prepareStatement(sql);
                pst.setString( 1, AccessionIDText.getText() );
                pst.setString( 2, TitleText.getText() );
                pst.setString( 3, Author1Text.getText() );
                pst.setString( 4, Author2Text.getText() );
                pst.setString( 5, CostText.getText() );
                pst.setString( 6, LocationText.getText() );
                pst.setString( 7, EditionText.getText() );
                pst.setString( 8, PublisherCombo.getSelectedItem().toString() );
                pst.setString( 9, BillNoText.getText() );
                pst.setString( 10, StatusCombo.getSelectedItem().toString() );
                pst.setString( 11, PagesText.getText() );
                pst.setString( 12, CourseCombo.getSelectedItem().toString() );
                pst.setString( 13, BarcodeText.getText() );
                pst.setString( 14, YearText.getText() );
            }
            
            pst.execute();
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
        close();
    }//GEN-LAST:event_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBooks( Accession_ID , Command ).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccessionID;
    private javax.swing.JTextField AccessionIDText;
    private javax.swing.JLabel Author1;
    private javax.swing.JTextField Author1Text;
    private javax.swing.JLabel Author2;
    private javax.swing.JTextField Author2Text;
    private javax.swing.JLabel Barcode;
    private javax.swing.JTextField BarcodeText;
    private javax.swing.JLabel BillNo;
    private javax.swing.JTextField BillNoText;
    private javax.swing.JButton Button;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel Cost;
    private javax.swing.JTextField CostText;
    private javax.swing.JLabel Course;
    private javax.swing.JComboBox CourseCombo;
    private javax.swing.JLabel Edition;
    private javax.swing.JTextField EditionText;
    private javax.swing.JLabel Location;
    private javax.swing.JTextField LocationText;
    private javax.swing.JLabel Pages;
    private javax.swing.JTextField PagesText;
    private javax.swing.JLabel Publisher;
    private javax.swing.JComboBox PublisherCombo;
    private javax.swing.JLabel Status;
    private javax.swing.JComboBox StatusCombo;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField TitleText;
    private javax.swing.JLabel Year;
    private javax.swing.JTextField YearText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
