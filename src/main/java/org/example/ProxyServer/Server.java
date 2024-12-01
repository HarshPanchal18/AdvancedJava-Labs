package org.example.ProxyServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                OutputStream out = clientSocket.getOutputStream();

                // Respond back with "Hello from the server!".
                String response = "HTTP/1.1 200 OK\r\n\r\nHello from the server!";

                out.write(response.getBytes());
                out.flush();
                clientSocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}