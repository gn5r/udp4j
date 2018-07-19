/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal.tokyo.ro14;

/**
 *
 * @author gn5r
 */
public class Sample {

    private static String IPAddress;
    private static int port;

    /*    引数:IPAddress port番号*/
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        if (args.length != 2) {
            System.out.println("必要パラメータが足りません");
            return;
        } else {
            IPAddress = args[0];
            port = Integer.parseInt(args[1]);
        }

        /*    どちらか片方で無限ループ    */
        udpReceive();
        udpSendText();

    }

    private static void udpReceive() throws Exception {
        UDPGet udpGet = new UDPGet(port);
        while (udpGet.receive()) {
            ;
        }
    }

    private static void udpSendText() throws Exception {
        UDPSend udpSend = new UDPSend(IPAddress, port);

        while (udpSend.send()) {
            ;
        }
        udpSend.close();
    }
}
