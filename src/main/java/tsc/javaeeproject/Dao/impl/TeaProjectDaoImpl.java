package tsc.javaeeproject.Dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.TeaProjectDao;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class TeaProjectDaoImpl implements TeaProjectDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void save(int p_id, String tea_id) {
        String sql = "insert into BigWork2..tea_project values (?,?,?,?,?,?,?,?,?)";
        template.update(sql,tea_id,p_id,false,false,false,null,false,null,null);
    }

    @Override
    public void saveHeaderTea(int p_id, String tea_id) {
        String sql = "insert into BigWork2..tea_project values (?,?,?,?,?,?,?,?,?)";
        template.update(sql,tea_id,p_id,true,false,false,null,false,null,null);
    }

    @Override
    public List<Map<String, Object>> findSubmitTeaProject(Object id) {
        String sql = "select tea.tea_id,tea.p_id,p.p_name,tea.is_header,tea.is_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..tea_project tea join BigWork2..project p on p.p_id = tea.p_id where tea_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"未立项");
    }

    @Override
    public List<Map<String, Object>> findMidTeaProject(Object id) {
        String sql = "select tea.tea_id,tea.p_id,p.p_name,tea.is_header,tea.is_mid_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..tea_project tea join BigWork2..project p on p.p_id = tea.p_id where tea_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"已立项");
    }

    @Override
    public List<Map<String, Object>> findResTeaProject(Object id) {
        String sql = "select tea.tea_id,tea.p_id,p.p_name,tea.is_header,tea.is_res_confirm,p.p_type,p.subjecttype,p.p_period from BigWork2..tea_project tea join BigWork2..project p on p.p_id = tea.p_id where tea_id=? and p.p_period=? and p.is_delete=0";
        return template.queryForList(sql,id,"中期");
    }

    @Override
    public void confirmSubmit(Object p_id, Object id, String suggestion) {
        String sql = "update BigWork2..tea_project set suggestion=?,is_confirm=1 where tea_id=? and p_id=?";
        template.update(sql,suggestion,id,p_id);
    }

    @Override
    public void confirmMid(Object p_id, Object id, String suggestion) {
        String sql = "update BigWork2..tea_project set mid_suggestion=?,is_mid_confirm=1 where tea_id=? and p_id=?";
        template.update(sql,suggestion,id,p_id);
    }

    @Override
    public void confirmRes(Object p_id, Object id, String suggestion) {
        String sql = "update BigWork2..tea_project set res_suggestion=?,is_res_confirm=1 where tea_id=? and p_id=?";
        template.update(sql,suggestion,id,p_id);
    }
}
