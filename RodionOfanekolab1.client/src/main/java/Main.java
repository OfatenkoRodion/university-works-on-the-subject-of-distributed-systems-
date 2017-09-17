import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String answer;
        int port = 9999;
        String host = "localhost";
        if (args.length !=0) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
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
                System.out.println("Please input string : ");
                answer= client.sentCommandToServer(new Scanner(System.in).next());
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
}


