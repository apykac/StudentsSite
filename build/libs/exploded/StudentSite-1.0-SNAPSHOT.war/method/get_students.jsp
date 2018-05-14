<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 14.05.2018
  Time: 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод студентов</title>
</head>
<body>
    <p>Введите данные студента или оставьте пустыми поля которые вы не знаете</p>
    <form action="${pageContext.request.contextPath}/method/get_students_to_page" method="post">
        <label>Имя: <input type="text" name="firstName"></label>
        <br>
        <label>Фамилия: <input type="text" name="secondName"></label>
        <br>
        <label>Отчество: <input type="text" name="middleName"></label>
        <br>
        <input type="submit" name="Вывести студентов">
    </form>
</body>
</html>
