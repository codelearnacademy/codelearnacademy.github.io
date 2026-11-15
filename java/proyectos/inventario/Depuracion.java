public class Depuracion {
    public static void main(String[] args) {
        int cantidad = args.length == 0 ? 3 : Integer.parseInt(args[0]);
        if (cantidad < 0) throw new CantidadInvalidaException(cantidad);
        long total = 0;
        // Punto de partida: reproduce el fallo antes de corregir el límite.
        for (int i = 1; i < cantidad; i++) {
            total += 250;
        }
        assert total == cantidad * 250L : "Falta sumar una unidad";
        System.out.println(total + " céntimos");
    }
}

class CantidadInvalidaException extends IllegalArgumentException {
    CantidadInvalidaException(int cantidad) {
        super("Cantidad negativa: " + cantidad);
    }
}
