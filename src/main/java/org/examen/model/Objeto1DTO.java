package org.examen.model;

public class Objeto1DTO {

    private String nombre;
    private String loQueSea;

    public Objeto1DTO(String nombre, String loQueSea) {
        this.nombre = nombre;
        this.loQueSea = loQueSea;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLoQueSea() {
        return loQueSea;
    }

    @Override
    public String toString() {
        return "\033[93m"+ "Nombre: " + nombre + ", Lo que sea : " + loQueSea + "\033[0m";
    }
}

