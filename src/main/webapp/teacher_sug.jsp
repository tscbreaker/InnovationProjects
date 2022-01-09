<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%
        request.getSession().setAttribute("p_id",request.getParameter("p_id"));
    %>
    <form name="form" action="teacherConfirmServlet" method="post">
        项目建议：<input type="text" name="suggestion">
        <input type="submit" value="确认">
    </form>
</div>
</body>
</html>
