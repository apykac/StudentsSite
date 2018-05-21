<%@ page import="ru.innopolis.stc9.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc9.pojo.DBObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<DBObject> objects = (List<DBObject>) request.getAttribute("objects");%>
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
    <p>Список студентов: </p>
    <table>
        <tr>
            <th>ID</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Название курса</th>
        </tr>
        <%for (DBObject student: objects) {%>
        <tr>
            <td><%=((Student)student).getId()%></td>
            <td><%=((Student)student).getSecondName()%></td>
            <td><%=((Student)student).getFirstName()%></td>
            <td><%=((Student)student).getMiddleName()%></td>
            <td>(<%=((Student)student).getCourseId()%>) <%if (((Student)student).getCourse()!=null) {%><%=((Student)student).getCourse().getName()%><%}%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
