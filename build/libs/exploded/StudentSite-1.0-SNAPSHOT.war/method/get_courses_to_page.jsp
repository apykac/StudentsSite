<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.innopolis.stc9.pojo.Course" %>
<%@ page import="java.util.List" %>
<%List<Course> courses = (List<Course>) request.getAttribute("courses");%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод курсов</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
<p>Список курсов: </p>
<ul>
    <%for (Course course: courses) {%>
    <li>
        <%=course.getId()%>
        <%=course.getName()%>
    </li>
    <%}%>
</ul>
</body>
</html>
