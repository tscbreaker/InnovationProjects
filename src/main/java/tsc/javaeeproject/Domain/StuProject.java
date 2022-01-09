package tsc.javaeeproject.Domain;

public class StuProject {
    public int stu_id,p_id;
    public String is_header,is_confirm;

    public StuProject() {

    }

    @Override
    public String toString() {
        return "StuProject{" +
                "stu_id=" + stu_id +
                ", p_id=" + p_id +
                ", is_header='" + is_header + '\'' +
                ", is_confirm='" + is_confirm + '\'' +
                '}';
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getIs_header() {
        return is_header;
    }

    public void setIs_header(String is_header) {
        this.is_header = is_header;
    }

    public String getIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(String is_confirm) {
        this.is_confirm = is_confirm;
    }

    public StuProject(int stu_id, int p_id, String is_header, String is_confirm) {
        this.stu_id = stu_id;
        this.p_id = p_id;
        this.is_header = is_header;
        this.is_confirm = is_confirm;
    }
}
