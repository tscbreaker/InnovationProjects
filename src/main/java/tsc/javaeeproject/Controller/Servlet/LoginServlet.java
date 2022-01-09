package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.*;
import tsc.javaeeproject.Service.*;
import tsc.javaeeproject.Service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
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
        Academyad academyad = new Academyad();
        Schoolad schoolad = new Schoolad();
        Expert expert = new Expert();
        boolean flag = false;
        String id = null;
        try {
            if((request.getParameter("type")).equals("1")){
                Map<String, String[]> map = request.getParameterMap();
                BeanUtils.populate(student,map);
                StudentService service = new StudentServiceImpl();
                flag = service.login(student);
                id = String.valueOf(student.getStu_id());
            }else if((request.getParameter("type")).equals("2")){
                teacher.setTea_id(Integer.parseInt(request.getParameter("stu_id")));
                teacher.setPassword(request.getParameter("password"));
                TeacherService service = new TeacherServiceImpl();
                flag = service.login(teacher);
                id = String.valueOf(teacher.getTea_id());
            }
            else if((request.getParameter("type")).equals("3")){
                academyad.setAca_id(Integer.parseInt(request.getParameter("stu_id")));
                academyad.setPassword(request.getParameter("password"));
                AcademyadService service = new AcademyadServiceImpl();
                flag = service.login(academyad);
                id = String.valueOf(academyad.getAca_id());
            }
            else if((request.getParameter("type")).equals("4")){
                schoolad.setSch_id(Integer.parseInt(request.getParameter("stu_id")));
                schoolad.setPassword(request.getParameter("password"));
                SchooladService service = new SchooladServiceImpl();
                flag = service.login(schoolad);
                id = String.valueOf(schoolad.getSch_id());
            }
            else if((request.getParameter("type")).equals("5")){
                expert.setEx_id(Integer.parseInt(request.getParameter("stu_id")));
                expert.setPassword(request.getParameter("password"));
                ExpertService service = new ExpertServiceImpl();
                flag = service.login(expert);
                id = String.valueOf(expert.getEx_id());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ResultInfo info = new ResultInfo();
        if(flag){
            request.getSession().setAttribute("id", id);
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误，登陆失败！");
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
