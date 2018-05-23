<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Обновление оценки</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<form action="${pageContext.request.contextPath}/method/update_data" method="post">
    <table>
        <tr>
            <td><label for="studentId">ID студета</label></td>
            <td><input type="text" name="studentId" id="studentId"></td>
        </tr>
        <tr>
            <td><label for="lessonId">ID урока</label></td>
            <td><input type="text" name="lessonId" id="lessonId"></td>
        </tr>
        <tr>
            <td><label for="value">Значение оценки</label></td>
            <td><input type="text" name="value" id="value"></td>
        </tr>
    </table>
    <b>Введите ID изменяемой оценки:</b>
    <br>
    <table>
        <tr>
            <td><label for="id">ID изменяемой оценки</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="update_mark">
    <input type="submit" name="Изменить оценку">
</form>
<%@include file="../pieces/error_to_page.jsp"%>
<i>
    Если ID предмета будет ввдено не корректно или не существует, то обновления не произойдет
    <br>
    ID студента и урока должно соответствовать существующим соответвутствующим ID,
    <br>
    значение оценки должно быть от 0 до 100
</i>
</body>
</html>