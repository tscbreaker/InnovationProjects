package tsc.javaeeproject.Service;

import tsc.javaeeproject.Domain.Notice;

public interface NoticeService {
    String getSpecialNotice();

    String getContent();

    boolean setSpecialNotice(Notice notice);

    boolean setContent(Notice notice);
}
