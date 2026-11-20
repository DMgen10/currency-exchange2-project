package org.dm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionManager {

    private static final String PROPERTIES_FILE = "db/db.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            Class.forName("org.postgresql.Driver");
            try (InputStream inputStream = ConnectionManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
                if (inputStream == null){
                    throw new RuntimeException("The PROPERTIES_FILE was not found in the resources");
                }
                PROPERTIES.load(inputStream);
            }
        } catch (IOException | ClassNotFoundException exception){
            throw new RuntimeException("The database driver could not be initialized or the file could not be opened or uploaded to PROPERTIES", exception);
        }
    }

    private ConnectionManager(){}

    public static Connection getConnection() throws SQLException {
        String url = PROPERTIES.getProperty("db.url");
        String password = PROPERTIES.getProperty("db.password");
        String userName = PROPERTIES.getProperty("db.username");
        return DriverManager.getConnection(url,userName,password);
    }
}
