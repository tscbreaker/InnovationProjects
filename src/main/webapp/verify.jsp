<%@ page import="tsc.javaeeproject.Service.ProjectService" %>
<%@ page import="tsc.javaeeproject.Domain.Project" %>
<%@ page import="tsc.javaeeproject.Service.impl.ProjectServiceImpl" %>
<%@ page import="tsc.javaeeproject.Domain.ExProject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProjectService service = new ProjectServiceImpl();
    Project project = service.findProjectByID(request.getParameter("p_id"));
    String p_type = project.p_type;
    String subjecttype = project.subjecttype;
    List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
    List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
    List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
    if(p_type.equals("nation") && subjecttype.equals("engineer")){
        list1 = service.findExProject("20191800",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191801",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191802",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("nation") && subjecttype.equals("literature")){
        list1 = service.findExProject("20191803",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191804",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191805",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("province") && subjecttype.equals("engineer")){
        list1 = service.findExProject("20191806",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191807",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191808",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("province") && subjecttype.equals("literature")){
        list1 = service.findExProject("20191809",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191810",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191811",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("school") && subjecttype.equals("engineer")){
        list1 = service.findExProject("20191812",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191813",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191814",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("school") && subjecttype.equals("literature")){
        list1 = service.findExProject("20191815",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191816",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191817",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("academy") && subjecttype.equals("engineer")){
        list1 = service.findExProject("20191818",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191819",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191820",request.getParameter("p_id"),request.getParameter("p_period"));
    }else if(p_type.equals("academy") && subjecttype.equals("literature")){
        list1 = service.findExProject("20191821",request.getParameter("p_id"),request.getParameter("p_period"));
        list2 = service.findExProject("20191822",request.getParameter("p_id"),request.getParameter("p_period"));
        list3 = service.findExProject("20191823",request.getParameter("p_id"),request.getParameter("p_period"));
    }
%>
<table>
    <tr><td>???????????????</td><td><%=project.p_name%></td></tr>
    <tr><td>???????????????</td><td><%=project.p_type%></td></tr>
    <tr><td>???????????????</td><td><%=project.subjecttype%></td></tr>
    <tr><td>????????????????????????:</td><td><%=project.p_info%></td></tr>
    <tr><td>??????????????????????????????:</td><td><%=project.meaning%></td></tr>
    <tr><td>??????????????????:</td><td><%=project.method%></td></tr>
    <tr><td>?????????????????????????????????:</td><td><%=project.creative%></td></tr>
    <tr><td>??????????????????:</td><td><%=project.pre_result%></td></tr>
    <tr><td>???????????????:</td><td><%=project.money%></td></tr>
    <tr><td>???????????????:</td><td><%=project.material_m%></td></tr>
    <tr><td>??????????????????:</td><td><%=project.print_m%></td></tr>
    <tr><td>??????????????????:</td><td><%=project.vehicle_m%></td></tr>
    <tr><td>?????????:</td><td><%=project.publish_m%></td></tr>
    <tr><td>?????????:</td><td><%=project.express_m%></td></tr>
    <td>?????????????????????</td><td><a href="download/upload/<%=project.submit_report%>">??????</a></td>
    <td>?????????????????????</td><td><a href="download/upload/<%=project.mid_report%>">??????</a></td>
    <td>?????????????????????</td><td><a href="download/upload/<%=project.res_report%>">??????</a></td>
    <tr><td>??????1?????????</td><td><%=list1.get(0).get("score")%></td></tr>
    <tr><td>??????1?????????</td><td><%=list1.get(0).get("suggestion")%></td></tr>
    <tr><td>??????2?????????</td><td><%=list2.get(0).get("score")%></td></tr>
    <tr><td>??????2?????????</td><td><%=list2.get(0).get("suggestion")%></td></tr>
    <tr><td>??????3?????????</td><td><%=list3.get(0).get("score")%></td></tr>
    <tr><td>??????3?????????</td><td><%=list3.get(0).get("suggestion")%></td></tr>
</table>
<a href="verifyServlet?p_id=<%=project.p_id%>&p_period=<%=request.getParameter("p_period")%>">????????????</a>
<a href="javascript:void(history.back())">?????????</a>
</body>
</html>