package tsc.javaeeproject.Controller.Servlet;

import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.Teacher;
import tsc.javaeeproject.Service.TeacherService;
import tsc.javaeeproject.Service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherService service = new TeacherServiceImpl();
        String operate = req.getParameter("operate");
        String id = req.getParameter("tea_id");
        Map<String, String[]> map = req.getParameterMap();
        Teacher teacher = new Teacher();
        switch (operate){
            case "delete":
                boolean x = service.deleteTeacherByID(id);
                if (x)
                    resp.sendRedirect("teacher_table.jsp");
                break;
            case "edit":
                teacher = service.findTeacherByID(id);
                req.getSession().setAttribute("tea",teacher);
                resp.sendRedirect("edit_tea.jsp");
                break;
            case "update":
                try {
                    BeanUtils.populate(teacher,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.update(teacher);
                resp.sendRedirect("teacher_table.jsp");
                break;
            case "add":
                try {
                    BeanUtils.populate(teacher,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.regist(teacher);
                resp.sendRedirect("teacher_table.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
