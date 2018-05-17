<%@ page import="ru.innopolis.stc9.Servlets.ConstantContainer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
[<a href="${pageContext.request.contextPath}/login?logout=true">ВЫХОД</a>] @<b><%=request.getSession().getAttribute(ConstantContainer.USERNAME)%></b>