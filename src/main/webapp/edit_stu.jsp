<%@ page import="tsc.javaeeproject.Domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student stu = (Student) request.getSession().getAttribute("stu");
%>
<form name="form1" action="studentServlet" method="post">
    <table border="0" align="center">
        <tr>
            <td>学号</td><td><input type="text" name="stu_id" value="<%=stu.getStu_id()%>" readonly></td>
        </tr>
        <tr>
            <td>姓名</td><td><input type="text" name="name" value="<%=stu.getName()%>"></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="text" name="password" value="<%=stu.getPassword()%>"></td>
        </tr>
        <tr>
            <td>性别</td><td><input type="text" name="sex" value="<%=stu.getSex()%>"></td>
        </tr>
        <tr>
            <td>邮箱</td><td><input type="text" name="stu_mail" value="<%=stu.getStu_mail()%>"></td>
        </tr>
        <tr>
            <td>学院</td><td><input type="text" name="academy" value="<%=stu.getAcademy()%>"></td>
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