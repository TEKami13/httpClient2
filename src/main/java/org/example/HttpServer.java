package main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {

    public final ServerSocket serverSocket;
    public String requestLine;
    public final Map<String, String> headers;

    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        headers = new HashMap<>();
        while (true) {
        Socket clientSocket = serverSocket.accept();

        String responseLine = "HTTP/1.1 200 OK\r\n";
        String body = "<HTML><H1>OH HAI IAM A SERVER</H1></HTML>";
        String header1 = "Content-Type:text/html\r\n";
        String header2 = "Content-Length:" + body.getBytes().length + "\r\n";
        String spacer = "\r\n";

        clientSocket.getOutputStream().write((responseLine +
                header1 +
                header2 +
                spacer +
                body).getBytes());
        clientSocket.getOutputStream().close();
        clientSocket.close();

        printThings();
        }
    }

    private void printThings() {
        System.out.println(requestLine);
        headers.entrySet().forEach(System.out::println);
    }
}
