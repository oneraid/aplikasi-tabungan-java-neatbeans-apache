/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;
import static Connection.Koneksi.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ridhw
 */
public class Login {
    String username;
    String password;
    
    public Login( String pUsername, String pPassword){
        this.username = pUsername;
        this.password = pPassword;
    }
    
    public static void LoginAdmin(JTextField pusername, JTextField ppasword) {
        try {
            String query = "select * from user where username= ? and password = ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1, pusername.getText());
            pst.setString(2, ppasword.getText());
            rst = pst.executeQuery();
            if (rst.next()) {
                new AJframe.JmainMenu().setVisible(true);
                SwingUtilities.getWindowAncestor(pusername).dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void LoginMhs(JTextField pusername, JTextField ppasword){
        try {
            String query = "select * from mahasiswa where nama= ? and nim = ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1, pusername.getText());
            pst.setString(2, ppasword.getText());
            rst = pst.executeQuery();
            if (rst.next()) {
                new AJframe.JShow(rst.getString(1)).setVisible(true);
                SwingUtilities.getWindowAncestor(pusername).dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean isAdmin(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ? AND user_type = 'admin'";
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rst = pst.executeQuery();
            if (rst.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void GetNama(String pNim, String OldName, JLabel BalTbl ){
        
            try {
                String query = "select * from mahasiswa where nim= ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, pNim);
                rst = pst.executeQuery();
                if(rst.next()){
                   OldName = rst.getString(2);
                   BalTbl.setText(""+OldName);
                }else{
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public static void GetJenisKelamin(String pNim, String OldName, JLabel BalTbl ){
        
            try {
                String query = "select * from mahasiswa where nim= ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, pNim);
                rst = pst.executeQuery();
                if(rst.next()){
                   OldName = rst.getString(3);
                   BalTbl.setText(""+OldName);
                }else{
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public static void GetJurusan(String pNim, String OldName, JLabel BalTbl ){
        
            try {
                String query = "select * from mahasiswa where nim= ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, pNim);
                rst = pst.executeQuery();
                if(rst.next()){
                   OldName = rst.getString(4);
                   BalTbl.setText(""+OldName);
                }else{
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public static void GetStatus(String pNim, String OldName, JLabel BalTbl ){
        
            try {
                String query = "select * from mahasiswa where nim= ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, pNim);
                rst = pst.executeQuery();
                if(rst.next()){
                   OldName = rst.getString(6);
                   BalTbl.setText(""+OldName);
                }else{
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public static void GetBalance(String pNim, int OldBalance, JLabel BalTbl ){
        
            try {
                String query = "select * from mahasiswa where nim= ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, pNim);
                rst = pst.executeQuery();
                if(rst.next()){
                   OldBalance = rst.getInt(5);
                   BalTbl.setText(""+OldBalance);
                }else{
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    

}
