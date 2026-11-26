---
layout: lesson
route: spring
lesson_id: leccion65
lesson_file: 65-entidades-jpa
lesson_number: "65"
title: Entidades JPA
description: Distingue el DTO, la entidad y la tabla. Comprueba cómo Boot descubre las entidades.
permalink: /spring/leccion65/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Entidades JPA

Distingue el DTO, la entidad y la tabla. Comprueba cómo Boot descubre las entidades.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 64–70.

El JSON del POST se convierte en `NuevaTarea`. Spring valida los campos y el servicio construye una `TareaEntity`. Hibernate usa su mapeo para guardar una fila en `tareas`. El servicio devuelve `TareaResponse`, que expone el ID de la categoría en el JSON.

```text
aula.tareas.TareasApplication
aula.tareas.persistencia.TareaEntity
aula.tareas.persistencia.CategoriaEntity
```

Spring Boot busca entidades en el paquete de la clase principal con `@SpringBootApplication` y sus subpaquetes. La configuración estándar del ejemplo prescinde de `persistence.xml` y del listado manual de clases. Si el mapeo reside en otro paquete, Spring Boot 4 permite indicar su ubicación:

```java
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = TareaEntity.class)
public class TareasApplication {
    // Método main.
}
```

La clase se usa como referencia al paquete. Si las entidades están en varios paquetes, indica uno por paquete en `basePackageClasses`.

**Ejercicio breve.** Busca `@Entity`, `@Table` y el constructor sin argumentos en el proyecto. Subraya qué campos del POST se convierten en columnas y qué valor agrega el servicio o la base. Después compara una fila de `tareas` con el JSON que devuelve GET.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion64/">← 64 · Configurar DataSource</a>
  <a href="/spring/leccion66/">66 · Identificadores →</a>
</div>
