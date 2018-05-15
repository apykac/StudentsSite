<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Пользовательская Страница</title>
</head>
<body>
    <%@include file="/pieces/logout_panel.jsp"%>
    <p>Выберите желаемое действие:</p>
    <a href="${pageContext.request.contextPath}/method?method=get_students">Вывод стедентов по ФИО (если нет данных то выведуться все студенты)</a>
    <br>
    <a href="#allmarksByName">Вывод оценок конекретного Студента</a>
    <br>
    <a href="#allmarksByNameinPeriod">Вывод оценок конкретного Студента в выбранный промежуток</a>
</body>
</html>
