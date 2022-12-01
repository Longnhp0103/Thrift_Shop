/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Transaction;
import models.UserDTO;
import models.Wallet;

/**
 *
 * @author Admiz
 */
public class LoginController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String ADMIN_PAGE = "adminpage.jsp";
    private static final String USER_PAGE = "homepage.jsp";
    private static final String SELL_PAGE = "seller.jsp";
    private static final String AD = "Admin";
    private static final String US = "User";
    private static final String SELLER = "Seller";
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try{
                String username = request.getParameter("userName");
                String password = request.getParameter("password");
                AccountDAO dao = new AccountDAO();
                UserDTO user = dao.checkLoginV2(username, password);
                Wallet wallet = dao.TakeAmount(user.getID());
                List<Transaction> transaction = dao.takeTransaction(user.getID());
                if(user != null) {
                    String roleName = user.getRoleName();
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    session.setAttribute("AMOUNT", wallet);
                    session.setAttribute("TRANSACTION", transaction);
                    if(AD.equals(roleName)){
                        url = "AdminController";
                    } else if (US.equals(roleName)){
                        
                        url = USER_PAGE;                        
                    } else if (SELLER.equals(roleName)){
                        request.setAttribute("ERROR", "Sorry you can't login by account. Please use login by email");
                        url = ERROR;                        
                    }   else {
                        request.setAttribute("ERROR", "Your role is not support");
                    }
                } else {
                    request.setAttribute("ERROR", "Incorrect userID or password");
                }
            } catch (Exception e) {
                log("Error at LoginController, " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
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
