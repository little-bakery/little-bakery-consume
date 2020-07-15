/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.controller;

import duongll.client.AccountClient;
import duongll.dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.jsp";
        try {
            Account account = new Account();
            AccountClient accountClient = new AccountClient();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String fullname = request.getParameter("txtFullName");
            String confirm = request.getParameter("txtConfirm");
            if (username != null) {
                account.setUsername(username);
            } else {
                request.setAttribute("ERROR", "Username cannot be empty");
            }
            if (fullname != null) {
                account.setFullname(fullname);
            } else {
                request.setAttribute("ERROR", "Fullname cannot be empty");
            }
            account.setRole("user");
            if (password == null) {
                request.setAttribute("ERROR", "Password and Password not match");
            }
            if (confirm == null) {
                request.setAttribute("ERROR", "Confirm Password cannot be empty");
            }
            if (!confirm.equals(password)) {
                request.setAttribute("ERROR", "Confirm Password and Password not match");
            } else {
                account.setPassword(password);
            }
            Account result = accountClient.register_XML(account, Account.class);
            if (result != null) {
                HttpSession session = request.getSession();
                session.setAttribute("INFO", result);
                url = "index.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
