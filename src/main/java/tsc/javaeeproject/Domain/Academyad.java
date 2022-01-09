package tsc.javaeeproject.Domain;

public class Academyad {
    public int aca_id;
    public String password,name,academy;

    public Academyad() {

    }

    @Override
    public String toString() {
        return "Academyad{" +
                "aca_id=" + aca_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }

    public Academyad(int aca_id, String password, String name, String academy) {
        this.aca_id = aca_id;
        this.password = password;
        this.name = name;
        this.academy = academy;
    }

    public int getAca_id() {
        return aca_id;
    }

    public void setAca_id(int aca_id) {
        this.aca_id = aca_id;
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

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
