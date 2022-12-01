/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Order;
import models.UserDTO;

/**
 *
 * @author htmlo
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ORDER_PAGE = "orderList.jsp";
    private static final String SAVE ="Save";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ORDER_PAGE;
        try {
            //orderDAO
            OrderDAO ord = new OrderDAO();
            String action = request.getParameter("action");
            if (SAVE.equals(action)) {
               int orderID =  Integer.parseInt(request.getParameter("orderId"));
               int productID= Integer.parseInt(request.getParameter("productID"));
               boolean isAdmin= Boolean.parseBoolean(request.getParameter("isAdmin"));
               boolean isBuyer = Boolean.parseBoolean(request.getParameter("isBuyer"));                               
               boolean CheckSave = ord.updateOrderStatus(orderID,isAdmin,isBuyer,productID);
               if (CheckSave) {
                    List<Order> listOrderAdmin = ord.listAllOrder();
                    request.setAttribute("listOrderAdmin", listOrderAdmin);
                    request.setAttribute("SETTING", "Setting SUCCESS ");
                } else {
                    List<Order> listOrderAdmin = ord.listAllOrder();
                    request.setAttribute("listOrderAdmin", listOrderAdmin);
                    request.setAttribute("SETTING", "Setting FAIL");
                }
            } else {
                List<Order> listOrderAdmin = ord.listAllOrder();
                request.setAttribute("listOrderAdmin", listOrderAdmin);
            }
        } catch (Exception ex) {
            log("Error at OrderController :" + ex.toString());
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
