<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
    List<String> errors = (List<String>) request.getAttribute("errorMsg");
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Обновление данных курса</title>
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
            <td><label for="name">Название курса</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
    </table>
    <br>
    <b>Введите ID изменяемого курса:</b>
    <br>
    <table>
        <tr>
            <td><label for="id">ID изменяемого курса</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="update_course">
    <input type="submit" name="Обновить курс">
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
    Название курса не должно быть пустым
</i>
</body>
</html>