package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Notice;

public interface NoticeDao {
    Notice getNotice();

    boolean update(Notice notice);
}
