import java.io.*;
import java.net.*;

public class ClientUDP {

    private static final int BUFF_LENGTH = 512;
    private byte [] buff = new byte [BUFF_LENGTH];

    private DatagramSocket udp_socket = null;
    private DatagramPacket receive_packet = null;
    private DatagramPacket send_packet = null;
    private InetAddress remoutIP_Adress = null;
    private int port ;

    public String sentMessageToServer(String message) throws IOException {
        buff = message.getBytes ();
        send_packet = new DatagramPacket (buff, message.length(), remoutIP_Adress, port);
        udp_socket.send (send_packet);
        udp_socket.receive (receive_packet);
        return  new String (receive_packet.getData (), 0, receive_packet.getLength ());
    }
    public void initialization() throws SocketException {
        udp_socket = new DatagramSocket ();
        receive_packet = new DatagramPacket (buff, BUFF_LENGTH);
    }
    public void closeConnection(){
        udp_socket.close ();
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setRemoutIP_Adress(String address) throws UnknownHostException {
        remoutIP_Adress = InetAddress.getByName (address);
    }
}
