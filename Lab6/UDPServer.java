package Lab6;

import java.net.*;
class UDPServer{
        public static void main(String args[]) throws Exception{
                DatagramSocket serverSocket = new DatagramSocket(5454);
                System.out.println("Server is Ready for the client");
                byte[] recieveData = new byte[1024];
                byte[] sendData = new byte[1024];
                while(true){
                        DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);
                        serverSocket.receive(recievePacket);
                        String sentence = new String(recievePacket.getData());
                        System.out.println("RECEIVED: " + sentence);
                        InetAddress IPAddress = recievePacket.getAddress();
                        int port = recievePacket.getPort();
                        String capitalized = sentence.toUpperCase();
                        sendData = capitalized.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                        serverSocket.send(sendPacket);
                }
        }
}
