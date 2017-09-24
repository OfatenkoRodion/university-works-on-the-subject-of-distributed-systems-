import java.io.IOException;
import java.net.SocketException;

public class Main {
    public static void main (String [] args) {

        initCsts();
        int server_port = 5555;
        String messageFromClient="";
        String answerForClient="";
        try {
            ServerUDP serverUDP = new ServerUDP ();
            serverUDP.setUdp_socket_command_source(server_port);


            while (!messageFromClient.equals("END")){
                messageFromClient=serverUDP.listenCommandFromClient();
                System.out.println ("Client told "+messageFromClient);

                answerForClient=CommandSelection.select(messageFromClient);
                System.out.println ("Our answer "+answerForClient);
                serverUDP.sendCommandToClient(answerForClient);
            }

            serverUDP.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void initCsts(){
        Cats cats= Cats.getInstance();
        cats.add(new Cat("Max","persian",1));
        cats.add(new Cat("Barsik","persian",2));
        cats.add(new Cat("Pushok","siamese",1));
    }
}
