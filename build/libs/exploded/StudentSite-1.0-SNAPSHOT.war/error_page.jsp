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
            pathToGo = "default";
        }
    %>
    <h1><%=displayErrMsg%></h1>
    <br>
    <a href="${pageContext.request.contextPath}/<%=pathToGo%>">Продолжить работу на сайте</a>
</body>
</html>
