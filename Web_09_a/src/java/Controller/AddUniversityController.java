/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.UniversityDAO;
import Model.UniversityDTO;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AddUniversityController", urlPatterns = {"/AddUniversityController"})
public class AddUniversityController extends HttpServlet {
    private static final String ERROR = "university-form.jsp";
    private static final String SUCCESS = "MainController?action=search&keywords=";
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String getSafeParameter (HttpServletRequest request, String paramName){
        String value = request.getParameter(paramName);
        if(value == null){
            value = "";
        }
        return value.trim();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String url = ERROR;
        String msg = "";
        
        List<String> listError = new ArrayList<>();
        
        try{
            String id = getSafeParameter(request, "id");
            String name = getSafeParameter(request, "name");
            String shortName = getSafeParameter(request, "shortName");
            String description = getSafeParameter(request, "description");
            String s_foundedYear = getSafeParameter(request, "foundedYear");
            String address = getSafeParameter(request, "address");
            String city = getSafeParameter(request, "city");
            String region = getSafeParameter(request, "region");
            String type = getSafeParameter(request, "type");
            String s_totalStudents = getSafeParameter(request, "totalStudents");
            String s_totalFaculties = getSafeParameter(request, "totalFaculties");
            String s_isDraft = getSafeParameter(request, "isDraft");
            
            // ========================================================
            // 2. VALIDATION (KIỂM TRA DỮ LIỆU THỦ CÔNG )
            // ========================================================
            
            // --- CHECK ID ---
            id = id.trim();
            if(id.isEmpty()){
                listError.add("Id khong duoc rong!");
            }else if(id.length() > 6){
                listError.add("Id qua dai (Toi da chi 6 ky tu)!");
            }else if(!id.matches("[a-zA-Z0-9]+")){
                listError.add("Id chi cho phep chu va so!");
            }else{
                // Check trùng ID trong Database
                UniversityDAO universityDAO = new UniversityDAO();
                if(!universityDAO.searchByID(id).isEmpty()){
                    listError.add("ID nay da ton tai! Vui long chon ID khac.");
                }
            }
            
            // --- CHECK NAME ---
            name = name.trim();
            if(name.isEmpty()){
                listError.add("Ten khong đuoc đe trong!");
            }else if(name.length() > 150){
                listError.add("Ten cua ban qua dai (Toi da 150 ky tu)");
            }
            
            // --- ShortName ---
            shortName = shortName.trim();
            if(shortName.length() > 20) listError.add("Ten viet tat cua ban qua dai (Toi da 20 ky tu)!");
                
            // --- Description ---
            if(description.length() > 500) listError.add("Description qua dai (toi da 500 ky tu)");
            
            // --- CHECK ADDRESS, CITY, REGION, TYPE ---
            if(address.length() > 200) listError.add("Address qua dai (toi da 200 ky tu)!");
            if(city.length() > 50) listError.add("City qua dai (toi da 200 ky tu)!");
            if(region.length() > 50) listError.add("Region qua dai (toi da 200 ky tu)!");
            if(type.length() > 50) listError.add("Type qua dai (toi da 50 ky tu)");
            
            // --- Founded Year --- // Nam thanh lap
            int foundedYear = 0;
            int currentYear = Year.now().getValue();
            
            if (!s_foundedYear.matches("\\d{4}")){
                listError.add("Nam thanh lap phai la so co 4 chu so (vi du: 2023).");
            }else{
                foundedYear = Integer.parseInt(s_foundedYear);
                if(foundedYear < 1900) listError.add("Nam thanh lap qua cu (Phai lon hon nam 1900).");
                if(foundedYear > currentYear) listError.add("Nam thanh lap khong the la nam trong tuong lai.");
            }
            // --- Total Students ---
            int totalStudents = 0;
            int totalFaculties = 0;
            
            if(!s_totalStudents.matches("\\d+")){ // \d+ nghĩa là phải có ít nhất 1 chữ số
                listError.add("Tong so hoc sinh phai la 1 so duong hop le.");
            }else{
                totalStudents = Integer.parseInt(s_totalStudents);
            }
            
            // --- Faculties ---
            if(!s_totalFaculties.matches("\\d+")){ // \d+ nghĩa là phải có ít nhất 1 chữ số
                listError.add("Tong so giang vien phai la mot so duong hop le.");
            }else{
                totalFaculties = Integer.parseInt(s_totalFaculties);
            }
            
            // Logic nghiệp vụ (Business Rule)
            if(totalStudents > 0 && totalFaculties > totalStudents){
                listError.add("Du lieu khong hop ly: Tong so giang vien khong the lon hon tong so hoc sinh!");
            }
            
            // 3. XỬ LÝCHECKBOX
            boolean isDraft = (s_isDraft.equals("1") || s_isDraft.equals("on"));
            
            // THAY ĐỔI 2: Kiểm tra listError có rỗng không
            UniversityDTO udto = new UniversityDTO(id, name, shortName, description, 
                    foundedYear, address, city, region, type, totalStudents, 
                    totalFaculties, isDraft);
            
            if (listError.isEmpty()) {
                UniversityDAO udao = new UniversityDAO();
                if (udao.add(udto)) {
                    msg = "Them Truong Dai Hoc Thanh Cong";
                    url = SUCCESS;
                } else {
                    msg = "Loi co so du lieu: Khong the chen ban ghi";
                    url = ERROR;
                }
            }else{
                request.setAttribute("listError", listError);
                request.setAttribute("u", udto);
                msg = "Xac thuc that bai! Vui long kiem tra lai thong tin nhap vao.";
                url = ERROR;
            }
            // Có lỗi -> Gửi listError sang JSP
            
        }catch(Exception e){
            e.printStackTrace();
            msg = "He thong loi: " + e.getMessage();
        }finally{
            request.setAttribute("msg", msg);
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
