package es.educacion.orm.demo;

import es.educacion.orm.model.Producto;
import es.educacion.orm.repository.RepositoryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CRUD JDBC monolítico de partida. La ruta lo refactoriza después a
 * ProductoJdbcRepository sin cambiar el comportamiento CRUD.
 */
public final class ProductoJdbcCrudDemo {

    private final String url;

    public ProductoJdbcCrudDemo(String url) {
        this.url = url;
    }

    public List<Producto> findAll() {
        String sql = "SELECT id, nombre, precio FROM producto ORDER BY id";
        List<Producto> productos = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(toProducto(rs));
            }
            return productos;
        } catch (SQLException e) {
            throw new RepositoryException("Error listando productos", e);
        }
    }

    public Optional<Producto> findById(long id) {
        String sql = "SELECT id, nombre, precio FROM producto WHERE id = ?";

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(toProducto(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new RepositoryException("Error buscando producto", e);
        }
    }

    public void create(Producto producto) {
        String sql = "INSERT INTO producto(id, nombre, precio) VALUES (?, ?, ?)";

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, producto.id());
            ps.setString(2, producto.nombre());
            ps.setDouble(3, producto.precio());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Error creando producto", e);
        }
    }

    public boolean update(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, producto.nombre());
            ps.setDouble(2, producto.precio());
            ps.setLong(3, producto.id());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RepositoryException("Error actualizando producto", e);
        }
    }

    public boolean delete(long id) {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RepositoryException("Error eliminando producto", e);
        }
    }

    private Producto toProducto(ResultSet rs) throws SQLException {
        return new Producto(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getDouble("precio"));
    }
}
