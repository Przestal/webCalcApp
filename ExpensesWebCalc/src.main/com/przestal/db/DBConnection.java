package com.przestal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection createConnection(){

        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/calc";
        String username = "postgres";
        String password = "postgres";

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
