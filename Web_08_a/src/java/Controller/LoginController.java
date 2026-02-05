/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.UserDAO;
import Model.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.URL;

/**
 *
 * @author ACER
 */
public class LoginController extends HttpServlet {
    
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

        String url = "login.jsp";
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("user") == null) {
                // getParameter sẽ đi tìm dữ liệu dựa vào cái nhãn name mà bạn đã đặt ở phía giao diện (HTML)
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");

                UserDAO udao = new UserDAO();
                UserDTO user = udao.login(username, password);
                if (user != null) {
                    if (user.isStatus()) {
                        url = URL.HOME_PAGE;
                        session.setAttribute("user", user); // "tên tự đặt" - "tên món đồ UserDTO với tên là user"
                    } else {
                        url = URL.ERROR_PAGE;
                    }
                } else {
                    url = URL.LOGIN_PAGE;
                    request.setAttribute("message", "Invalid username or password!");
                }
            } else {
                url = URL.HOME_PAGE;
            }
        } catch (SQLException ex) {
            // Ghi log lỗi cụ thể để sau này dễ debug
            log("Error at LoginController (SQL): " + ex.toString());
            // Có thể gán url = ERROR_PAGE nếu cần
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
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
