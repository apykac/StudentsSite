<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 14.05.2018
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка</title>
</head>
<body>
    <p>Выберите желаемое действие</p>
    <a href="${pageContext.request.contextPath}/method?method=get_students">Вывод стедентов по ФИО</a>
    <br>
    <a href="${pageContext.request.contextPath}/method?method=get_courses">Вывод курсов по названию</a>
    <br>
    <a href="${pageContext.request.contextPath}/method?method=add_student">Добавить студента</a>
    <br>
    <a href="${pageContext.request.contextPath}/method?method=del_student">Удалить студента</a>
    <br>
    <a href="${pageContext.request.contextPath}/method?method=add_course">Добавить курс</a>
    <br>
    <a href="${pageContext.request.contextPath}/method?method=del_course">Удалить курс</a>
    <br>
</body>
</html>
