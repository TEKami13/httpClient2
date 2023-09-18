package main.java.org.example;

import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpRequestHandler extends Thread {

    private final Socket clientSocket;
    public HttpRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        clientSocket.getOutputStream().write(
                requestHandler.getResponse().getBytes(StandardCharsets.UTF_8));
        clientSocket.getOutputStream().close();
        clientSocket.close();
    }
}
