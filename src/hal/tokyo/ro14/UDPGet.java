/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal.tokyo.ro14;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author gn5r
 */
public class UDPGet {

    private final DatagramSocket socket;

    public UDPGet(int port) throws Exception {
        this.socket = new DatagramSocket(port);
    }

    public boolean receive() throws Exception {
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("受信中...");
        socket.receive(packet);
        System.out.println("受信データ:" + new String(packet.getData()));
        return true;
    }
}
