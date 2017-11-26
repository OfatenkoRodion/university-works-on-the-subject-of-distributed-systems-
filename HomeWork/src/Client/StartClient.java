package Client;

import Server.iTable;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartClient
{
    public static void main(String[] args)
    {
        try
        {
            iTable myRemoteInterface = new Server.Server();
            iTable stub = ( iTable) UnicastRemoteObject.exportObject(myRemoteInterface,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server",stub);

            System.out.print(stub.getAllBelongings());
        }
        catch (RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        catch (Exception ex)
        {
            System.out.print(ex.toString());
        }
    }
}
