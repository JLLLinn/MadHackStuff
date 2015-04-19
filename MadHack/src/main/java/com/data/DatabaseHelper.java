package com.data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by karthik on 1/28/15.
 */

public class DatabaseHelper {

    public Connection initConnectionPool() {
        Connection connection = null;
        try {
            //String connectionURL = "jdbc:mysql://localhost:3306/imageintegration";
            String connectionURL = "jdbc:mysql://ap-eye.cloudapp.net:3307/ap_eye_db";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "");
            //connectionPool = new SimpleJDBCConnectionPool(
            //    "com.mysql.jdbc.Driver",
            //        "jdbc:mysql://localhost:3306/imageintegration", "root", "");

            System.out.println("connected :)");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}