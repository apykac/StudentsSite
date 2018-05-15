<%@ page import="ru.innopolis.stc9.controllers.ConstantContainer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
@<%=request.getSession().getAttribute(ConstantContainer.USERNAME)%> [<a href="${pageContext.request.contextPath}/login?logout=true">ВЫХОД</a>]
<br>
<br>