<%@ page import="tsc.javaeeproject.Domain.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Teacher tea = (Teacher) request.getSession().getAttribute("tea");
%>
<form name="form1" action="teacherServlet" method="post">
    <table border="0" align="center">
        <tr>
            <td>工号</td><td><input type="text" name="tea_id" value="<%=tea.getTea_id()%>" readonly></td>
        </tr>
        <tr>
            <td>姓名</td><td><input type="text" name="name" value="<%=tea.getName()%>"></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="text" name="password" value="<%=tea.getPassword()%>"></td>
        </tr>
        <tr>
            <td>性别</td><td><input type="text" name="sex" value="<%=tea.getSex()%>"></td>
        </tr>
        <tr>
            <td>邮箱</td><td><input type="text" name="tea_mail" value="<%=tea.getTea_mail()%>"></td>
        </tr>
        <tr>
            <td>学院</td><td><input type="text" name="academy" value="<%=tea.getAcademy()%>"></td>
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
