package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDAO { // Danh sach nguoi dung
    private ArrayList<UserDTO> listUser = new ArrayList<>();

    public UserDAO() {
        listUser = new ArrayList<>();
        listUser.add(new UserDTO("trangiabao", "bao123", "Tran Gia Bao"));
        listUser.add(new UserDTO("nguyentruongthinh", "thinh123", "Nguyen Truong Thinh"));
        listUser.add(new UserDTO("nguyenchicuong", "cuong123", "Nguyen Chi Cuong"));
    }
    
    public UserDTO searchById(String username){
        for (UserDTO userDTO : listUser) {
            if(userDTO.getUsername().equalsIgnoreCase(username)){
                return userDTO;
            }
        }
        return null;
    }
    
    public UserDTO login(String username, String password){
        UserDTO checkName = searchById(username);
        if(checkName != null && checkName.getPassword().equals(password)){
            return checkName;
        }
        return null;
    }
}
