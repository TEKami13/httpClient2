package main.java.org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(8181);
        server.start();
    }
}
