<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Обновление урока</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<form action="${pageContext.request.contextPath}/method/update_data" method="post">
    <table>
        <tr>
            <td><label for="subjectId">ID предмета</label></td>
            <td><input type="text" name="subjectId" id="subjectId"></td>
        </tr>
        <tr>
            <td><label for="date">Дата урока</label></td>
            <td><input type="date" name="date" id="date"></td>
        </tr>
    </table>
    <br>
    <b>Введите ID изменяемого урока:</b>
    <br>
    <table>
        <tr>
            <td><label for="id">ID изменяемого Урока</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="update_lesson">
    <input type="submit" name="Обновить урок">
</form>
<%@include file="../pieces/error_to_page.jsp"%>
<i>
    Если ID урока будет ввдено не корректно или не существует, то обновления не произойдет
    <br>
    ID предмет должно совпадать с ID существуещего предмета
</i>
</body>
</html>