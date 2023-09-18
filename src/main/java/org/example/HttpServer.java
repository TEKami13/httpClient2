package main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer extends Thread {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new http.server.HttpRequestHandler(clientSocket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
