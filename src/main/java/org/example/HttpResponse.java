package main.java.org.example;

import java.nio.charset.StandardCharsets;

public class HttpResponse {

    String getResponse() {
        String responseLine = "HTTP/1.1 200 OK\r\n";
        String body = "<HTML><H1>OH HAI IAM A SERVER</H1></HTML>";
        String header1 = "Content-Type:text/html\r\n";
        String header2 = "Content-Length:" + body.getBytes().length + "\r\n";
        String spacer = "\r\n";
        return responseLine + header1 + header2 + spacer + body;
    }

    String getResponse2() {
        String responseLine = "HTTP/1.1 200 OK\r\n";
        String body = "<HTML><button type='button' onclick=\"location.href='https://google.com/chrome/'\">Click Me!</button></HTML>";
        String header1 = "Content-Type:text/html\r\n";
        String header2 = "Content-Length:" + body.getBytes().length + "\r\n";
        String spacer = "\r\n";
        return responseLine + header1 + header2 + spacer + body;
    }
}
