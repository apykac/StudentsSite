<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод предметов</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<p>Введите данные предмета</p>
<form action="${pageContext.request.contextPath}/method/to_page" method="post">
    <table>
        <tr>
            <td><label for="name">Название предмета</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
    </table>
    <input type="hidden" name="methodType" value="get_to_page_subject">
    <input type="submit" name="Вывести предметы">
</form>
<br>
<i>Если оставить поле не заполненым то будут выведенны все предметы</i>
</body>
</html>