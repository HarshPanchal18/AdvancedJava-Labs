package org.example.LabPracticals;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProxyServer {

    public static void main(String[] args)  {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Serving at localhost:8888...");

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(() -> handleClientRequests(socket));
                thread.start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void handleClientRequests(Socket clientSocket) {
        try {
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = in.read(buffer); // Read client's request

            String request = new String(buffer, 0, bytesRead);
            String targetUrl = extractTargetUrl(request);

            // Open a connection to the target server
            Socket targetSocket = new Socket(targetUrl, 8888);
            InputStream tIn = targetSocket.getInputStream();
            OutputStream tOut = targetSocket.getOutputStream();

            // Forward client's request to target server
            tOut.write(request.getBytes());
            tOut.flush();

            while ((bytesRead = tIn.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }

            targetSocket.close();
            clientSocket.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static String extractTargetUrl(String request) {
        String[] lines = request.split("\\r\\n");
        String[] requestLine = lines[0].split(" ");
        return requestLine[1];
    }
}