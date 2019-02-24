package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clasa folosita pentru a face conexiunea dintre programul de dezvoltare si baza de date
 */
public class MySql {
    public static MySql mySql = new MySql();
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    public String query;

    private MySql() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/catering", "root", "Martie0603");
            System.out.println("Conectat la Baza de Date");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static MySql getMySql() {
        return mySql;
    }
    public void getResultSet(String query) throws Exception
    {
        this.query = query;
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(query);
    }

    public void insereaza(String query) throws Exception
    {
        this.query = query;
        this.statement = this.connection.createStatement();
        this.statement.executeUpdate(query);
    }
}
