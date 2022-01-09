package tsc.javaeeproject.Domain;

public class Expert {
    public int ex_id;
    public String password,name;

    public Expert() {

    }

    public Expert(int ex_id, String password, String name) {
        this.ex_id = ex_id;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "ex_id=" + ex_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
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
