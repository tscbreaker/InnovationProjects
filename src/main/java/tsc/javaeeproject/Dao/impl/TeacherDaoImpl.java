package tsc.javaeeproject.Dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.TeacherDao;
import tsc.javaeeproject.Domain.Teacher;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class TeacherDaoImpl implements TeacherDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Teacher tea = null;
    @Override
    public Teacher findByTeaidAndPassword(Teacher teacher) {
        String sql = "select * from BigWork2..teacher where tea_id=? and password=?";
        try {
            tea = template.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class), teacher.getTea_id(),teacher.getPassword());
        } catch (Exception e) {
            return null;
        }
        return tea;
    }

    @Override
    public Teacher findTeacherByID(String tea_id) {
        String sql = "select * from BigWork2..teacher where tea_id=?";
        try {
            tea = template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), new Integer(tea_id));
        } catch (Exception e) {
            return null;
        }
        return tea;
    }

    @Override
    public void save(Teacher teacher) {
        String sql = "insert into BigWork2..teacher values (?,?,?,?,?,?)";
        template.update(sql, teacher.getTea_id(), teacher.getPassword(), teacher.getName(), teacher.getSex(), teacher.getTea_mail(), teacher.getAcademy());
    }

    @Override
    public boolean update(Teacher teacher) {
        String sql = "update BigWork2..teacher set password=?,name=?,sex=?,tea_mail=?,academy=? where tea_id=?";
        try {
            template.update(sql, teacher.getPassword(), teacher.getName(), teacher.getSex(), teacher.getTea_mail(), teacher.getAcademy(), teacher.getTea_id());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> findTeacherByAcademy(String string) {
        String sql = "select * from BigWork2..teacher where academy=?";
        return template.queryForList(sql,string);
    }

    @Override
    public boolean deleteByID(String id) {
        String sql = "delete from BigWork2..teacher where tea_id=?";
        try {
            template.update(sql, id);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> getTeacher() {
        String sql = "select * from BigWork2..teacher";
        return template.queryForList(sql);
    }
}
