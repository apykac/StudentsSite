<%@ page import="ru.innopolis.stc9.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Student> students = (List<Student>) request.getAttribute("students");%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод студентов</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
    <p>Список студентов: </p>
    <ul>
        <%for (Student student: students) {%>
            <li>
                <%=student.getId()%>
                <%=student.getSecondName()%>
                <%=student.getFirstName()%>
                <%=student.getMiddleName()%>
                <%=student.getCourseId()%>
            </li>
        <%}%>
    </ul>
</body>
</html>
