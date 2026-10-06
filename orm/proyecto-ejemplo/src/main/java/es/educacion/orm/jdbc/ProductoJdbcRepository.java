package es.educacion.orm.jdbc;
import es.educacion.orm.model.Producto;
import es.educacion.orm.repository.*;
import java.sql.*; import java.util.*;
public final class ProductoJdbcRepository implements IProductoRepository {
    private final String url;
    public ProductoJdbcRepository(String url) { this.url=url; }
    private Producto map(ResultSet rs) throws SQLException { return new Producto(rs.getLong("id"),rs.getString("nombre"),rs.getDouble("precio")); }
    @Override public List<Producto> findAll() {
        String sql="SELECT id,nombre,precio FROM producto ORDER BY id"; List<Producto> out=new ArrayList<>();
        try(Connection c=DriverManager.getConnection(url); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()) { while(rs.next()) out.add(map(rs)); return out; }
        catch(SQLException e){ throw new RepositoryException("Error listando productos",e); }
    }
    @Override public Optional<Producto> findById(Long id) {
        String sql="SELECT id,nombre,precio FROM producto WHERE id=?";
        try(Connection c=DriverManager.getConnection(url); PreparedStatement ps=c.prepareStatement(sql)){ ps.setLong(1,id); try(ResultSet rs=ps.executeQuery()){ return rs.next()?Optional.of(map(rs)):Optional.empty(); } }
        catch(SQLException e){ throw new RepositoryException("Error buscando producto",e); }
    }
    @Override public void create(Producto p) {
        String sql="INSERT INTO producto(id,nombre,precio) VALUES(?,?,?)";
        try(Connection c=DriverManager.getConnection(url); PreparedStatement ps=c.prepareStatement(sql)){ ps.setLong(1,p.id());ps.setString(2,p.nombre());ps.setDouble(3,p.precio());ps.executeUpdate(); }
        catch(SQLException e){ throw new RepositoryException("Error creando producto",e); }
    }
    @Override public boolean update(Producto p) {
        String sql="UPDATE producto SET nombre=?,precio=? WHERE id=?";
        try(Connection c=DriverManager.getConnection(url); PreparedStatement ps=c.prepareStatement(sql)){ ps.setString(1,p.nombre());ps.setDouble(2,p.precio());ps.setLong(3,p.id());return ps.executeUpdate()==1; }
        catch(SQLException e){ throw new RepositoryException("Error actualizando producto",e); }
    }
    @Override public boolean delete(Long id) {
        try(Connection c=DriverManager.getConnection(url); PreparedStatement ps=c.prepareStatement("DELETE FROM producto WHERE id=?")){ ps.setLong(1,id);return ps.executeUpdate()==1; }
        catch(SQLException e){ throw new RepositoryException("Error eliminando producto",e); }
    }
}