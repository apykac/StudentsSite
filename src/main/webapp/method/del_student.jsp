<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 14.05.2018
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление студента</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/method/del_student" method="post">
    <label>Введите ID студента: <input type="text" name="id"></label>
    <br>
    <input type="submit" name="Удалить студента">
</form>
<a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
