<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProjectService service = new ProjectServiceImpl();
    List<Map<String, Object>> project = service.acadProject(request.getParameter("id"),"school");
%>
<table>
    <tr><th>项目号</th><th>项目名称</th><th>项目级别</th><th>项目类型</th><th>项目周期</th><th>是否待审核</th></tr>
    <%
        for (Map<String, Object> stringObjectMap : project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='verify.jsp?p_id="+stringObjectMap.get("p_id")+"&p_period="+stringObjectMap.get("p_period")+"'>审核</a></td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
</body>
</html>
