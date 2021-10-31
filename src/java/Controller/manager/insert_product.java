/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.manager;

import DAO.CategoryDBConnect;
import DAO.Product_Connect;
import Model.Account;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tebellum
 */
@WebServlet(name = "insert_product", urlPatterns = {"/manager/insertProduct"})
public class insert_product extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
              request.setCharacterEncoding("UTF-8");
//              String name = request.getParameter("name");
//              String title = request.getParameter("title");
//              String description = request.getParameter("description");
//              String image = request.getParameter("image");
//              String price = request.getParameter("price");
              String category = request.getParameter("category");
              
              Product p = new Product();
              p.setName(request.getParameter("name"));
              p.setTittle(request.getParameter("title"));
              p.setImage(request.getParameter("image"));
              p.setPrice(Double.parseDouble(request.getParameter("price")));
              p.setDescription(request.getParameter("description"));
              
              Account a;
              HttpSession session = request.getSession();
               a= (Account) session.getAttribute("acc");
              int sell_id = a.getId();
              
              
              Product_Connect pc = new Product_Connect();
              pc.insertProduct(p, category, sell_id);
              
              response.sendRedirect("product");
       }

       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
       /**
        * Handles the HTTP <code>GET</code> method.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              processRequest(request, response);
       }

       /**
        * Handles the HTTP <code>POST</code> method.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              processRequest(request, response);
       }

       /**
        * Returns a short description of the servlet.
        *
        * @return a String containing servlet description
        */
       @Override
       public String getServletInfo() {
              return "Short description";
       }// </editor-fold>

}
