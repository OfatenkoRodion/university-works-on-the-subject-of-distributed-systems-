package Client;

import MyServer.iTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainForm
{
    public JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton buttonAddOwner;
    private JButton buttonAddHouse;
    private JButton buttonAddBelonging;
    private JButton buttonGetAllOwners;
    private JButton buttonGetAllHouses;
    private JButton buttonGetAllBelonging;

    public MainForm()
    {
        buttonAddOwner.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.addOwner(textField1.getText(), Integer.parseInt(textField2.getText())));
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });

        buttonAddHouse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.addHouse(textField1.getText(), Integer.parseInt(textField2.getText())));
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });

        buttonAddBelonging.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.addBelonging(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText())));
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });

        buttonGetAllHouses.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.getAllHouses());
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });

        buttonGetAllOwners.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.getAllOwners());
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });
        buttonGetAllBelonging.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1");
                    iTable stub = (iTable) registry.lookup("Server2");
                    textField3.setText(stub.getAllBelongings());
                }
                catch (RemoteException ex)
                {
                    textField3.setText(ex.toString());
                }
                catch (Exception ex)
                {
                    textField3.setText("Что-то пошло не так");
                }
            }
        });
    }
}
