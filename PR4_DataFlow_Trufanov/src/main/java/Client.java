import org.apache.xmlrpc.*;
import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Client {
    static Vector<String> nameTour = null;
    static XmlRpcClient client = null;

    void showData(Vector<String> nameTour) {
        String ar = "";

        try {
            ar = (String) client.execute("4pr.selectTour", nameTour);
        }
        catch (XmlRpcException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ar);
    }

    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8080/4pr";
        nameTour = new Vector<String>();
        client = new XmlRpcClient(url);

        System.out.println("Введите название тура: ");
        Scanner s = new Scanner(System.in);
        nameTour.add(s.nextLine());

        Client client = new Client();
        client.showData(nameTour);
    }
}
