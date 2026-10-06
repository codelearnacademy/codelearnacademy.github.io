package es.educacion.orm.orm.entity;
import jakarta.persistence.*;
@Entity @Table(name="vehiculo")
public class VehiculoEntity {
    @Id private String matricula;
    @Column(nullable=false) private String marca;
    @Column(nullable=false) private String modelo;
    @Column(nullable=false) private int anio;
    protected VehiculoEntity() {}
    public VehiculoEntity(String matricula,String marca,String modelo,int anio){this.matricula=matricula;this.marca=marca;this.modelo=modelo;this.anio=anio;}
    public String getMatricula(){return matricula;} public String getMarca(){return marca;} public String getModelo(){return modelo;} public int getAnio(){return anio;}
    public void setMarca(String v){marca=v;} public void setModelo(String v){modelo=v;} public void setAnio(int v){anio=v;}
}