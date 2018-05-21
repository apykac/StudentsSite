<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Обновление предмета</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<form action="${pageContext.request.contextPath}/method/add_data" method="post">
    <table>
        <tr>
            <td><label for="name">Название предмета</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td><label for="courseId">ID курса</label></td>
            <td><input type="text" name="courseId" id="courseId"></td>
        </tr>
    </table>
    <br>
    <b>Введите ID изменяемого предмета:</b>
    <br>
    <table>
        <tr>
            <td><label for="id">ID изменяемого предмета</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="update_subject">
    <input type="submit" name="Добавить предмет">
</form>
<%@include file="../pieces/error_to_page.jsp"%>
<i>
    Если ID предмета будет ввдено не корректно или не существует, то обновления не произойдет
    <br>
    Имя не должно быть пустым, ID курса должно соответствовать существующему ID курса
</i>
</body>
</html>