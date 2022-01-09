package tsc.javaeeproject.Domain;

public class Schoolad {
    public int sch_id;
    public String password,name;

    public Schoolad() {
    }

    @Override
    public String toString() {
        return "Schoolad{" +
                "sch_id=" + sch_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Schoolad(int sch_id, String password, String name) {
        this.sch_id = sch_id;
        this.password = password;
        this.name = name;
    }

    public int getSch_id() {
        return sch_id;
    }

    public void setSch_id(int sch_id) {
        this.sch_id = sch_id;
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
}
