---
layout: lesson
route: spring
lesson_id: leccion68
lesson_file: 68-configuracion-externa
lesson_number: "68"
title: Configuración externa
description: Externaliza configuración y secretos para trabajar con varios entornos de forma segura.
permalink: /spring/leccion68/
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
# Configuración externa

Externaliza configuración y secretos para trabajar con varios entornos de forma segura.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Configuración externa** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Configuración y entornos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Paquete: Contiene la aplicación. Configuración externa: Aporta valores por entorno. Arranque: Lee los valores efectivos.]({{ "/assets/images/spring/68-configuracion-externa.webp" | relative_url }})

## Ejemplo guiado

Ejecuta la misma aplicación con distinta configuración sin recompilar el JAR.



## Relación con el resto de la ruta

Git conserva configuración no sensible; Docker/CI inyectan variables; los secretos deben vivir fuera del repositorio.



## Ejemplo adicional: aplicación práctica

```properties
app.correos.remitente=${MAIL_SENDER:no-reply@ejemplo.test}
app.tareas.limite=100
```

Una propiedad puede tener un valor predeterminado y otro procedente del entorno.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Configura **Configuración externa** mediante propiedades externas en lugar de constantes en el código.
2. Comprueba el comportamiento con dos perfiles diferentes y verifica qué propiedad tiene prioridad.
3. Describe qué parámetros pueden guardarse en Git y cuáles deben proporcionarse de manera segura durante el despliegue.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Configuración externa** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion67/">← 67 · Migraciones de base de datos</a>
  <a href="/spring/leccion69/">69 · Profiles de desarrollo, test y producción →</a>
</div>
