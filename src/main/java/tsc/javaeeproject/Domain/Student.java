package tsc.javaeeproject.Domain;

public class Student {
    public int stu_id;
    public String password,name,sex,stu_mail,academy;

    public Student() {
    }

    public Student(int stu_id, String password, String name, String sex, String stu_mail, String academy) {
        this.stu_id = stu_id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.stu_mail = stu_mail;
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", stu_mail='" + stu_mail + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
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

    public String getStu_mail() {
        return stu_mail;
    }

    public void setStu_mail(String stu_mail) {
        this.stu_mail = stu_mail;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
