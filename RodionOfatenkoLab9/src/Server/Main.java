package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        if (System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            iCommand myRemoteInterface = new Command();
            iCommand stub = ( iCommand) UnicastRemoteObject.exportObject(myRemoteInterface,0);
            Registry registry = LocateRegistry.createRegistry(1099);


            registry.bind("Command",stub);
            System.out.println("Command bound");

        } catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
