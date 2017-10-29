package Server;


import DataBase.ConnectToDB;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class Command  implements iCommand
{
    public Command() throws SQLException, ClassNotFoundException
    {
        ConnectToDB.deleteTable();
        ConnectToDB.createTable();
    }

    @Override
    public String add(String name,String breed, int age) throws RemoteException, SQLException, ClassNotFoundException
    {
        return ConnectToDB.addCat(name,breed,age);
    }
    @Override
    public String get_all() throws RemoteException, SQLException, ClassNotFoundException
    {
        return ConnectToDB.getAll();
    }
    @Override
    public String dell_all() throws RemoteException, SQLException, ClassNotFoundException
    {
        ConnectToDB.deleteTable();
        ConnectToDB.createTable();
        return "Successfully cleared";
    }
    @Override
    public String dell_by_id(int id) throws RemoteException, SQLException, ClassNotFoundException
    {
        return ConnectToDB.del_by_id(id);
    }
}
