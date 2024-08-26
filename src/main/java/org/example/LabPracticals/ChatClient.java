package org.example.LabPracticals;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);
//        Socket socket = new Socket("192.168.137.145", 5555);
        System.out.println("Client is online...");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentMessage;
        String receivedMessage;
        do {
            System.out.print("Your message: ");

            sentMessage = br.readLine();
            out.writeUTF(sentMessage);

            System.out.println("Client: " + sentMessage);
            System.out.println();

            receivedMessage = in.readUTF();
            System.out.println("Server: " + receivedMessage);
            System.out.println();

        } while (!sentMessage.equalsIgnoreCase("stop"));

        System.out.println("Terminated connection...");

        br.close();
        out.close();
        socket.close();
    }
}