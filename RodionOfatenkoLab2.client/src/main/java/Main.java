import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main (String [] args) {

        String address = "localhost";
        int server_port = 5555;
        String messageFromServer="";
        String messageToServer="";
        try {
            ClientUDP clientUDP = new ClientUDP ();
            clientUDP.setPort(server_port);
            clientUDP.setRemoutIP_Adress(address);
            clientUDP.initialization();

            while (!messageToServer.equals("END")) {
                messageToServer = CommandSelection.select();
                System.out.println("Our command " + messageToServer);

                messageFromServer = clientUDP.sentMessageToServer(messageToServer);
                System.out.println("Server told: " + messageFromServer);
            }

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
