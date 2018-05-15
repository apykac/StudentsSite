<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление студента</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <form action="${pageContext.request.contextPath}/method/del_data" method="post">
        <label>Введите ID студента: <input type="text" name="id"></label>
        <br>
        <input type="submit" name="Удалить студента">
        <input type="hidden" name="methodType" value="del_student">
    </form>
    <%if((errorMsg != null) && errorMsg.equals("delStudentError")) {%> <b>Некорректное ID студента</b> <%}%>
    <br>
    <i>ID студента должно быть не пустое и быть цифрой</i>
    <br>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
