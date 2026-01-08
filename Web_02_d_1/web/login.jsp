<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login System</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>

        <video autoplay muted loop id="bgVideo">
            <source src="${pageContext.request.contextPath}/assets/images/HenHoNhungKhongYeu2.mp4" type="video/mp4">
        </video>

        
        <div class="container">
            <h1>Login System</h1>
            <form action="MainController" method="POST">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="txtUsername" placeholder="Enter admin" required>
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="txtPassword" placeholder="Enter password" required>
                </div>

                <input type="submit" value="Login">

                <a href="#">Forgot password?</a>
            </form>
        </div>
        
        <button id="muteBtn" onclick="toggleMute()">
        <span id="muteIcon">🔇</span>
    </button>

    <script type="text/javascript">
        function toggleMute() {
            // Lấy đúng ID mà bạn đã đặt cho thẻ video
            var video = document.getElementById("bgVideo");
            var icon = document.getElementById("muteIcon");
            var btn = document.getElementById("muteBtn");

            if (video.muted) {
                video.muted = false;
                icon.innerHTML = "🔊";
                btn.style.background = "rgba(0, 210, 255, 0.5)";
            } else {
                video.muted = true;
                icon.innerHTML = "🔇";
                btn.style.background = "rgba(255, 255, 255, 0.2)";
            }
        }
    </script>
    
    </body>
</html>