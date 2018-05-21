<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод уроков</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<p>Введите данные урока</p>
<form action="${pageContext.request.contextPath}/method/to_page" method="post">
    <table>
    </table>
    <input type="hidden" name="methodType" value="get_to_page_lesson">
    <input type="submit" name="Вывести уроки">
</form>
<br>
<i></i>
</body>
</html>