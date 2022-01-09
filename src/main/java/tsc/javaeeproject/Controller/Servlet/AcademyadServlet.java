package tsc.javaeeproject.Controller.Servlet;

import org.apache.commons.beanutils.BeanUtils;
import tsc.javaeeproject.Domain.Academyad;
import tsc.javaeeproject.Service.AcademyadService;
import tsc.javaeeproject.Service.impl.AcademyadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/academyadServlet")
public class AcademyadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AcademyadService service = new AcademyadServiceImpl();
        String operate = req.getParameter("operate");
        String id = req.getParameter("aca_id");
        Map<String, String[]> map = req.getParameterMap();
        Academyad academyad = new Academyad();
        switch (operate){
            case "delete":
                boolean x = service.deleteAcademyadByID(id);
                if (x)
                    resp.sendRedirect("academy_table.jsp");
                break;
            case "edit":
                academyad = service.findAcademyadById(id);
                req.getSession().setAttribute("aca",academyad);
                resp.sendRedirect("edit_aca.jsp");
                break;
            case "update":
                try {
                    BeanUtils.populate(academyad,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.update(academyad);
                resp.sendRedirect("academy_table.jsp");
                break;
            case "add":
                try {
                    BeanUtils.populate(academyad,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                service.regist(academyad);
                resp.sendRedirect("academy_table.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
