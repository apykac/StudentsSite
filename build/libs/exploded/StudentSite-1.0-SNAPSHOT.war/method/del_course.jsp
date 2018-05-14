<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 14.05.2018
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление Курса</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/method/del_course" method="post">
    <label>Введите ID курса: <input type="text" name="id"></label>
    <br>
    <input type="submit" name="Удалить курс">
</form>
<a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
