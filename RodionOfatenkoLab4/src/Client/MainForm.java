package Client;

import Server.iCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainForm {
    private JTextField textField1;
    private JButton послатьКомандуButton;
    private JTextArea textArea1;
    public JPanel panel1;

    public MainForm() {
        послатьКомандуButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String messageToServer = textField1.getText();
                String messageFromServer =null;

                try {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");

                    messageFromServer=stub.sentCommand(messageToServer);

                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                }
                textArea1.setText(messageFromServer);
            }
        });
    }
}
