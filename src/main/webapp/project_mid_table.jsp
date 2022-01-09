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
    List<Map<String, Object>> stu_project = service.findMidStuProject(request.getSession().getAttribute("id"));
%>
<table>
    <tr><th>学号</th><th>项目号</th><th>项目名称</th><th>是否为负责人</th><th>是否确认</th><th>项目级别</th><th>项目类型</th><th>项目周期</th></tr>
    <%
        for (Map<String, Object> stringObjectMap : stu_project) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><form method=\"post\" action=\"uploadServlet?operate=mid&p_id="+stringObjectMap.get("p_id")+"\" enctype=\"multipart/form-data\">\n" +
                    "\t\t\t选择一个文件: <input type=\"file\" name=\"submit_file\" /> \n" +
                    "\t\t\t     <input type=\"submit\" value=\"上传立项报告\" />\n" +
                    "\t\t</form></td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>