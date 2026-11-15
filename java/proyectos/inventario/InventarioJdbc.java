import java.sql.*;

public class InventarioJdbc {
    public static void main(String[] args) throws SQLException {
        boolean forzarFallo = args.length > 0 && args[0].equals("fallo");
        try (Connection db = DriverManager.getConnection("jdbc:sqlite::memory:");
             Statement sql = db.createStatement()) {
            sql.execute("PRAGMA foreign_keys = ON");
            sql.execute("CREATE TABLE material (id INTEGER PRIMARY KEY, cantidad INTEGER NOT NULL CHECK(cantidad >= 0))");
            sql.execute("CREATE TABLE movimiento (id INTEGER PRIMARY KEY, material_id INTEGER NOT NULL REFERENCES material(id))");
            sql.executeUpdate("INSERT INTO material VALUES (1, 5)");
            db.setAutoCommit(false);
            try (PreparedStatement salida = db.prepareStatement("INSERT INTO movimiento(material_id) VALUES (?)");
                 PreparedStatement descontar = db.prepareStatement("UPDATE material SET cantidad = cantidad - 1 WHERE id = ? AND cantidad > 0")) {
                salida.setInt(1, 1);
                salida.executeUpdate();
                descontar.setInt(1, forzarFallo ? 99 : 1);
                if (descontar.executeUpdate() != 1) {
                    throw new SQLException("No se pudo descontar la unidad.");
                }
                db.commit();
            } catch (SQLException fallo) {
                db.rollback();
                System.out.println("Transacción revertida: " + fallo.getMessage());
            }
            try (ResultSet resultado = sql.executeQuery("SELECT cantidad, (SELECT COUNT(*) FROM movimiento) FROM material WHERE id = 1")) {
                if (resultado.next()) {
                    System.out.printf("Unidades: %d. Movimientos: %d.%n", resultado.getInt(1), resultado.getInt(2));
                }
            }
        }
    }
}
