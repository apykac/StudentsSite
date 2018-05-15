<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление курса</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <form action="${pageContext.request.contextPath}/method/add_data" method="post">
        <label>Название курса: <input type="text" name="course"></label>
        <br>
        <input type="submit" name="Добавить курс">
        <input type="hidden" name="methodType" value="add_course">
    </form>
    <%if ((errorMsg != null) && errorMsg.equals("addCourseError")) {%> <b>Введены не корректные название курса</b> <%}%>
    <br>
    <i>Название курса не должно быть пустым</i>
    <br>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
