package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.Project;
import tsc.javaeeproject.Domain.ResultInfo;
import tsc.javaeeproject.Service.ProjectService;
import tsc.javaeeproject.Service.StudentService;
import tsc.javaeeproject.Service.TeacherService;
import tsc.javaeeproject.Service.impl.ProjectServiceImpl;
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

@WebServlet("/projectServlet")
public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectService service = new ProjectServiceImpl();
        Map<String, String[]> map = request.getParameterMap();
        Project project = new Project();
        ResultInfo info = new ResultInfo();
        try {
            BeanUtils.populate(project, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        TeacherService teacherService = new TeacherServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        boolean flagtea = false;
        boolean flagstu = true;
        if ((request.getParameter("submit")).equals("保存并提交")) {
            if ((request.getParameter("tea_num")).equals("one")) {
                flagtea = teacherService.findTeacherByID(request.getParameter("tea_id1")) != null;
            } else if ((request.getParameter("tea_num")).equals("two")) {
                flagtea = teacherService.findTeacherByID(request.getParameter("tea_id1")) != null
                        && teacherService.findTeacherByID(request.getParameter("tea_id2")) != null;
            }
            if ((request.getParameter("stu_num")).equals("one")) {
                flagstu = studentService.findStudentByID(request.getParameter("stu_id1")) != null;
            } else if ((request.getParameter("stu_num")).equals("two")) {
                flagstu = studentService.findStudentByID(request.getParameter("stu_id1")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id2")) != null;
            } else if ((request.getParameter("stu_num")).equals("three")) {
                flagstu = studentService.findStudentByID(request.getParameter("stu_id1")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id2")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id3")) != null;
            } else if ((request.getParameter("stu_num")).equals("four")) {
                flagstu = studentService.findStudentByID(request.getParameter("stu_id1")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id2")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id3")) != null
                        && studentService.findStudentByID(request.getParameter("stu_id4")) != null;
            }
            Integer integer = service.regist(project);
            if (integer != null && flagtea && flagstu) {
                //注册成功
                service.saveExProject(integer);
                service.saveHeadTea(integer, request.getParameter("tea_id1"));
                service.saveTea(integer, request.getParameter("tea_id2"));
                service.saveHeadStu(integer, (String) request.getSession().getAttribute("id"));
                service.saveStu(integer, request.getParameter("stu_id1"));
                service.saveStu(integer, request.getParameter("stu_id2"));
                service.saveStu(integer, request.getParameter("stu_id3"));
                service.saveStu(integer, request.getParameter("stu_id4"));
                info.setFlag(true);
                info.setErrorMsg("注册成功!");
            } else {
                //注册失败
                info.setFlag(false);
                info.setErrorMsg("注册失败!");
            }
        } else if ((request.getParameter("submit")).equals("保存项目")) {
            request.getSession().setAttribute("p_type", request.getParameter("p_type"));
            request.getSession().setAttribute("p_name", request.getParameter("p_name"));
            request.getSession().setAttribute("subjecttype", request.getParameter("subjecttype"));
            request.getSession().setAttribute("tea_num", request.getParameter("tea_num"));
            request.getSession().setAttribute("tea_id1", request.getParameter("tea_id1"));
            request.getSession().setAttribute("tea_id2", request.getParameter("tea_id2"));
            request.getSession().setAttribute("stu_num", request.getParameter("stu_num"));
            request.getSession().setAttribute("stu_id1", request.getParameter("stu_id1"));
            request.getSession().setAttribute("stu_id2", request.getParameter("stu_id2"));
            request.getSession().setAttribute("stu_id3", request.getParameter("stu_id3"));
            request.getSession().setAttribute("stu_id4", request.getParameter("stu_id4"));
            request.getSession().setAttribute("p_info", request.getParameter("p_info"));
            request.getSession().setAttribute("header_info", request.getParameter("header_info"));
            request.getSession().setAttribute("member_info", request.getParameter("member_info"));
            request.getSession().setAttribute("meaning", request.getParameter("meaning"));
            request.getSession().setAttribute("method", request.getParameter("method"));
            request.getSession().setAttribute("creative", request.getParameter("creative"));
            request.getSession().setAttribute("pre_result", request.getParameter("pre_result"));
            request.getSession().setAttribute("material_m", request.getParameter("material_m"));
            request.getSession().setAttribute("print_m", request.getParameter("print_m"));
            request.getSession().setAttribute("vehicle_m", request.getParameter("vehicle_m"));
            request.getSession().setAttribute("publish_m", request.getParameter("publish_m"));
            request.getSession().setAttribute("express_m", request.getParameter("express_m"));
            request.getSession().setAttribute("money", request.getParameter("money"));
            info.setFlag(true);
            info.setErrorMsg("保存成功!");
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
