<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.innopolis.stc9.pojo.Course" %>
<%@ page import="java.util.List" %>
<%List<Object> objects = (List<Object>) request.getAttribute("objects");%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Вывод курсов</title>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%>
    <a href="${pageContext.request.contextPath}/defaultmenu">Вернуться в меню</a>
    <p>Список курсов: </p>
    <ul>
        <%for (Object course: objects) {%>
        <li>
            <%=((Course)course).getId()%>
            <%=((Course)course).getName()%>
        </li>
        <%}%>
    </ul>
</body>
</html>
