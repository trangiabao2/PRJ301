/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.UniversityDAO;
import Model.UniversityDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.URL;

/**
 *
 * @author ACER
 */
@WebServlet(name = "DeleteController", urlPatterns = {"/DeleteController"})
public class DeleteController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String keywords = request.getParameter("keywords");
        String id = request.getParameter("id");

        if (keywords == null) {
            keywords = "";
        }
        if (id == null) {
            id = "";
        }

        System.out.println("Keywords nhận được: " + keywords);
        System.out.println("ID muon xoa: " + id);

        try {
            UniversityDAO udao = new UniversityDAO();

            if (!id.isEmpty()) {

                boolean check = udao.softDelete(id);

                if (check) {
                    request.setAttribute("mag", "Deleted!");
                } else {
                    request.setAttribute("msg", "Error, can not delete: " + id);
                }
            }

            // Tìm kiếm và gửi danh sách đã người dùng tìm còn lại (danh sách đã xóa)
            ArrayList<UniversityDTO> list = new ArrayList<>();
            if (keywords.trim().length() > 0) {
                list = udao.filterByName(keywords);
            }
            request.setAttribute("list", list);
            request.setAttribute("keywords", keywords);
            
        }catch (SQLException e) {
            log("Database error in SearchController: " + e.getMessage());
            request.setAttribute("msg", "Hệ thống đang bảo trì, vui lòng thử lại sau!");
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(URL.SEARCH_CONTROLLER);
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
