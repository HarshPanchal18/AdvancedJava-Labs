package org.example.Part2.Assignment4.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

    public static void main(String[] args) throws IOException {
        DatagramPacket sendPacket; // a container that holds data to be sent or received over a UDP connection.
        byte[] sendData; // to hold the message to be sent.

        // Create a Datagram Socket - acts as the endpoint for sending and receiving datagrams (packets) on a UDP connection.
        DatagramSocket clientSocket = new DatagramSocket();

        // Set client timeout to be 1 second
        clientSocket.setSoTimeout(1000);
        Scanner input = new Scanner(System.in);

        while (true) {
            String cmd = input.nextLine();

            // If client types quit, close the socket and exit
            if (cmd.equals("QUIT")) {
                clientSocket.close();
                System.exit(1);
            }

            sendData = cmd.getBytes();

            // A new DatagramPacket is created with the message bytes, destination IP 127.0.0.1:5001.
            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"), 5001);
            clientSocket.send(sendPacket); // send packet
        }
    }

}