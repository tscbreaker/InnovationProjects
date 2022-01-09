package tsc.javaeeproject.Dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import tsc.javaeeproject.Dao.ProjectDao;
import tsc.javaeeproject.Domain.Project;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProjectDapImpl extends HibernateDaoSupport implements ProjectDao {
    Project project = new Project();
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Project findProjectByID(String p_id) {
        String sql = "select * from BigWork2..project where p_id=? and is_delete=0";
        try {
            project = template.queryForObject(sql, new BeanPropertyRowMapper<Project>(Project.class), new Integer(p_id));
        } catch (Exception e) {
            return null;
        }
        return project;
    }

    @Override
    public Integer save(Project project) {
        String sql = "insert into BigWork2..project values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String hql = "select count(*) from BigWork2..project";
        Integer integer = template.queryForObject(hql, Integer.class)+1;
        template.update(sql, integer, project.p_name, project.p_type, project.subjecttype, project.begintime, project.endtime, project.p_info, project.header_info, project.member_info, project.meaning, project.method, project.creative, project.pre_result, project.money, project.material_m, project.print_m, project.vehicle_m, project.publish_m, project.express_m, "未立项", project.submit_report, project.mid_report,project.res_report,project.submit_score,project.mid_score,project.res_score,0);
        return integer;
    }

    @Override
    public void saveSubmitReportName(String saveFilename, String p_id) {
        String sql = "update BigWork2..project set submit_report=? where p_id = ? and is_delete=0";
        template.update(sql, saveFilename, p_id);
    }

    @Override
    public void saveMidReportName(String saveFilename, String p_id) {
        String sql = "update BigWork2..project set mid_report=? where p_id = ? and is_delete=0";
        template.update(sql, saveFilename, p_id);
    }

    @Override
    public void saveResReportName(String saveFilename, String p_id) {
        String sql = "update BigWork2..project set res_report=? where p_id = ? and is_delete=0";
        template.update(sql, saveFilename, p_id);
    }

    @Override
    public List<Map<String, Object>> acadSubmitProject(String p_type) {
        String sql = "select p_id,p_name,p_type,subjecttype,p_period from BigWork2..project where p_type=? and p_period=?";
        return template.queryForList(sql,p_type,"未立项");
    }

    @Override
    public List<Map<String, Object>> acadMidProject(String p_type) {
        String sql = "select p_id,p_name,p_type,subjecttype,p_period from BigWork2..project where p_type=? and p_period=?";
        return template.queryForList(sql,p_type,"已立项");
    }

    @Override
    public List<Map<String, Object>> acadResProject(String p_type) {
        String sql = "select p_id,p_name,p_type,subjecttype,p_period from BigWork2..project where p_type=? and p_period=?";
        return template.queryForList(sql,p_type,"中期");
    }

    @Override
    public void changePeriod(String p_id, String value) {
        String sql = "update BigWork2..project set p_period=? where p_id=?";
        template.update(sql,value,p_id);
    }

    @Override
    public void setBeginTime(String p_id) {
        Date time = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(time);
        String sql = "update BigWork2..project set beaintime=? where p_id = ?";
        template.update(sql,date,p_id);
    }
}
