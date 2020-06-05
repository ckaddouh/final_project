package chatting_stuff;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    public Client(String address, int port) {
        try {
            this.address = InetAddress.getByName(address);
            this.port = port;

            socket = new DatagramSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }

        send("\\con: Christina");
    }
        public void send(String message){
        try {
            message += "\\e";
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
            System.out.println("Sent message to, " + address.getHostAddress() + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}