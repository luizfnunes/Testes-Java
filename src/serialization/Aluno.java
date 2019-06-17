package serialization;

import java.io.Serializable;

public class Aluno implements Serializable {
    private long id;
    private String name;
    // transient não serializa o atributo
    private transient String password;
    private static String school = "Tempero Verde";

    public Aluno(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Aluno.school = school;
    }
}
