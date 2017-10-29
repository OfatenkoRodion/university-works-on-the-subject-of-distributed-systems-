package DataBase;

import java.sql.*;

public class ConnectToDB
{
    public static String createTable() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/LabJDBC";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            statement.executeUpdate("CREATE TABLE Cats(id INTEGER AUTO_INCREMENT PRIMARY KEY ,name TEXT,breeds TEXT,  age INTEGER);");
            return "Created";
        }
    }
    public static String deleteTable() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/LabJDBC";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            statement.executeUpdate("Drop TABLE cats");
            return "Deleted";
        }
    }
    public static String addCat(String name,String breed, int age) throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/LabJDBC";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            String sql="INSERT INTO cats SET name='"+name.toString()+"', breeds='"+breed.toString()+"',  age ='"+Integer.valueOf(age)+"'";
            statement.executeUpdate(sql);
            return "Added";
        }
    }
    public static String getAll() throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/LabJDBC";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM cats");
            String temp="";
            while (resultSet.next())
            {
                temp+="id:"+resultSet.getInt(1)+"\r\n";// or temp+="id:"+resultSet.getString("id")+"\r\n";
                temp+="name:"+resultSet.getString(2)+"\r\n";
                temp+="breed:"+resultSet.getString(3)+"\r\n";
                temp+="age:"+resultSet.getInt(4)+"\r\n";
            }
            return temp;
        }
    }
    public static String del_by_id(int id) throws ClassNotFoundException, SQLException
    {
        String userName="root";
        String password="1234";
        String connectionURL = "jdbc:mysql://localhost:3306/LabJDBC";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL,userName,password);
             Statement statement =  connection.createStatement();)
        {
            String sql="DELETE FROM cats WHERE id ="+id;
            statement.executeUpdate(sql);
            return "Deleted cat with id:"+id+" (if it was exist)";
        }
    }
}
