<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pieces/heade_error_init.jsp"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Удаление студента</title>
    <style><%@include file='../styles/styles.css'%></style>
</head>
<body>
    <%@include file="../pieces/logout_panel.jsp"%> <%@include file="../pieces/back_to_menu.jsp"%>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/method/del_data" method="post">
        <table>
            <tr>
                <td><label for="id">Введите ID студента</label></td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
        </table>
        <input type="hidden" name="methodType" value="del_student">
        <input type="submit" name="Удалить студента">
    </form>
    <%@include file="../pieces/error_to_page.jsp"%>
    <i>ID студента должно быть не пустое и быть цифрой</i>
</body>
</html>
