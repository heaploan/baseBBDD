package org.examen.view;

import org.examen.exceptions.BbddException;
import org.examen.exceptions.CommandException;

import java.sql.SQLException;

public class Menu {
    InputData input = new InputData();
    Options op = new Options();

    public void menu(){
        String option;
        do{
            String[] command = input.askStr().trim().split(" ");
            op.setCommand(command);
            option = command[0].toLowerCase();
            try{
                switch(option){
                    case "opcion1":
                        break;
                    case "opcion2":
                        break;
                    case "opcion3":
                        break;
                    case "opcion4":
                        break;
                    case "opcion5":
                        break;
                    case "opcion6":
                        break;
                    case "exit":
                        System.out.println("Saliendo...");
                        break;
                    default:
                        throw new CommandException(CommandException.WRONG_OPERATION);
                }
            } catch (CommandException | BbddException e){
                System.out.println(e.getMessage());
            } catch (SQLException e){
                System.out.println("Error con la bbdd: " + e.getMessage());
            }
        } while(!option.equals("exit"));
    }
}
