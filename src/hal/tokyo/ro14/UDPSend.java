/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal.tokyo.ro14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author gn5r
 */
public class UDPSend {

    private final DatagramSocket socket;
    private final InetAddress inetAddress;
    private final int port;

    public UDPSend(String IPAddress, int port) throws Exception {
        this.socket = new DatagramSocket();
        this.inetAddress = InetAddress.getByName(IPAddress);
        this.port = port;
    }

    public boolean send() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Type send message:");
        String message = br.readLine();
        byte[] buf = message.getBytes("UTF-8");

        DatagramPacket packet = new DatagramPacket(buf, buf.length, this.inetAddress, this.port);
        socket.send(packet);
        if (message.equals("")) {
            return false;
        }
        return true;
    }

    public void close() {
        this.socket.close();
    }

}
