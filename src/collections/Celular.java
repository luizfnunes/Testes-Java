package collections;

public class Celular {
    private String name;
    private String Imei;

    public Celular(String name, String imei) {
        this.name = name;
        Imei = imei;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "name='" + name + '\'' +
                ", Imei='" + Imei + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImei() {
        return Imei;
    }
    public void setImei(String imei) {
        Imei = imei;
    }
}
