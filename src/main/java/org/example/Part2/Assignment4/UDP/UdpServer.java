package org.example.Part2.Assignment4.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Timestamp;

public class UdpServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(5001);
        System.out.println("Server Started. Listening for Clients on port 5001" + "...");

        // Assume messages are not over 1024 bytes
        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket;

        while (true) {

            // Server waiting for clients message
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);// The received data is stored in the receiveData byte array.

            // Get the client's IP address and port
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            // Convert Byte Data to String
            String clientMessage = new String(receivePacket.getData(),0,receivePacket.getLength());

            // Print the message with log header
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("[" + timestamp + " ,IP: " + IPAddress + " ,Port: " + port +"]  " + clientMessage);
        }
    }

}