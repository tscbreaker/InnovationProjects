package tsc.javaeeproject.Dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.StudentDao;
import tsc.javaeeproject.Domain.Student;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class StudnetDaoImpl implements StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Student student = null;
    @Override
    public Student findStudentByID(String stu_id) {
        String sql = "select * from BigWork2..student where stu_id=?";
        try {
            student = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), new Integer(stu_id));
        } catch (Exception e) {
            return null;
        }
        return student;
    }

    @Override
    public Student findByStuidAndPassword(Student stu) {
        String sql = "select * from BigWork2..student where stu_id=? and password=?";
        try {
            student = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),new Integer(stu.getStu_id()),stu.getPassword());
        } catch (Exception e) {
            return null;
        }
        return student;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into BigWork2..student values (?,?,?,?,?,?)";
        template.update(sql, student.getStu_id(), student.getPassword(), student.getName(), student.getSex(), student.getStu_mail(), student.getAcademy());
    }

    @Override
    public boolean deleteByID(String id) {
        String sql = "delete from BigWork2..student where stu_id=?";
        try {
            template.update(sql, id);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Student student) {
        String sql = "update BigWork2..student set password=?,name=?,sex=?,stu_mail=?,academy=? where stu_id=?";
        try {
            template.update(sql, student.getPassword(), student.getName(), student.getSex(), student.getStu_mail(), student.getAcademy(), student.getStu_id());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> getStudent() {
        String sql = "select * from BigWork2..student";
        return template.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> findStudentByAcademy(String string) {
        String sql = "select * from BigWork2..student where academy=?";
        return template.queryForList(sql,string);
    }

}
