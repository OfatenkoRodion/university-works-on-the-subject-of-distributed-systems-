package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface iCommand extends Remote
{
    String add(String name,String breed, int age) throws RemoteException, SQLException, ClassNotFoundException;
    String get_all() throws RemoteException, SQLException, ClassNotFoundException;
    String dell_all() throws RemoteException, SQLException, ClassNotFoundException;
    String dell_by_id(int id) throws RemoteException, SQLException, ClassNotFoundException;
}
