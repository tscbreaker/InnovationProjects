package tsc.javaeeproject.Domain;

public class Teacher {
    public int tea_id;
    public String password,name,sex,tea_mail,academy;

    public Teacher() {
    }

    public Teacher(int tea_id, String password, String name, String sex, String tea_mail, String academy) {
        this.tea_id = tea_id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.tea_mail = tea_mail;
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tea_id=" + tea_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", tea_mail='" + tea_mail + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTea_mail() {
        return tea_mail;
    }

    public void setTea_mail(String tea_mail) {
        this.tea_mail = tea_mail;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
