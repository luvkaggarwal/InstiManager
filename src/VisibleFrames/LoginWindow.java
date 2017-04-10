/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisibleFrames;

import com.sun.glass.events.KeyEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

/**
 *
 * @author LUV
 */
public class LoginWindow extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        this.setLayout( new BorderLayout() ); 
        //this.setContentPane( new JLabel( new ImageIcon ( "C:\\Users\\LUV\\Documents\\NetBeansProjects\\Project\\Images\\Login_background.jpg" ) ) );
        this.setLayout( new FlowLayout() );
        initComponents();
        conn = FunctionClasses.DataBaseConnection.ConnectDB();
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
        PasswordLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setName("login"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setToolTipText("");

        PasswordLabel.setFont(new java.awt.Font("Myanmar Text", 1, 36)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("Password");

        LoginButton.setBackground(new java.awt.Color(0, 0, 102));
        LoginButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginButtonKeyPressed(evt);
            }
        });

        txt_username.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_username.setForeground(new java.awt.Color(0, 0, 102));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("Myanmar Text", 1, 36)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UsernameLabel.setText("Username");

        txt_password.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_password.setForeground(new java.awt.Color(0, 0, 102));
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_username)
                    .addComponent(txt_password))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(LoginButton)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UsernameLabel)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginButtonKeyPressed
        // TODO add your handling code here:
        if( evt.getKeyCode() == KeyEvent.VK_ENTER )
            Login();
    }//GEN-LAST:event_LoginButtonKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:
        if( evt.getKeyCode() == KeyEvent.VK_ENTER )
            Login();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void Login(){
        String sql = "select * from user where u_id=? and password=?";
        try{
            pst = conn.prepareStatement(sql);
            String userid = txt_username.getText();
            pst.setString( 1, userid );
            pst.setString( 2, txt_password.getText() );
            
            rs = pst.executeQuery();
            if( rs.next() ){
                //JOptionPane.showMessageDialog( null, "Username and Password is correct" );
                //StartNewWindow and set its visibility = true
                if( rs.getString("job").equals("student") )
                {
                    close();
                    studentHome frame = new studentHome( userid );
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                else if( rs.getString("job").equals("teacher") ){
                    close();
                    teacherHome frame = new teacherHome();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                else if( rs.getString("job").equals("parent") ){
                    close();
                    parentHome frame = new parentHome();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }else if( rs.getString("job").equals("accounts") ){
                    close();
                    accountsHome frame = new accountsHome();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }else if( rs.getString("job").equals("management") ){
                    close();
                    adminHome frame = new adminHome();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }else if( rs.getString("job").equals("librarian") ){
                    close();
                    librarianHome frame = new librarianHome( "librarian",userid );
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }else {
                    close();
                    logisticsHome frame = new logisticsHome();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            else
                JOptionPane.showMessageDialog( null, "Username and Password is not correct" );
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
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final LoginWindow frame = new LoginWindow();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
