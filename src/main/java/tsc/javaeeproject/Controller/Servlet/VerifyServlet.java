package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import tsc.javaeeproject.Domain.ResultInfo;
import tsc.javaeeproject.Service.ProjectService;
import tsc.javaeeproject.Service.impl.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifyServlet")
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getParameter("p_id");
        String p_period = request.getParameter("p_period");
        ProjectService service = new ProjectServiceImpl();
        ResultInfo info = new ResultInfo();
        boolean flag = service.changePeriod(p_id,p_period);
        if(flag){
            service.setBeginTime(p_id);
            info.setFlag(true);
            info.setErrorMsg("审核成功！");
        }else{
            info.setFlag(false);
            info.setErrorMsg("审核失败！");
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
