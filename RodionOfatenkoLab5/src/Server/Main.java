package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        if (System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        iCommand myRemoteInterface = new Command();

        try {
            iCommand stub = ( iCommand) UnicastRemoteObject.exportObject(myRemoteInterface,0);
            Registry registry = LocateRegistry.createRegistry(1099);


            registry.bind("Command",stub);
            System.out.println("Command bound");


        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
