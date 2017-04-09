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
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LUV
 */
public class librarianHome extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private String AccessionID;
    public static String column = null;
    public static String value = null;
    /**
     * Creates new form librarianHome
     */
    public librarianHome() {
        initComponents();
        conn = FunctionClasses.DataBaseConnection.ConnectDB();
        updateTable(false);
        
    }

    public void loop( ){
        
            try {
                TimeUnit.SECONDS.sleep(2);
                close();
                librarianHome frame = new librarianHome();
                frame.setLocationRelativeTo(null);
                frame.jTabbedPane1.setSelectedIndex(1);
                frame.setVisible(true);
                TimeUnit.SECONDS.sleep(2);
                close();
                frame = new librarianHome();
                frame.setLocationRelativeTo(null);
                frame.jTabbedPane1.setSelectedIndex(2);
                frame.setVisible(true);
                TimeUnit.SECONDS.sleep(2);
                close();
                frame = new librarianHome();
                frame.setLocationRelativeTo(null);
                frame.jTabbedPane1.setSelectedIndex(0);
                frame.setVisible(true);
                /*Thread.sleep(10000);
            jTabbedPane1.setSelectedIndex(0);
            Thread.sleep(1000);
                jTabbedPane1.setSelectedIndex(1);
            Thread.sleep(10000);
            jTabbedPane1.setSelectedIndex(2);
            Thread.sleep(10000);
            jTabbedPane1.setSelectedIndex(0);
            Thread.sleep(10000);
                jTabbedPane1.setSelectedIndex(1);
            Thread.sleep(10000);
            jTabbedPane1.setSelectedIndex(2);
            Thread.sleep(1000);
            jTabbedPane1.setSelectedIndex(0);*/
            } catch (InterruptedException ex) {
                Logger.getLogger(librarianHome.class.getName()).log(Level.SEVERE, null, ex);
            }         
            
            
            
    
    }
    
    private void updateTable( boolean number ){
        
        try{
            String sql = "select AccessionID,"
                    + "Title,"
                    + "AuthorCode1,"
                    + "AuthorCode2,"
                    + "Edition,"
                    + "Status from Books";
            if( number )
                sql += " where "+ column + "='" + value + "'";
            sql += ";";
            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            /*if( !( rs.next() ) && column.equals("AuthorCode1")){
                column = "AuthorCode2";
                updateTable( 1 );
            }
            else if( !( rs.next() ) ){
                JOptionPane.showMessageDialog( null, "No record found!!" );
                updateTable( 0 );
            }
            else*/
                ViewTable.setModel( DbUtils.resultSetToTableModel(rs) );
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
    
    private void updateTable( String Table , boolean number ){
        
        try{
            String sql = "select ID,"
                    + "Title,"
                    + "Periodicity,"
                    + "Edition,"
                    + "Volume from " + Table;
            if( number )
                sql += " where "+ column + "='" + value + "'";
            sql += ";";

            pst = conn.prepareStatement( sql );
            rs = pst.executeQuery();
            
            /*if( !( rs.next() ) ){
                JOptionPane.showMessageDialog( null, "No record found!!" );
                updateTable( Table , false );
            }
            else*/ if( Table.equals("Journals") )
                JournalsTable.setModel( DbUtils.resultSetToTableModel(rs) );
            else
                MagazinesTable.setModel( DbUtils.resultSetToTableModel(rs) );
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
    
    private void empty(){
        AccessionIDText.setText(null);
        TitleText.setText(null);
        Author1Text.setText(null);
        Author2Text.setText(null);
        CostText.setText(null);
        EditionText.setText(null);
        PublisherText.setText(null);
        StatusText.setText(null);
        SubjectText.setText(null);
    }
    
    private void mEmpty(){
        MagazineIDText.setText(null);
        MTitleText.setText(null);
        MEditionText.setText(null);
        MPublisherText.setText(null);
        MVendorText.setText(null);
        MVolumeText.setText(null);
        MPeriodicityText.setText(null);
        MNumberText.setText(null);
        MDateText.setText(null);
    }
    
    private void jEmpty(){
        JournalIDText.setText(null);
        JTitleText.setText(null);
        JEditionText.setText(null);
        JPublisherText.setText(null);
        JVendorText.setText(null);
        JVolumeText.setText(null);
        JPeriodicityText.setText(null);
        JNumberText.setText(null);
        JDateText.setText(null);
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
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        FindBook = new javax.swing.JButton();
        FindStudent = new javax.swing.JButton();
        ScanStudentCode = new javax.swing.JButton();
        BookCode = new javax.swing.JTextField();
        StudentCode = new javax.swing.JTextField();
        ScanBookCode = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        StudentNameLabel = new javax.swing.JLabel();
        StudentNameText = new javax.swing.JTextField();
        ClassLabel = new javax.swing.JLabel();
        ClassText = new javax.swing.JTextField();
        IssueDateLabel = new javax.swing.JLabel();
        TotalFineText = new javax.swing.JTextField();
        TotalFineLabel = new javax.swing.JLabel();
        RollNoLabel = new javax.swing.JLabel();
        RollNoText = new javax.swing.JTextField();
        TitleLabel = new javax.swing.JLabel();
        DueDateLabel = new javax.swing.JLabel();
        AccessionIDLabel = new javax.swing.JLabel();
        BookFineLabel = new javax.swing.JLabel();
        Book1AccessionID = new javax.swing.JTextField();
        Book2AccessionID = new javax.swing.JTextField();
        Book3AccessionID = new javax.swing.JTextField();
        Book1Title = new javax.swing.JTextField();
        Book2Title = new javax.swing.JTextField();
        Book3Title = new javax.swing.JTextField();
        Book1IssueDate = new javax.swing.JTextField();
        Book2IssueDate = new javax.swing.JTextField();
        Book3IssueDate = new javax.swing.JTextField();
        Book1DueDate = new javax.swing.JTextField();
        Book2DueDate = new javax.swing.JTextField();
        Book3DueDate = new javax.swing.JTextField();
        Book1Fine = new javax.swing.JTextField();
        Book2Fine = new javax.swing.JTextField();
        Book3Fine = new javax.swing.JTextField();
        IssuedLabel = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        BookTitleLabel = new javax.swing.JLabel();
        BookTitleText = new javax.swing.JTextField();
        BookAuthor1Text = new javax.swing.JTextField();
        BookAuthor1Label = new javax.swing.JLabel();
        BookAuthor2Label = new javax.swing.JLabel();
        BookAccessionIDLabel = new javax.swing.JLabel();
        BookEditionLabel = new javax.swing.JLabel();
        BookPublisherLabel = new javax.swing.JLabel();
        BookPublisherText = new javax.swing.JTextField();
        BookEditionText = new javax.swing.JTextField();
        BookAccessionIDText = new javax.swing.JTextField();
        BookAuthor2Text = new javax.swing.JTextField();
        BookStatusLabel = new javax.swing.JLabel();
        BookCostLabel = new javax.swing.JLabel();
        BookSubjectLabel = new javax.swing.JLabel();
        BookSubjectText = new javax.swing.JTextField();
        BookCostText = new javax.swing.JTextField();
        BookStatusText = new javax.swing.JTextField();
        IssuedText = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        IssueButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ViewTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        TITLE = new javax.swing.JLabel();
        PUBLISHER = new javax.swing.JLabel();
        EDITION = new javax.swing.JLabel();
        AUTHOR2 = new javax.swing.JLabel();
        AUTHOR1 = new javax.swing.JLabel();
        ACCESSION_ID = new javax.swing.JLabel();
        SUBJECT = new javax.swing.JLabel();
        COST = new javax.swing.JLabel();
        STATUS = new javax.swing.JLabel();
        EditionText = new javax.swing.JTextField();
        Author2Text = new javax.swing.JTextField();
        SubjectText = new javax.swing.JTextField();
        CostText = new javax.swing.JTextField();
        StatusText = new javax.swing.JTextField();
        TitleText = new javax.swing.JTextField();
        Author1Text = new javax.swing.JTextField();
        PublisherText = new javax.swing.JTextField();
        AccessionIDText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        BFindButton = new javax.swing.JButton();
        BAddButton = new javax.swing.JButton();
        BDeleteButton = new javax.swing.JButton();
        BUpdateButton = new javax.swing.JButton();
        BEditButton = new javax.swing.JButton();
        BPrintButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MagazinesTable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        MTITLE = new javax.swing.JLabel();
        MPUBLISHER = new javax.swing.JLabel();
        MVENDOR = new javax.swing.JLabel();
        MVOLUME = new javax.swing.JLabel();
        MEDITION = new javax.swing.JLabel();
        MAGAZINE_ID = new javax.swing.JLabel();
        MDATE = new javax.swing.JLabel();
        MNUMBER = new javax.swing.JLabel();
        MPERIODICITY = new javax.swing.JLabel();
        MVendorText = new javax.swing.JTextField();
        MVolumeText = new javax.swing.JTextField();
        MDateText = new javax.swing.JTextField();
        MNumberText = new javax.swing.JTextField();
        MPeriodicityText = new javax.swing.JTextField();
        MTitleText = new javax.swing.JTextField();
        MEditionText = new javax.swing.JTextField();
        MPublisherText = new javax.swing.JTextField();
        MagazineIDText = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        MFindButton = new javax.swing.JButton();
        MAddButton = new javax.swing.JButton();
        MDeleteButton = new javax.swing.JButton();
        MUpdateButton = new javax.swing.JButton();
        MEditButton = new javax.swing.JButton();
        MPrintButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JournalsTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        JTITLE = new javax.swing.JLabel();
        JPUBLISHER = new javax.swing.JLabel();
        JVENDOR = new javax.swing.JLabel();
        JVOLUME = new javax.swing.JLabel();
        JEDITION = new javax.swing.JLabel();
        JOURNAL_ID = new javax.swing.JLabel();
        JDATE = new javax.swing.JLabel();
        JNUMBER = new javax.swing.JLabel();
        JPERIODICITY = new javax.swing.JLabel();
        JVendorText = new javax.swing.JTextField();
        JVolumeText = new javax.swing.JTextField();
        JDateText = new javax.swing.JTextField();
        JNumberText = new javax.swing.JTextField();
        JPeriodicityText = new javax.swing.JTextField();
        JTitleText = new javax.swing.JTextField();
        JEditionText = new javax.swing.JTextField();
        JPublisherText = new javax.swing.JTextField();
        JournalIDText = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        JFindButton = new javax.swing.JButton();
        JAddButton = new javax.swing.JButton();
        JDeleteButton = new javax.swing.JButton();
        JUpdateButton = new javax.swing.JButton();
        JEditButton = new javax.swing.JButton();
        JPrintButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LOGOUT = new javax.swing.JButton();
        NAME2 = new javax.swing.JLabel();
        NAME1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 153));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 102), 4, true));

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane4.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N

        jPanel16.setBackground(new java.awt.Color(0, 0, 102));

        jPanel13.setBackground(new java.awt.Color(0, 0, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "BARCODE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        FindBook.setBackground(new java.awt.Color(0, 0, 102));
        FindBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FindBook.setForeground(new java.awt.Color(255, 255, 255));
        FindBook.setText("FIND");
        FindBook.setEnabled(false);
        FindBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindBookActionPerformed(evt);
            }
        });

        FindStudent.setBackground(new java.awt.Color(0, 0, 102));
        FindStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FindStudent.setForeground(new java.awt.Color(255, 255, 255));
        FindStudent.setText("FIND");
        FindStudent.setEnabled(false);
        FindStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindStudentActionPerformed(evt);
            }
        });

        ScanStudentCode.setBackground(new java.awt.Color(0, 0, 102));
        ScanStudentCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ScanStudentCode.setForeground(new java.awt.Color(255, 255, 255));
        ScanStudentCode.setText("SCAN");
        ScanStudentCode.setToolTipText("Scan Student Barcode");
        ScanStudentCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanStudentCodeActionPerformed(evt);
            }
        });

        BookCode.setBackground(new java.awt.Color(0, 0, 102));
        BookCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookCode.setForeground(new java.awt.Color(255, 255, 255));
        BookCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookCode.setToolTipText("Book Barcode");
        BookCode.setEnabled(false);

        StudentCode.setBackground(new java.awt.Color(0, 0, 102));
        StudentCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentCode.setForeground(new java.awt.Color(255, 255, 255));
        StudentCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentCode.setToolTipText("Student Barcode");
        StudentCode.setEnabled(false);

        ScanBookCode.setBackground(new java.awt.Color(0, 0, 102));
        ScanBookCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ScanBookCode.setForeground(new java.awt.Color(255, 255, 255));
        ScanBookCode.setText("SCAN");
        ScanBookCode.setToolTipText("Scan Book Barcode");
        ScanBookCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanBookCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(BookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScanBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FindBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(StudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScanStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(FindBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ScanBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(ScanStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(StudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(0, 0, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "STUDENT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel15.setEnabled(false);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setEnabled(false);

        StudentNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        StudentNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentNameLabel.setText("NAME");
        StudentNameLabel.setEnabled(false);

        StudentNameText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        StudentNameText.setForeground(new java.awt.Color(0, 0, 153));
        StudentNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentNameText.setEnabled(false);

        ClassLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClassLabel.setForeground(new java.awt.Color(255, 255, 255));
        ClassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClassLabel.setText("CLASS");
        ClassLabel.setEnabled(false);

        ClassText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ClassText.setForeground(new java.awt.Color(0, 0, 153));
        ClassText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ClassText.setEnabled(false);

        IssueDateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IssueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        IssueDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IssueDateLabel.setText("ISSUE DATE");
        IssueDateLabel.setEnabled(false);

        TotalFineText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TotalFineText.setForeground(new java.awt.Color(0, 0, 153));
        TotalFineText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalFineText.setEnabled(false);

        TotalFineLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TotalFineLabel.setForeground(new java.awt.Color(255, 255, 255));
        TotalFineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalFineLabel.setText("FINE");
        TotalFineLabel.setEnabled(false);

        RollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RollNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        RollNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RollNoLabel.setText("ROLL NO");
        RollNoLabel.setEnabled(false);

        RollNoText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RollNoText.setForeground(new java.awt.Color(0, 0, 153));
        RollNoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RollNoText.setEnabled(false);

        TitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("TITLE");
        TitleLabel.setEnabled(false);

        DueDateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        DueDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DueDateLabel.setText("DUE DATE");
        DueDateLabel.setEnabled(false);

        AccessionIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AccessionIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        AccessionIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccessionIDLabel.setText("ACC ID");
        AccessionIDLabel.setEnabled(false);

        BookFineLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookFineLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookFineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookFineLabel.setText("FINE");
        BookFineLabel.setEnabled(false);

        Book1AccessionID.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book1AccessionID.setForeground(new java.awt.Color(0, 0, 153));
        Book1AccessionID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book1AccessionID.setEnabled(false);

        Book2AccessionID.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book2AccessionID.setForeground(new java.awt.Color(0, 0, 153));
        Book2AccessionID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book2AccessionID.setEnabled(false);

        Book3AccessionID.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book3AccessionID.setForeground(new java.awt.Color(0, 0, 153));
        Book3AccessionID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book3AccessionID.setEnabled(false);

        Book1Title.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Book1Title.setForeground(new java.awt.Color(0, 0, 153));
        Book1Title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book1Title.setEnabled(false);

        Book2Title.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Book2Title.setForeground(new java.awt.Color(0, 0, 153));
        Book2Title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book2Title.setEnabled(false);

        Book3Title.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Book3Title.setForeground(new java.awt.Color(0, 0, 153));
        Book3Title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book3Title.setEnabled(false);

        Book1IssueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book1IssueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book1IssueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book1IssueDate.setEnabled(false);

        Book2IssueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book2IssueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book2IssueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book2IssueDate.setEnabled(false);

        Book3IssueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book3IssueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book3IssueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book3IssueDate.setEnabled(false);

        Book1DueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book1DueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book1DueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book1DueDate.setEnabled(false);

        Book2DueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book2DueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book2DueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book2DueDate.setEnabled(false);

        Book3DueDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book3DueDate.setForeground(new java.awt.Color(0, 0, 153));
        Book3DueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book3DueDate.setEnabled(false);

        Book1Fine.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book1Fine.setForeground(new java.awt.Color(0, 0, 153));
        Book1Fine.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book1Fine.setEnabled(false);

        Book2Fine.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book2Fine.setForeground(new java.awt.Color(0, 0, 153));
        Book2Fine.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book2Fine.setEnabled(false);

        Book3Fine.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Book3Fine.setForeground(new java.awt.Color(0, 0, 153));
        Book3Fine.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Book3Fine.setEnabled(false);

        IssuedLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IssuedLabel.setForeground(new java.awt.Color(255, 255, 255));
        IssuedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IssuedLabel.setText("ISSUED");
        IssuedLabel.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Book2AccessionID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Book1AccessionID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AccessionIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Book3AccessionID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Book3Title)
                            .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Book2Title)
                            .addComponent(Book1Title, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Book2IssueDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Book1IssueDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IssueDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Book3IssueDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Book2DueDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Book1DueDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DueDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(Book3DueDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BookFineLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(Book3Fine, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Book2Fine)
                            .addComponent(Book1Fine)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(StudentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ClassLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addComponent(IssuedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(ClassText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TotalFineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RollNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RollNoText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TotalFineText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(StudentNameText))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StudentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClassText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RollNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalFineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalFineText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IssuedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AccessionIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IssueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookFineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(Book1AccessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Book2AccessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Book3AccessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(Book1IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Book2IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Book3IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Book1Fine, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Book2Fine, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(Book1Title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Book2Title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Book3Title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(Book1DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Book2DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Book3DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Book3Fine, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(0, 0, 102));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "BOOK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel14.setEnabled(false);

        BookTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookTitleLabel.setText("TITLE");
        BookTitleLabel.setEnabled(false);

        BookTitleText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookTitleText.setForeground(new java.awt.Color(0, 0, 153));
        BookTitleText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookTitleText.setEnabled(false);

        BookAuthor1Text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookAuthor1Text.setForeground(new java.awt.Color(0, 0, 153));
        BookAuthor1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookAuthor1Text.setEnabled(false);

        BookAuthor1Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookAuthor1Label.setForeground(new java.awt.Color(255, 255, 255));
        BookAuthor1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookAuthor1Label.setText("AUTHOR1");
        BookAuthor1Label.setEnabled(false);

        BookAuthor2Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookAuthor2Label.setForeground(new java.awt.Color(255, 255, 255));
        BookAuthor2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookAuthor2Label.setText("AUTHOR2");
        BookAuthor2Label.setEnabled(false);

        BookAccessionIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookAccessionIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookAccessionIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookAccessionIDLabel.setText("ACC ID");
        BookAccessionIDLabel.setEnabled(false);

        BookEditionLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookEditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookEditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookEditionLabel.setText("EDITION");
        BookEditionLabel.setEnabled(false);

        BookPublisherLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookPublisherLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookPublisherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookPublisherLabel.setText("PUBLISHER");
        BookPublisherLabel.setEnabled(false);

        BookPublisherText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookPublisherText.setForeground(new java.awt.Color(0, 0, 153));
        BookPublisherText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookPublisherText.setEnabled(false);

        BookEditionText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookEditionText.setForeground(new java.awt.Color(0, 0, 153));
        BookEditionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookEditionText.setEnabled(false);

        BookAccessionIDText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookAccessionIDText.setForeground(new java.awt.Color(0, 0, 153));
        BookAccessionIDText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookAccessionIDText.setEnabled(false);

        BookAuthor2Text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookAuthor2Text.setForeground(new java.awt.Color(0, 0, 153));
        BookAuthor2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookAuthor2Text.setEnabled(false);

        BookStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookStatusLabel.setText("STATUS");
        BookStatusLabel.setEnabled(false);

        BookCostLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookCostLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookCostLabel.setText("COST");
        BookCostLabel.setEnabled(false);

        BookSubjectLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookSubjectLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookSubjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookSubjectLabel.setText("SUBJECT");
        BookSubjectLabel.setEnabled(false);

        BookSubjectText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookSubjectText.setForeground(new java.awt.Color(0, 0, 153));
        BookSubjectText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookSubjectText.setEnabled(false);

        BookCostText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookCostText.setForeground(new java.awt.Color(0, 0, 153));
        BookCostText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookCostText.setEnabled(false);

        BookStatusText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookStatusText.setForeground(new java.awt.Color(0, 0, 153));
        BookStatusText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookStatusText.setEnabled(false);

        IssuedText.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        IssuedText.setForeground(new java.awt.Color(0, 0, 153));
        IssuedText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IssuedText.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(BookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookTitleText))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(BookPublisherText)
                                .addGap(18, 18, 18)
                                .addComponent(BookSubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(BookAccessionIDText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookStatusText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookSubjectText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BookAuthor1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookAuthor2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(BookAuthor1Text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IssuedText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BookAuthor2Text)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(BookEditionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookEditionText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BookCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(BookCostText, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookAccessionIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookPublisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BookAuthor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BookAuthor1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IssuedText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BookAuthor2Text)
                            .addComponent(BookAuthor2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BookAccessionIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BookAccessionIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BookStatusText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookEditionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookEditionText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookCostText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookPublisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookPublisherText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookSubjectText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookSubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(0, 0, 102));
        jPanel19.setEnabled(false);

        IssueButton.setBackground(new java.awt.Color(0, 0, 102));
        IssueButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        IssueButton.setForeground(new java.awt.Color(255, 255, 255));
        IssueButton.setText("ISSUE");
        IssueButton.setEnabled(false);
        IssueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueButtonActionPerformed(evt);
            }
        });

        ReturnButton.setBackground(new java.awt.Color(0, 0, 102));
        ReturnButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ReturnButton.setForeground(new java.awt.Color(255, 255, 255));
        ReturnButton.setText("RETURN");
        ReturnButton.setEnabled(false);
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(0, 0, 102));
        ResetButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(IssueButton, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IssueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab(" ISSUE / RETURN ", jPanel16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/VisibleFrames/Books-2-icon.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 4, true));

        jTabbedPane2.setBackground(new java.awt.Color(0, 0, 102));
        jTabbedPane2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTabbedPane2.setName(""); // NOI18N
        jTabbedPane2.setOpaque(true);
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));

        ViewTable.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ViewTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ViewTable.setRowHeight(20);
        ViewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ViewTable);

        jPanel6.setBackground(new java.awt.Color(0, 0, 102));

        TITLE.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TITLE.setForeground(new java.awt.Color(255, 255, 255));
        TITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TITLE.setText("TITLE");

        PUBLISHER.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        PUBLISHER.setForeground(new java.awt.Color(255, 255, 255));
        PUBLISHER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PUBLISHER.setText("PUBLISHER");

        EDITION.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        EDITION.setForeground(new java.awt.Color(255, 255, 255));
        EDITION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EDITION.setText("EDITION");

        AUTHOR2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        AUTHOR2.setForeground(new java.awt.Color(255, 255, 255));
        AUTHOR2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AUTHOR2.setText("AUTHOR2");

        AUTHOR1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        AUTHOR1.setForeground(new java.awt.Color(255, 255, 255));
        AUTHOR1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AUTHOR1.setText("AUTHOR1");

        ACCESSION_ID.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ACCESSION_ID.setForeground(new java.awt.Color(255, 255, 255));
        ACCESSION_ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACCESSION_ID.setText("ACCESSION ID");

        SUBJECT.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        SUBJECT.setForeground(new java.awt.Color(255, 255, 255));
        SUBJECT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SUBJECT.setText("SUBJECT");

        COST.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        COST.setForeground(new java.awt.Color(255, 255, 255));
        COST.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        COST.setText("COST");

        STATUS.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        STATUS.setForeground(new java.awt.Color(255, 255, 255));
        STATUS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STATUS.setText("STATUS");

        EditionText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        EditionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EditionText.setEnabled(false);

        Author2Text.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Author2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Author2Text.setEnabled(false);

        SubjectText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        SubjectText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SubjectText.setEnabled(false);

        CostText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        CostText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostText.setEnabled(false);

        StatusText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        StatusText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StatusText.setEnabled(false);

        TitleText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        TitleText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TitleText.setEnabled(false);

        Author1Text.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Author1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Author1Text.setEnabled(false);

        PublisherText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        PublisherText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PublisherText.setEnabled(false);

        AccessionIDText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        AccessionIDText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AccessionIDText.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PUBLISHER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EDITION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AUTHOR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AUTHOR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(EditionText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(Author2Text, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Author1Text, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PublisherText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(COST, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(STATUS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ACCESSION_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUBJECT, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CostText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(StatusText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubjectText)
                            .addComponent(AccessionIDText, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(TitleText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleText))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AUTHOR1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Author1Text))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AUTHOR2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Author2Text))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDITION, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditionText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PUBLISHER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PublisherText)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ACCESSION_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccessionIDText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(COST, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CostText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SUBJECT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubjectText))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        BFindButton.setBackground(new java.awt.Color(0, 0, 102));
        BFindButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BFindButton.setForeground(new java.awt.Color(255, 255, 255));
        BFindButton.setText("FIND");
        BFindButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BFindButton.setFocusable(false);
        BFindButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BFindButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFindButtonActionPerformed(evt);
            }
        });

        BAddButton.setBackground(new java.awt.Color(0, 0, 102));
        BAddButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BAddButton.setForeground(new java.awt.Color(255, 255, 255));
        BAddButton.setText("ADD");
        BAddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BAddButton.setFocusable(false);
        BAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddButtonActionPerformed(evt);
            }
        });

        BDeleteButton.setBackground(new java.awt.Color(0, 0, 102));
        BDeleteButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        BDeleteButton.setText("DELETE");
        BDeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BDeleteButton.setEnabled(false);
        BDeleteButton.setFocusable(false);
        BDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BDeleteButton.setPreferredSize(new java.awt.Dimension(135, 39));
        BDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteButtonActionPerformed(evt);
            }
        });

        BUpdateButton.setBackground(new java.awt.Color(0, 0, 102));
        BUpdateButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        BUpdateButton.setText("UPDATE");
        BUpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BUpdateButton.setFocusable(false);
        BUpdateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BUpdateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUpdateButtonActionPerformed(evt);
            }
        });

        BEditButton.setBackground(new java.awt.Color(0, 0, 102));
        BEditButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BEditButton.setForeground(new java.awt.Color(255, 255, 255));
        BEditButton.setText("EDIT");
        BEditButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BEditButton.setEnabled(false);
        BEditButton.setFocusable(false);
        BEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditButtonActionPerformed(evt);
            }
        });

        BPrintButton.setBackground(new java.awt.Color(0, 0, 102));
        BPrintButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        BPrintButton.setForeground(new java.awt.Color(255, 255, 255));
        BPrintButton.setText("PRINT");
        BPrintButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BPrintButton.setFocusable(false);
        BPrintButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BPrintButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(BFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(BPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(BUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(BFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(BEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BUpdateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BPrintButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1544, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("BOOKS", jPanel5);

        jPanel7.setBackground(new java.awt.Color(0, 0, 102));

        MagazinesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        MagazinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MagazinesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MagazinesTable);

        jPanel9.setBackground(new java.awt.Color(0, 0, 102));

        MTITLE.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MTITLE.setForeground(new java.awt.Color(255, 255, 255));
        MTITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MTITLE.setText("TITLE");

        MPUBLISHER.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MPUBLISHER.setForeground(new java.awt.Color(255, 255, 255));
        MPUBLISHER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MPUBLISHER.setText("PUBLISHER");

        MVENDOR.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MVENDOR.setForeground(new java.awt.Color(255, 255, 255));
        MVENDOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MVENDOR.setText("VENDOR");

        MVOLUME.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MVOLUME.setForeground(new java.awt.Color(255, 255, 255));
        MVOLUME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MVOLUME.setText("VOLUME");

        MEDITION.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MEDITION.setForeground(new java.awt.Color(255, 255, 255));
        MEDITION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MEDITION.setText("EDITION");

        MAGAZINE_ID.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MAGAZINE_ID.setForeground(new java.awt.Color(255, 255, 255));
        MAGAZINE_ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MAGAZINE_ID.setText("MAGAZINE ID");

        MDATE.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MDATE.setForeground(new java.awt.Color(255, 255, 255));
        MDATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MDATE.setText("DATE");

        MNUMBER.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MNUMBER.setForeground(new java.awt.Color(255, 255, 255));
        MNUMBER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MNUMBER.setText("NUMBER");

        MPERIODICITY.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MPERIODICITY.setForeground(new java.awt.Color(255, 255, 255));
        MPERIODICITY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MPERIODICITY.setText("PERIODICITY");

        MVendorText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MVendorText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MVendorText.setEnabled(false);

        MVolumeText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MVolumeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MVolumeText.setEnabled(false);

        MDateText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MDateText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MDateText.setEnabled(false);

        MNumberText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MNumberText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MNumberText.setEnabled(false);

        MPeriodicityText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MPeriodicityText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MPeriodicityText.setEnabled(false);

        MTitleText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MTitleText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MTitleText.setEnabled(false);

        MEditionText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MEditionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MEditionText.setEnabled(false);

        MPublisherText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MPublisherText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MPublisherText.setEnabled(false);

        MagazineIDText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MagazineIDText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MagazineIDText.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MPUBLISHER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MVENDOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MVOLUME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MEDITION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MTITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MVendorText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(MVolumeText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MEditionText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MPublisherText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MNUMBER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MPERIODICITY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MAGAZINE_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MNumberText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(MPeriodicityText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MDateText)
                            .addComponent(MagazineIDText, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(MTitleText))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MTITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MTitleText))
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MEDITION, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MEditionText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MVOLUME, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MVolumeText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MVENDOR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MVendorText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MPUBLISHER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MPublisherText)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MAGAZINE_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MagazineIDText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MPERIODICITY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MPeriodicityText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MNUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MNumberText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MDateText))))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 0, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        MFindButton.setBackground(new java.awt.Color(0, 0, 102));
        MFindButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MFindButton.setForeground(new java.awt.Color(255, 255, 255));
        MFindButton.setText("FIND");
        MFindButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MFindButton.setFocusable(false);
        MFindButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MFindButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MFindButtonActionPerformed(evt);
            }
        });

        MAddButton.setBackground(new java.awt.Color(0, 0, 102));
        MAddButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MAddButton.setForeground(new java.awt.Color(255, 255, 255));
        MAddButton.setText("ADD");
        MAddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MAddButton.setFocusable(false);
        MAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAddButtonActionPerformed(evt);
            }
        });

        MDeleteButton.setBackground(new java.awt.Color(0, 0, 102));
        MDeleteButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        MDeleteButton.setText("DELETE");
        MDeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MDeleteButton.setEnabled(false);
        MDeleteButton.setFocusable(false);
        MDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MDeleteButton.setPreferredSize(new java.awt.Dimension(135, 39));
        MDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDeleteButtonActionPerformed(evt);
            }
        });

        MUpdateButton.setBackground(new java.awt.Color(0, 0, 102));
        MUpdateButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        MUpdateButton.setText("UPDATE");
        MUpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MUpdateButton.setFocusable(false);
        MUpdateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MUpdateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MUpdateButtonActionPerformed(evt);
            }
        });

        MEditButton.setBackground(new java.awt.Color(0, 0, 102));
        MEditButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MEditButton.setForeground(new java.awt.Color(255, 255, 255));
        MEditButton.setText("EDIT");
        MEditButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MEditButton.setEnabled(false);
        MEditButton.setFocusable(false);
        MEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEditButtonActionPerformed(evt);
            }
        });

        MPrintButton.setBackground(new java.awt.Color(0, 0, 102));
        MPrintButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        MPrintButton.setForeground(new java.awt.Color(255, 255, 255));
        MPrintButton.setText("PRINT");
        MPrintButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MPrintButton.setFocusable(false);
        MPrintButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MPrintButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(MDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(MFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(MAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(MPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(MUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(MFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(MEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MUpdateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MPrintButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("MAGAZINES", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 102));

        JournalsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        JournalsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JournalsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JournalsTable);

        jPanel11.setBackground(new java.awt.Color(0, 0, 102));

        JTITLE.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JTITLE.setForeground(new java.awt.Color(255, 255, 255));
        JTITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTITLE.setText("TITLE");

        JPUBLISHER.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JPUBLISHER.setForeground(new java.awt.Color(255, 255, 255));
        JPUBLISHER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPUBLISHER.setText("PUBLISHER");

        JVENDOR.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JVENDOR.setForeground(new java.awt.Color(255, 255, 255));
        JVENDOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JVENDOR.setText("VENDOR");

        JVOLUME.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JVOLUME.setForeground(new java.awt.Color(255, 255, 255));
        JVOLUME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JVOLUME.setText("VOLUME");

        JEDITION.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JEDITION.setForeground(new java.awt.Color(255, 255, 255));
        JEDITION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JEDITION.setText("EDITION");

        JOURNAL_ID.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JOURNAL_ID.setForeground(new java.awt.Color(255, 255, 255));
        JOURNAL_ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JOURNAL_ID.setText("JOURNAL ID");

        JDATE.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JDATE.setForeground(new java.awt.Color(255, 255, 255));
        JDATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JDATE.setText("DATE");

        JNUMBER.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JNUMBER.setForeground(new java.awt.Color(255, 255, 255));
        JNUMBER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JNUMBER.setText("NUMBER");

        JPERIODICITY.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JPERIODICITY.setForeground(new java.awt.Color(255, 255, 255));
        JPERIODICITY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPERIODICITY.setText("PERIODICITY");

        JVendorText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JVendorText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JVendorText.setEnabled(false);

        JVolumeText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JVolumeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JVolumeText.setEnabled(false);

        JDateText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JDateText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JDateText.setEnabled(false);

        JNumberText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JNumberText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JNumberText.setEnabled(false);

        JPeriodicityText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JPeriodicityText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPeriodicityText.setEnabled(false);

        JTitleText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JTitleText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTitleText.setEnabled(false);

        JEditionText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JEditionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JEditionText.setEnabled(false);

        JPublisherText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JPublisherText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPublisherText.setEnabled(false);

        JournalIDText.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JournalIDText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JournalIDText.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPUBLISHER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JVENDOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JVOLUME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JEDITION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JVendorText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(JVolumeText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JEditionText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JPublisherText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JNUMBER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPERIODICITY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JOURNAL_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JNumberText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(JPeriodicityText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDateText)
                            .addComponent(JournalIDText, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(JTitleText))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTitleText))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JEDITION, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JEditionText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JVOLUME, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JVolumeText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JVENDOR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JVendorText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPUBLISHER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPublisherText)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JOURNAL_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JournalIDText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPERIODICITY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPeriodicityText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JNumberText))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDateText))))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(0, 0, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        JFindButton.setBackground(new java.awt.Color(0, 0, 102));
        JFindButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JFindButton.setForeground(new java.awt.Color(255, 255, 255));
        JFindButton.setText("FIND");
        JFindButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JFindButton.setFocusable(false);
        JFindButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JFindButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFindButtonActionPerformed(evt);
            }
        });

        JAddButton.setBackground(new java.awt.Color(0, 0, 102));
        JAddButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JAddButton.setForeground(new java.awt.Color(255, 255, 255));
        JAddButton.setText("ADD");
        JAddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JAddButton.setFocusable(false);
        JAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAddButtonActionPerformed(evt);
            }
        });

        JDeleteButton.setBackground(new java.awt.Color(0, 0, 102));
        JDeleteButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        JDeleteButton.setText("DELETE");
        JDeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JDeleteButton.setEnabled(false);
        JDeleteButton.setFocusable(false);
        JDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JDeleteButton.setPreferredSize(new java.awt.Dimension(135, 39));
        JDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDeleteButtonActionPerformed(evt);
            }
        });

        JUpdateButton.setBackground(new java.awt.Color(0, 0, 102));
        JUpdateButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        JUpdateButton.setText("UPDATE");
        JUpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JUpdateButton.setFocusable(false);
        JUpdateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JUpdateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUpdateButtonActionPerformed(evt);
            }
        });

        JEditButton.setBackground(new java.awt.Color(0, 0, 102));
        JEditButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JEditButton.setForeground(new java.awt.Color(255, 255, 255));
        JEditButton.setText("EDIT");
        JEditButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JEditButton.setEnabled(false);
        JEditButton.setFocusable(false);
        JEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEditButtonActionPerformed(evt);
            }
        });

        JPrintButton.setBackground(new java.awt.Color(0, 0, 102));
        JPrintButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JPrintButton.setForeground(new java.awt.Color(255, 255, 255));
        JPrintButton.setText("PRINT");
        JPrintButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPrintButton.setFocusable(false);
        JPrintButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JPrintButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPrintButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(JDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(JFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(JAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(JPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(JUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(JFindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(JEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JUpdateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPrintButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("JOURNALS", jPanel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/VisibleFrames/books-icon.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 4, true));

        LOGOUT.setBackground(new java.awt.Color(0, 0, 102));
        LOGOUT.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        LOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisibleFrames/logout.png"))); // NOI18N
        LOGOUT.setText("LOG OUT");
        LOGOUT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LOGOUT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        NAME2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        NAME2.setForeground(new java.awt.Color(255, 255, 255));
        NAME2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAME2.setText("RISHABH VASU");

        NAME1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        NAME1.setForeground(new java.awt.Color(255, 255, 255));
        NAME1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAME1.setText("LUV K AGGARWAL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addComponent(NAME2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(LOGOUT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAME2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NAME1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(LOGOUT)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/VisibleFrames/user_lock.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUpdateButtonActionPerformed
        // TODO add your handling code here:
        empty();
        if( column == null )
            updateTable( false );
        else
            updateTable( true );
        BFindButton.setEnabled(true);
        BPrintButton.setEnabled(true);
        BAddButton.setEnabled(true);
        column = null;
        value = null;
    }//GEN-LAST:event_BUpdateButtonActionPerformed

    private void BFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFindButtonActionPerformed
        // TODO add your handling code here:
        FindBooks frame = new FindBooks();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        column = null;
        value = null;
        BAddButton.setEnabled(false);
        BEditButton.setEnabled(false);
        BDeleteButton.setEnabled(false);
        BPrintButton.setEnabled(false);
        BFindButton.setEnabled(false);
        empty();
    }//GEN-LAST:event_BFindButtonActionPerformed

    private void ViewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTableMouseClicked
        // TODO add your handling code here:
        try{
            int row = ViewTable.getSelectedRow();
            AccessionID = ViewTable.getModel().getValueAt(row, 0).toString();
            String sql = "select AccessionID,"
                    + "AuthorCode1,"
                    + "AuthorCode2,"
                    + "Cost,"
                    + "Edition,"
                    + "PublisherID,"
                    + "Status,"
                    + "SubjectID,"
                    + "Title "
                    + "from Books where AccessionID='"+AccessionID+"';";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if( rs.next() ){
                AccessionIDText.setText( rs.getString("AccessionID") );
                Author1Text.setText( rs.getString("AuthorCode1") );
                Author2Text.setText( rs.getString("AuthorCode2") );
                CostText.setText( rs.getString("Cost") );
                EditionText.setText( rs.getString("Edition") );
                PublisherText.setText( rs.getString("PublisherID") );
                StatusText.setText( rs.getString("Status") );
                SubjectText.setText( rs.getString("SubjectID") );
                TitleText.setText( rs.getString("Title") );
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
        
        BEditButton.setEnabled(true);
        BDeleteButton.setEnabled(true);
    }//GEN-LAST:event_ViewTableMouseClicked

    private void BEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditButtonActionPerformed
        // TODO add your handling code here:
        EditBooks frame = new EditBooks( AccessionID , "EDIT" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        BAddButton.setEnabled(false);
        BEditButton.setEnabled(false);
        BDeleteButton.setEnabled(false);
        BPrintButton.setEnabled(false);
        BFindButton.setEnabled(false);
        empty();
    }//GEN-LAST:event_BEditButtonActionPerformed

    private void BDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteButtonActionPerformed
        // TODO add your handling code here:
        int Choice = JOptionPane.showConfirmDialog( null, "Do you want to delete the entry ?", "Delete", JOptionPane.YES_NO_OPTION );
        
        if( Choice == 0  ){
            try{
                String sql = "delete from Books where AccessionID=?;";
                pst = conn.prepareStatement(sql);
                pst.setString( 1, AccessionIDText.getText() );
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
            empty();
            updateTable( false );
        }
    }//GEN-LAST:event_BDeleteButtonActionPerformed

    private void BPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPrintButtonActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintHeader.png");
        MessageFormat footer = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintFooter.png");

        try{
            ViewTable.print( JTable.PrintMode.FIT_WIDTH , header , footer );
        }catch( java.awt.print.PrinterException e ){
            System.err.format( "Cannot Print %s%n" , e.getMessage() );
        }
    }//GEN-LAST:event_BPrintButtonActionPerformed

    private void BAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddButtonActionPerformed
        // TODO add your handling code here:
        EditBooks frame = new EditBooks( AccessionID , "ADD" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        BAddButton.setEnabled(false);
        BEditButton.setEnabled(false);
        BDeleteButton.setEnabled(false);
        BPrintButton.setEnabled(false);
        BFindButton.setEnabled(false);
        empty();
    }//GEN-LAST:event_BAddButtonActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        updateTable( false );
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        updateTable( "Magazines" , false );
        updateTable( "Journals" , false );
        updateTable( false );
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void MFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MFindButtonActionPerformed
        // TODO add your handling code here:
        FindJournalMagazine frame = new FindJournalMagazine();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        column = null;
        value = null;
        MAddButton.setEnabled(false);
        MEditButton.setEnabled(false);
        MDeleteButton.setEnabled(false);
        MPrintButton.setEnabled(false);
        MFindButton.setEnabled(false);
        mEmpty();
    }//GEN-LAST:event_MFindButtonActionPerformed

    private void MAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAddButtonActionPerformed
        // TODO add your handling code here:
        JournalMagazine frame = new JournalMagazine( AccessionID , "ADD" , "Magazines" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        MAddButton.setEnabled(false);
        MEditButton.setEnabled(false);
        MDeleteButton.setEnabled(false);
        MPrintButton.setEnabled(false);
        MFindButton.setEnabled(false);
        mEmpty();
    }//GEN-LAST:event_MAddButtonActionPerformed

    private void MDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDeleteButtonActionPerformed
        // TODO add your handling code here:
        int Choice = JOptionPane.showConfirmDialog( null, "Do you want to delete the entry ?", "Delete", JOptionPane.YES_NO_OPTION );
        
        if( Choice == 0  ){
            try{
                String sql = "delete from Magazines where ID=?;";
                pst = conn.prepareStatement(sql);
                pst.setString( 1, MagazineIDText.getText() );
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
            mEmpty();
            updateTable( "Magazines" , false );
        }
    }//GEN-LAST:event_MDeleteButtonActionPerformed

    private void MUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MUpdateButtonActionPerformed
        // TODO add your handling code here:
        mEmpty();
        if( column == null )
            updateTable( "Magazines" , false );
        else
            updateTable( "Magazines" , true );
        column = null;
        value = null;
        MFindButton.setEnabled(true);
        MPrintButton.setEnabled(true);
        MAddButton.setEnabled(true);
    }//GEN-LAST:event_MUpdateButtonActionPerformed

    private void MEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEditButtonActionPerformed
        // TODO add your handling code here:
        JournalMagazine frame = new JournalMagazine( AccessionID , "EDIT" , "Magazines" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        MAddButton.setEnabled(false);
        MEditButton.setEnabled(false);
        MDeleteButton.setEnabled(false);
        MPrintButton.setEnabled(false);
        MFindButton.setEnabled(false);
        mEmpty();
    }//GEN-LAST:event_MEditButtonActionPerformed

    private void MPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPrintButtonActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintHeader.png");
        MessageFormat footer = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintFooter.png");

        try{
            MagazinesTable.print( JTable.PrintMode.FIT_WIDTH , header , footer );
        }catch( java.awt.print.PrinterException e ){
            System.err.format( "Cannot Print %s%n" , e.getMessage() );
        }
    }//GEN-LAST:event_MPrintButtonActionPerformed

    private void JFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFindButtonActionPerformed
        // TODO add your handling code here:
        FindJournalMagazine frame = new FindJournalMagazine();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        column = null;
        value = null;
        JAddButton.setEnabled(false);
        JEditButton.setEnabled(false);
        JDeleteButton.setEnabled(false);
        JPrintButton.setEnabled(false);
        JFindButton.setEnabled(false);
        jEmpty();
    }//GEN-LAST:event_JFindButtonActionPerformed

    private void JAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAddButtonActionPerformed
        // TODO add your handling code here:
        JournalMagazine frame = new JournalMagazine( AccessionID , "ADD" , "Journals" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JAddButton.setEnabled(false);
        JEditButton.setEnabled(false);
        JDeleteButton.setEnabled(false);
        JPrintButton.setEnabled(false);
        JFindButton.setEnabled(false);
        jEmpty();
    }//GEN-LAST:event_JAddButtonActionPerformed

    private void JDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDeleteButtonActionPerformed
        // TODO add your handling code here:
        int Choice = JOptionPane.showConfirmDialog( null, "Do you want to delete the entry ?", "Delete", JOptionPane.YES_NO_OPTION );
        
        if( Choice == 0  ){
            try{
                String sql = "delete from Journals where ID=?;";
                pst = conn.prepareStatement(sql);
                pst.setString( 1, JournalIDText.getText() );
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
            jEmpty();
            updateTable( "Journals" , false );
        }
    }//GEN-LAST:event_JDeleteButtonActionPerformed

    private void JUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUpdateButtonActionPerformed
        // TODO add your handling code here:
        jEmpty();
        if( column == null )
            updateTable( "Journals" , false );
        else
            updateTable( "Journals" , true );
        column = null;
        value = null;
        JFindButton.setEnabled(true);
        JPrintButton.setEnabled(true);
        JAddButton.setEnabled(true);
    }//GEN-LAST:event_JUpdateButtonActionPerformed

    private void JEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEditButtonActionPerformed
        // TODO add your handling code here:
        JournalMagazine frame = new JournalMagazine( AccessionID , "EDIT" , "Journals" );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JAddButton.setEnabled(false);
        JEditButton.setEnabled(false);
        JDeleteButton.setEnabled(false);
        JPrintButton.setEnabled(false);
        JFindButton.setEnabled(false);
        jEmpty();
    }//GEN-LAST:event_JEditButtonActionPerformed

    private void JPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPrintButtonActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintHeader.png");
        MessageFormat footer = new MessageFormat("C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\PrintFooter.png");

        try{
            JournalsTable.print( JTable.PrintMode.FIT_WIDTH , header , footer );
        }catch( java.awt.print.PrinterException e ){
            System.err.format( "Cannot Print %s%n" , e.getMessage() );
        }
    }//GEN-LAST:event_JPrintButtonActionPerformed

    private void MagazinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MagazinesTableMouseClicked
        // TODO add your handling code here:
        try{
            int row = MagazinesTable.getSelectedRow();
            AccessionID = MagazinesTable.getModel().getValueAt(row, 0).toString();
            String sql = "select ID,"
                    + "Title,"
                    + "PublisherID,"
                    + "Vendor,"
                    + "Periodicity,"
                    + "Edition,"
                    + "Volume,"
                    + "Number,"
                    + "ReceiptDate "
                    + "from Magazines where ID='"+AccessionID+"';";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if( rs.next() ){
                MagazineIDText.setText( rs.getString("ID") );
                MTitleText.setText( rs.getString("Title") );
                MPublisherText.setText( rs.getString("PublisherID") );
                MVendorText.setText( rs.getString("Vendor") );
                MEditionText.setText( rs.getString("Edition") );
                MPeriodicityText.setText( rs.getString("Periodicity") );
                MVolumeText.setText( rs.getString("Volume") );
                MDateText.setText( rs.getString("ReceiptDate") );
                MNumberText.setText( rs.getString("Number") );
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
        
        MEditButton.setEnabled(true);
        MDeleteButton.setEnabled(true);
    }//GEN-LAST:event_MagazinesTableMouseClicked

    private void JournalsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JournalsTableMouseClicked
        // TODO add your handling code here:
        try{
            int row = JournalsTable.getSelectedRow();
            AccessionID = JournalsTable.getModel().getValueAt(row, 0).toString();
            String sql = "select ID,"
                    + "Title,"
                    + "PublisherID,"
                    + "Vendor,"
                    + "Periodicity,"
                    + "Edition,"
                    + "Volume,"
                    + "Number,"
                    + "ReceiptDate "
                    + "from Journals where ID='"+AccessionID+"';";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if( rs.next() ){
                JournalIDText.setText( rs.getString("ID") );
                JTitleText.setText( rs.getString("Title") );
                JPublisherText.setText( rs.getString("PublisherID") );
                JVendorText.setText( rs.getString("Vendor") );
                JEditionText.setText( rs.getString("Edition") );
                JPeriodicityText.setText( rs.getString("Periodicity") );
                JVolumeText.setText( rs.getString("Volume") );
                JDateText.setText( rs.getString("ReceiptDate") );
                JNumberText.setText( rs.getString("Number") );
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
        
        JEditButton.setEnabled(true);
        JDeleteButton.setEnabled(true);
    }//GEN-LAST:event_JournalsTableMouseClicked

    private void ScanBookCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanBookCodeActionPerformed
        // TODO add your handling code here:
        
        BookCode.setEnabled( true );
        FindBook.setEnabled( true );
        ScanBookCode.setEnabled( false );
    }//GEN-LAST:event_ScanBookCodeActionPerformed

    private void ScanStudentCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanStudentCodeActionPerformed
        // TODO add your handling code here:
        StudentCode.setEnabled( true );
        FindStudent.setEnabled( true );
        ScanStudentCode.setEnabled( false );
    }//GEN-LAST:event_ScanStudentCodeActionPerformed

    private void FindBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindBookActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql = "select * from Books where BarCode='"+BookCode.getText()+"';";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if( rs.next() ){
                BookTitleText.setText( rs.getString("Title") );
                BookAuthor1Text.setText( rs.getString("AuthorCode1") );
                BookAuthor2Text.setText( rs.getString("AuthorCode2") );
                BookAccessionIDText.setText( rs.getString("AccessionID") );
                BookStatusText.setText( rs.getString("Status") );
                BookEditionText.setText( rs.getString("Edition") );
                BookCostText.setText( rs.getString("Cost") );
                BookPublisherText.setText( rs.getString("PublisherID") );
                BookSubjectText.setText( rs.getString("SubjectID") );
            }
            else{
                JOptionPane.showMessageDialog( null, "No record found!!" );
                BookCode.setText(null);
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
        
        BookCode.setEnabled( false );
        FindBook.setEnabled( false );
        ScanBookCode.setEnabled( true );
        
        
        if( BookStatusText.getText().equals("AVAILABLE") )
            IssueButton.setEnabled( true );
        else
            ReturnButton.setEnabled( true );
        
    }//GEN-LAST:event_FindBookActionPerformed

    private void FindStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindStudentActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql = "select * from Students where Barcode='"+StudentCode.getText()+"';";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            float fine = 0;
            long days;
            Date date1 = new Date(),date2;
            
            if( rs.next() ){
                StudentNameText.setText( rs.getString("Name") );
                ClassText.setText( rs.getString("Class") );
                RollNoText.setText( rs.getString("RollNo") );
                IssuedText.setText( rs.getString("Issued") );
                
                Book1AccessionID.setText( rs.getString("Book1AccessionID") );
                Book1Title.setText( rs.getString("Book1Title") );                
                Book1IssueDate.setText( rs.getString("Book1IssueDate") );
                Book1DueDate.setText( rs.getString("Book1DueDate") );
                if( !("".equals(Book1DueDate.getText())) ){
                    date2 = new SimpleDateFormat("yyyy-MM-dd").parse(Book1DueDate.getText());
                    if( date1.after(date2) ){
                        days = Math.abs( date2.getTime() - date1.getTime() )/(1000*60*60*24);
                        fine = ( days + 2 )*10;
                    }
                    else
                        fine = 0;
                }                
                Book1Fine.setText( String.valueOf(fine) );
                
                Book2AccessionID.setText( rs.getString("Book2AccessionID") );
                Book2Title.setText( rs.getString("Book2Title") );
                Book2IssueDate.setText( rs.getString("Book2IssueDate") );
                Book2DueDate.setText( rs.getString("Book2DueDate") );
                if( !("".equals(Book2DueDate.getText())) ){
                    date2 = new SimpleDateFormat("yyyy-MM-dd").parse(Book2DueDate.getText());
                    if( date1.after(date2) ){
                        days = Math.abs( date2.getTime() - date1.getTime() )/(1000*60*60*24);
                        fine = ( days + 2 )*10;
                    }
                    else
                        fine = 0;
                }
                Book2Fine.setText( String.valueOf(fine) );
                
                Book3AccessionID.setText( rs.getString("Book3AccessionID") );
                Book3Title.setText( rs.getString("Book3Title") );
                Book3IssueDate.setText( rs.getString("Book3IssueDate") );
                Book3DueDate.setText( rs.getString("Book3DueDate") );
                if( !("".equals(Book3DueDate.getText())) ){
                    date2 = new SimpleDateFormat("yyyy-MM-dd").parse(Book3DueDate.getText());
                    if( date1.after(date2) ){
                        days = Math.abs( date2.getTime() - date1.getTime() )/(1000*60*60*24);
                        fine = ( days + 2 )*10;
                    }
                    else
                        fine = 0;
                }
                Book3Fine.setText( String.valueOf(fine) );
                
                fine += Float.valueOf(Book1Fine.getText());
                fine += Float.valueOf(Book2Fine.getText());
                TotalFineText.setText( String.valueOf(fine) );
            }
            else{
                JOptionPane.showMessageDialog( null, "No record found!!" );
                StudentCode.setText(null);
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
        
        StudentCode.setEnabled( false );
        FindStudent.setEnabled( false );
        ScanStudentCode.setEnabled( true );
        
    }//GEN-LAST:event_FindStudentActionPerformed

    private void IssueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueButtonActionPerformed
        // TODO add your handling code here:
        if( Integer.valueOf( IssuedText.getText() ) == 3 )
            JOptionPane.showMessageDialog( null, "Already Issued 3 Books!!" );
        else{
            int number = Integer.valueOf( IssuedText.getText() );
            number ++;
            Calendar cal = Calendar.getInstance();
            cal.setTime( new Date() );
            cal.add( Calendar.DATE , 15 );
            switch( number ){
                case 1 :Book1AccessionID.setText( BookAccessionIDText.getText() );
                        Book1Title.setText( BookTitleText.getText() );                
                        Book1IssueDate.setText( String.valueOf( new Date() ) );
                        Book1DueDate.setText( String.valueOf( cal.getTime() ) );
                        Book1Fine.setText( null );
                    break;
                case 2 :Book2AccessionID.setText( BookAccessionIDText.getText() );
                        Book2Title.setText( BookTitleText.getText() );
                        Book2IssueDate.setText( new SimpleDateFormat("yyyy-MM-dd").format( new Date() ) );
                        Book2DueDate.setText( new SimpleDateFormat("yyyy-MM-dd").format( cal.getTime() ) );
                        Book2Fine.setText( null );
                    break;
                case 3 :Book3AccessionID.setText( BookAccessionIDText.getText() );
                        Book3Title.setText( BookTitleText.getText() );
                        Book3IssueDate.setText( String.valueOf( new Date() ) );
                        Book3DueDate.setText( String.valueOf( cal.getTime() ) );
                        Book3Fine.setText( null );
                    break;
            }
            IssuedText.setText( String.valueOf(number) );
        }
        IssueButton.setEnabled(false);
        BookStatusText.setText( "ISSUED" );
        Update();
        JOptionPane.showMessageDialog( null, "Book has been Issued!!" );
    }//GEN-LAST:event_IssueButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        loop();
        BookTitleText.setText( null );
        BookAuthor1Text.setText( null );
        BookAuthor2Text.setText( null );
        BookAccessionIDText.setText( null );
        BookStatusText.setText( null );
        BookEditionText.setText( null );
        BookCostText.setText( null );
        BookPublisherText.setText( null );
        BookSubjectText.setText( null );
        
        StudentNameText.setText( null );
        ClassText.setText( null );
        RollNoText.setText( null );
        IssuedText.setText( null );
        Book1AccessionID.setText( null );
        Book1Title.setText( null );                
        Book1IssueDate.setText( null );
        Book1DueDate.setText( null );
        Book1Fine.setText( null );
        Book2AccessionID.setText( null );
        Book2Title.setText( null );
        Book2IssueDate.setText( null );
        Book2DueDate.setText( null );
        Book2Fine.setText( null );
        Book3AccessionID.setText( null );
        Book3Title.setText( null );
        Book3IssueDate.setText( null );
        Book3DueDate.setText( null );
        Book3Fine.setText( null );
        TotalFineText.setText( null );
        
        BookCode.setEnabled( false );
        FindBook.setEnabled( false );
        ScanBookCode.setEnabled( true );
        StudentCode.setEnabled( false );
        FindStudent.setEnabled( false );
        ScanStudentCode.setEnabled( true );
        IssueButton.setEnabled(false);
        ReturnButton.setEnabled(false);
        BookCode.setText( null );
        StudentCode.setText( null );                
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        if( Book1AccessionID.getText().equals(BookAccessionIDText.getText()) ){
            JOptionPane.showMessageDialog( null, "Book Returned!!" );
            Book1AccessionID.setText( null );
            Book1Title.setText( null );                
            Book1IssueDate.setText( null );
            Book1DueDate.setText( null );
            Book1Fine.setText( null );
            BookStatusText.setText( "AVAILABLE" );
            int number = Integer.valueOf( IssuedText.getText() );
            number --;
            IssuedText.setText( String.valueOf(number) );
            Update();
        }
        else if( Book2AccessionID.getText().equals(BookAccessionIDText.getText()) ){
            JOptionPane.showMessageDialog( null, "Book Returned!!" );
            Book2AccessionID.setText( null );
            Book2Title.setText( null );                
            Book2IssueDate.setText( null );
            Book2DueDate.setText( null );
            Book2Fine.setText( null );
            BookStatusText.setText( "AVAILABLE" );
            int number = Integer.valueOf( IssuedText.getText() );
            number --;
            IssuedText.setText( String.valueOf(number) );
            Update();
        }
        else if( Book3AccessionID.getText().equals(BookAccessionIDText.getText()) ){
            JOptionPane.showMessageDialog( null, "Book Returned!!" );
            Book3AccessionID.setText( null );
            Book3Title.setText( null );                
            Book3IssueDate.setText( null );
            Book3DueDate.setText( null );
            Book3Fine.setText( null );
            BookStatusText.setText( "AVAILABLE" );
            int number = Integer.valueOf( IssuedText.getText() );
            number --;
            IssuedText.setText( String.valueOf(number) );
            Update();
        }
        else
            JOptionPane.showMessageDialog( null, "Book is not issued by this Student!!" );
    }//GEN-LAST:event_ReturnButtonActionPerformed

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent( this , WindowEvent.WINDOW_CLOSING );
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
        close();
        LoginWindow frame = new LoginWindow();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void Update(){
        try{
            String sql = "update Books set Status='" + BookStatusText.getText() + "' "
                    + "where AccessionID='"+ BookAccessionIDText.getText() +"';";
            pst = conn.prepareStatement( sql );
            pst.execute();
            
            sql = "update Students set Book1AccessionID='" + Book1AccessionID.getText() + "' ,"
                    + "Book1Title='" + Book1Title.getText() + "' ,"
                    + "Book1IssueDate='" + Book1IssueDate.getText() + "' ,"
                    + "Book1DueDate='" + Book1DueDate.getText() + "' ,"
                    + "Book1Fine='" + Book1Fine.getText() + "' ,"
                    + "Book2AccessionID='" + Book2AccessionID.getText() + "' ,"
                    + "Book2Title='" + Book2Title.getText() + "' ,"
                    + "Book2IssueDate='" + Book2IssueDate.getText() + "' ,"
                    + "Book2DueDate='" + Book2DueDate.getText() + "' ,"
                    + "Book2Fine='" + Book2Fine.getText() + "' ,"
                    + "Book3AccessionID='" + Book3AccessionID.getText() + "' ,"
                    + "Book3Title='" + Book3Title.getText() + "' ,"
                    + "Book3IssueDate='" + Book3IssueDate.getText() + "' ,"
                    + "Book3DueDate='" + Book3DueDate.getText() + "' ,"
                    + "Book3Fine='" + Book3Fine.getText() + "' ,"
                    + "Fine='" + TotalFineText.getText() + "' ,"
                    + "Issued='" + IssuedText.getText() + "' "
                    + "where RollNo='"+RollNoText.getText()+"';";
            pst = conn.prepareStatement( sql );
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
    }
    
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
            java.util.logging.Logger.getLogger(librarianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(librarianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(librarianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(librarianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new librarianHome().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACCESSION_ID;
    private javax.swing.JLabel AUTHOR1;
    private javax.swing.JLabel AUTHOR2;
    private javax.swing.JLabel AccessionIDLabel;
    private javax.swing.JTextField AccessionIDText;
    private javax.swing.JTextField Author1Text;
    private javax.swing.JTextField Author2Text;
    private javax.swing.JButton BAddButton;
    private javax.swing.JButton BDeleteButton;
    private javax.swing.JButton BEditButton;
    private javax.swing.JButton BFindButton;
    private javax.swing.JButton BPrintButton;
    private javax.swing.JButton BUpdateButton;
    private javax.swing.JTextField Book1AccessionID;
    private javax.swing.JTextField Book1DueDate;
    private javax.swing.JTextField Book1Fine;
    private javax.swing.JTextField Book1IssueDate;
    private javax.swing.JTextField Book1Title;
    private javax.swing.JTextField Book2AccessionID;
    private javax.swing.JTextField Book2DueDate;
    private javax.swing.JTextField Book2Fine;
    private javax.swing.JTextField Book2IssueDate;
    private javax.swing.JTextField Book2Title;
    private javax.swing.JTextField Book3AccessionID;
    private javax.swing.JTextField Book3DueDate;
    private javax.swing.JTextField Book3Fine;
    private javax.swing.JTextField Book3IssueDate;
    private javax.swing.JTextField Book3Title;
    private javax.swing.JLabel BookAccessionIDLabel;
    private javax.swing.JTextField BookAccessionIDText;
    private javax.swing.JLabel BookAuthor1Label;
    private javax.swing.JTextField BookAuthor1Text;
    private javax.swing.JLabel BookAuthor2Label;
    private javax.swing.JTextField BookAuthor2Text;
    private javax.swing.JTextField BookCode;
    private javax.swing.JLabel BookCostLabel;
    private javax.swing.JTextField BookCostText;
    private javax.swing.JLabel BookEditionLabel;
    private javax.swing.JTextField BookEditionText;
    private javax.swing.JLabel BookFineLabel;
    private javax.swing.JLabel BookPublisherLabel;
    private javax.swing.JTextField BookPublisherText;
    private javax.swing.JLabel BookStatusLabel;
    private javax.swing.JTextField BookStatusText;
    private javax.swing.JLabel BookSubjectLabel;
    private javax.swing.JTextField BookSubjectText;
    private javax.swing.JLabel BookTitleLabel;
    private javax.swing.JTextField BookTitleText;
    private javax.swing.JLabel COST;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JTextField ClassText;
    private javax.swing.JTextField CostText;
    private javax.swing.JLabel DueDateLabel;
    private javax.swing.JLabel EDITION;
    private javax.swing.JTextField EditionText;
    private javax.swing.JButton FindBook;
    private javax.swing.JButton FindStudent;
    private javax.swing.JButton IssueButton;
    private javax.swing.JLabel IssueDateLabel;
    private javax.swing.JLabel IssuedLabel;
    private javax.swing.JTextField IssuedText;
    private javax.swing.JButton JAddButton;
    private javax.swing.JLabel JDATE;
    private javax.swing.JTextField JDateText;
    private javax.swing.JButton JDeleteButton;
    private javax.swing.JLabel JEDITION;
    private javax.swing.JButton JEditButton;
    private javax.swing.JTextField JEditionText;
    private javax.swing.JButton JFindButton;
    private javax.swing.JLabel JNUMBER;
    private javax.swing.JTextField JNumberText;
    private javax.swing.JLabel JOURNAL_ID;
    private javax.swing.JLabel JPERIODICITY;
    private javax.swing.JLabel JPUBLISHER;
    private javax.swing.JTextField JPeriodicityText;
    private javax.swing.JButton JPrintButton;
    private javax.swing.JTextField JPublisherText;
    private javax.swing.JLabel JTITLE;
    private javax.swing.JTextField JTitleText;
    private javax.swing.JButton JUpdateButton;
    private javax.swing.JLabel JVENDOR;
    private javax.swing.JLabel JVOLUME;
    private javax.swing.JTextField JVendorText;
    private javax.swing.JTextField JVolumeText;
    private javax.swing.JTextField JournalIDText;
    private javax.swing.JTable JournalsTable;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JLabel MAGAZINE_ID;
    private javax.swing.JButton MAddButton;
    private javax.swing.JLabel MDATE;
    private javax.swing.JTextField MDateText;
    private javax.swing.JButton MDeleteButton;
    private javax.swing.JLabel MEDITION;
    private javax.swing.JButton MEditButton;
    private javax.swing.JTextField MEditionText;
    private javax.swing.JButton MFindButton;
    private javax.swing.JLabel MNUMBER;
    private javax.swing.JTextField MNumberText;
    private javax.swing.JLabel MPERIODICITY;
    private javax.swing.JLabel MPUBLISHER;
    private javax.swing.JTextField MPeriodicityText;
    private javax.swing.JButton MPrintButton;
    private javax.swing.JTextField MPublisherText;
    private javax.swing.JLabel MTITLE;
    private javax.swing.JTextField MTitleText;
    private javax.swing.JButton MUpdateButton;
    private javax.swing.JLabel MVENDOR;
    private javax.swing.JLabel MVOLUME;
    private javax.swing.JTextField MVendorText;
    private javax.swing.JTextField MVolumeText;
    private javax.swing.JTextField MagazineIDText;
    private javax.swing.JTable MagazinesTable;
    private javax.swing.JLabel NAME1;
    private javax.swing.JLabel NAME2;
    private javax.swing.JLabel PUBLISHER;
    private javax.swing.JTextField PublisherText;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel RollNoLabel;
    private javax.swing.JTextField RollNoText;
    private javax.swing.JLabel STATUS;
    private javax.swing.JLabel SUBJECT;
    private javax.swing.JButton ScanBookCode;
    private javax.swing.JButton ScanStudentCode;
    private javax.swing.JTextField StatusText;
    private javax.swing.JTextField StudentCode;
    private javax.swing.JLabel StudentNameLabel;
    private javax.swing.JTextField StudentNameText;
    private javax.swing.JTextField SubjectText;
    private javax.swing.JLabel TITLE;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleText;
    private javax.swing.JLabel TotalFineLabel;
    private javax.swing.JTextField TotalFineText;
    private javax.swing.JTable ViewTable;
    private javax.swing.JLabel image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    // End of variables declaration//GEN-END:variables
}
