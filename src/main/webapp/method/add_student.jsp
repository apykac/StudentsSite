<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление студента</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <form action="${pageContext.request.contextPath}/method/add_data" method="post">
        <label>Имя: <input type="text" name="firstName"></label>
        <br>
        <label>Фамилия: <input type="text" name="secondName"></label>
        <br>
        <label>Отчество: <input type="text" name="middleName"></label>
        <br>
        <label>Курс: <input type="text" name="courseId"></label>
        <br>
        <input type="submit" name="Добавить студента">
        <input type="hidden" name="methodType" value="add_student">
    </form>
    <%if ((errorMsg != null) && errorMsg.equals("addStudentError")) {%> <b>Введены не корректные данные ФИО студента</b> <%}%>
    <br>
    <i>Имя, фамилия и курс не должны быть пустыми, отчество может отсутствовать</i>
    <br>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
