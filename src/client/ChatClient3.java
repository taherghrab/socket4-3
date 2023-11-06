package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ChatClient3 {
    public static void main(String[] args) {
        String serverIP = "localhost"; // Adresse IP du serveur
        int serverPort = 1234; // Port du serveur

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez votre nom  : ");
            String username = scanner.nextLine();

            while (true) {
                System.out.print("Message : ");
                String message = scanner.nextLine();
                String fullMessage = username + ": " + message;
                DatagramPacket send = new DatagramPacket(fullMessage.getBytes(), fullMessage.length(),
                        new InetSocketAddress(serverIP, serverPort));
                clientSocket.send(send);


            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
