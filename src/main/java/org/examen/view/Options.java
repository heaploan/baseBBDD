package org.examen.view;

import org.examen.exceptions.BbddException;
import org.examen.exceptions.CommandException;
import org.examen.model.Objeto1;
import org.examen.model.Objeto1DTO;
import org.examen.model.util.Validations;
import org.examen.persistence.Objeto1DAO;
import org.examen.view.messages.Message;

import java.sql.SQLException;
import java.util.ArrayList;

public class Options {

    private String[] command;
    private Validations vl = new Validations();
    private Message msg = new Message();
    private Objeto1DAO od = new Objeto1DAO();

    public void setCommand(String[] command){
        this.command = command;
    }


    // ALL ABOUT OBJECT1
    public void addObject1() throws CommandException, SQLException, BbddException {
        vl.valComLength(command,4);
        String nombre = command[1];
        String loQueSea = command[2];
        int loQueSea2 = vl.valIntNum(command[3]);
        vl.valNameLength(nombre,20);
        vl.valNameLength(loQueSea,20);
        Objeto1 ob1 = new Objeto1(nombre,loQueSea,loQueSea2);
        od.insertObject(ob1);
        System.out.println(msg.getMessage(Message.OBJECT1_SUCCESSFULLY_ADDED));
    }

    public void showAllObjects1() throws CommandException, SQLException, BbddException {
        vl.valComLength(command,1);
        ArrayList<Objeto1> objetos1 = od.allObjeto1();
        for(Objeto1 ob1 : objetos1){
            System.out.println(ob1);
        }
        if(objetos1.isEmpty()){
            throw new BbddException("No hay objetos1 registrados en la base de datos");
        }
    }


    public void showObject1() throws CommandException, SQLException, BbddException {
        vl.valComLength(command,2);
        String nombre = command[1];
        Objeto1 ob1 = od.getObjeto1ByNombre(nombre);
        System.out.println(ob1);
    }

    public void showObject1WithLoQueSea() throws CommandException, SQLException {
        vl.valComLength(command,2);
        String loQueSea = command[1];
        ArrayList<Objeto1DTO> objetos1 = od.getObjeto1WithLoQueSea(loQueSea);
        for(Objeto1DTO ob1 : objetos1){
            System.out.println(ob1);
        }
        if(objetos1.isEmpty()){
            System.out.println("No hay objetos1 con ese loquesea");
        }
    }

    public void deleteObject1() throws CommandException, SQLException, BbddException {
        vl.valComLength(command,2);
        String nombre = command[1];
        od.delObjeto1(nombre);
    }

    // ALL ABOUT OBJECT2

}
