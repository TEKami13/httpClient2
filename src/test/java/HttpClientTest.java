package test.java;

import main.java.org.example.HttpClient;
import main.java.org.example.HttpServer;
import org.junit.jupiter.api.Test;
import org.w3c.dom.html.HTMLTitleElement;

import java.io.IOException;

public class HttpClientTest {

    @Test
    void shouldMakeHttpCallAndGet200Response() {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");

        assert client.statusCode == 200;
        assert client.headers.get("Content-Type") != null;
        assert client.body != null;

    }

    @Test
    void makeServerGoBigBig() throws IOException {
        HttpServer server = new HttpServer(8181);
        HttpClient client = new HttpClient("localhost", 8181, "/");
    }

}
