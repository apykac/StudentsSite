<%@ page import="ru.innopolis.stc9.Servlets.ConstantContainer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.getSession().setAttribute(ConstantContainer.ROLE, 3);%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Сервис получения информации по успеваемости студентов</title>
</head>
    <body>
        <h1>
            Добро пожаловать в систему!
            <br>
            Вы попали на страницу успеваемости студентов
            <br>
            Сначало вам надо авторизоваться
        </h1>
        <br>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/login">Войти</a>
    </body>
</html>
