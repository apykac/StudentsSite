<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод оценок</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<p>Введите данные оценки</p>
<form action="${pageContext.request.contextPath}/method/to_page" method="post">
    <table>
        <tr>
            <td><label for="student">ID студента</label></td>
            <td><input type="text" name="student" id="student"></td>
        </tr>
        <tr>
            <td><label for="subject">ID предмета</label></td>
            <td><input type="text" name="subject" id="subject"></td>
        </tr>
        <tr>
            <td><label for="begin">Период (ОТ)</label></td>
            <td><input type="date" name="begin" id="begin"></td>
        </tr>
        <tr>
            <td><label for="end">Период (ДО)</label></td>
            <td><input type="date" name="end" id="end"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="get_to_page_mark">
    <input type="submit" name="Вывести оценки">
</form>
<br>
<i></i>
</body>
</html>