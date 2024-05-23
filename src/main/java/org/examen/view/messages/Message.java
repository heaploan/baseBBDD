package org.examen.view.messages;

import java.util.Arrays;
import java.util.List;

public class Message {
    // Message codes
    public static final int OBJECT1_SUCCESSFULLY_ADDED = 0;
    public static final int OBJECT2_SUCCESSFULLY_ADDED = 1;
    public static final int OBJECT1_SUCCESSFULLY_DELETED = 2;
    public static final int OBJECT2_SUCCESSFULLY_DELETED = 3;

    // ANSI colors
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public final List<String> msgs = Arrays.asList(
            "El objeto1 ha sido agregado exitosamente",
            "El objeto2 ha sido agregado exitosamente",
            "EL objeto1 ha sido eliminado exitosamente",
            "El objeto2 ha sido eliminado exitosamente"
    );

    public String getMessage(int code){
        return ANSI_BLUE + msgs.get(code) + ANSI_RESET;
    }
}
