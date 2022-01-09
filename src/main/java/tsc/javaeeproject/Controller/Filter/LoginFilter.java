package tsc.javaeeproject.Controller.Filter;

import tsc.javaeeproject.Service.IdentifyService;
import tsc.javaeeproject.Service.impl.IdentifyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    String[] escapeURLs = {"login.html", "regist.html", "Servlet", "header.html", "footer.html", "checkCode", ".js", ".css","jurisdiction.html"};
    String[] studentURLs = {"notice.jsp","stu_index.html", "addTeacher_sch.html", "project_submit.html", "project_submit_table.jsp", "project_mid_table.jsp", "project_res_table.jsp", "project_submit.jsp", "project_res.jsp", "confirm_project.jsp", "editstu_pf.jsp"};
    String[] teacherURLs = {"notice.jsp","tea_index.html","tea_project_submit.jsp","tea_project_mid.jsp","tea_project_res.jsp","teacher_sug.jsp","edittea_pf.jsp"};
    String[] academyadURLs = {"download","notice.jsp","acad_index.html", "addTeacher_acad.html", "nation_project.jsp" ,"province_project.jsp","school_project.jsp","academy_project.jsp","verify.jsp","teacher_table.jsp","student_table.jsp","addStudent_acad.html","edit_tea.jsp","edit_stu.jsp"};
    String[] schooladURLs = {"download","notice.jsp","academy_table.jsp","addStudent_sch.html", "addTeacher_sch.html","addAcad_sch.html", "nation_project.jsp" ,"province_project.jsp","school_project.jsp","academy_project.jsp","verify.jsp","teacher_table_sch.jsp","student_table_sch.jsp","notice_edit.jsp","scad_index.html","edit_tea.jsp","edit_stu.jsp","edit_aca.jsp"};
    String[] expertURLs = {"download","notice.jsp","ex_nation.jsp","ex_province.jsp","ex_school.jsp","ex_academy.jsp","ex_index.html","expert_score.jsp"};

    private boolean isFilter(String uri, String[] strings) {
        boolean flag = false;
        for (String s : strings) {
            if (uri.contains(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        IdentifyService service = new IdentifyServiceImpl();
        String uri = httpReq.getRequestURI();
        int id = service.identify((String) httpReq.getSession().getAttribute("id"));
        if (isFilter(uri, escapeURLs)) {
            chain.doFilter(req, res);
        } else if (id == 1) {
            if (isFilter(uri, studentURLs)) chain.doFilter(req, res);
            else httpRes.sendRedirect("jurisdiction.html");
        } else if (id == 2) {
            if (isFilter(uri, teacherURLs)) chain.doFilter(req, res);
            else httpRes.sendRedirect("jurisdiction.html");
        } else if (id == 3) {
            if (isFilter(uri, academyadURLs)) chain.doFilter(req, res);
            else httpRes.sendRedirect("jurisdiction.html");
        } else if (id == 4) {
            if (isFilter(uri, schooladURLs)) chain.doFilter(req, res);
            else httpRes.sendRedirect("jurisdiction.html");
        } else if (id == 5) {
            if (isFilter(uri, expertURLs)) chain.doFilter(req, res);
            else httpRes.sendRedirect("jurisdiction.html");
        } else {
            httpRes.sendRedirect("login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}