package tsc.javaeeproject.Dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tsc.javaeeproject.Dao.NoticeDao;
import tsc.javaeeproject.Domain.Notice;
import tsc.javaeeproject.Utils.JDBCUtils;

public class NoticeDaoImpl implements NoticeDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    Notice notice = null;
    @Override
    public Notice getNotice() {
        String sql = "select * from BigWork2..notice where notice_id=1";
        try {
            notice = template.queryForObject(sql,new BeanPropertyRowMapper<Notice>(Notice.class));
        } catch (Exception e) {
            return null;
        }
        return notice;
    }
    @Override
    public boolean update(Notice notice) {
        String sql = "update BigWork2..notice set special_notice=?,content=? where notice_id=1";
        try {
            template.update(sql,notice.getSpecial_notice(),notice.getContent());
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }
}
