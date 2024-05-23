package org.examen.model;

public class Objeto1 {

    private String nombre;
    private String loQueSea;
    private int loQueSea2;

    public Objeto1(){
    }

    public Objeto1(String nombre, String loQueSea, int loQueSea2) {
        this.nombre = nombre;
        this.loQueSea = loQueSea;
        this.loQueSea2 = loQueSea2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLoQueSea() {
        return loQueSea;
    }

    public int getLoQueSea2() {
        return loQueSea2;
    }

    @Override
    public String toString() {
        return "\033[93m"+ "Nombre: " + nombre + ", Lo que sea : " + loQueSea + ", Lo que sea2: " + loQueSea2 + "\033[0m";
    }

}
