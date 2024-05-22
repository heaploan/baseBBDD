package org.examen.persistence;

import org.examen.model.Objeto1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Objeto1DAO {
    private DBConnection c = new DBConnection();

    private boolean existeObjeto1(String nombre) throws SQLException{
        Connection con = c.connect();
        Statement st = con.createStatement();
        String query = "SELECT * FROM objeto1 WHERE nombre = '" + nombre + "';";
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

    public ArrayList<Objeto1> Objeto1DAO() throws SQLException {
        Connection con = c.connect();
        ArrayList<Objeto1> objeto1s = new ArrayList<>();
        String query = "SELECT * FROM objeto1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String nombre = rs.getString("nombre");
            String loQueSea = rs.getString("loquesea");
            int loQueSea2 = rs.getInt("loquesea2");
            objeto1s.add(new Objeto1(nombre, loQueSea, loQueSea2));
        }
        rs.close();
        st.close();
        c.disconnect(con);
        return objeto1s;
    }
}
