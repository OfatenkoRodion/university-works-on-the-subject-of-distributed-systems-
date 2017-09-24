import java.io.*;
import java.net.*;

public class ServerUDP {

    private static final int BUFF_LENGTH = 512;
    private byte [] buff = new byte [BUFF_LENGTH];

    private DatagramSocket udp_socket_command_source = null;
    private DatagramPacket receive_packet = null;
    private DatagramPacket send_packet = null;

    public ServerUDP() {
        receive_packet = new DatagramPacket (buff, BUFF_LENGTH);
    }
    public String listenCommandFromClient() throws IOException {
        udp_socket_command_source.receive (receive_packet);
        return new String (receive_packet.getData(), 0, receive_packet.getLength());
    }
    public void sendCommandToClient(String command) throws IOException {
        buff = command.getBytes ();
        receive_packet.setData(buff);
        send_packet=new DatagramPacket(receive_packet.getData(), receive_packet.getLength(), receive_packet.getAddress(), receive_packet.getPort());
        udp_socket_command_source.send (send_packet);
    }
    public void close(){
        udp_socket_command_source.close ();
    }
    public void setUdp_socket_command_source(int port) throws SocketException {
        udp_socket_command_source = new DatagramSocket (port);
    }

}
