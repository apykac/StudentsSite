<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка</title>
</head>
<body>
    <%@include file="/pieces/logout_panel.jsp"%>
    <h2>Выберите желаемое действие:</h2>
    <h3>Вывод данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=get_student">Вывод стедентов по ФИО</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=get_course">Вывод курсов по названию</a></li>
    </ul>
    <br>
    <h3>Добавление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=add_student">Добавить студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=add_course">Добавить курс</a></li>
    </ul>
    <br>
    <h3>Удаление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=del_student">Удалить студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=del_course">Удалить курс</a></li>
    </ul>
    <br>
    <h3>Обновление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=update_student">Обновить данные студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=update_course">Обновить данные курса</a></li>
    </ul>
</body>
</html>
