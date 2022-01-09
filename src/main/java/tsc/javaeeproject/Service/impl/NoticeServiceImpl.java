package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.NoticeDao;
import tsc.javaeeproject.Dao.impl.NoticeDaoImpl;
import tsc.javaeeproject.Domain.Notice;
import tsc.javaeeproject.Service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
    NoticeDao noticeDao = new NoticeDaoImpl();
    @Override
    public String getSpecialNotice() {
        Notice notice = noticeDao.getNotice();
        return notice.getSpecial_notice();
    }

    @Override
    public String getContent() {
        Notice notice = noticeDao.getNotice();
        return notice.getContent();
    }

    @Override
    public boolean setSpecialNotice(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public boolean setContent(Notice notice) {
        return noticeDao.update(notice);
    }
}
