package main.java.org.example;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    public final String statusLine;
    public final Map<String, String> headers;
    public final String body;

    public HttpResponse(HttpRequest request) {
        headers = new HashMap<>();
        if (request.getMethod().equals("GET")) {
            if (request.getResource().equals("/")) {
                body = "<html><h1>Hello world!</h1></html>";
                statusLine = "HTTP/1.1 200 OK\r\n";
                headers.put("Content-Length", body.getBytes(StandardCharsets.UTF_8).length + "\r\n");
                headers.put("Content-Type", "text/html\r\n");
            } else if (request.getResource().equals("/cat")) {
                body = "<html><button src='localhost:8181'>Home</button>" +
                        "<img = src='https://i.kym-cdn.com/entries/icons/original/000/038/239/maxresdefault.jpeg'></html>";
                statusLine = "HTTP/1.1 200 OK\r\n";
                headers.put("Content-Length", body.getBytes(StandardCharsets.UTF_8).length + "\r\n");
                headers.put("Content-Type", "text/html\r\n");
            } else {
                body = "<html><h1>ERROR 404</h1></html>";
                statusLine = "HTTP/1.1 200 OK\r\n";
                headers.put("Content-Length", body.getBytes(StandardCharsets.UTF_8).length + "\r\n");
                headers.put("Content-Type", "text/html\r\n");
            }
        } else {
            body = "<html><h1>ERROR 405</h1></html>";
            statusLine = "HTTP/1.1 200 OK\r\n";
            headers.put("Content-Length", body.getBytes(StandardCharsets.UTF_8).length + "\r\n");
            headers.put("Content-Type", "text/html\r\n");
        }
    }
}
