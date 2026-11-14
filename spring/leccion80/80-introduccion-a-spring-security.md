---
layout: lesson
route: spring
lesson_id: leccion80
lesson_file: 80-introduccion-a-spring-security
lesson_number: "80"
title: Introducción a Spring Security
description: Introduce autenticación, autorización y protección de credenciales con Spring Security.
permalink: /spring/leccion80/
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
# Introducción a Spring Security

Introduce autenticación, autorización y protección de credenciales con Spring Security.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Introducción a Spring Security** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Seguridad.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Petición: Llega a la aplicación. Filtros: Aplican la política de seguridad. Controlador: Atiende si procede.]({{ "/assets/images/spring/80-introduccion-a-spring-security.webp" | relative_url }})

## Ejemplo guiado

Añade Spring Security y observa que la aplicación web queda protegida por defecto; después define reglas explícitas.



## Relación con el resto de la ruta

Spring Security es un framework del ecosistema Spring; no debes mezclar autenticación con reglas de negocio ni guardar secretos en código.



## Ejemplo adicional: aplicación práctica

```java
@Configuration
@EnableWebSecurity
class SeguridadConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(reg -> reg
            .requestMatchers("/actuator/health").permitAll()
            .anyRequest().authenticated()).build();
    }
}
```

Adapta la configuración CSRF y la autenticación al tipo de cliente.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Aplica **Introducción a Spring Security** a un endpoint de la API de tareas.
2. Comprueba los códigos HTTP para peticiones anónimas, autenticadas y sin permisos.
3. Añade pruebas que validen explícitamente que un usuario no puede consultar o modificar recursos ajenos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Introducción a Spring Security** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion79/">← 79 · Autenticación y autorización</a>
  <a href="/spring/leccion81/">81 · Password hashing →</a>
</div>
