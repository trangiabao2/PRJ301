package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import utils.URL;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Lấy ServletContext (Application Scope)
        ServletContext context = sce.getServletContext();
        
        // Đưa đối tượng Url vào với tên định danh là "URL"
        context.setAttribute("URL", new URL());
        
        System.out.println("---  URL Constants have been loaded into Application Scope! ---");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Không cần xử lý khi tắt server
    }
}