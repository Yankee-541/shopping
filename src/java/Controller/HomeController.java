 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoryDBConnect;
import DAO.Product_Connect;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tebellum
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product_Connect pdbc = new Product_Connect();
        ArrayList<Product> allProduct = pdbc.getAllProduct();
        
        CategoryDBConnect cdbc = new CategoryDBConnect();
        ArrayList<Category> allCate = cdbc.getcates();
        Product productLast = pdbc.getLast();
        request.setAttribute("productLast", productLast);
        request.setAttribute("allCate", allCate);
        
        request.setAttribute("allProduct", allProduct);
        request.getRequestDispatcher("View/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
