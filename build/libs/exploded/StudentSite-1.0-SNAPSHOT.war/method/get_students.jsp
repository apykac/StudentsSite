<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод студентов</title>
</head>
<body>
    <p>Введите данные студента</p>
    <form action="${pageContext.request.contextPath}/method/get_students_to_page" method="post">
        <label>Имя: <input type="text" name="firstName"></label>
        <br>
        <label>Фамилия: <input type="text" name="secondName"></label>
        <br>
        <label>Отчество: <input type="text" name="middleName"></label>
        <br>
        <input type="submit" name="Вывести студентов">
    </form>
    <i>
        Если оставить одно из полей не заполненым то автоматически включает диапозон поиска студентов,
        <br>
        будут выведенны все студенты с задаными параметрами имени.
    </i>
</body>
</html>
