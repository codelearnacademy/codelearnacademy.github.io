package es.educacion.orm.orm;
import es.educacion.orm.model.Vehiculo; import es.educacion.orm.orm.entity.VehiculoEntity; import es.educacion.orm.orm.mapper.VehiculoMapper; import es.educacion.orm.repository.*; import jakarta.persistence.*; import java.util.*;
public final class VehiculoOrmRepository implements IVehiculoRepository {
    private final EntityManagerFactory emf;
    public VehiculoOrmRepository(EntityManagerFactory emf){this.emf=emf;}
    @Override public List<Vehiculo> findAll(){ try(EntityManager em=emf.createEntityManager()){ return em.createQuery("select v from VehiculoEntity v order by v.matricula",VehiculoEntity.class).getResultStream().map(VehiculoMapper::toDomain).toList(); }catch(RuntimeException e){throw new RepositoryException("Error listando vehículos",e);} }
    @Override public Optional<Vehiculo> findById(String id){ try(EntityManager em=emf.createEntityManager()){return Optional.ofNullable(em.find(VehiculoEntity.class,id)).map(VehiculoMapper::toDomain);}catch(RuntimeException e){throw new RepositoryException("Error buscando vehículo",e);} }
    @Override public void create(Vehiculo v){ withTx("Error creando vehículo",em->em.persist(VehiculoMapper.toEntity(v))); }
    @Override public boolean update(Vehiculo v){return withTxResult("Error actualizando vehículo",em->{VehiculoEntity e=em.find(VehiculoEntity.class,v.matricula());if(e==null)return false;e.setMarca(v.marca());e.setModelo(v.modelo());e.setAnio(v.anio());return true;});}
    @Override public boolean delete(String id){return withTxResult("Error eliminando vehículo",em->{VehiculoEntity e=em.find(VehiculoEntity.class,id);if(e==null)return false;em.remove(e);return true;});}
    private void withTx(String msg,java.util.function.Consumer<EntityManager>a){withTxResult(msg,em->{a.accept(em);return true;});}
    private <R> R withTxResult(String msg,java.util.function.Function<EntityManager,R>a){EntityManager em=emf.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();R r=a.apply(em);tx.commit();return r;}catch(RuntimeException e){if(tx.isActive())tx.rollback();throw new RepositoryException(msg,e);}finally{em.close();}}
}