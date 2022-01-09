<%@ page import="tsc.javaeeproject.Domain.Academyad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Academyad aca = (Academyad) request.getSession().getAttribute("aca");
%>
<form name="form1" action="academyadServlet" method="post">
    <table border="0" align="center">
        <tr>
            <td>工号</td><td><input type="text" name="aca_id" value="<%=aca.getAca_id()%>" readonly></td>
        </tr>
        <tr>
            <td>姓名</td><td><input type="text" name="name" value="<%=aca.getName()%>"></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="text" name="password" value="<%=aca.getPassword()%>"></td>
        </tr>
        <tr>
            <td>学院</td><td><input type="text" name="academy" value="<%=aca.getAcademy()%>"></td>
        </tr>
        <tr hidden>
            <td></td><td><input type="text" name="operate" value="update">update</td>
        </tr>
        <tr>
            <td></td><td><input type="submit" value="提交更改"></td>
        </tr>
    </table>
</form>
</body>
</html>