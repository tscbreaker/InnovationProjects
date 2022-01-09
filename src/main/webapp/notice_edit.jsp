<%@ page import="tsc.javaeeproject.Service.NoticeService" %>
<%@ page import="tsc.javaeeproject.Service.impl.NoticeServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="noticeServlet" method="post">
    编辑公告头<input type="text" name="special_notice">
    编辑公告<input type="text" name="content">
    <input type="submit" value="发布公告">
</form>
</body>
</html>
