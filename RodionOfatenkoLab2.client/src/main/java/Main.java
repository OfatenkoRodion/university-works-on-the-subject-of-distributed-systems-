import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main (String [] args) {

        String address = "localhost";
        int server_port = 5555;
        try {
            ClientUDP clientUDP = new ClientUDP ();
            clientUDP.setPort(server_port);
            clientUDP.setRemoutIP_Adress(address);

            clientUDP.initialization();
            System.out.println ("The client is started ...");

            String messageFromServer= clientUDP.sentMessageToServer("fuck");
            System.out.println ("Server told: "+messageFromServer);

            clientUDP.closeConnection();
        }
        catch (SocketException e) {
            System.out.println ("Exception in  initialization()");
            e.printStackTrace();
        }
        catch (UnknownHostException e) {
            System.out.println ("Exception: can*t set RemoutIP_Adress ");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println ("Exception in receive or sent message ");
            e.printStackTrace();
        }
    }
}
