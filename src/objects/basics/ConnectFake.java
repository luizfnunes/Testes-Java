package objects.basics;

public class ConnectFake {
    private String host;
    private int port;
    private String user;
    private String password;

    public ConnectFake(String host,int port,String user,String password){
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public void connect(){
        System.out.println("Conectando...");
        System.out.println("Conectado ao servidor "+this.host+":"+this.port);
        System.out.println(this.host+"@"+this.user);
    }

}
