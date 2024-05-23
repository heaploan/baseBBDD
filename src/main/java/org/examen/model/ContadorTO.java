package org.examen.model;

// Esta clase es para almacenar el número de objetos por nombre

public class ContadorTO {
    private String nombre;
    private int cantidad;

    public ContadorTO(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + ", cantidad: " + cantidad;
    }

}
