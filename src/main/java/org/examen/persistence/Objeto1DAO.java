package org.examen.persistence;

import org.examen.exceptions.BbddException;
import org.examen.model.Objeto1;
import org.examen.model.Objeto1DTO;

import java.sql.*;
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

    public void insertObject(Objeto1 ob1) throws SQLException, BbddException {
        if(existeObjeto1(ob1.getNombre())){
            throw new BbddException("Ya existe un objeto1 con ese nombre");
        }
        Connection con = c.connect();
        PreparedStatement ps = con.prepareStatement("INSERT INTO objeto1 VALUES(?, ?, ?)");
        ps.setString(1, ob1.getNombre());
        ps.setString(2, ob1.getLoQueSea());
        ps.setInt(3, ob1.getLoQueSea2());
        ps.executeUpdate();
        ps.close();
        c.disconnect(con);
    }

    public ArrayList<Objeto1> allObjeto1() throws SQLException {
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

    public Objeto1 getObjeto1ByNombre(String nombre) throws SQLException, BbddException{
        Connection con = c.connect();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM objeto1 WHERE nombre = ?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String loQueSea = rs.getString("loquesea");
            int loQueSea2 = rs.getInt("loquesea2");
            Objeto1 ob1 = new Objeto1(nombre, loQueSea, loQueSea2);
            return ob1;
        }else{
            throw new BbddException("No existe el objeto1 con ese nombre");
        }
    }

    public ArrayList<Objeto1DTO> getObjeto1WithLoQueSea(String loQueSea) throws SQLException {
        Connection con = c.connect();
        ArrayList<Objeto1DTO> objeto1s = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT nombre, loquesea FROM objeto1 WHERE loquesea = ?");
        ps.setString(1, loQueSea);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String nombre = rs.getString("nombre");
            objeto1s.add(new Objeto1DTO(nombre, loQueSea));
        }
        rs.close();
        ps.close();
        c.disconnect(con);
        return objeto1s;
    }

    public void delObjeto1(String nombre) throws SQLException, BbddException {
        if(!existeObjeto1(nombre)){
            throw new BbddException("No existe un objeto1 con ese nombre");
        }
        Connection con = c.connect();
        PreparedStatement ps = con.prepareStatement("DELETE FROM objeto1 WHERE nombre = ?");
        ps.setString(1, nombre);
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected == 0){
            throw new SQLException("No se encontró un propietario con ese nombre");
        }
        ps.close();
        c.disconnect(con);
    }


}
