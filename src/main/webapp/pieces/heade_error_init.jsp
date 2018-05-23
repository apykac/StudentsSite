<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%
    String errorMsg = request.getParameter("error");
    List<String> errors = (List<String>) request.getAttribute("errorMsg");
%>