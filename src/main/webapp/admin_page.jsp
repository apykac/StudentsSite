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
        <li><a href="${pageContext.request.contextPath}/method?method=get_subject">Вывод предметов по названию</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=get_lesson">Вывод уроков</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=get_mark">Вывод оценок</a></li>
    </ul>
    <br>
    <h3>Добавление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=add_student">Добавить студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=add_course">Добавить курс</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=add_subject">Добавить предмет</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=add_lesson">Добавить урок</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=add_mark">Добавить оценку</a></li>
    </ul>
    <br>
    <h3>Удаление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=del_student">Удалить студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=del_course">Удалить курс</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=del_subject">Удалить предмет</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=del_lesson">Удалить урок</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=del_mark">Удалить оценку</a></li>
    </ul>
    <br>
    <h3>Обновление данных:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/method?method=update_student">Обновить данные студента</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=update_course">Обновить данные курса</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=update_subject">Обновить данные предмета</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=update_lesson">Обновить данные урока</a></li>
        <li><a href="${pageContext.request.contextPath}/method?method=update_mark">Обновить данные оценки</a></li>
    </ul>
</body>
</html>
