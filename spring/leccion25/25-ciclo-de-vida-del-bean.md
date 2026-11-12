---
layout: lesson
route: spring
lesson_id: leccion25
lesson_file: 25-ciclo-de-vida-del-bean
lesson_number: "25"
title: Ciclo de vida del bean
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion25/
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
# Ciclo de vida del bean

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Ciclo de vida del bean** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```text
instanciación
  ↓
inyección
  ↓
post-procesado
  ↓
inicialización
  ↓
uso
  ↓
destrucción
```



## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
@Component
class RecursoExterno {
    @PostConstruct void iniciar() { /* conectar */ }
    @PreDestroy void cerrar() { /* liberar */ }
}
```

Comprueba cuándo se invocan las acciones del ciclo de vida.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **Ciclo de vida del bean**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Ciclo de vida del bean** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion24/">← 24 · Scopes de los beans</a>
  <a href="/spring/leccion26/">26 · Qué problema resuelve Spring Boot →</a>
</div>
