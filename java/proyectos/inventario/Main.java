import java.util.Scanner;
import java.util.Locale;

public class Main {
    static final int PRECIO_CENTIMOS = 250;

    static long calcularTotal(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva o cero.");
        }
        return (long) cantidad * PRECIO_CENTIMOS;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        if (!entrada.hasNextInt()) {
            System.out.println("Introduce un número entero.");
            return;
        }
        try {
            System.out.printf(Locale.forLanguageTag("es-ES"), "Total: %.2f €%n",
                    calcularTotal(entrada.nextInt()) / 100.0);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
