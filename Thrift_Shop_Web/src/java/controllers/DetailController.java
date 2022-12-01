/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Product;
import models.UserDTO;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class DetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * 00*9----------03
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        AccountDAO d = new AccountDAO();
        HttpSession session = request.getSession();
        Product p = pd.getProductbyID(pid);
        String categoryID = Integer.toString(p.getCategoryID());
        List<Category> listCategory = cd.listAllCategory();
        List<Product> listRelated = pd.getRelatedProduct(categoryID,p.getProductID());
        int userID = d.getAccountFromProduct(pid);
        int numberofOrder = d.noOfOrder(userID);
        int successOrderSold = d.successOrderSold(userID);
        Product product = d.latestPostedFeed(userID);
        session.setAttribute("numberofOrder", numberofOrder);
        session.setAttribute("successOrderSold", successOrderSold);
        session.setAttribute("product", product);
        request.setAttribute("detail", p);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listRelated", listRelated);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
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
