package dataProvider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Test {


    static String url ="jdbc:mysql://localhost:3306/sakila";
    static String userName="root";

    static String password="abcd123";

    static Connection connect =null;

    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected !");
        return connect;
    }





    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        connectToSqlDatabase();
    }



}
