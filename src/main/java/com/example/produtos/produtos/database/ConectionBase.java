package com.example.produtos.produtos.database;

import javax.swing.*;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionBase {

    public static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUri = System.getenv("DATABASE_HOST");
        String dbPort = System.getenv("DATABASE_PORT");
        String dbName = System.getenv("DATABASE_NAME");

        String username = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");
        String dbUrl = "jdbc:postgresql://" + dbUri + ':' + dbPort + "/" + dbName + "?serverTimezone=UTC";

        return DriverManager.getConnection(dbUrl, username, password);
    }}
