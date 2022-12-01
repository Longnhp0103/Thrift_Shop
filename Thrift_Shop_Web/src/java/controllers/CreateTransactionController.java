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
import models.Payment;
import models.Transaction;
import models.Wallet;

/**
 *
 * @author Admiz
 */
public class CreateTransactionController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "thankyou.jsp";

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
            try {
                int walletID = Integer.parseInt(request.getParameter("walletID"));
                String userID = request.getParameter("userID");
                String sellerID = request.getParameter("sellerID");
                float amount = Float.parseFloat(request.getParameter("amount"));
                float balance = Float.parseFloat(request.getParameter("balance"));
                String discription = request.getParameter("discription");
                String paymentType = "";
                long millis = System.currentTimeMillis();
                java.sql.Date paymentTime = new java.sql.Date(millis);
                HttpSession session = request.getSession();
                AccountDAO dao = new AccountDAO();
                int orderID = 0;
                orderID = dao.takeOrderID();

                if (sellerID == null) {
                    paymentType = "Recharge";
                    boolean createPayment = dao.createPayment(paymentTime, amount, paymentType, orderID);
                    if (createPayment) {
                        Payment payment = dao.takePayment();
                        boolean createTransaction = dao.createTransaction(discription, amount, walletID, payment.getPaymentID());
                        if (createTransaction) {
                            List<Transaction> transaction = dao.takeTransaction(userID);
                            Wallet wallet = dao.TakeAmount(userID);
                            session.setAttribute("AMOUNT", wallet);
                            session.setAttribute("TRANSACTION", transaction);
                            url = SUCCESS;
                        }
                    }
                } else {
                    paymentType = "Payment";
                    if (discription.equalsIgnoreCase("Payment via wallet")) {
                        amount = amount + 10;
                    }
                    boolean createPayment = dao.createPayment(paymentTime, amount, paymentType, orderID);
                    if (createPayment) {
                        Payment payment = dao.takePayment();
                        boolean createTransaction = dao.createTransaction(discription, -amount, walletID, payment.getPaymentID());
                        if (createTransaction) {
                            boolean updateBalance = dao.UpdateMoney(amount, userID);
                            if (discription.equalsIgnoreCase("Payment via wallet")) {
                                amount = amount - 10;
                            }
                            boolean addMoney = dao.AddMoney(amount, sellerID);
                            if(addMoney){
                                int sellerWalletID = dao.takeWallet(sellerID);
                                boolean createTransactionSeller = dao.createTransaction("Added from the product", amount, sellerWalletID, payment.getPaymentID());
                            }
                            if (updateBalance) {
                                List<Transaction> transaction = dao.takeTransaction(userID);
                                Wallet wallet = dao.TakeAmount(userID);
                                session.setAttribute("AMOUNT", wallet);
                                session.setAttribute("TRANSACTION", transaction);
                                url = SUCCESS;
                            }
                        }
                    }
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
