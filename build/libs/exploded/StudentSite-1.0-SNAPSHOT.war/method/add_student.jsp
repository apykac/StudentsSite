<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление студента</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/method/add_data" method="post">
        <table>
            <tr>
                <td><label for="firstName">Имя</label></td>
                <td><input type="text" name="firstName" id="firstName"></td>
            </tr>
            <tr>
                <td><label for="secondName">Фамилия</label></td>
                <td><input type="text" name="secondName" id="secondName"></td>
            </tr>
            <tr>
                <td><label for="middleName">Отчество</label></td>
                <td><input type="text" name="middleName" id="middleName"></td>
            </tr>
            <tr>
                <td><label for="courseId">Курс</label></td>
                <td><input type="text" name="courseId" id="courseId"></td>
            </tr>
        </table>
        <input type="submit" name="Добавить студента">
        <input type="hidden" name="methodType" value="add_student">
    </form>
    <br>
    <%if ((errorMsg != null) && errorMsg.equals("addStudentError")) {%> <b>Введены не корректные данные ФИО студента</b> <%}%>
    <br>
    <i>Имя, фамилия и курс не должны быть пустыми, отчество может отсутствовать</i>
</body>
</html>
