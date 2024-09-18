package org.example.Part2.Assignment3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class TcpFileSend {
    private static DataOutputStream dos = null;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000)) {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            File file = new File("D:\\CLionProjects\\C_C++\\CMakeLists.txt");

            System.out.println("Sending file to the server...");
            sendFile(file.getAbsolutePath());

            System.out.println("File Sent!");

            dis.close();
            dos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sendFile(String path) throws Exception {
        int bytes;

        // Open located file.
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        dos.writeLong(file.length()); // Send the file to server.

        byte[] buffer = new byte[4 * 1024]; // 4 MB

        while ((bytes = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, bytes); // Send the file to server socket.
            dos.flush();
        }

        fis.close();
    }
}