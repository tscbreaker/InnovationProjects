package tsc.javaeeproject.Dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.ExpertDao;
import tsc.javaeeproject.Domain.Expert;
import tsc.javaeeproject.Utils.JDBCUtils;

public class ExpertDaoImpl implements ExpertDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Expert ex = null;
    @Override
    public Expert findByExidAndPassword(Expert expert) {
        String sql = "select * from BigWork2..expert where ex_id=? and password=?";
        try {
            ex = template.queryForObject(sql,new BeanPropertyRowMapper<Expert>(Expert.class),new Integer(expert.getEx_id()),expert.getPassword());
        } catch (Exception e) {
            return null;
        }
        return ex;
    }

    @Override
    public Expert findExpertByID(String id) {
        String sql = "select * from BigWork2..expert where ex_id=?";
        try {
            ex = template.queryForObject(sql, new BeanPropertyRowMapper<Expert>(Expert.class), new Integer(id));
        } catch (Exception e) {
            return null;
        }
        return ex;
    }
}
