package main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    ServerSocket serverSocket;

    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);

        Socket clientSocket = serverSocket.accept();
        String requestLine = readLine(clientSocket);
        System.out.println(requestLine);


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
}
