<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление Курса</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <form action="${pageContext.request.contextPath}/method/del_data" method="post">
        <label>Введите ID курса: <input type="text" name="id"></label>
        <br>
        <input type="submit" name="Удалить курс">
        <input type="hidden" name="methodType" value="del_course">
    </form>
    <%if((errorMsg != null) && errorMsg.equals("delCourseError")) {%> <b>Некорректное ID курса</b> <%}%>
    <br>
    <i>ID курса должно быть не пустое и быть цифрой</i>
    <br>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
