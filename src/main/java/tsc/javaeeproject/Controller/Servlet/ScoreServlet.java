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

@WebServlet("/scoreServlet")
public class ScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectService service = new ProjectServiceImpl();
        boolean flag = service.Score(request.getSession().getAttribute("id"),request.getParameter("p_id"),request.getParameter("operate"),request.getParameter("score"),request.getParameter("suggestion"));
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(true);
            info.setErrorMsg("打分成功");
        }else {
            info.setFlag(false);
            info.setErrorMsg("打分失败");
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
