<%@ page import="tsc.javaeeproject.Service.StudentService" %>
<%@ page import="tsc.javaeeproject.Service.impl.StudentServiceImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="tsc.javaeeproject.Service.AcademyadService" %>
<%@ page import="tsc.javaeeproject.Service.impl.AcademyadServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        StudentService service = new StudentServiceImpl();
        AcademyadService serviceaca = new AcademyadServiceImpl();
        String id = (String) request.getSession().getAttribute("id");
        String aca = serviceaca.findAcademyadById(id).getAcademy();
        List<Map<String, Object>> student = service.findStudentByAcademy(aca);
    %>
    <a href="addStudent_acad.html">添加学生</a>
    <table>
        <tr>
            <th>学号</th><th>密码</th><th>姓名</th><th>性别</th><th>邮箱</th><th>学院</th>
        </tr>
        <%
            for (Map<String, Object> stringObjectMap : student) {
                Set<String> keySet = stringObjectMap.keySet();
                out.print("<tr>");
                for(String s:keySet) {
                    out.print("<td>"+stringObjectMap.get(s)+"</td>");
                }
                out.print("<td><a href='studentServlet?operate=delete&stu_id="+stringObjectMap.get("stu_id")+"'>删除</a>" +"&nbsp"+
                        "<a href='studentServlet?operate=edit&stu_id="+stringObjectMap.get("stu_id")+"'>编辑</a></td>");
                out.print("</tr>");
                System.out.println();
            }
        %>
    </table>
</body>
</html>
