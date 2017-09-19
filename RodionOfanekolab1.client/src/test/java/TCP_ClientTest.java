import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class TCP_ClientTest {

    @org.junit.jupiter.api.Test
    void sentCommandToServer_GET_ALL() {

        TCP_Client client= new TCP_Client();
        String expected="0) Name Max, breed persian, age 1; 1) Name Barsik, breed persian, age 2; 2) Name Pushok, breed siamese, age 1; ";
        String actual;
        String commandToServer="GET_ALL";
        actual=sentComm(commandToServer);
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void sentCommandToServer_DEL_ALL() {

        TCP_Client client= new TCP_Client();
        String expected="Successfully cleared";
        String actual;
        String commandToServer="DEL_ALL";
        actual=sentComm(commandToServer);
        assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void sentCommandToServer_ADD() {

        TCP_Client client= new TCP_Client();
        String expected="Successfully added";
        String actual;
        String commandToServer="ADD Tom Bars 3";
        actual=sentComm(commandToServer);
        assertEquals(expected,actual);
    }

    private String sentComm(String command){

        TCP_Client client= new TCP_Client();
        try {
            client.setSocket(new Socket("localhost", 9999));
            client.setIs( new BufferedReader(new InputStreamReader(client.getSocket().getInputStream())));
            client.setPrintWriter(new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getSocket().getOutputStream()))));
            return client.sentCommandToServer(command);

        } catch (IOException e) {
            return String.format("Errorr in setters %s", e);
        }
    }

}