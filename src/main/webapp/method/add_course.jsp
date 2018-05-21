<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
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
                <td><label for="name">Название курса</label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="add_course">
        <input type="submit" name="Добавить курс">
    </form>
    <%@include file="../pieces/error_to_page.jsp"%>
    <i>Название курса не должно быть пустым</i>
</body>
</html>
