<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bài tập PRJ</title>
        <link rel="stylesheet" href="CSS_Web_01_b.css">
    </head>
    <body>

        <form action="MainController" method="POST"> 
            <h1>HTML Forms</h1>

            <!--        <label> Lệnh này dùng để tạo ra một nhãn mô tả cho người dùng biết 
                        họ cần phải điền gì vào cái ô bên cạnh.--> <!--type chính là cái nút vặn chế độ <input>-->
            <div class="row">
                <label>Textbox</label>
                <input type="text" name="txtText" value="" size="5" /> <!--<input> (Ô nhập liệu)-->
            </div>

            <div class="row">
                <label>Password</label>
                <input type="password" name="txtPassword" value="" />
            </div>

            <div class="row">
                <label>Hidden</label>
                <input type="hidden" name="txtHidden" value="" /> <!--hidden là ẨN -->
            </div>

            <div class="row">
                <label>Male</label>
                <input type="checkbox" name="chkCheck" value="ON" checked="checked" />
            </div>

            <div class="row">
                <label>Status</label>
                <input type="radio" name="rdoStatus" value="Single" checked="checked" /> Single <br/>
                <input type="radio" name="rdoStatus" value="Married" /> Married <br/>
                <input type="radio" name="rdoStatus" value="Divorsed" /> Divorsed <br/>
            </div>

            <div class="row">
                <label>ComboBox</label>
                <select name="txtCombo">
                    <option value="Servlet">JSP and Servlet</option>
                    <option value="EJB">EJB</option>
                </select>
            </div>

            <div class="row">
                <label>Multiple</label>
                <select name="txtList" multiple="multiple" size="3">
                    <option value="Servlet">JSP and Servlet</option>
                    <option value="EJB" selected="selected">EJB</option>
                    <option value="Java">Core Java</option>
                </select>
            </div>


            <div class="row">
                <label>TextArea</label>
                <textarea name="txtArea" rows="4" cols="20">This is a form parameters demo!!!!</textarea>
            </div>

            <div class="row buttons">
                <input type="submit" value="Submit Query" name="txtB" />
                <input type="submit" value="Register" name="action" />
                <input type="reset" value="Reset" name="txtB" />
                <input type="button" value="JavaScript" name="txtB" />
            </div>
        </form>

    </body>
</html>