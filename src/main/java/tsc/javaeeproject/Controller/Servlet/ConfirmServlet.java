package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import tsc.javaeeproject.Dao.StuProjectDao;
import tsc.javaeeproject.Dao.impl.StuProjectDaoImpl;
import tsc.javaeeproject.Domain.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmServlet")
public class ConfirmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("stu_id");
        String p_id = request.getParameter("p_id");
        StuProjectDao dao = new StuProjectDaoImpl();
        boolean flag = dao.confirmProject(id,p_id);
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(true);
            info.setErrorMsg("确认成功！");
        }else{
            info.setFlag(false);
            info.setErrorMsg("确认失败！");
        }
        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
