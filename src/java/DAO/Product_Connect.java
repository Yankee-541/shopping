/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
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
public class Product_Connect extends DBConnect {

       public void uploadProduct(Product p, String id, String category) {
              try {
                     String sql = "UPDATE [product]\n"
                             + "   SET [name] = ?\n"
                             + "      ,[image] = ?\n"
                             + "      ,[price] = ?\n"
                             + "      ,[title] = ?\n"
                             + "      ,[description] = ?\n"
                             + "      ,[cateID] = ?\n"
                             + " WHERE product.id = ?";
                     PreparedStatement ps = connection.prepareStatement(sql);
                     ps.setString(1, p.getName());
                     ps.setString(2, p.getImage());
                     ps.setDouble(3, p.getPrice());
                     ps.setString(4, p.getTittle());
                     ps.setString(5, p.getDescription());
                     ps.setString(6, category);
                     ps.setString(7, id);
                     ps.executeUpdate();
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }

       }

       public void insertProduct(Product p, String category, int sell_id) {
              try {
                     String sql = "INSERT INTO [product]\n"
                             + "           ([name]\n"
                             + "           ,[image]\n"
                             + "           ,[price]\n"
                             + "           ,[title]\n"
                             + "           ,[description]\n"
                             + "           ,[cateID]\n"
                             + "           ,[sell_ID])\n"
                             + "     VALUES\n"
                             + "           (?,?,?,?,?,?,?)";
                     PreparedStatement ps = connection.prepareStatement(sql);
                     ps.setString(1, p.getName());
                     ps.setString(2, p.getImage());
                     ps.setDouble(3, p.getPrice());
                     ps.setString(4, p.getTittle());
                     ps.setString(5, p.getDescription());
                     ps.setString(6, category);
                     ps.setInt(7, sell_id);
                     ps.executeUpdate();

              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
       }

       public ArrayList<Product> getAllProduct() {
              ArrayList<Product> product = new ArrayList<>();
              try {
                     String sql_getProduct = "SELECT * FROM [product]";
                     PreparedStatement ps = connection.prepareStatement(sql_getProduct);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt(1));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setDescription(rs.getString(6));

                            product.add(p);
                     }
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return product;
       }

       public ArrayList<Product> getAllProduct_byCid(String cid) {
              ArrayList<Product> product = new ArrayList<>();
              try {
                     String sql_getProduct = "select * from product where cateID = ?";
                     PreparedStatement ps = connection.prepareStatement(sql_getProduct);
                     ps.setString(1, cid);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt(1));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setDescription(rs.getString(6));
                            product.add(p);
                     }
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return product;
       }

       public void deleteProduct(String id) {
              try {
                     String sql = "DELETE FROM [product]\n"
                             + "      WHERE id = ?";
                     PreparedStatement ps = connection.prepareStatement(sql);
                     ps.setString(1, id);
                     ps.executeUpdate();
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }

       }

       public ArrayList<Product> getProduct_sellId(int sell_id) {
              ArrayList<Product> product = new ArrayList<>();
              try {
                     String sql_getProduct = "select * from product where sell_ID = ?";
                     PreparedStatement ps = connection.prepareStatement(sql_getProduct);
                     ps.setInt(1, sell_id);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt(1));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setDescription(rs.getString(6));
                            product.add(p);
                     }
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return product;
       }

       public Product getProduct_Detail(String pid) {
              try {
                     String sql_getProduct = "select * from product where id = ? ";
                     PreparedStatement ps = connection.prepareStatement(sql_getProduct);
                     ps.setString(1, pid);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt(1));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setDescription(rs.getString(6));
                            return p;
                     }
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return null;
       }

       public Product getLast() {
              try {
                     String sql = "SELECT top 1 * FROM [product]\n"
                             + "order by id desc";
                     PreparedStatement ps = connection.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt("id"));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setTittle(rs.getString(6));
                            return p;
                     }

              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return null;
       }

       public ArrayList<Product> search_product(String name) {
              ArrayList<Product> search_pro = new ArrayList<>();
              try {
                     String sql = "select * from product\n"
                             + "where [name] like ?";
                     PreparedStatement ps = connection.prepareStatement(sql);
                     ps.setString(1, '%' + name + '%');
                     ResultSet rs = ps.executeQuery();
                     while (rs.next()) {
                            Product p = new Product();
                            p.setId(rs.getInt(1));
                            p.setName(rs.getString(2));
                            p.setImage(rs.getString(3));
                            p.setPrice(rs.getDouble(4));
                            p.setTittle(rs.getString(5));
                            p.setDescription(rs.getString(6));
                            search_pro.add(p);
                     }

                     return search_pro;
              } catch (SQLException ex) {
                     Logger.getLogger(Product_Connect.class.getName()).log(Level.SEVERE, null, ex);
              }
              return null;
       }

//    public static void main(String[] args) {
//        Product_Connect p = new Product_Connect();
//        for (Product pr : p.getAllProduct()) {
//            System.out.println(pr.getName());
//        }
//    }
}
