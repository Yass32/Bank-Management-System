package BankManagementSystem;


import java.sql.*;
public class Connect {
    //Connection is an interface provided by the java.sql package in Java.
    // It represents a connection to a database
    Connection c;
    // Statement interface is used to execute SQL statements.
    Statement s;
    public Connect() {
        try {
            // Load the JDBC driver and establish a connection to the database.
            // The JDBC driver is responsible for providing a set of classes that enable Java applications to interact with a database.
            //Connect to a MySQL database named "bankmanagementsystem" with a username "root" and no password.
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "");

            // Create a Statement object for executing SQL queries.
            s = c.createStatement();
        }
        catch (Exception e) {
            //Print out any exceptions that might occur during the connection process
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
