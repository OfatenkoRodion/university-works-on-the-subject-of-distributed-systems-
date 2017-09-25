package Layouts;

import UDP_CLient.ClientUDP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;


public class MainForm {
    private JTextField textField1;
    public JPanel panel1;
    private JButton послатьКоммандуButton;
    private JTextArea textArea1;
    private String address = "localhost";
    private int server_port = 5555;
    ClientUDP clientUDP;

    public MainForm() {

        clientUDP = new ClientUDP();
        clientUDP.setPort(server_port);
        try{
        clientUDP.setRemoutIP_Adress(address);
        clientUDP.initialization();}
        catch (SocketException e) {
            textArea1.setText ("Exception in  initialization()");
        }
        catch (UnknownHostException e) {
            textArea1.setText("Exception: can*t set RemoutIP_Adress ");
        }

        послатьКоммандуButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String messageToServer = textField1.getText();
                String messageFromServer =null;
                try {
                    messageFromServer = clientUDP.sentMessageToServer(messageToServer);
                } catch (IOException e1) {
                    textArea1.setText ("Exception in receive or sent message ");
                }
                textArea1.setText(messageFromServer);
            }
        });
    }
}
