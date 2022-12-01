/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ImageDAO;
import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import models.Account;
import models.Image;
import models.Product;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class PostController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static String ERROR = "post.jsp";
    private static String SUCCESS = "homepage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO pd = new ProductDAO();
        ImageDAO id = new ImageDAO();
        String productName = null;
        int productPrice = 0;
        int productQuantity = 0;
        String productDesc = null;
        int categoryID = 0;
        boolean status = false;
        int userID = 0;
        String imageLink = null;
        int productID = 0;
        String url = ERROR;
        FileItemFactory itemfactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemfactory);
        
        try {
            productName = request.getParameter("productName");
            productPrice = Integer.parseInt(request.getParameter("productPrice"));
            productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            productDesc = request.getParameter("productDesc");
            imageLink = request.getParameter("img");
            categoryID = Integer.parseInt(request.getParameter("categoryID"));
            status = true;
            HttpSession session = request.getSession();
            userID = Integer.parseInt(request.getParameter("userID"));;
            
            Product product = new Product(productName, productPrice, productQuantity, productDesc, categoryID, status, userID);
            boolean checkInsertProduct = pd.insert1(product);
            if (checkInsertProduct) {
                productID = pd.TakeProductID();
                boolean checkInsertImg = pd.insertImagine(imageLink, productID);
                if(checkInsertImg) {
                    System.out.println("Add successfully");
                    url = SUCCESS;
                }
                
            }
        } catch (Exception e) {
            log("Error at Create Controller: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
//        try {
//            List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));//lỗi ở đây là 2
//            for (FileItem item : items) {
//
//                if (item.isFormField()) {
//                    String name1 = item.getFieldName();
//                    String value = item.getString("UTF-8");
//                    System.out.println("name1: " + name1);
//                    System.out.println("value: " + value);
//                    if (name1.equals("productName")) {
//                        productName = item.getString("UTF-8");
//                    } else if (name1.equals("productPrice")) {
//                        productPrice = Integer.parseInt(item.getString());
//                    } else if (name1.equals("productQuantity")) {
//                        productQuantity = Integer.parseInt(item.getString());
//                    } else if (name1.equals("productDesc")) {
//                        productDesc = item.getString();
//                    } else if (name1.equals("categoryID")) {
//                        categoryID = Integer.parseInt(item.getString());
//                    }
//
//                } else {
//                    System.out.println(productName);
//                    File uploadDir = new File("D:\\FPT University Materials\\K5 - Fall22\\SWP391\\main\\SWP-Thrift-Shop\\build\\web\\img"
//                            + item.getName() + ".");
//                    //item.getName()
//                    userID = user.getAccountID(); //loi o day la 1
//                    boolean checkInsertProduct = pd.insert1(new Product(productName, productPrice, productQuantity, productDesc, categoryID, status, userID));
//                    productID = pd.getLastProductID();
//                    status = true;
//                    imageLink = item.getName();
//                    boolean checkInsertImage = id.insertImageForProduct(new Image(productID, imageLink));
//                    if (checkInsertProduct && checkInsertImage) {
//                        item.write(uploadDir);
//                        request.setAttribute("message", "File Saved Successfully");
//                        url = SUCCESS;
//                    }
//                }
//            }
//            request.getRequestDispatcher(url).forward(request, response);
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//            request.setAttribute("message", "Your file has problem!");
//            System.out.println("Your file has problem!");
//            request.getRequestDispatcher(url).forward(request, response);
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            request.setAttribute("message", "Your file has problem!");
//            System.out.println("Your file has problem!");
//            request.getRequestDispatcher(url).forward(request, response);
//        }

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
        /* Receive file uploaded to the Servlet from the HTML5 form */
//        Part filePart = request.getPart("file");
//        String fileName = filePart.getSubmittedFileName();
//        for (Part part : request.getParts()) {
//            part.write("C:\\Users\\Admiz\\Desktop\\SWP_Full\\SWP-Thrift-Shop\\build\\web\\img" + fileName);
//        }
//        response.getWriter().print("The file uploaded sucessfully.");
    
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
