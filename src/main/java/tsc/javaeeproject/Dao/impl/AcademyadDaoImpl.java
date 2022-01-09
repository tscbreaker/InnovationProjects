package tsc.javaeeproject.Dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.AcademyadDao;
import tsc.javaeeproject.Domain.Academyad;
import tsc.javaeeproject.Utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class AcademyadDaoImpl implements AcademyadDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Academyad aca = null;
    @Override
    public Academyad findByAcaidAndPassword(Academyad academyad) {
        String sql = "select * from BigWork2..academyad where aca_id=? and password=?";
        try {
            aca = template.queryForObject(sql,new BeanPropertyRowMapper<Academyad>(Academyad.class),new Integer(academyad.getAca_id()),academyad.getPassword());
        } catch (Exception e) {
            return null;
        }
        return aca;
    }

    @Override
    public Academyad findAcademyadByID(String id) {
        String sql = "select * from BigWork2..academyad where aca_id=?";
        try {
            aca = template.queryForObject(sql,new BeanPropertyRowMapper<Academyad>(Academyad.class),id);
        } catch (Exception e) {
            return null;
        }
        return aca;
    }

    @Override
    public List<Map<String, Object>> getAcademyad() {
        String sql = "select * from BigWork2..academyad";
        return template.queryForList(sql);
    }

    @Override
    public boolean deleteByID(String id) {
        String sql = "delete from BigWork2..academyad where aca_id=?";
        try {
            template.update(sql, id);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Academyad academyad) {
        String sql = "update BigWork2..academyad set password=?,name=?,academy=? where aca_id=?";
        try {
            template.update(sql, academyad.getPassword(), academyad.getName(), academyad.getAcademy(), academyad.getAca_id());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void save(Academyad academyad) {
        String sql = "insert into BigWork2..academyad values (?,?,?,?)";
        template.update(sql, academyad.getAca_id(), academyad.getPassword(), academyad.getName(), academyad.getAcademy());
    }
}
