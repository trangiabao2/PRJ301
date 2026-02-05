/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.URL;

/**
 *
 * @author ACER
 */
public class MainController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String url = URL.LOGIN_PAGE;

        try {
            // 2. Kiểm tra action != null để tránh lỗi NullPointerException
            if (action == null) {
                url = URL.LOGIN_PAGE;
            } else if (action.equalsIgnoreCase("login")) { // Chấp nhận cả LOGIN, login, Login
                url = URL.LOGIN_CONTROLLER;
            } else if (action.equalsIgnoreCase("logout")) {
                url = URL.LOGOUT_CONTROLLER;
            } else if (action.equalsIgnoreCase("search")) { // Chấp nhận cả search, Search, SEARCH
                url = URL.SEARCH_CONTROLLER;
            } else if (action.equalsIgnoreCase("delete")) {
                url = URL.DELETE_CONTROLLER;
            } else if (action.equals("addUniversity")) {
                url = URL.ADD_CONTROLLER;
            } else {
                url = URL.LOGIN_PAGE;
            }
        } catch (Exception e) {
            // Ghi log cụ thể để dễ debug trong môi trường thực tế
            log("Error at MainController: " + e.toString());
        } finally {
            // Chuyen trang
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
