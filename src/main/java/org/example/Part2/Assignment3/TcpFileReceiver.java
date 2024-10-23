package org.example.Part2.Assignment3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileReceiver {
    private static DataInputStream dis = null;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9000)) {

            System.out.println("Server is started...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected...");

            dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            receiveFile("ReceivedTCPFile.txt");

            System.out.println("Received file");

            dis.close();
            dos.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void receiveFile(String fileName) throws Exception {
        int bytes;
        FileOutputStream fos = new FileOutputStream(fileName);
        long size = dis.readLong(); // File size.
        byte[] buffer = new byte[4 * 1024];

        while (size > 0 &&
                (bytes = dis.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1
        ) {
            fos.write(buffer, 0, bytes); // write the file.
            size -= bytes; // read up to file size.
        }

        fos.close();
    }
}