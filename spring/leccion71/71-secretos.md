---
layout: lesson
route: spring
lesson_id: leccion71
lesson_file: 71-secretos
lesson_number: "71"
title: Secretos
description: Externaliza configuración y secretos para trabajar con varios entornos de forma segura.
permalink: /spring/leccion71/
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
# Secretos

Externaliza configuración y secretos para trabajar con varios entornos de forma segura.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Secretos** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Configuración y entornos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

No guardes:

```yaml
password: contraseña-real
```

en Git. Usa variables protegidas o un gestor de secretos.



## Relación con el resto de la ruta

Git conserva configuración no sensible; Docker/CI inyectan variables; los secretos deben vivir fuera del repositorio.



## Ejemplo adicional: aplicación práctica

```yaml
spring:
  datasource:
    username: ${DB_USER}
    password: ${DB_PASSWORD}
```

No almacenes secretos reales en archivos versionados.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Configura **Secretos** mediante propiedades externas en lugar de constantes en el código.
2. Comprueba el comportamiento con dos perfiles diferentes y verifica qué propiedad tiene prioridad.
3. Describe qué parámetros pueden guardarse en Git y cuáles deben proporcionarse de manera segura durante el despliegue.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Secretos** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion70/">← 70 · Variables de entorno</a>
  <a href="/spring/leccion72/">72 · @ConfigurationProperties →</a>
</div>
