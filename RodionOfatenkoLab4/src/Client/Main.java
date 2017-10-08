package Client;
import Server.iCommand;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        if (System.getSecurityManager()==null){
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
        }
    }
}
