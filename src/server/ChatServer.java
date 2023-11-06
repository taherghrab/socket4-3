package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) {
        // Création d'une liste pour stocker les adresses IP des clients connectés.
        List<InetSocketAddress> clients = new ArrayList<>();
        int port = 1234;

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("Serveur  démarré sur le port " + port);

            while (true) {
                byte[] Data = new byte[1024];
                DatagramPacket receive = new DatagramPacket(Data, Data.length);
                serverSocket.receive(receive);
            // Conversion des données reçues en une chaîne de caractères (message).
                String message = new String(receive.getData(), 0, receive.getLength());
                InetSocketAddress Addcli = (InetSocketAddress) receive.getSocketAddress();

                System.out.println("Message reçu de " + Addcli + ": " + message);

              /*  for (InetSocketAddress clientAddress : clients) {
                    if (!clientAddress.equals(senderAddress)) {
                        DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), clientAddress);
                        serverSocket.send(sendPacket);
                    }
                }*/
                // Si l'expéditeur n'est pas déjà dans la liste des clients, l'ajouter
                if (!clients.contains(Addcli)) {
                    clients.add(Addcli);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
