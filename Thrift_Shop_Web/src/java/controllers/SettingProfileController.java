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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserDTO;

/**
 *
 * @author htmlo
 */
@WebServlet(name = "SettingProfileController", urlPatterns = {"/SettingProfileController"})
public class SettingProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ADMIN_PAGE = "AdminController";
    private static final String SAVE = "Save";
    private static final String SETTING_PAGE = "profileManagement.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SETTING_PAGE;
        try{
            String action = request.getParameter("action");
            if(SAVE.equals(action)){
                url = SETTING_PAGE;
                //AccountDAO
                AccountDAO acd = new AccountDAO();
                //getParamSetting
                String userName = request.getParameter("userName") ;
                String fullName= request.getParameter("fullName");
                String email= request.getParameter("email");
                String phone= request.getParameter("phone");
                String address= request.getParameter("address");
                String roleID= request.getParameter("role");
                boolean status = Boolean.parseBoolean(request.getParameter("status"));
                //checkSetting
                boolean CheckSetting = acd.settingProfile(userName, fullName, email, phone, address, roleID,status);                
                    if (CheckSetting) {
                        url = SETTING_PAGE;
                        UserDTO profile = acd.getUserByEmail(email); 
                        request.setAttribute("USER_PROFILE", profile);
                        request.setAttribute("SETTING", "Setting SUCCESS");
                    } else {
                        url = SETTING_PAGE;
                        UserDTO profile = acd.getUserByEmail(email); 
                        request.setAttribute("USER_PROFILE", profile);
                        request.setAttribute("SETTING", "Setting FAIL");
                    }
            }            
            
        }catch (Exception e){
            log("Error at SettingProfileController :" + e.toString());
        }finally {
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
