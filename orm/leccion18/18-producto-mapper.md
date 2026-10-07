---
layout: "lesson"
route: "orm"
lesson_id: "leccion18"
lesson_file: "18-producto-mapper"
lesson_number: "18"
title: "ProductoMapper: dominio y persistencia"
description: "ProductoMapper: dominio y persistencia"
permalink: "/orm/leccion18/"
---

# ProductoMapper: dominio y persistencia

## Mapper entre dominio y persistencia

```java
public final class ProductoMapper {
    private ProductoMapper() {}

    public static ProductoEntity toEntity(Producto p) {
        return new ProductoEntity(p.id(), p.nombre(), p.precio());
    }

    public static Producto toDomain(ProductoEntity e) {
        return new Producto(e.getId(), e.getNombre(), e.getPrecio());
    }
}
```

Esto introduce una responsabilidad explícita:

```text
IProductoRepository trabaja con Producto
Hibernate trabaja con ProductoEntity
```

El resto de la aplicación no necesita conocer las entidades ORM.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/18-mapper.png" alt="Mapper bidireccional. Producto → toEntity / toDomain → ProductoEntity." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Producto → toEntity / toDomain → ProductoEntity.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/18-separacion.png" alt="Separar modelos. Dominio independiente → Mapper explícito → Persistencia JPA." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Dominio independiente → Mapper explícito → Persistencia JPA.</p>


## Ejemplo guiado

### Implementar ProductoMapper

1. Implementa `toEntity(Producto)`.
2. Copia id, nombre y precio.
3. Implementa `toDomain(ProductoEntity)`.
4. Prueba ida y vuelta con un Producto conocido.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué responsabilidad tiene el mapper?

- A) Convertir entre modelos
- B) Abrir Connection
- C) Crear tablas
- D) Ejecutar JPQL siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Centraliza la traducción dominio-persistencia.</p>

</details>

### 2. ¿Debe contener SQL?

- A) No
- B) Sí siempre
- C) Solo SELECT
- D) Solo DELETE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El mapper no es repositorio.</p>

</details>

### 3. ¿Qué ventaja aporta?

- A) Evita duplicar conversiones
- B) Elimina entidades
- C) Sustituye EntityManager
- D) Crea tests automáticamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La conversión queda centralizada y explícita.</p>

</details>

### 4. ¿Qué dos direcciones necesitamos?

- A) dominio→entidad y entidad→dominio
- B) SQL→HTML y HTML→SQL
- C) JVM→JDK y JDK→JVM
- D) CSV→XML únicamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El repositorio lee y escribe.</p>

</details>


## Ejercicio propuesto

Crea `VehiculoMapper` y comprueba que normaliza la matrícula de acuerdo con el dominio.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion17/">← 17 · .properties y configuración ORM</a>
  <a href="/orm/leccion19/">19 · CREATE con EntityManager y persist() →</a>
</div>
