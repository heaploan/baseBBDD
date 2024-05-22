package org.examen.model;

public class Objeto1 {

    private String nombre;
    private String loQueSea;
    private int loQueSea2;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLoQueSea(String loQueSea) {
        this.loQueSea = loQueSea;
    }

    public void setLoQueSea2(int loQueSea2) {
        this.loQueSea2 = loQueSea2;
    }
}
