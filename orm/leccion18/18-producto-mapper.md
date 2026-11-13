---
layout: "lesson"
route: "orm"
lesson_id: "leccion18"
lesson_file: "18-producto-mapper"
lesson_number: "18"
title: "ProductoMapper: dominio y persistencia"
description: "ProductoMapper: dominio y persistencia"
permalink: "/orm/leccion18/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: mapper-entre-dominio-y-persistencia
  title: Mapper entre dominio y persistencia
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# ProductoMapper: dominio y persistencia

## Objetivo de aprendizaje

Convierte Producto en ProductoEntity para guardar y aplica la conversión inversa al leer.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/18-producto-mapper.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 18">
    <img src="{{ '/assets/images/orm/infografias/18-producto-mapper.webp' | relative_url }}" alt="Resumen visual de la lección 18. ProductoMapper: dominio y persistencia" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 18.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/18-producto-mapper.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/18-mapper.png' | relative_url }}" alt="ProductoMapper en ambos sentidos" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La dirección del mapeo depende de la operación. Comprueba que el identificador y los datos se conservan según el contrato.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/18-separacion.png' | relative_url }}" alt="Un mapper entre dos modelos" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El repositorio puede trabajar con el ORM y devolver objetos de dominio. La API del repositorio evita exponer entidades al cliente.</p>


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
- B) Ejecutar JPQL siempre
- C) Crear tablas
- D) Abrir Connection

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Centraliza la traducción dominio-persistencia.</p>

</details>

### 2. ¿Debe contener SQL?

- A) Sí siempre
- B) Solo SELECT
- C) No
- D) Solo DELETE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El mapper no es repositorio.</p>

</details>

### 3. ¿Qué ventaja aporta?

- A) Sustituye EntityManager
- B) Elimina entidades
- C) Crea tests automáticamente
- D) Evita duplicar conversiones

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La conversión queda centralizada y explícita.</p>

</details>

### 4. ¿Qué dos direcciones necesitamos?

- A) dominio→entidad y entidad→dominio
- B) CSV→XML únicamente
- C) SQL→HTML y HTML→SQL
- D) JVM→JDK y JDK→JVM

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

---
