package org.examen.model.util;

import org.examen.exceptions.CommandException;

public class Validations {
    public void valComLength(String[] command, int expectedLength) throws CommandException{
        if(command.length != expectedLength){
            throw new CommandException(CommandException.WRONG_NUM_ARGS);
        }
    }

    public void valComLength(String[] command, int min, int max) throws CommandException{
        if(command.length < min || command.length > max ) {
            throw new CommandException(CommandException.WRONG_NUM_ARGS);
        }
    }

    public void valNameLength(String command, int max) throws CommandException  {
        if(command.length() > max){
            throw new CommandException(CommandException.WRONG_NAME_LENGTH);
        }
    }

    public int valIntNum(String num) throws CommandException {
        try{
            return Integer.parseInt(num);
        } catch (NumberFormatException e){
            throw new CommandException(CommandException.WRONG_NUM_FORMAT);
        }
    }

    public float valFloatnum(String num) throws CommandException {
        try {
            return Float.parseFloat(num);
        } catch (NumberFormatException e){
            throw new CommandException(CommandException.WRONG_NUM_FORMAT);
        }
    }

}
