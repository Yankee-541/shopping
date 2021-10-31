/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.manager;

import DAO.CategoryDBConnect;
import DAO.Product_Connect;
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

/**
 *
 * @author Tebellum
 */
@WebServlet(name = "Upload_Product", urlPatterns = {"/manager/uploadProduct"})
public class Upload_Product extends HttpServlet {

       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              request.setCharacterEncoding("UTF-8");

              String pid = request.getParameter("pid");
              Product_Connect pc = new Product_Connect();
              Product p = pc.getProduct_Detail(pid);

              CategoryDBConnect cdbc = new CategoryDBConnect();
              ArrayList<Category> allCate = cdbc.getcates();
              request.setAttribute("pid", pid);
              request.setAttribute("allCate", allCate);
              request.setAttribute("detailproduct", p);
              request.getRequestDispatcher("../View/upload_product.jsp").forward(request, response);
       }

       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              request.setCharacterEncoding("UTF-8");

              String id = request.getParameter("id");
              String tittle = request.getParameter("tittle");
              String Description = request.getParameter("Description");

              Product p = new Product();
              p.setName(request.getParameter("name"));
              p.setPrice(Double.parseDouble(request.getParameter("price")));
              p.setImage(request.getParameter("imagin"));
              p.setTittle(tittle);
              p.setDescription(Description);
              String category = request.getParameter("category");

              Product_Connect pc = new Product_Connect();
              pc.uploadProduct(p, id, category);

              response.sendRedirect("product");
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
