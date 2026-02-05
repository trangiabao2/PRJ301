package utils;

public class URL {
    public static final String LOGIN_PAGE = "login.jsp";
    public static final String HOME_PAGE = "welcome.jsp";
    public static final String ERROR_PAGE = "E403.jsp";
    public static final String SEARCH_PAGE = "search.jsp";
    public static final String ADD_PAGE = "university-form.jsp";
    
    // Đường dẫn các Controller (Nếu cần gọi từ trang JSP hoặc Servlet khác)
    public static final String MAIN_CONTROLLER = "MainController";
    public static final String LOGIN_CONTROLLER = "LoginController";
    public static final String LOGOUT_CONTROLLER = "LogoutController";
    public static final String SEARCH_CONTROLLER = "SearchController";
    public static final String DELETE_CONTROLLER = "DeleteController";
    public static final String ADD_CONTROLLER = "AddUniversityController";
    
    public String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }

    public String getHOME_PAGE() {
        return HOME_PAGE;
    }

    public String getERROR_PAGE() {
        return ERROR_PAGE;
    }

    public String getMAIN_CONTROLLER() {
        return MAIN_CONTROLLER;
    }

    public String getLOGIN_CONTROLLER() {
        return LOGIN_CONTROLLER;
    }

    public String getLOGOUT_CONTROLLER() {
        return LOGOUT_CONTROLLER;
    }

    public String getSEARCH_CONTROLLER() {
        return SEARCH_CONTROLLER;
    }

    public String getDELETE_CONTROLLER() {
        return DELETE_CONTROLLER;
    }

    public String getSEARCH_PAGE() {
        return SEARCH_PAGE;
    }

    public String getADD_CONTROLLER() {
        return ADD_CONTROLLER;
    }

    public String getADD_PAGE() {
        return ADD_PAGE;
    }
    
    
}
