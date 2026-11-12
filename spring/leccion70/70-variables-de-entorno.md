---
layout: lesson
route: spring
lesson_id: leccion70
lesson_file: 70-variables-de-entorno
lesson_number: "70"
title: Variables de entorno
description: Externaliza configuración y secretos para trabajar con varios entornos de forma segura.
permalink: /spring/leccion70/
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
# Variables de entorno

Externaliza configuración y secretos para trabajar con varios entornos de forma segura.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Variables de entorno** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Configuración y entornos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/tasks
```



## Relación con el resto de la ruta

Git conserva configuración no sensible; Docker/CI inyectan variables; los secretos deben vivir fuera del repositorio.



## Ejemplo adicional: aplicación práctica

```bash
export DB_USER=app_user
export DB_PASSWORD='cambia-esta-clave'
./mvnw spring-boot:run
```

Las variables de entorno no deben incluirse en el repositorio Git.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Configura **Variables de entorno** mediante propiedades externas en lugar de constantes en el código.
2. Comprueba el comportamiento con dos perfiles diferentes y verifica qué propiedad tiene prioridad.
3. Describe qué parámetros pueden guardarse en Git y cuáles deben proporcionarse de manera segura durante el despliegue.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Variables de entorno** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion69/">← 69 · Profiles de desarrollo, test y producción</a>
  <a href="/spring/leccion71/">71 · Secretos →</a>
</div>
