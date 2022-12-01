/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admiz
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String HOME = "Home";
    private static final String HOME_CONTROLLER = "HomeController";
    private static final String DETAIL = "Detail";
    private static final String DETAIL_CONTROLLER = "DetailController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String CATEGORY = "Category";
    private static final String CATEGORY_CONTROLLER = "CategoryController";
    private static final String SHOP = "Shop";
    private static final String SHOP_CONTROLLER = "ShopController";
    private static final String VIEW = "View";
    private static final String VIEW_CONTROLLER = "ViewController";
    private static final String POST = "Post";
    private static final String POST_CONTROLLER = "PostController";
    private static final String CHECKOUT = "Checkout";
    private static final String CHECKOUT_CONTROLLER = "CheckoutController";
    private static final String USER = "User";
    private static final String USER_CONTROLLER = "UserController";
    private static final String ADMIN = "Admin";
    private static final String ADMIN_CONTROLLER = "AdminController";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String REGISTER = "Register";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String CHANGE = "Change";
    private static final String CHANGE_CONTROLLER = "ChangePasswordController";
    private static final String UPDATE_PROFILE = "Update";
    private static final String UPDATE_PROFILE_CONTROLLER = "UpdateProfileController";
    private static final String SETTING_PROFILE = "Setting"; // use for admin 
    private static final String SETTING_PROFILE_CONTROLLER = "SettingProfileController";
    private static final String ADD_MONEY = "Add Money";
    private static final String ADD_MONEY_CONTROLLER = "AddMoneyController";

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
            String url = ERROR;
            try {
                String action = request.getParameter("action");
                if (HOME.equals(action)) {
                    url = HOME_CONTROLLER;
                } else if (DETAIL.equals(action)) {
                    url = DETAIL_CONTROLLER;
                } else if (ADMIN.equals(action)) {
                    url = ADMIN_CONTROLLER;
                } else if (LOGIN.equals(action)) {
                    url = LOGIN_CONTROLLER;
                } else if (action.equals(LOGOUT)) {
                    url = LOGOUT_CONTROLLER;
                } else if (action.equals(REGISTER)) {
                    url = REGISTER_CONTROLLER;
                } else if (action.equals(CHANGE)) {
                    url = CHANGE_CONTROLLER;
                } else if (action.equals(UPDATE_PROFILE)) {
                    url = UPDATE_PROFILE_CONTROLLER;
                } else if (action.equals(SETTING_PROFILE)) {
                    url = SETTING_PROFILE_CONTROLLER;
                } else if (action.equals(SEARCH)) {
                    url = SEARCH_CONTROLLER;
                } else if (action.equals(VIEW)) {
                    url = VIEW_CONTROLLER;
                } else if (action.equals(POST)) {
                    url = POST_CONTROLLER;
                } else if (action.equals(CHECKOUT)) {
                    url = CHECKOUT_CONTROLLER;
                } else if (action.equals(ADD_MONEY)) {
                    url = ADD_MONEY_CONTROLLER;
                } else if (action.equals(SHOP)) {
                    url = SHOP_CONTROLLER;
                } else if (action.equals(CATEGORY)) {
                    url = CATEGORY_CONTROLLER;
                } else if (action.equals(USER)) {
                    url = USER_CONTROLLER;
                }
            } catch (Exception e) {
                log("Error at MainController " + e.toString());
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
