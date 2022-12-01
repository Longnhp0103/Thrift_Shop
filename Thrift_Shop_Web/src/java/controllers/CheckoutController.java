/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ImageDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import models.Image;
import models.Product;
import models.UserDTO;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "CreateTransactionController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO pd = new ProductDAO();

        ImageDAO id = new ImageDAO();
        float totalPrice = Float.parseFloat(request.getParameter("amount"));
        float balance = Float.parseFloat(request.getParameter("balance"));
        Date OrderDate = null;
        Date ShipDate = null;
        String ShipAddress = null;
        int TotalPrice = 0;
        int UserID = 0;
        String url = ERROR;
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            if (balance < totalPrice) {
                session.setAttribute("WARNING", "You are not enough money");
                url = ERROR;
            } else {
                OrderDAO od = new OrderDAO();
                long millis = System.currentTimeMillis();
                java.sql.Date sqlOrderDate = new java.sql.Date(millis);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sqlOrderDate);
                cal.add(Calendar.DAY_OF_YEAR, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                java.sql.Date sqlShipDate = new java.sql.Date(cal.getTimeInMillis());
                ShipAddress = request.getParameter("ShipAddress");
                // getProductID, then TotalPrice = productgetprice + ship 
                // if Ship == "FPTU Thrift Shop" = 0, else = 10
                String ProductID = request.getParameter("productID");
                Product product = pd.getProductbyID(ProductID);
                int ProductPrice = product.getProductPrice();
                int ship = 0;
                if (ShipAddress.equals("FPTU Thrift Shop")) {
                    ship = 0;
                } else {
                    ship = 10;
                }
                TotalPrice = ProductPrice + ship;
                UserID = Integer.parseInt(user.getID());
                int ProductIDI = Integer.parseInt(ProductID);
                boolean check = od.checkout1(sqlOrderDate, sqlShipDate, ShipAddress,
                        TotalPrice, UserID, ProductIDI);
                if (check) {
                    System.out.println("Add successfully");
                    boolean afterCheckout = pd.productAfterCheckout(product.getProductID());
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at Create Controller: " + e.toString());
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
