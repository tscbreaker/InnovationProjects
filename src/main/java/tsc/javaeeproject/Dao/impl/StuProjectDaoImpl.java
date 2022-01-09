package tsc.javaeeproject.Dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.StuProjectDao;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class StuProjectDaoImpl implements StuProjectDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void save(int p_id, String stu_id) {
        String sql = "insert into BigWork2..stu_project values (?,?,?,?)";
        template.update(sql, stu_id, p_id, false, false);
    }

    @Override
    public void saveHeaderStu(int p_id, String id) {
        String sql = "insert into BigWork2..stu_project values (?,?,?,?)";
        template.update(sql, id, p_id, true, true);
    }

    @Override
    public List<Map<String, Object>> finStuProject(Object id) {
        String sql = "select stu.stu_id,stu.p_id,p.p_name,stu.is_header,stu.is_confirm from BigWork2..stu_project stu join BigWork2..project p on p.p_id = stu.p_id where stu_id=? and is_confirm=0";
        return template.queryForList(sql,id);
    }

    @Override
    public boolean confirmProject(String id, String p_id) {
        String sql = "update BigWork2..stu_project set is_confirm=1 where stu_id=? and p_id=?";
        try {
            template.update(sql,id,p_id);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> finSubmitStuProject(Object id) {
        String sql = "select stu.stu_id,stu.p_id,p.p_name,stu.is_header,stu.is_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..stu_project stu join BigWork2..project p on p.p_id = stu.p_id where stu_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"未立项");
    }

    @Override
    public List<Map<String, Object>> finMidStuProject(Object id) {
        String sql = "select stu.stu_id,stu.p_id,p.p_name,stu.is_header,stu.is_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..stu_project stu join BigWork2..project p on p.p_id = stu.p_id where stu_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"已立项");
    }

    @Override
    public List<Map<String, Object>> finResStuProject(Object id) {
        String sql = "select stu.stu_id,stu.p_id,p.p_name,stu.is_header,stu.is_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..stu_project stu join BigWork2..project p on p.p_id = stu.p_id where stu_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"中期");
    }

    @Override
    public List<Map<String, Object>> finOverStuProject(Object id) {
        String sql = "select stu.stu_id,stu.p_id,p.p_name,stu.is_header,stu.is_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..stu_project stu join BigWork2..project p on p.p_id = stu.p_id where stu_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"结题");
    }
}
