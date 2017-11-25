package DataBase;

import java.sql.*;

public class ConnectToDB
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
            statement.executeUpdate("CREATE TABLE Owner(id INTEGER AUTO_INCREMENT PRIMARY KEY ,name TEXT, telefon INTEGER);");
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
            statement.executeUpdate("Drop TABLE Owner");
            return "Deleted";
        }
    }
    public static String addOwner(String name,int newtelefon) throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            String sql="INSERT INTO Owner SET name='"+name.toString()+"',telefon ='"+Integer.valueOf(newtelefon)+"'";
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

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Owner");
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
