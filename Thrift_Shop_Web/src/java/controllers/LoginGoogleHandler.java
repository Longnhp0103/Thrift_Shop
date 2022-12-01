/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Constants;
import models.Transaction;
import models.UserDTO;
import models.UserGoogleDTO;
import models.Wallet;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Admiz
 */
public class LoginGoogleHandler extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String USER_PAGE = "homepage.jsp";
    private static final String SELL_PAGE = "seller.jsp";
    private static final String REGISTER_PAGE = "register.jsp";
    private static final String AD = "Admin";
    private static final String US = "User";
    private static final String SELLER = "Seller";
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
        System.out.println(request.getParameter("code"));
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
                AccountDAO dao = new AccountDAO();
                String code = request.getParameter("code");
                String accessToken = getToken(code);
                UserGoogleDTO user = getUserInfo(accessToken);
                UserDTO us = dao.checkEmail(user.getEmail());
                Wallet wallet = dao.TakeAmount(us.getID());
                List<Transaction> transaction = dao.takeTransaction(us.getID());
                HttpSession session = request.getSession();
                session.setAttribute("EMAIL", us.getEmail());
                if(us != null) {
                    String roleName = us.getRoleName();
                    session.setAttribute("LOGIN_USER", us);
                    session.setAttribute("AMOUNT", wallet);
                    session.setAttribute("TRANSACTION", transaction);
                    if(AD.equals(roleName)){
                        url = "AdminController";
                    } else if (US.equals(roleName)){
                        url = USER_PAGE;                        
                    } else if (SELLER.equals(roleName)){
                        url = SELL_PAGE;                        
                    }   else {
                        request.setAttribute("ERROR", "Your role is not support");
                    }
                } else {
                    url = REGISTER_PAGE;
                    request.setAttribute("ERROR", "You must register before login");
                }
            } catch (Exception e) {
                log("Error at UpdateController:" + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            } 
        
    }
    
    public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
						.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

    public static UserGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
                
		UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);

		return googlePojo;
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
