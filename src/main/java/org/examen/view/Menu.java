package org.examen.view;

import org.examen.exceptions.BbddException;
import org.examen.exceptions.CommandException;
import org.examen.model.util.Validations;

import java.sql.SQLException;

public class Menu {
    InputData input = new InputData();
    Options op = new Options();
    Validations vl = new Validations();
    String[] command;
    public void menu(){
        String option;
        do{
            command = input.askStr().trim().split(" ");
            op.setCommand(command);
            option = command[0].toLowerCase();
            try{
                switch(option){
                    case "adob":
                        op.addObject1();
                        break;
                    case "showallobjects":
                        op.showAllObjects1();
                        break;
                    case "showobject1":
                        op.showObject1();
                        break;
                    case "showobj1loquesea":
                        op.showObject1WithLoQueSea();
                        break;
                    case "delobj1":
                        op.deleteObject1();
                        break;
                    case "opcion6":
                        break;
                    case "exit":
                        if (command.length != 1){
                            throw new CommandException(CommandException.WRONG_NUM_ARGS);
                        }
                        System.out.println("Saliendo...");
                        break;
                    default:
                        throw new CommandException(CommandException.WRONG_OPERATION);
                }
            } catch (CommandException | BbddException e){
                System.out.println(e.getMessage());
            } catch (SQLException e){
                System.out.println("\u001B[31mError con la bbdd: " + e.getMessage() + "\u001B[0m");
            }
        } while(!option.equals("exit") || command.length != 1);
    }
}
