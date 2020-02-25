import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    static String address;
    static String userName;
    public static void main(String[] args) throws IOException {
        URL url=null;

        while (true) {
            System.out.println("Enter command:");

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            String[] tokens = line.split(" ");

            if ("connect".equalsIgnoreCase(tokens[0])) {
                address=tokens[1];
                userName = line.substring(line.indexOf("as") + 3);
                url = new URL("http://" + address + "/register?name=" + userName);

            } else if ("list".equalsIgnoreCase(tokens[0])) {
                url = new URL("http://" + address + "/list");

            } else if ("send".equalsIgnoreCase(tokens[0])) {
                String receiver =line.substring(line.indexOf(">")+1);
                System.out.println("reciever"+receiver);
                String msg = line.substring(line.indexOf("s")+3);
                System.out.println("msg"+msg);
                url = new URL("http://" + address + "/send?message="+msg+"&receiver="+receiver+"&sender="+userName);
            } else if("exit".equalsIgnoreCase(tokens[0])){
                break;
            }


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line1;
            while ((line1 = reader.readLine()) != null) {
                System.out.println(line1);
            }

            reader.close();


        }

    }
}
