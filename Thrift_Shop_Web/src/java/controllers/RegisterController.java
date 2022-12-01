/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserDTO;
import models.UserError;

/**
 *
 * @author Admiz
 */
public class RegisterController extends HttpServlet {
    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.jsp";
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
            UserError userError = new UserError();
            boolean checkValidation = true;
            AccountDAO dao = new AccountDAO();
            try {
                String fullname = request.getParameter("fullName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                if (checkValidation) {
                    boolean checkInsert = dao.insert(new UserDTO("", "", fullname, email, "", true, phone, address, "user") );
                    if (checkInsert) {
                        String userID = dao.takeUserID();
                        dao.CreateWallet(userID);
                        url = SUCCESS;
                        request.setAttribute("REGISTER_SUCCESS", "Register successful");
                    }
                } else {
                    request.setAttribute("USER_ERROR", userError);
                }
            } catch (Exception e) {
                log("Error at CreateController :" + e.toString());
                if (e.toString().contains("duplicate")) {
                    userError.setUserNameError("Duplicate userID!!!!!!!!!");
                    request.setAttribute("USER_ERROR", userError);
            }
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
