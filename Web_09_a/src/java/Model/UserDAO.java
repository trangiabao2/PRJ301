package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.dbutils;

public class UserDAO {

    public UserDAO() {
    }

    public UserDTO searchById(String username) throws SQLException{
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UserDTO user = null;

//      ResultSet là Bảng dữ liệu tạm thời
//      chứa các dòng kết quả trả về từ SQL Server (Box chứa kết quả)
//      PreparedStatement pst lúc này đã giữ câu lệnh 
//      và cả dữ liệu (như username/password em đã nạp vào).
        try {
            conn = dbutils.getConnection();

            if (conn != null) {
                String sql = "SELECT * FROM tblUsers WHERE userID=?";
                System.out.println(sql);
                pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();

                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullname = rs.getString("fullname");
                    String password = rs.getString("password");
                    String roleID = rs.getString("roleID");
                    boolean status = rs.getBoolean("status");
                    user = new UserDTO(userID, fullname, password, roleID, status);
                }

                System.out.println(sql);

            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }finally{
            if(conn != null){
                conn.close();
            }
            if(pst != null){
                pst.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return user;
    }

    public UserDTO login(String username, String password) throws SQLException {
        UserDTO u = searchById(username);
        if(u != null && u.getPassword().equals(password)){
            return u;
        }
        return null;
    }

}
