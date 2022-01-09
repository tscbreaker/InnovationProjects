package tsc.javaeeproject.Controller.Servlet;

import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.Student;
import tsc.javaeeproject.Service.StudentService;
import tsc.javaeeproject.Service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService service = new StudentServiceImpl();
        String operate = req.getParameter("operate");
        String id = req.getParameter("stu_id");
        Map<String, String[]> map = req.getParameterMap();
        Student student = new Student();
        switch (operate){
            case "delete":
                boolean x = service.deleteStudentByID(id);
                if (x)
                    resp.sendRedirect("student_table.jsp");
                break;
            case "edit":
                student = service.findStudentByID(id);
                req.getSession().setAttribute("stu",student);
                resp.sendRedirect("edit_stu.jsp");
                break;
            case "update":
                try {
                    BeanUtils.populate(student,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.update(student);
                resp.sendRedirect("student_table.jsp");
                break;
            case "add":
                try {
                    BeanUtils.populate(student,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.regist(student);
                resp.sendRedirect("student_table.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
