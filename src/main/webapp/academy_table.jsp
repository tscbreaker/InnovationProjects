<%@ page import="tsc.javaeeproject.Service.AcademyadService" %>
<%@ page import="tsc.javaeeproject.Service.impl.AcademyadServiceImpl" %>
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
        AcademyadService service = new AcademyadServiceImpl();
        List<Map<String, Object>> academyad=service.findAllAcademyad();
    %>
    <a href="addAcad_sch.html">添加学院管理员</a>
    <table>
        <tr>
            <th>工号</th><th>密码</th><th>姓名</th><th>学院</th>
        </tr>
        <%
            for (Map<String, Object> stringObjectMap : academyad) {
                Set<String> keySet = stringObjectMap.keySet();
                out.print("<tr>");
                for(String s:keySet) {
                    out.print("<td>"+stringObjectMap.get(s)+"</td>");
                }
                out.print("<td><a href='academyadServlet?operate=delete&aca_id="+stringObjectMap.get("aca_id")+"'>删除</a>" +"&nbsp"+
                        "<a href='academyadServlet?operate=edit&aca_id="+stringObjectMap.get("aca_id")+"'>编辑</a></td>");
                out.print("</tr>");
                System.out.println();
            }
        %>
    </table>
</body>
</html>
