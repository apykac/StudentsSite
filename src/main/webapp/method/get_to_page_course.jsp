<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.innopolis.stc9.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc9.pojo.DBObject" %>
<%List<DBObject> objects = (List<DBObject>) request.getAttribute("objects");%>
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
    <p>Список курсов: </p>
    <table>
        <tr>
            <th>ID</th>
            <th>Название</th>
        </tr>
        <%for (Object course: objects) {%>
        <tr>
            <td><%=((Course)course).getId()%></td>
            <td><%=((Course)course).getName()%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
