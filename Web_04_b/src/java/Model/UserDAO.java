package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DbUtils;

public class UserDAO { // Danh sach nguoi dung
    public ArrayList<UserDTO> list = new ArrayList<>();

    public UserDAO() {
    }

    public UserDTO searchById(String username) {
        try {
            Connection conn = DbUtils.getConnection(); // Thêm
            String sql = "SELECT * FROM tblUsers "
                    + " WHERE userID=?"; // Thêm
            System.out.println(sql);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            UserDTO user = null;
            while (rs.next()) {
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");
                user = new UserDTO(userID, fullName, password, roleID, status);
            }
            
            System.out.println(user);
            
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public UserDTO login(String username, String password) {
        UserDTO u = searchById(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}
