package org.examen.model.util;

import org.examen.exceptions.CommandException;

public class Validations {
    public void valComLength(String[] command, int expectedLength) throws CommandException{
        if(command.length != expectedLength){
            throw new CommandException(CommandException.WRONG_NUM_ARGS);
        }
    }
}
