/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.dbutils;

public class UniversityDAO {

    public UniversityDAO() {
    }

    private UniversityDTO mapDTO(ResultSet rs) throws SQLException {
        return new UniversityDTO(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("shortName"),
                rs.getString("description"),
                rs.getInt("foundedYear"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("region"),
                rs.getString("type"),
                rs.getInt("totalStudents"),
                rs.getInt("totalFaculties"),
                rs.getBoolean("isDraft")
        );
    }

    // --- 2. HÀM TÌM KIẾM CHUNG (Dùng dấu =) ---
    public ArrayList<UniversityDTO> searchByColum(String colum, String value) {
        ArrayList<UniversityDTO> listDTO = new ArrayList<>();
        String sql = "SELECT * FROM tblUniversity WHERE " + colum + "=?";

        try {
            // Try-With-Resources
            try ( Connection conn = dbutils.getConnection();
                    PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, value);
                
                try ( ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        listDTO.add(mapDTO(rs));
                    }
                }
            }
        } catch (SQLException e) {
            // Ghi log rõ ràng loại lỗi để dễ debug
            System.err.println("Database error at filterByColumn: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Lỗi không tìm thấy Driver kết nối
            System.err.println("Driver not found: " + e.getMessage());
        } catch (Exception e) {
            // Các lỗi không mong muốn khác
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return listDTO;
    }

    // --- 3. HÀM LỌC CHUNG (Dùng LIKE) ---
    public ArrayList<UniversityDTO> filterByColum(String colum, String value) {
        ArrayList<UniversityDTO> listDTO = new ArrayList<>();
        String sql = "SELECT * FROM tblUniversity WHERE " + colum + " LIKE ?";

        try {
            // Try-With-Resources
            try ( Connection conn = dbutils.getConnection();
                    PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, "%" + value + "%");
                try ( ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        listDTO.add(mapDTO(rs));
                    }
                }
            }
        } catch (SQLException e) {
            // Ghi log rõ ràng loại lỗi để dễ debug
            System.err.println("Database error at filterByColumn: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Lỗi không tìm thấy Driver kết nối
            System.err.println("Driver not found: " + e.getMessage());
        } catch (Exception e) {
            // Các lỗi không mong muốn khác
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return listDTO;
    }
    
    public ArrayList<UniversityDTO> searchByID(String ID) {
        return searchByColum("id", ID);
    }

    public ArrayList<UniversityDTO> searchByName(String name) {
        return searchByColum("name", name);
    }

    public ArrayList<UniversityDTO> filterByName(String name) {
        return filterByColum("name", name);
    }
}
