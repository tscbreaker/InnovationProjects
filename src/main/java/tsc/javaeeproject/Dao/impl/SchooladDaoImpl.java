package tsc.javaeeproject.Dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.SchooladDao;
import tsc.javaeeproject.Domain.Schoolad;
import tsc.javaeeproject.Utils.JDBCUtils;

public class SchooladDaoImpl implements SchooladDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Schoolad sch = null;
    @Override
    public Schoolad findBySchidAndPassword(Schoolad schoolad) {
        String sql = "select * from BigWork2..schoolad where sch_id=? and password=?";
        try {
            sch = template.queryForObject(sql,new BeanPropertyRowMapper<Schoolad>(Schoolad.class),new Integer(schoolad.getSch_id()),schoolad.getPassword());
        } catch (Exception e) {
            return null;
        }
        return sch;
    }

    @Override
    public Schoolad findSchooladByID(String id) {
        String sql = "select * from BigWork2..schoolad where sch_id=?";
        try {
            sch = template.queryForObject(sql, new BeanPropertyRowMapper<Schoolad>(Schoolad.class), new Integer(id));
        } catch (Exception e) {
            return null;
        }
        return sch;
    }
}
