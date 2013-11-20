/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import bank.Account;
import bank.AccountManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HugoCésar
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    @EJB
    private AccountManager accountManager;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid= request.getParameter("id");
        Long id= Long.valueOf(sid);
        Account acc=accountManager.read(id);
        request.setAttribute("account", acc);
        RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String sid= request.getParameter("id");
        Long id= Long.valueOf(sid);
        
        String sb = request.getParameter("balance");
        BigDecimal balance = new BigDecimal(sb);
        String address = request.getParameter("address");
        Account acc = new Account(id,balance,address);
        accountManager.update(acc);
        response.sendRedirect("index.jsp");
        

        
        
    }

}
