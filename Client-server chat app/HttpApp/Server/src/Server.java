import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static ConcurrentHashMap<String,String> userList=new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        HttpServer httpServer=HttpServer.create(new InetSocketAddress(8000),0);
        HttpContext register=httpServer.createContext("/register");
        register.setHandler(httpExchange -> register(httpExchange));

        HttpContext list=httpServer.createContext("/list");
        list.setHandler(httpExchange -> list(httpExchange));

        HttpContext sendMsg=httpServer.createContext("/send");
        sendMsg.setHandler(httpExchange -> sendMsg(httpExchange));

        httpServer.start();
    }

    private static void sendMsg(HttpExchange httpExchange) throws IOException {
        URI registeredURIMSG=httpExchange.getRequestURI();
        String query=registeredURIMSG.getRawQuery();
        Matcher matcher2 = Pattern.compile("message=(?<msg>\\w*)&receiver=(?<rec>\\w*)&sender=(?<sen>\\w*)").matcher(query);
        String response = null;
        if (matcher2.find()){
            String message = matcher2.group("msg");
            String receiver = matcher2.group("rec");
            String sender = matcher2.group("sen");

            if (userList.keySet().contains(receiver)){
                userList.put(receiver,message);
            } else {
                response="No such a user";
            }
            
        }

        httpExchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream outputStream= httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();

        
       
    }

    private static void list(HttpExchange httpExchange) throws IOException {
        String response = "User list" + userList;
        System.out.println(response);
        httpExchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream outputStream= httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();

    }

    private static void register(HttpExchange httpExchange) throws IOException {
        URI registeredURI=httpExchange.getRequestURI();
        String query=registeredURI.getRawQuery();
        String clientName = query.substring(query.indexOf("=") +1 ,query.length());
        System.out.println("name :"+ clientName);
        String response= "registered!!!!!!!!";
        if (userList.keySet().contains(clientName)){
            response="Already exist!!!!!!!!!!";
        }
        userList.put(clientName,"Default message");

        httpExchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream outputStream= httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();

    }


}
