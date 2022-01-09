package tsc.javaeeproject.Controller.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.Notice;
import tsc.javaeeproject.Domain.ResultInfo;
import tsc.javaeeproject.Service.NoticeService;
import tsc.javaeeproject.Service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/noticeServlet")
public class NoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notice notice = new Notice();
        NoticeService service = new NoticeServiceImpl();
        Map<String, String[]> map = request.getParameterMap();
        ResultInfo info = new ResultInfo();
        boolean flag = false;
        try {
            BeanUtils.populate(notice,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        flag = service.setSpecialNotice(notice) && service.setContent(notice);
        if(flag){
            response.sendRedirect("notice.jsp");
        }else{
            info.setFlag(false);
            info.setErrorMsg("编辑公告失败！");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
