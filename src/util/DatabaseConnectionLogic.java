package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// * REQ: PATRONES DE DISEÑO - Singleton
public class DatabaseConnectionLogic {
    private static Connection connection;
    public static Connection getConnection() throws SQLException {
        if (connection==null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_union", "campus2023", "campus2023");
        }
            System.out.println("Connection Establecida Correctamente");
            return connection;
    }
}