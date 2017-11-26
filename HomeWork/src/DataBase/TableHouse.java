package DataBase;

import java.sql.*;

public class TableHouse
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
            statement.executeUpdate("CREATE TABLE House(id INTEGER AUTO_INCREMENT PRIMARY KEY ,adress TEXT, price INTEGER);");
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
            statement.executeUpdate("Drop TABLE House");
            return "Deleted";
        }
    }
    public static String addHouse(String _adress, int _price) throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/HomeWork";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            String sql="INSERT INTO House SET adress='"+_adress.toString()+"',price ='"+Integer.valueOf(_price)+"'";
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

            ResultSet resultSet = statement.executeQuery("SELECT * FROM House");
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
