package Client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
      /*  if (System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            iCommand stub = (iCommand) registry.lookup("Command");

            System.out.println(stub.sentCommand("ADD TOM paroda 1"));
            System.out.println(stub.sentCommand("ADD Jon paroda 1"));
            System.out.println(stub.sentCommand("GET_ALL"));


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }*/

        JFrame frame = new JFrame("Lab4");
        frame.setContentPane( new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
