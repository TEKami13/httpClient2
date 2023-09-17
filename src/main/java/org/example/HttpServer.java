package main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer {

    public final ServerSocket serverSocket;

    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            HttpRequest request = new HttpRequest(clientSocket);
            HttpResponse response = new HttpResponse();

            if (request.getHeaders().get("User-Agent") == null) {
                clientSocket.getOutputStream().write(
                        response.getResponse2().getBytes(StandardCharsets.UTF_8));
            } else if (request.getHeaders().get("User-Agent").contains("Safari") &&
                    request.getHeaders().get("User-Agent").contains("Chrome")) {
                clientSocket.getOutputStream().write(
                        response.getResponse().getBytes(StandardCharsets.UTF_8));
            } else if (request.getHeaders().get("User-Agent").contains("Safari")) {
                clientSocket.getOutputStream().write(
                        response.getResponse2().getBytes(StandardCharsets.UTF_8));
            } else {
                clientSocket.getOutputStream().write(
                        response.getResponse().getBytes(StandardCharsets.UTF_8));
            }
        clientSocket.getOutputStream().close();
        clientSocket.close();
        }
    }
}
