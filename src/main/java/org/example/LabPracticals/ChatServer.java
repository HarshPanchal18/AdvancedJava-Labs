package org.example.LabPracticals;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is online");

        Socket socket = server.accept();
        System.out.println("Client is connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());

        int i;

        do {
            i = in.readChar();
            System.out.println((char)i);
        } while ((char) i != 'q');

        System.out.println("Terminated connection");

        in.close();
        socket.close();
        server.close();
    }
}