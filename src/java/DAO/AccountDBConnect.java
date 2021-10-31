/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tebellum
 */
public class AccountDBConnect extends DBConnect {

    public Account getAcc(String user, String pass) {
        try {
            String sql = "select * from Account \n"
                    + "where [user] = ?\n"
                    + "and pass = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt(1));
                acc.setUser(rs.getString(2));
                acc.setPass(rs.getString(3));
                acc.setIsSell(rs.getInt(4));
                acc.setIsAdmin(rs.getInt(5));

                return acc;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account check_acc_exist(String user) {
        try {
            String sql = "select * from Account \n"
                    + "where [user] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt(1));
                acc.setUser(rs.getString(2));
                acc.setPass(rs.getString(3));
                acc.setIsSell(rs.getInt(4));
                acc.setIsAdmin(rs.getInt(5));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setAcc(String user, String pass) {
        try {
            String sql = "INSERT INTO [Account]\n"
                    + "     VALUES\n"
                    + "           (?,?,0,0)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user );
            ps.setString(2,pass );
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
