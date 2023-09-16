package main.java.org.example;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    public final int statusCode;
    public final Map<String, String> headers = new HashMap<>();
    public final String status;
    public final String body;


    public HttpClient(String host, int port, String url) {
        try (Socket socket = new Socket(host, port)) {

            String request = String.format("GET %s HTTP/1.1\r\nHost: %s \r\n\r\n", url, host);

            socket.getOutputStream().write(request.getBytes());

            String[] statusLine = readLine(socket).split(" ", 3);
            statusCode = Integer.parseInt(statusLine[1]);
            status = statusLine[2];




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder sb = new StringBuilder();
        int character;

        while ( (character = socket.getInputStream().read() ) != '\r') {
            sb.append(character);
        }
        character = socket.getInputStream().read();
        if (character != '\n') {
            throw new IllegalStateException("Invalid http header - \\r not followed by \\n");
        }
        return sb.toString();
    }
}
