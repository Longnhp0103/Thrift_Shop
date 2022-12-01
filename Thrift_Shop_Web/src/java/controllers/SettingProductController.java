/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/**
 *
 * @author htmlo
 */
@WebServlet(name = "SettingProductController", urlPatterns = {"/SettingProductController"})
public class SettingProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SAVE_CHANGE = "SAVE CHANGE";
    private static final String SETTING_PAGE = "productCRUD.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SETTING_PAGE;
        try {
            String action = request.getParameter("action");
            if (SAVE_CHANGE.equals(action)) {
                url = SETTING_PAGE;
                //productDAO
                ProductDAO prd = new ProductDAO();
                //getParamSettings
                int productId = Integer.parseInt(request.getParameter("productID"));
                int categorieID = Integer.parseInt(request.getParameter("categories"));
                String productName = request.getParameter("productName");
                float price = Float.parseFloat(request.getParameter("price"));
                boolean status = Boolean.parseBoolean(request.getParameter("status"));
                //CheckSetting
                boolean CheckSetting = prd.settingProduct(productId, categorieID, productName, price, status, productName); // checkUpdateProduct

                if (CheckSetting) {
                    url = SETTING_PAGE;
                    Product pro = prd.getProductbyID(request.getParameter("productID"));
                    request.setAttribute("PRODUCT_DETAIL", pro);
                    request.setAttribute("SETTING", "Setting SUCCESS ");
                } else {
                    url = SETTING_PAGE;
                    Product pro = prd.getProductbyID(request.getParameter("productID"));
                    request.setAttribute("PRODUCT_DETAIL", pro);
                    request.setAttribute("SETTING", "Setting SUCCESS ");
                    request.setAttribute("SETTING", "Setting FAIL");
                }
            }
        } catch (Exception e) {
            log("Error at ProductDetailController:" + e.toString());
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
