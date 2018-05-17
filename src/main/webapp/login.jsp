<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Авторизация</title>
</head>
<body>
    <h1>Необходима авторизация</h1>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table class="loginTable">
            <tr>
                <td><label for="userName">Имя пользователя</label></td>
                <td><input type="text" value="user" name="userName" id="userName"></td>
            </tr>
            <tr>
                <td><label for="userPswrd">Пароль</label></td>
                <td><input type="password" value="password" name="userPassword" id="userPswrd"></td>
            </tr>
        </table>
        <input type="submit" value="Войти">
    </form>
    <br>
    <%if ("authorisationError".equals(request.getParameter("error"))) {%>
    Ошибка авторизации, попробуйте авторизоваться снова
    <%}%>
    <br>
    <a href="${pageContext.request.contextPath}/guest_page">Зайти как гость</a>
</body>
</html>
