package es.educacion.orm.orm.entity;
import jakarta.persistence.*;
@Entity @Table(name="producto")
public class ProductoEntity {
    @Id private Long id;
    @Column(nullable=false) private String nombre;
    @Column(nullable=false) private double precio;
    protected ProductoEntity() {}
    public ProductoEntity(Long id,String nombre,double precio){this.id=id;this.nombre=nombre;this.precio=precio;}
    public Long getId(){return id;} public String getNombre(){return nombre;} public double getPrecio(){return precio;}
    public void setNombre(String nombre){this.nombre=nombre;} public void setPrecio(double precio){this.precio=precio;}
}