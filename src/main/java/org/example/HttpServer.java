package main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {

    public final ServerSocket serverSocket;
    public final String requestLine;
    public final Map<String, String> headers;

    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        headers = new HashMap<>();

        Socket clientSocket = serverSocket.accept();
        requestLine = readLine(clientSocket);

        String headerLine;
        while (!(headerLine = readLine(clientSocket)).isEmpty()) {
            String[] headerParts = headerLine.split(" *: *", 2);
            headers.put(headerParts[0], headerParts[1]);
        }

        String responseLine = "HTTP/1.1 200 OK\r\n";
        String body = "<HTML><H1>OH HAI IAM A SERVER</H1></HTML>";
        String header1 = "Content-Type:text/plain";
        String header2 = "Content-Length:" + body.getBytes().length;
        String spacer = "\r\n\r";

        clientSocket.getOutputStream().write((responseLine + header1 + header2 + spacer + body).getBytes());

        printThings();

    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder sb = new StringBuilder();
        int character;

        while ((character = socket.getInputStream().read()) != '\r') {
            sb.append((char)character); //char is important
        }
        character = socket.getInputStream().read();
        return sb.toString();
    }

    private void printThings() {
        System.out.println(requestLine);
        headers.entrySet().forEach(System.out::println);
    }
}
