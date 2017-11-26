package DataBase;

import java.sql.*;

public class TableBelonging
{
    public static String createTable() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            statement.executeUpdate("CREATE TABLE Belonging(id INTEGER AUTO_INCREMENT PRIMARY KEY ,id_Owner INTEGER, id_House INTEGER, FOREIGN KEY(id_Owner) REFERENCES Owner(id),FOREIGN KEY(id_House) REFERENCES House(id));");
            return "Created";
        }
    }
    public static String deleteTable() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            statement.executeUpdate("Drop TABLE Belonging");
            return "Deleted";
        }
    }
    public static String addBelonging(int id_house, int id_owner) throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            String sql="INSERT INTO Belonging SET id_Owner='"+Integer.valueOf(id_owner)+"',id_House ='"+Integer.valueOf(id_house)+"'";
            statement.executeUpdate(sql);
            return "Added";
        }
    }
    public static String getAll() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Belonging");
            String temp="";
            while (resultSet.next())
            {
                temp+="id:"+resultSet.getInt(1)+"\r\n";// or temp+="id:"+resultSet.getString("id")+"\r\n";
                temp+="name:"+resultSet.getString(2)+"\r\n";
                temp+="telefon:"+resultSet.getString(3)+"\r\n";
            }
            return temp;
        }
    }
}
