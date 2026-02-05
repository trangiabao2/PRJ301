# Hướng dẫn chạy dự án Web_08_a trên VS Code (Windows)

Mô tả nhanh: hướng dẫn này giúp bạn thiết lập môi trường, build bằng Ant, deploy lên Tomcat và chạy project trên VS Code.

---

## 1. Yêu cầu
- Java JDK 8 (hoặc 11) — set `JAVA_HOME` và thêm vào `PATH`.
- VS Code + extension: Java Pack & Tomcat (xem `.vscode/extensions.json`).
- Apache Tomcat (9.x) — giải nén và đặt `CATALINA_HOME` env var trỏ đến thư mục cài Tomcat.
- Microsoft SQL Server (Express/Developer) — bật TCP/IP, bật SQL Authentication.
- JDBC driver (Microsoft JDBC / `sqljdbc4.jar`) — download từ Microsoft và copy vào `web/WEB-INF/lib`.

## 2. Chuẩn bị DB
- Mở `sql/init_db.sql` và chạy trong SQL Server (SSMS hoặc `sqlcmd`).
- Mặc định project cấu hình DB trong `src/java/utils/dbutils.java`:
  - DB_NAME = `PRJ30x_DB1`
  - user = `sa`, password = `12345`, server = `localhost:1433`
- Nếu cần thay đổi, sửa `dbutils.java` cho phù hợp.

## 3. Thêm JDBC driver
1. Tải Microsoft JDBC driver (ví dụ `mssql-jdbc-9.x.jre8.jar` hoặc `sqljdbc4.jar`).
2. Copy file jar đó vào thư mục `web/WEB-INF/lib` (tạo nếu chưa có).

## 4. Build & deploy (cách nhanh với VS Code)
1. Mở VS Code → Open Folder → chọn `Web_08_a`.
2. Cài các extension được đề xuất (xem `.vscode/extensions.json`).
3. Mở Terminal trong VS Code và chạy: `ant` (hoặc dùng Task `Ant: build`).
4. Dùng Task `Deploy to Tomcat` (menu Terminal → Run Task) để copy file WAR vào Tomcat (`%CATALINA_HOME%/webapps`).
5. Start Tomcat (Task `Start Tomcat` hoặc chạy `%CATALINA_HOME%/bin/startup.bat`).
6. Mở trình duyệt: `http://localhost:8080/Web_08_a/login.jsp` (nếu context tên dự án khác, thay tương ứng).

## 5. Troubleshooting nhanh
- Lỗi `ClassNotFoundException: com.microsoft.sqlserver.jdbc.SQLServerDriver` → kiểm tra đã copy JDBC jar chưa.
- `Login failed for user 'sa'` → kiểm tra SQL Server authentication và password.
- Không có WAR trong `dist/` → chắc Ant build chưa chạy thành công; chạy `ant -v` để debug.

---

## 6. Công cụ thêm (tự động)
- Có sẵn tasks VS Code trong `.vscode/tasks.json` để build, deploy, start/stop Tomcat.
- Có script `scripts/deploy-wars.ps1` dùng `CATALINA_HOME` để copy WAR.
- Có script `scripts/run_sqlcmd.ps1` để chạy `sql/init_db.sql` bằng `sqlcmd` (nếu cài).

Nếu bạn muốn, tôi có thể:
- Thêm Task để mở browser tự động khi Tomcat đã chạy.
- Thêm script chép JDBC jar nếu bạn cung cấp URL (tuy nhiên tôi không thể tự động tải file từ Internet).

---

Chỉ dẫn ngắn: sau khi bạn chạy SQL và đặt JDBC jar → chạy `ant` → ``Deploy to Tomcat` → Start Tomcat → mở trang.
