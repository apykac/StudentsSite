<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод курсов</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <p>Введите данные курса</p>
    <form action="${pageContext.request.contextPath}/method/to_page" method="post">
        <label>Название курса: <input type="text" name="course"></label>
        <br>
        <input type="submit" name="Вывести курсы">
        <input type="hidden" name="methodType" value="courses_to_page">
    </form>
    <i>Если оставить поле пустым, выведутся все курсы</i>
</body>
</html>
