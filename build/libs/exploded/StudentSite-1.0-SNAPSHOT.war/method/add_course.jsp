<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление курса</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/method/add_course" method="post">
    <label>Название курса: <input type="text" name="course"></label>
    <br>
    <input type="submit" name="Добавить курс">
</form>
<a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
