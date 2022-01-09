package tsc.javaeeproject.Domain;

public class Notice {
    int notice_id;
    String special_notice,content;

    public Notice(int notice_id, String special_notice, String content) {
        this.notice_id = notice_id;
        this.special_notice = special_notice;
        this.content = content;
    }

    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", special_notice='" + special_notice + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getSpecial_notice() {
        return special_notice;
    }

    public void setSpecial_notice(String special_notice) {
        this.special_notice = special_notice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
