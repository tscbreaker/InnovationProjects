<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="tsc.javaeeproject.Service.AcademyadService" %>
<%@ page import="tsc.javaeeproject.Service.impl.AcademyadServiceImpl" %>
<%@ page import="tsc.javaeeproject.Service.TeacherService" %>
<%@ page import="tsc.javaeeproject.Service.impl.TeacherServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    TeacherService service = new TeacherServiceImpl();
    List<Map<String, Object>> teacher = service.findAllTeacher();
%>
<a href="addTeacher_sch.html">添加导师</a>
<table>
    <tr>
        <th>工号</th><th>密码</th><th>姓名</th><th>性别</th><th>邮箱</th><th>学院</th>
    </tr>
    <%
        for (Map<String, Object> stringObjectMap : teacher) {
            Set<String> keySet = stringObjectMap.keySet();
            out.print("<tr>");
            for(String s:keySet) {
                out.print("<td>"+stringObjectMap.get(s)+"</td>");
            }
            out.print("<td><a href='teacherServlet?operate=delete&tea_id="+stringObjectMap.get("tea_id")+"'>删除</a>" +"&nbsp"+
                    "<a href='teacherServlet?operate=edit&tea_id="+stringObjectMap.get("tea_id")+"'>编辑</a></td>");
            out.print("</tr>");
            System.out.println();
        }
    %>
</table>
</body>
</html>
