<%@ page import="tsc.javaeeproject.Service.NoticeService" %>
<%@ page import="tsc.javaeeproject.Service.impl.NoticeServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        NoticeService service = new NoticeServiceImpl();
        String speical_notice = service.getSpecialNotice();
        String content = service.getContent();
    %>
    <h3><%=speical_notice%></h3>
    <p><%=content%></p>
</body>
</html>
