<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление курса</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/method/add_data" method="post">
        <table>
            <tr>
                <td><label for="courseName">Название курса</label></td>
                <td><input type="text" name="course" id="courseName"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="add_course">
        <input type="submit" name="Добавить курс">
    </form>
    <br>
    <%if ((errorMsg != null) && errorMsg.equals("addCourseError")) {%> <b>Введены не корректные название курса</b> <%}%>
    <br>
    <i>Название курса не должно быть пустым</i>
</body>
</html>
