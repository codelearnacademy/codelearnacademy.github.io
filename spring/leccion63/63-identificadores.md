---
layout: lesson
route: spring
lesson_id: leccion63
lesson_file: 63-identificadores
lesson_number: "63"
title: Identificadores
description: Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.
permalink: /spring/leccion63/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Identificadores

Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Identificadores** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Persistencia con JPA y PostgreSQL.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

Compara identificadores asignados por aplicación con `@GeneratedValue` y explica cómo afecta al ciclo de persistencia.



## Relación con el resto de la ruta

PostgreSQL es infraestructura. JPA abstrae persistencia, Spring Data reduce código repetitivo y Flyway controla evolución del esquema.



## Ejemplo adicional: aplicación práctica

```java
@Entity
class ClienteEntity {
    @Id
    private String dni; // Asignado por la aplicación, no autogenerado.
    protected ClienteEntity() {}
}
```

Las claves naturales String y las claves numéricas autogeneradas requieren estrategias distintas.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa el concepto **Identificadores** en una entidad `TaskEntity` y su repositorio.
2. Añade una prueba de repositorio que compruebe los cambios persistidos, no solo los objetos en memoria.
3. Comprueba un caso límite: registro inexistente, relación inválida o transacción fallida, según corresponda.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Identificadores** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion62/">← 62 · Entidades JPA</a>
  <a href="/spring/leccion64/">64 · Repositories →</a>
</div>
