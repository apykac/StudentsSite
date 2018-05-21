<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<%if ((errorMsg != null) && errorMsg.equals("true")) {%>
<b>
    <%for (String s: errors) {%>
    <%=s%>
    <br>
    <%}%>
</b>
<%}%>
<br>
