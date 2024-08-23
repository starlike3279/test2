package org.example;

import org.example.db.DBConnection;

import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }
}