<%@ page import="ru.innopolis.stc9.pojo.Lesson" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc9.pojo.DBObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<DBObject> objects = (List<DBObject>) request.getAttribute("objects");%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод уроков</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
<%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
<br>
<br>
<p>Список уроков: </p>
<table>
    <tr>
        <th>ID</th>
        <th>Название предмета</th>
        <th>Начало урока</th>
        <th>Конец урока</th>
    </tr>
    <%for (DBObject lesson: objects) {%>
    <tr>
        <td><%=((Lesson)lesson).getId()%></td>
        <td>(<%=((Lesson)lesson).getSubjectId()%>) <%if (((Lesson)lesson).getSubject()!=null) {%><%=((Lesson)lesson).getSubject().getName()%><%}%></td>
        <td><%=((Lesson)lesson).getBegin()%></td>
        <td><%=((Lesson)lesson).getEnd()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>