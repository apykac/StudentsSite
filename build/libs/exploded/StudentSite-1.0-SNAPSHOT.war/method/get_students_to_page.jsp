<%@ page import="ru.innopolis.stc9.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Object> objects = (List<Object>) request.getAttribute("objects");%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод студентов</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
    <p>Список студентов: </p>
    <ul>
        <%for (Object student: objects) {%>
            <li>
                <%=((Student)student).getId()%>
                <%=((Student)student).getSecondName()%>
                <%=((Student)student).getFirstName()%>
                <%=((Student)student).getMiddleName()%>
                <%=((Student)student).getCourseId()%>
            </li>
        <%}%>
    </ul>
</body>
</html>
