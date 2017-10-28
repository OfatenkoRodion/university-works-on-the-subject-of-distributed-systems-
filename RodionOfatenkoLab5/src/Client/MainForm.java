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

public class MainForm
{
    private JTextField textField1;
    private JButton послатьКомандуButton;
    private JTextArea textArea1;
    public JPanel panel1;
    private JButton ADD;
    private JTextField textFieldName;
    private JTextField textFieldBreed;
    private JTextField textFieldAge;
    private JButton GET_ALL;
    private JButton DEL_ALL;
    private JButton DEL_BY_ID;

    public MainForm()
    {
        послатьКомандуButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String messageToServer = textField1.getText();
                String messageFromServer =null;
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");
                    messageFromServer=stub.sentCommand(messageToServer);
                }
                catch (RemoteException ex)
                {
                    ex.printStackTrace();
                }
                catch (NotBoundException ex)
                {
                    ex.printStackTrace();
                }
                textArea1.setText(messageFromServer);
            }
        });
        ADD.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String messageFromServer =null;
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");
                    messageFromServer=stub.add(textFieldName.getText(),textFieldBreed.getText(),Integer.valueOf(textFieldAge.getText()));
                    textArea1.setText(messageFromServer);
                }
                catch (RemoteException ex)
                {
                    textArea1.setText(ex.toString());
                }
                catch (NotBoundException ex)
                {
                    textArea1.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textArea1.setText("Что-то пошло не так");
                }
            }
        });
        GET_ALL.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String messageFromServer =null;
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");
                    messageFromServer=stub.get_all();
                    textArea1.setText(messageFromServer);
                }
                catch (RemoteException ex)
                {
                    textArea1.setText(ex.toString());
                }
                catch (NotBoundException ex)
                {
                    textArea1.setText(ex.toString());
                }
            }
        });
        DEL_ALL.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String messageFromServer =null;
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");
                    messageFromServer=stub.dell_all();
                    textArea1.setText(messageFromServer);
                }
                catch (RemoteException ex)
                {
                    textArea1.setText(ex.toString());
                }
                catch (NotBoundException ex)
                {
                    textArea1.setText(ex.toString());
                }
            }
        });
        DEL_BY_ID.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String messageFromServer =null;
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iCommand stub = (iCommand) registry.lookup("Command");
                    messageFromServer=stub.dell_by_id(Integer.valueOf(textFieldName.getText()));
                    textArea1.setText(messageFromServer);
                }
                catch (RemoteException ex)
                {
                    textArea1.setText(ex.toString());
                }
                catch (NotBoundException ex)
                {
                    textArea1.setText(ex.toString());
                }
            }
        });
    }
}
