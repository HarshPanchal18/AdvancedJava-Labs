package org.example.LabPracticals;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Client is online...");

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message;
        do {
            message = br.readLine();
            out.writeUTF(message);
            System.out.println(message);
        } while (!message.equalsIgnoreCase("stop"));

        System.out.println("Terminated connection...");

        br.close();
        out.close();
        socket.close();
    }
}