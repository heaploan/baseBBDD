package org.examen.view;

import org.examen.model.util.Validations;
import org.examen.persistence.Objeto1DAO;
import org.examen.view.messages.Message;

public class Options {
    private String[] command;
    private Validations vl = new Validations();
    private Message msg = new Message();
    private Objeto1DAO bdD = new Objeto1DAO();

    public void setCommand(String[] command){
        this.command = command;
    }


}
