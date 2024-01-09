package BankManagementSystem;


import java.sql.*;
public class Connect {

    public Connect() {
        try {
            Class.forName(com.mysql.cj.jdbc.Driver);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }
}
