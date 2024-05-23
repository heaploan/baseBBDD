package org.examen.persistence;

// local imports
import org.examen.exceptions.BbddException;
import org.examen.model.Objeto2;

// Java imports
import java.sql.*;

public class Objeto2DAO {
    private DBConnection c = new DBConnection();

    // Método para comprobar si existe un objeto2 en la base de datos
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

    // Método para insertar un objeto2 a su propia tabla en la base de datos
    public void insertObject(Objeto2 ob2) throws SQLException, BbddException {
        if(existeObjeto2(ob2.getNombre())){
            throw new BbddException("Ya existe un objeto1 con ese nombre");
        }
        Connection con = c.connect();
        PreparedStatement ps = con.prepareStatement("INSERT INTO objeto1 VALUES(?, ?, ?)");
        ps.setString(1, ob2.getNombre());
        ps.setString(2, ob2.getLoQueSea());
        ps.setInt(3, ob2.getLoQueSea2());
        ps.executeUpdate();
        ps.close();
        c.disconnect(con);
    }


}
