package org.example.LabPracticals;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5555);
        System.out.println("Server is online...");

        Socket socket = server.accept();
        System.out.println("Client is connected...");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));

        String receivedMessage;
        String sentMessage;
        try {
            do {
                receivedMessage = in.readUTF();
                System.out.println("Client: " + receivedMessage);

                System.out.print("Your message: ");
                sentMessage = ibr.readLine();
                out.writeUTF(sentMessage);

                System.out.println("Server: " + sentMessage);
                System.out.println();

            } while (!receivedMessage.equalsIgnoreCase("stop"));
        } catch (Exception ignored) {
        }

        System.out.println("Terminated connection...");

        in.close();
        socket.close();
        server.close();
    }
}