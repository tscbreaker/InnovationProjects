<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Domain.Project" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProjectService service = new ProjectServiceImpl();
    Project project = service.findProjectByID(request.getParameter("p_id"));
%>
<table>
    <tr><td>项目名称：</td><td><%=project.p_name%></td></tr>
    <tr><td>项目类型：</td><td><%=project.p_type%></td></tr>
    <tr><td>项目学科：</td><td><%=project.subjecttype%></td></tr>
    <tr><td>项目主要内容简介:</td><td><%=project.p_info%></td></tr>
    <tr><td>项目背景、目的及意义:</td><td><%=project.meaning%></td></tr>
    <tr><td>项目研究方案:</td><td><%=project.method%></td></tr>
    <tr><td>项目研究条件及创新之处:</td><td><%=project.creative%></td></tr>
    <tr><td>项目预期成果:</td><td><%=project.pre_result%></td></tr>
    <td>项目立项报告：</td><td><a href="download/upload/<%=project.submit_report%>">下载</a></td>
    <td>项目中期报告：</td><td><a href="download/upload/<%=project.mid_report%>">下载</a></td>
    <td>项目结题报告：</td><td><a href="download/upload/<%=project.res_report%>">下载</a></td>
</table>
<form action="scoreServlet?p_id=<%=project.p_id%>&operate=<%=request.getParameter("p_period")%>" method="post">
    分数：<input type="text" name="score"><br>
    专家意见：<input type="text" name="suggestion"><br>
    <input type="submit" value="提交打分">
</form>
</body>
</html>
