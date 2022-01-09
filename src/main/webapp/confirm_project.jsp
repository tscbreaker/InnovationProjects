<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProjectService service = new ProjectServiceImpl();
    List<Map<String, Object>> stu_project = service.findStuProject(request.getSession().getAttribute("id"));
%>
<table>
    <tr><th>学号</th><th>项目号</th><th>项目名称</th><th>是否为负责人</th><th>是否确认</th></tr>
    <%
        for (Map<String, Object> stringObjectMap : stu_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='confirmServlet?stu_id="+stringObjectMap.get("stu_id")+"&p_id="+stringObjectMap.get("p_id")+"'>确认加入项目</a></td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
