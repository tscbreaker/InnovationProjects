package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.ResultInfo;
import tsc.javaeeproject.Domain.Student;
import tsc.javaeeproject.Domain.Teacher;
import tsc.javaeeproject.Service.StudentService;
import tsc.javaeeproject.Service.TeacherService;
import tsc.javaeeproject.Service.impl.StudentServiceImpl;
import tsc.javaeeproject.Service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        Teacher teacher = new Teacher();
        boolean flag = false;
        try {
            if (request.getParameter("stu_id") != null){
                BeanUtils.populate(student,map);
                StudentService service = new StudentServiceImpl();
                flag = service.update(student);
            } else if (request.getParameter("tea_id") != null) {
                BeanUtils.populate(teacher,map);
                TeacherService service = new TeacherServiceImpl();
                flag = service.update(teacher);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("修改失败！");
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
