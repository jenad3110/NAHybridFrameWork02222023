package connectExternalData.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectToSQL {
    public static Connection connect = null;



    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected !");
        return connect;
    }


    public static Properties loadProperties() throws IOException{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/main/java/connectExternalData/database/credentielsforsql.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }



    public void executeQueries(String s) throws SQLException, IOException, ClassNotFoundException {


        connectToSqlDatabase();


        Statement stmt= connect.createStatement();

        //System.out.println("Executing this query : "+s);

        stmt.execute(s);

        connect.close();

    }


    public static String selectQueriesWithWhereCondition(String table,String column1,String whereCondition) throws SQLException, IOException, ClassNotFoundException {


        //1 connect to database

        connectToSqlDatabase();

        //2 create statment / query

        Statement stmt= connect.createStatement();

        String s = "SELECT " +column1+" FROM "+ table+" where "+whereCondition+";";

        System.out.println("Executing this query : "+s);

        //3 execute query
        ResultSet rs =stmt.executeQuery(s);

        String c1 = null;

        while(rs.next())
        {
            c1 = rs.getString(column1);
            //System.out.println(c1);
        }

        connect.close();

        return c1;
    }

    public void SelectQueries(String table,String column1) throws SQLException, IOException, ClassNotFoundException {

        //1 connect to database

        connectToSqlDatabase();

        //2 create statment / query

        Statement stmt= connect.createStatement();


        String s = "SELECT " +column1+" FROM "+ table+";";
        //SELECT actor_id FROM actor;

        System.out.println("Executing this query : "+s);

        //3 execute query
        ResultSet rs =stmt.executeQuery(s);



        while(rs.next())
        {
            String actorID = rs.getString(column1);
            System.out.println(actorID);

        }


        connect.close();

    }

    public void SelectQueries(String table,String column1,String column2) throws SQLException, IOException, ClassNotFoundException {

        //1 connect to database

        connectToSqlDatabase();

        //2 create statment / query

        Statement stmt= connect.createStatement();
        String s = "SELECT " +column1+","+column2+ " FROM "+ table+";";


        System.out.println("Executing this query : "+s);

        //3 execute query
        ResultSet rs =stmt.executeQuery(s);



        while(rs.next())
        {
            String c1 = rs.getString(column1);
            String c2 = rs.getString(column2);
            System.out.println(c1+" , "+c2);

        }


        connect.close();

    }

    public String selectQueries(String table,String column1) throws SQLException, IOException, ClassNotFoundException {


        //1 connect to database

        connectToSqlDatabase();

        //2 create statment / query

        Statement stmt= connect.createStatement();

        String s = "SELECT " +column1+" FROM "+ table+";";

        System.out.println("Executing this query : "+s);

        //3 execute query
        ResultSet rs =stmt.executeQuery(s);

        String c1 = null;

        while(rs.next())
        {
           c1 = rs.getString(column1);
           System.out.println(c1);
        }

        connect.close();

        return c1;
    }


    public String selectQueries(String table,String column1,int RowNumber) throws SQLException, IOException, ClassNotFoundException {


        //1 connect to database

        connectToSqlDatabase();

        //2 create statment / query

        Statement stmt= connect.createStatement();

        String s = "SELECT " +column1+" FROM "+ table+"WHERE ROWNUMBER ="+RowNumber;

        System.out.println("Executing this query : "+s);

        //3 execute query
        ResultSet rs =stmt.executeQuery(s);

        String c1 = null;

        while(rs.next())
        {
            c1 = rs.getString(column1);

            System.out.println(c1);
        }

        connect.close();

        return c1;
    }



    public static void main(String[] args) throws Exception {
        ConnectToSQL test = new ConnectToSQL();

        //test.executeQueries("DELETE FROM `sakila`.`actor` WHERE (`actor_id` = '600');");
         //test.executeQueries("DELETE FROM actor WHERE (actor_id = '600');");
       // test.executeQueries("insert into actor (actor_id,first_name,last_name) values ('600','?','?');");
        test.selectQueries("actor","first_name");

    }
}
