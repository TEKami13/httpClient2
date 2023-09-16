package main.java.org.example;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {


    public HttpClient(String host, int port, String url) {
        try (Socket socket = new Socket(host, port)) {

            String request = String.format("GET %s HTTP/1.1\r\nHost: %s \r\n\r\n", url, host);

            socket.getOutputStream().write(request.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
