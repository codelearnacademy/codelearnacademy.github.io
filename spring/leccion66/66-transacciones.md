---
layout: lesson
route: spring
lesson_id: leccion66
lesson_file: 66-transacciones
lesson_number: "66"
title: Transacciones
description: Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.
permalink: /spring/leccion66/
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

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# Transacciones

Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Transacciones** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Persistencia con JPA y PostgreSQL.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Iniciar: Agrupa cambios. Éxito: Commit confirma. Fallo: Rollback revierte según las reglas.]({{ "/assets/images/spring/66-transacciones.webp" | relative_url }})

## Ejemplo guiado

```java
@Transactional
public void completeAndAudit(Long id) {
    ...
}
```

Provoca una excepción y comprueba el rollback.



## Relación con el resto de la ruta

PostgreSQL es infraestructura. JPA abstrae persistencia, Spring Data reduce código repetitivo y Flyway controla evolución del esquema.



## Ejemplo adicional: aplicación práctica

```java
@Service
class TransferenciaService {
    @Transactional
    public void transferir(Long origen, Long destino, BigDecimal importe) {
        // Cargar ambas cuentas y aplicar los cambios en la misma transacción.
    }
}
```

Si la operación falla con una excepción no comprobada, Spring revierte la transacción por defecto.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa el concepto **Transacciones** en una entidad `TaskEntity` y su repositorio.
2. Añade una prueba de repositorio que compruebe los cambios persistidos, no solo los objetos en memoria.
3. Comprueba un caso límite: registro inexistente, relación inválida o transacción fallida, según corresponda.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Transacciones** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion65/">← 65 · Relaciones entre entidades</a>
  <a href="/spring/leccion67/">67 · Migraciones de base de datos →</a>
</div>
