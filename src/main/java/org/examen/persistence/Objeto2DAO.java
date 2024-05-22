package org.examen.persistence;

import org.examen.model.Objeto1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Objeto2DAO {
    private DBConnection c = new DBConnection();

    private boolean existeObjeto2(String nombre) throws SQLException{
        Connection con = c.connect();
        Statement st = con.createStatement();
        String query = "SELECT * FROM objeto2 WHERE nombre = '" + nombre + "';";
        ResultSet rs = st.executeQuery(query);
        boolean exists = false;
        if(rs.next()){
            exists = true;
        }
        rs.close();
        st.close();
        c.disconnect(con);
        return exists;
    }


}
