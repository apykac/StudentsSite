<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод курсов</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <p>Введите данные курса</p>
    <form action="${pageContext.request.contextPath}/method/to_page" method="post">
        <table>
            <tr>
                <td><label for="course">Название курса</label></td>
                <td><input type="text" name="name" id="course"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="courses_to_page">
        <input type="submit" name="Вывести курсы">
    </form>
    <br>
    <i>Если оставить поле пустым, выведутся все курсы</i>
</body>
</html>
