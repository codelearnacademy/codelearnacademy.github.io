package es.ies.puerto.ides;

public class App {
    public static String mensaje(String nombre) {
        return "Hola, " + nombre + "!";
    }

    public static void main(String[] args) {
        System.out.println(mensaje("IDEs"));
    }
}
