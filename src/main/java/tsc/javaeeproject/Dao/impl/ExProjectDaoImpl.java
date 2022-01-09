package tsc.javaeeproject.Dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.ExProjectDao;
import tsc.javaeeproject.Domain.ExProject;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class ExProjectDaoImpl implements ExProjectDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Map<String, Object>> findNationSubmitProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_submit_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and is_delete=0";
        return template.queryForList(sql, "未立项","nation",id);
    }

    @Override
    public List<Map<String, Object>> findNationMidProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_mid_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and is_delete=0";
        return template.queryForList(sql, "已立项","nation",id);
    }

    @Override
    public List<Map<String, Object>> findNationResProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_res_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and is_delete=0";
        return template.queryForList(sql, "中期","nation",id);
    }

    @Override
    public void saveExProject(Integer integer) {
        String sql = "insert into BigWork2..ex_project values (?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql, 20191800, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191801, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191802, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191803, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191804, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191805, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191806, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191807, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191808, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191809, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191810, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191811, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191812, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191813, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191814, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191815, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191816, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191817, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191818, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191819, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191820, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191821, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191822, integer, false, null, null, null, null, null, null, false, false);
        template.update(sql, 20191823, integer, false, null, null, null, null, null, null, false, false);
    }

    @Override
    public void setSubmitScore(Object id, String p_id, String score, String suggestion) {
        String sql = "update BigWork2..ex_project set is_submit_score=1,submit_score=?,submit_suggestion=? where ex_id=? and p_id=?";
        template.update(sql,score,suggestion,id,p_id);
    }

    @Override
    public void setMidScore(Object id, String p_id, String score, String suggestion) {
        String sql = "update BigWork2..ex_project set is_mid_score=1,mid_score=?,mid_suggestion=? where ex_id=? and p_id=?";
        template.update(sql,score,suggestion,id,p_id);
    }

    @Override
    public void setResScore(Object id, String p_id, String score, String suggestion) {
        String sql = "update BigWork2..ex_project set is_res_score=1,res_score=?,res_suggestion=? where ex_id=? and p_id=?";
        template.update(sql,score,suggestion,id,p_id);
    }

    @Override
    public List<Map<String, Object>> findProvinceSubmitProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_submit_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "未立项","province",id);
    }

    @Override
    public List<Map<String, Object>> findProvinceMidProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_mid_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "已立项","province",id);
    }

    @Override
    public List<Map<String, Object>> findProvinceResProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_res_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "中期","province",id);
    }

    @Override
    public List<Map<String, Object>> findSchoolSubmitProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_submit_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "未立项","school",id);
    }

    @Override
    public List<Map<String, Object>> findSchoolMidProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_mid_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "已立项","school",id);
    }

    @Override
    public List<Map<String, Object>> findSchoolResProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_res_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "中期","school",id);
    }

    @Override
    public List<Map<String, Object>> findAcademySubmitProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_submit_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "未立项","academy",id);
    }

    @Override
    public List<Map<String, Object>> findAcademyMidProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_mid_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "已立项","academy",id);
    }

    @Override
    public List<Map<String, Object>> findAcademyResProject(Object id) {
        String sql = "select ex.p_id,p.p_name,ex.is_res_score,p.p_type,p.subjecttype,p.p_period from BigWork2..ex_project ex join BigWork2..project p on p.p_id = ex.p_id where p.p_period=? and p.p_type=? and ex.ex_id=? and p.is_delete=0";
        return template.queryForList(sql, "中期","academy",id);
    }

    @Override
    public boolean isScore(Object p_id, String p_period, String type) {
        try {
            String sql1 = "";
            String sql2 = "";
            String sql3 = "";
            if(p_period.equals("未立项")){
                if(type.equals("1")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191800";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191801";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191802";
                }else if (type.equals("2")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191803";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191804";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191805";
                }else if (type.equals("3")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191806";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191807";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191808";
                }else if (type.equals("4")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191809";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191810";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191811";
                }else if (type.equals("5")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191812";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191813";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191814";
                }else if (type.equals("6")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191815";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191816";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191817";
                }else if (type.equals("7")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191818";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191819";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191820";
                }else if (type.equals("8")){
                    sql1 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191821";
                    sql2 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191822";
                    sql3 = "select is_submit_score from BigWork2..ex_project where p_id=? and ex_id=20191823";
                }
                List<Map<String, Object>> maps = template.queryForList(sql1, p_id);
                List<Map<String, Object>> maps1 = template.queryForList(sql2, p_id);
                List<Map<String, Object>> maps2 = template.queryForList(sql3, p_id);
                if((Boolean) maps.get(0).get("is_submit_score") && (Boolean)maps1.get(0).get("is_submit_score") && (Boolean)maps2.get(0).get("is_submit_score")){
                    return true;
                }else
                    return false;
            }else if (p_period.equals("已立项")){
                if(type.equals("1")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191800";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191801";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191802";
                }else if (type.equals("2")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191803";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191804";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191805";
                }else if (type.equals("3")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191806";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191807";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191808";
                }else if (type.equals("4")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191809";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191810";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191811";
                }else if (type.equals("5")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191812";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191813";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191814";
                }else if (type.equals("6")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191815";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191816";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191817";
                }else if (type.equals("7")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191818";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191819";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191820";
                }else if (type.equals("8")){
                    sql1 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191821";
                    sql2 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191822";
                    sql3 = "select is_mid_score from BigWork2..ex_project where p_id=? and ex_id=20191823";
                }
                List<Map<String, Object>> maps = template.queryForList(sql1, p_id);
                List<Map<String, Object>> maps1 = template.queryForList(sql2, p_id);
                List<Map<String, Object>> maps2 = template.queryForList(sql3, p_id);
                if((Boolean) maps.get(0).get("is_mid_score")&& (Boolean) maps1.get(0).get("is_mid_score") && (Boolean) maps2.get(0).get("is_mid_score")){
                    return true;
                }else
                    return false;
            }else if (p_period.equals("中期")){
                if(type.equals("1")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191800";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191801";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191802";
                }else if (type.equals("2")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191803";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191804";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191805";
                }else if (type.equals("3")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191806";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191807";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191808";
                }else if (type.equals("4")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191809";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191810";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191811";
                }else if (type.equals("5")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191812";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191813";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191814";
                }else if (type.equals("6")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191815";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191816";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191817";
                }else if (type.equals("7")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191818";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191819";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191820";
                }else if (type.equals("8")){
                    sql1 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191821";
                    sql2 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191822";
                    sql3 = "select is_res_score from BigWork2..ex_project where p_id=? and ex_id=20191823";
                }
                List<Map<String, Object>> maps = template.queryForList(sql1, p_id);
                List<Map<String, Object>> maps1 = template.queryForList(sql2, p_id);
                List<Map<String, Object>> maps2 = template.queryForList(sql3, p_id);
                if((Boolean) maps.get(0).get("is_res_score") && (Boolean) maps1.get(0).get("is_res_score") && (Boolean) maps2.get(0).get("is_res_score")){
                    return true;
                }else
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public ExProject findExProject(String s, String p_id) {
        String sql = "select * from BigWork2..ex_project where ex_id=? and p_id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<ExProject>(ExProject.class),s,p_id);
    }
}
