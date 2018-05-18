<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление Курса</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/method/del_data" method="post">
        <table>
            <tr>
                <td><label for="id">Введите ID курса</label></td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="del_course">
        <input type="submit" name="Удалить курс">
    </form>
    <br>
    <%if((errorMsg != null) && errorMsg.equals("delCourseError")) {%> <b>Некорректное ID курса</b> <%}%>
    <br>
    <i>ID курса должно быть не пустое и быть цифрой</i>
</body>
</html>
