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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        Student student = new Student();
        Teacher teacher = new Teacher();
        boolean flag = false;
        try {
            if((request.getParameter("type")).equals("1")){
                Map<String, String[]> map = request.getParameterMap();
                BeanUtils.populate(student,map);
                StudentService service = new StudentServiceImpl();
                flag = service.regist(student);
            }else if((request.getParameter("type")).equals("2")){
                teacher.setTea_id(Integer.parseInt(request.getParameter("stu_id")));
                teacher.setPassword(request.getParameter("password"));
                teacher.setName(request.getParameter("name"));
                teacher.setSex(request.getParameter("sex"));
                teacher.setTea_mail(request.getParameter("stu_mail"));
                teacher.setAcademy(request.getParameter("academy"));
                TeacherService service = new TeacherServiceImpl();
                flag = service.regist(teacher);
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
            info.setErrorMsg("注册失败!");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}