package DataBase;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            //ConnectToDB.createTable();
            //ConnectToDB.deleteTable();
            //ConnectToDB.addOwner("Jon",35111);
            System.out.print(ConnectToDB.getAll());

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
