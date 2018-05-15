<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавление студента</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/method/add_student" method="post">
        <label>Имя: <input type="text" name="firstName"></label>
        <br>
        <label>Фамилия: <input type="text" name="secondName"></label>
        <br>
        <label>Отчество: <input type="text" name="middleName"></label>
        <br>
        <label>Курс: <input type="text" name="courseId"></label>
        <br>
        <input type="submit" name="Добавить студента">
    </form>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
</body>
</html>
