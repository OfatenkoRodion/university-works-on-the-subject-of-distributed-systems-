package DataBase;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {

            TableBelonging.createTable();
            TableBelonging.addBelonging(1,1);
            System.out.print(TableBelonging.getAll());

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
