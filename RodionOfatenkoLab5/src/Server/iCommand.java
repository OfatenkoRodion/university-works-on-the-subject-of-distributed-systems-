package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iCommand extends Remote
{
    String sentCommand(String command) throws RemoteException;
    String add(String name,String breed, int age) throws RemoteException;
    String get_all() throws RemoteException;
    String dell_all() throws RemoteException;
    String dell_by_id(int id) throws RemoteException;
}
