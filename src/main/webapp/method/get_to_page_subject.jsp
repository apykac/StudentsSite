<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.innopolis.stc9.pojo.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc9.pojo.DBObject" %>
<%List<DBObject> objects = (List<DBObject>) request.getAttribute("objects");%>
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
<p>Список предметов: </p>
<table>
    <tr>
        <th>ID</th>
        <th>Название предмета</th>
        <th>Название курса</th>
    </tr>
    <%for (DBObject subject: objects) {%>
    <tr>
        <td><%=((Subject)subject).getId()%></td>
        <td><%=((Subject)subject).getName()%></td>
        <td>(<%=((Subject)subject).getCourseId()%>) <%if (((Subject)subject).getCourse()!=null) {%><%=((Subject)subject).getCourse().getName()%><%}%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
