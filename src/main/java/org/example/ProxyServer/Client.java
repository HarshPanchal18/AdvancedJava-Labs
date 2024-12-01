package org.example.ProxyServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9090)) { // Connect to proxy

            OutputStream out = socket.getOutputStream();
            String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
            out.write(request.getBytes()); // Send an HTTP request through the proxy to the server
            out.flush();

            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read response from Proxy server
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*

*/