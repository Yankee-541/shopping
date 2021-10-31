/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogin;

import DAO.AccountDBConnect;
import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tebellum
 */
public class login_author extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("View/Login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        AccountDBConnect adbc = new AccountDBConnect();
        Account acc = adbc.getAcc(user, pass);
        if(acc == null){
            request.setAttribute("mess", "!!! Invalid username or passord");
            request.getRequestDispatcher("View/Login.jsp").forward(request, response);//mang dữ liệu đi
        }else{
//            HttpSession session = request.getSession();
            request.getSession().setAttribute("acc", acc);
            request.getSession().setMaxInactiveInterval(10000);
            response.sendRedirect("../Web_BanHang/home"); //đẩy dữ liệu thì requestdispatcher còn chuyển trang thì redirect
//        request.getRequestDispatcher("../Web_BanHang/home").forward(request, response);
        }

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
