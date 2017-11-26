package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class StartServer
{
    public static void main(String[] args)
    {
        if (System.getSecurityManager()==null)
        {
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
            iTable myRemoteInterface = new Server();
            iTable stub = ( iTable) UnicastRemoteObject.exportObject(myRemoteInterface,0);
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("Server",stub);
            System.out.println("Server started successfully");
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e)
        {
            e.printStackTrace();
        }
    }
}
