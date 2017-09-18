import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Connection {

   private int port;
   private String host;
   private String answer;

    public Connection(int port, String host) {
        this.port = port;
        this.host = host;
    }
    public void start(){
        TCP_Client client= new TCP_Client();

        try {
            client.setSocket(new Socket(host, port));
            client.setIs( new BufferedReader(new InputStreamReader(client.getSocket().getInputStream())));
            client.setPrintWriter(new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getSocket().getOutputStream()))));
        } catch (IOException e) {
            System.out.println("Errorr in setters " + e);
        }
        try {
            while (true){
                answer= client.sentCommandToServer(CommandSelection.select());
                System.out.println("Receive from server : " + answer);
                if(answer.equals("end")){
                    client.finishWork();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Errorr: cant*t take the answer" + e);
        }
        System.out.println("TCP_Client : Programm terminated ");
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
}
