package Server;

import DataBase.TableBelonging;
import DataBase.TableHouse;
import DataBase.TableOwner;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class Server  implements iTable
{

    @Override
    public String addBelonging(int id_house, int id_owner) throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableBelonging.addBelonging(id_house,id_owner);
    }

    @Override
    public String getAllBelongings() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableBelonging.getAll();
    }

    @Override
    public String createTableBelonging() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableBelonging.createTable();
    }

    @Override
    public String deleteTableBelonging() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableBelonging.deleteTable();
    }

    @Override
    public String addHouse(String _adress, int _price) throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableHouse.addHouse(_adress,_price);
    }

    @Override
    public String getAllHouses() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableHouse.getAll();
    }

    @Override
    public String createTableHouse() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableHouse.createTable();
    }

    @Override
    public String deleteTableHouse() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableHouse.deleteTable();
    }

    @Override
    public String addOwner(String name, int newtelefon) throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableOwner.addOwner( name, newtelefon);
    }

    @Override
    public String getAllOwners() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableOwner.getAll();
    }

    @Override
    public String createTableOwner() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableOwner.createTable();
    }

    @Override
    public String deleteTableOwner() throws RemoteException, SQLException, ClassNotFoundException
    {
        return TableOwner.deleteTable();
    }
}
