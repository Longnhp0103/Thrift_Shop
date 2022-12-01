/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Order;
import models.Product;
import models.UserDTO;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "shop.jsp";
    private static final String SUCCESS = "shop.jsp";
    
    //////////////////////////////////////////////////////////////////////
    private static final String PRODUCT_LIST = "productList.jsp";
    private static final String PRODUCT_ACTION = "adminProductSearch";
    //////////////////////////////////////////////////////////////////////
    private static final String USER_ACTION = "adminUserSearch";
    private static final String USER_LIST = "adminpage.jsp"; 
    //////////////////////////////////////////////////////////////////////
    private static final String ORDER_ACTION = "adminOrderSearch";
    private static final String ORDER_LIST = "orderList.jsp"; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            String search = request.getParameter("search");
            ProductDAO dao = new ProductDAO();
            AccountDAO acd = new AccountDAO();
            OrderDAO odd = new OrderDAO();
            CategoryDAO cd = new CategoryDAO();           
            if (PRODUCT_ACTION.equals(action)) {
                url = PRODUCT_LIST;
                List<Product> productListAdmin = dao.findProductByName_Admin(search);
                request.setAttribute("listProductAdmin", productListAdmin);
            } else if (USER_ACTION.equals(action)){
                url = USER_LIST;
                List<UserDTO>listAccount=acd.findUserByFullName_Admin(search);
                request.setAttribute("listAccount", listAccount);
            }else if (ORDER_ACTION.equals(action)){
                url = ORDER_LIST;
                List<Order> listOrderAdmin= odd.findOrderByProductName_Admin(search);
                request.setAttribute("listOrderAdmin", listOrderAdmin);
            } 
            else { 
                // code của ông đây nè 
                url = SUCCESS;
                List<Category> listCategory = cd.listAllCategory();
                List<Product> listShop = dao.findProductByName(search);
                if (listShop.size() > 0) {
                    request.setAttribute("listShop", listShop);
                }
                request.setAttribute("listCategory", listCategory);
            }                    
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
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
