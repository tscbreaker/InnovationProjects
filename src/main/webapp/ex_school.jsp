<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page import="java.util.Set" %>
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
    List<Map<String, Object>> submit_project = service.findSchoolSubmitProject(request.getSession().getAttribute("id"));
    List<Map<String, Object>> mid_project = service.findSchoolMidProject(request.getSession().getAttribute("id"));
    List<Map<String, Object>> res_project = service.findSchoolResProject(request.getSession().getAttribute("id"));
%>

<table>
    <tr><th>项目号</th><th>项目名称</th><th>是否已打分</th><th>项目级别</th><th>项目类型</th><th>项目周期</th></tr>
    <%
        for (Map<String, Object> stringObjectMap : submit_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='expert_score.jsp?p_id="+stringObjectMap.get("p_id")+"&p_period="+stringObjectMap.get("p_period")+"'>打分</a></td>");
            out.print("</tr>");
        }
        for (Map<String, Object> stringObjectMap : mid_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='expert_score.jsp?p_id="+stringObjectMap.get("p_id")+"&p_period="+stringObjectMap.get("p_period")+"'>打分</a></td>");
            out.print("</tr>");
        }
        for (Map<String, Object> stringObjectMap : res_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='expert_score.jsp?p_id="+stringObjectMap.get("p_id")+"&p_period="+stringObjectMap.get("p_period")+"'>打分</a></td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>