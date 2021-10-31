/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tebellum
 */
public class CategoryDBConnect extends DBConnect {

       public ArrayList<Category> getcates() {
              ArrayList<Category> cates = new ArrayList<>();
              try {
                     String sql_getProduct = "SELECT * FROM [Category]";
                     PreparedStatement ps = connection.prepareStatement(sql_getProduct);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Category c = new Category();
                            c.setCid(rs.getInt(1));
                            c.setCname(rs.getString(2));
                            cates.add(c);
                     }
              } catch (SQLException ex) {
                     Logger.getLogger(CategoryDBConnect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return cates;

       }
//        public static void main(String[] args) {
//        CategoryDBConnect p = new CategoryDBConnect();
//        for (Category pr : p.getcates()) {
//            System.out.println(pr.getCname());
//        }
//    }

}
