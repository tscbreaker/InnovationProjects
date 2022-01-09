<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<%
    request.getSession().removeAttribute("id");
    response.sendRedirect("login.html");
%>
</body>
</html>
</html>