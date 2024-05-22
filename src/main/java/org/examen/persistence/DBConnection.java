package org.examen.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/examen";
        String user = "root";
        String password = "root";
        Connection c = DriverManager.getConnection(url, user, password);
        return c;
    }

    public void disconnect(Connection c) throws SQLException{
        c.close();
    }
}
