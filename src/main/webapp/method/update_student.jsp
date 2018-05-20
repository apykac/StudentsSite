<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
    List<String> errors = (List<String>) request.getAttribute("errorMsg");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Обновление данных студента</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<form action="${pageContext.request.contextPath}/method/update_data" method="post">
    <b>Введите изменяемые данные:</b>
    <br>
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
    <br>
    <b>Введите ID изменяемого стуента:</b>
    <br>
    <table>
        <tr>
            <td><label for="id">ID изменяемого Студента</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="update_student">
    <input type="submit" name="Update">
</form>
<br>
<%if ((errorMsg != null) && errorMsg.equals("true")) {%>
<b>
    <%for (String s: errors) {%>
    <%=s%>
    <br>
    <%}%>
</b>
<%}%>
<br>
<i>
    Если ID курса будет ввдено не корректно или не существует, то обновления не произойдет
    <br>
    Имя, фамилия и курс не должны быть пустыми, отчество может отсутствовать
</i>
</body>
</html>