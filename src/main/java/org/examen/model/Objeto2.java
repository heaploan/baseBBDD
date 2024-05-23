package org.examen.model;

public class Objeto2 {

        private String nombre;
        private String loQueSea;
        private int loQueSea2;

        //ANSI colors
        public static final String ANSI_YELLOW = "\033[93m";
        public static final String ANSI_RESET = "\033[0m";

        public Objeto2(){
        }

        public Objeto2(String nombre, String loQueSea, int loQueSea2) {
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
            return "Nombre: " + nombre + ", Lo que sea : " + loQueSea + ", Lo que sea2: " + loQueSea2;
        }

}
