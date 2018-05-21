<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление урока</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<form action="${pageContext.request.contextPath}/method/add_data" method="post">
    <table>
        <tr>
            <td><label for="subjectId">ID предмета</label></td>
            <td><input type="text" name="subjectId" id="subjectId"></td>
        </tr>
        <tr>
            <td><label for="begin">Начало урока</label></td>
            <td><input type="date" name="begin" id="begin"></td>
        </tr>
        <tr>
            <td><label for="end">Конец урока</label></td>
            <td><input type="date" name="end" id="end"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="add_lesson">
    <input type="submit" name="Добавить урок">
</form>
<%@include file="../pieces/error_to_page.jsp"%>
<i>ID предмет должно совпадать с ID существуещего предмета</i>
</body>
</html>