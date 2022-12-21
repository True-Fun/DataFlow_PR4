import org.apache.xmlrpc.WebServer;

public class Server {
    public static void main(String[] args) {
        WebServer webServer = new WebServer(8080);
        webServer.addHandler("4pr", new Connection());
        webServer.start();

        System.out.println("Сервер запущен");
    }
}