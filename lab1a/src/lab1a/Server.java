package lab1a;

import java.net.*;
import java.io.*;

/**
 * Created by douglas on 9/10/17.
 */
public class Server {
    public static final int PORT = 4950;
    public static final int MAXBUF = 1024;

    public static void main(String[] args) throws IOException {

        DatagramSocket sock = null;

        try {
            // Bind the servers socket to a port
            sock = new DatagramSocket(PORT);

            byte[] buffer = new byte[MAXBUF];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Wait for packet to arrive, retrive message
            System.out.println("Server waiting for message...");
            sock.receive(packet);
            // Exctract the part of the byte array containing the message
            String message = new String(packet.getData(), 0, packet.getLength());

            // Print information
            InetAddress clientAddr = packet.getAddress();
            System.out.println("Packet received from " + clientAddr.getHostName());
            System.out.println("Packet contained: " + message);
        }
        finally {
            sock.close();
            System.out.println("UDPServer done.");
        }
    }

}
