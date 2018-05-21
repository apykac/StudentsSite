<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод студентов</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <p>Введите данные студента</p>
    <form action="${pageContext.request.contextPath}/method/to_page" method="post">
        <table>
            <tr>
                <td><label for="firstName">Имя</label></td>
                <td><input type="text" name="firstName" id="firstName"></td>
            </tr>
            <tr>
                <td><label for="secondName">Фамилия</label></td>
                <td><input type="text" name="secondName" id="secondName"></td>
            </tr>
            <tr>
                <td><label for="middleName">Отчество</label></td>
                <td><input type="text" name="middleName" id="middleName"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="get_to_page_student">
        <input type="submit" name="Вывести студентов">
    </form>
    <br>
    <i>
        Если оставить одно из полей не заполненым то автоматически включает диапозон поиска студентов,
        <br>
        будут выведенны все студенты с задаными параметрами имени.
    </i>
</body>
</html>
