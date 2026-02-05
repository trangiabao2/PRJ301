//setAttribute: Gói dữ liệu vào một "chiếc hộp" (Object) và dán nhãn cho nó.
    // Lưu dữ liệu để dùng ở trang tiếp theo.
    // Khi muốn truyền dữ liệu từ Servlet sang JSP, chúng ta dùng setAttribute

//getAttribute: Mở chiếc hộp đó ra để lấy dữ liệu dựa trên nhãn đã dán.
    // Lấy dữ liệu đã lưu từ setAttribute.

// getParameter: Từ Trình duyệt đến Máy chủ
    // Đọc thông tin người dùng gửi lên.
    // - Các ô nhập liệu trong <form>.
    // Các tham số trên đường dẫn URL (ví dụ: ?id=123).
    // Chỉ có getParameter, không có Set


// Request Scope: 
    // Rất ngắn. Kết thúc ngay khi trang web hiện ra xong.
    // Chỉ dùng được ở trang đích mà Servlet chuyển hướng tới (forward).
    // Danh sách kết quả tìm kiếm, thông báo lỗi nhập liệu, 
    // dữ liệu một món đồ cụ thể để xem chi tiết.

// Session Scope:
    // Dài. Tồn tại xuyên suốt từ lúc đăng nhập đến khi đóng trình duyệt/đăng xuất.
    // Dùng được ở tất cả các trang trong cùng một website.
    // Thông tin người dùng đã đăng nhập, giỏ hàng (shopping cart), 
    // ngôn ngữ hiển thị đã chọn (Việt/Anh).

// <tr> là viết tắt của Table Row (Dòng trong bảng).
    // Nó đóng vai trò xác định một hàng ngang duy nhất chứa các ô dữ liệu.
    // Một hàng (<tr>) thường chứa hai loại ô:
        // <th> (Table Header): Dùng cho các ô tiêu đề ở đầu bảng (thường in đậm và căn giữa)
        // <td> (Table Data): Dùng cho các ô chứa dữ liệu thực tế của từng bản ghi.
    // Có thể kết hợp với: <td colspan="10" style="text-align: center;">
    // colspan="10": gôm 10 ô trong bảng thành 1 ô dài chứa chuỗi dài

// value="${requestScope.keywords}", bạn đang thực hiện nhiệm vụ đầu tiên:
    // Hiển thị lại những gì người dùng vừa tìm kiếm để họ không phải gõ lại từ đầu.

// Khi nào thì dùng POST?
    // Đăng ký / Đăng nhập (Mật khẩu).
    // Thêm mới / Cập nhật / Xóa dữ liệu (như nút Update mà bạn vừa làm).
    // Gửi bài viết, bình luận.

// Muốn "Xem" -> executeQuery.
    // Muốn "Sửa/Xóa/Thêm" -> executeUpdate.