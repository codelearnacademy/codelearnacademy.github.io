package es.educacion.orm.model;
public record Vehiculo(String matricula, String marca, String modelo, int anio) {
    public Vehiculo {
        if (matricula == null || matricula.isBlank()) throw new IllegalArgumentException("La matrícula es obligatoria");
        matricula = matricula.trim().toUpperCase();
        if (marca == null || marca.isBlank()) throw new IllegalArgumentException("La marca es obligatoria");
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("El modelo es obligatorio");
        if (anio < 1886) throw new IllegalArgumentException("Año no válido");
    }
}