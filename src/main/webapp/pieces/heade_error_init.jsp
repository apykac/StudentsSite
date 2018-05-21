<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsg = request.getParameter("error");
    List<String> errors = (List<String>) request.getAttribute("errorMsg");
%>