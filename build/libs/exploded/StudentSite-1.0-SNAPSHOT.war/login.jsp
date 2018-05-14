<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Авторизация</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
       <h1>Необходима авторизация</h1>
       <br>
       <br>
       <label>
           Имя пользователя:
           <br>
           <input type="text" value="user" name="userName">
       </label>
        <br>
        <label>
            Пароль:
            <br>
            <input type="password" value="password" name="userPassword">
        </label>
        <br>
        <input type="submit" value="Войти">
    </form>
    <br>
    <a href="guest_page.jsp">Зайти как гость</a>
</body>
</html>
