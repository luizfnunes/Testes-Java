package objects.basics;

public class TestConnection {
    public static void main(String[] args) {
        String host = "luizfnunes.com";
        int port = 2020;
        String user = "luiz";
        String password = "123456";
        ConnectFake conn = new ConnectFake(host,port,user,password);
        conn.connect();
    }
}
