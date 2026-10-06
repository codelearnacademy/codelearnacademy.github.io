package es.educacion.orm.orm;
import es.educacion.orm.model.Producto; import es.educacion.orm.orm.entity.ProductoEntity; import es.educacion.orm.orm.mapper.ProductoMapper; import es.educacion.orm.repository.*; import jakarta.persistence.*; import java.util.*;
public final class ProductoOrmRepository implements IProductoRepository {
    private final EntityManagerFactory emf;
    public ProductoOrmRepository(EntityManagerFactory emf){this.emf=emf;}
    @Override public List<Producto> findAll(){ try(EntityManager em=emf.createEntityManager()){ return em.createQuery("select p from ProductoEntity p order by p.id",ProductoEntity.class).getResultStream().map(ProductoMapper::toDomain).toList(); } catch(RuntimeException e){throw new RepositoryException("Error listando productos",e);} }
    @Override public Optional<Producto> findById(Long id){ try(EntityManager em=emf.createEntityManager()){ return Optional.ofNullable(em.find(ProductoEntity.class,id)).map(ProductoMapper::toDomain); } catch(RuntimeException e){throw new RepositoryException("Error buscando producto",e);} }
    @Override public void create(Producto p){ withTx("Error creando producto", em->em.persist(ProductoMapper.toEntity(p))); }
    @Override public boolean update(Producto p){ return withTxResult("Error actualizando producto", em->{ ProductoEntity e=em.find(ProductoEntity.class,p.id()); if(e==null)return false;e.setNombre(p.nombre());e.setPrecio(p.precio());return true;}); }
    @Override public boolean delete(Long id){ return withTxResult("Error eliminando producto", em->{ProductoEntity e=em.find(ProductoEntity.class,id);if(e==null)return false;em.remove(e);return true;}); }
    private void withTx(String msg, java.util.function.Consumer<EntityManager> action){ withTxResult(msg,em->{action.accept(em);return true;}); }
    private <R> R withTxResult(String msg, java.util.function.Function<EntityManager,R> action){ EntityManager em=emf.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();R r=action.apply(em);tx.commit();return r;}catch(RuntimeException e){if(tx.isActive())tx.rollback();throw new RepositoryException(msg,e);}finally{em.close();} }
}