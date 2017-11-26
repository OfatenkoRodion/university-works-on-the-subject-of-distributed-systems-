package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface iTable extends Remote
{
    String addOwner(String name,int newtelefon) throws RemoteException, SQLException, ClassNotFoundException;
    String getAllOwners() throws RemoteException, SQLException, ClassNotFoundException;
    String createTableOwner() throws RemoteException, SQLException, ClassNotFoundException;
    String deleteTableOwner() throws RemoteException, SQLException, ClassNotFoundException;

    String addHouse(String _adress, int _price) throws RemoteException, SQLException, ClassNotFoundException;
    String getAllHouses() throws RemoteException, SQLException, ClassNotFoundException;
    String createTableHouse() throws RemoteException, SQLException, ClassNotFoundException;
    String deleteTableHouse() throws RemoteException, SQLException, ClassNotFoundException;

    String addBelonging(int id_house, int id_owner) throws RemoteException, SQLException, ClassNotFoundException;
    String getAllBelongings() throws RemoteException, SQLException, ClassNotFoundException;
    String createTableBelonging() throws RemoteException, SQLException, ClassNotFoundException;
    String deleteTableBelonging() throws RemoteException, SQLException, ClassNotFoundException;
}
