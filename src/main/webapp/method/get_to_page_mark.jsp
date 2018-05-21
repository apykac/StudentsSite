<%@ page import="ru.innopolis.stc9.pojo.Mark" %>
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
        <th>ФИО студента</th>
        <th>Урок</th>
        <th>Заначение</th>
    </tr>
    <%for (DBObject mark: objects) {%>
    <tr>
        <td><%=((Mark)mark).getId()%></td>
        <td>(<%=((Mark)mark).getStudentId()%>) <%if (((Mark)mark).getStudent()!=null) {%><%=((Mark)mark).getStudent().getSecondName()%> <%=((Mark)mark).getStudent().getFirstName()%> <%=((Mark)mark).getStudent().getMiddleName()%><%}%></td>
        <td>(<%=((Mark)mark).getLessonId()%>) <%if (((Mark)mark).getLesson()!=null) {%>[<%=((Mark)mark).getLesson().getSubjectId()%>] <%=((Mark)mark).getLesson().getSubject().getName()%> <%=((Mark)mark).getLesson().getBegin()%> / <%=((Mark)mark).getLesson().getEnd()%><%}%></td>
        <td><%=((Mark)mark).getValue()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
