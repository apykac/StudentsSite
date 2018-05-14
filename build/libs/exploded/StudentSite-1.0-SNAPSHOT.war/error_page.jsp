<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 13.05.2018
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>ERROR PAGE</title>
</head>
<body>
    <%
        String errorMessage = request.getParameter("error_message");
        String displayErrMsg = "";
        String pathToGo = "";
        if (errorMessage.equals("authorisationError")) {
            displayErrMsg = "Ошибка авторизации, попробуйте авторизоваться снова";
            pathToGo = "login";
        }
        if (errorMessage.equals("permissionError")) {
            displayErrMsg = "Недостаточно прав";
            pathToGo = "defaultmenu";
        }
    %>
    <h1><%=displayErrMsg%></h1>
    <br>
    <a href="${pageContext.request.contextPath}/<%=pathToGo%>">Продолжить работу на сайте</a>
</body>
</html>
