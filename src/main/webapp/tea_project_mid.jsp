<%@ page import="java.util.Set" %>
<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProjectService service = new ProjectServiceImpl();
    List<Map<String, Object>> tea_project = service.findMidTeaProject(request.getSession().getAttribute("id"));
%>
<table>
    <tr><th>工号</th><th>项目号</th><th>项目名称</th><th>是否为负责人</th><th>是否确认</th><th>项目级别</th><th>项目类型</th><th>项目周期</th></tr>
    <%
        for (Map<String, Object> stringObjectMap : tea_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='teacher_sug.jsp?p_id="+stringObjectMap.get("p_id")+"'>中期确认</a></td>");
            out.print("</tr>");
        }
        session.setAttribute("operate","mid");
    %>
</table>
</body>
</html>
