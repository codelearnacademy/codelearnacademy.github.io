---
layout: lesson
route: spring
lesson_id: leccion34
lesson_file: 34-controller-frente-a-restcontroller
lesson_number: "34"
title: "@Controller frente a @RestController"
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion34/
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
# @Controller frente a @RestController

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **@Controller frente a @RestController** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![@Controller: Selecciona una vista HTML. @RestController: Escribe el cuerpo de la respuesta.]({{ "/assets/images/spring/34-controller-frente-a-restcontroller.webp" | relative_url }})

## Ejemplo guiado

En un proyecto Spring Boot Servlet con `spring-boot-starter-web` y `spring-boot-starter-thymeleaf`, coloca estas clases en el paquete de la aplicación o un subpaquete. Cada clase pública debe guardarse en su propio archivo; importa las anotaciones web desde `org.springframework.web.bind.annotation` y Controller desde `org.springframework.stereotype`.

```java
@Controller
public class PageController {
    @GetMapping("/pagina")
    public String pagina() {
        return "saludo";
    }

    @GetMapping("/texto")
    @ResponseBody
    public String texto() {
        return "Hola";
    }
}
```

Crea `src/main/resources/templates/saludo.html` con `<h1>Hola desde la vista</h1>`.

```java
@RestController
public class TaskController {
    public static class Saludo {
        private String mensaje;

        public Saludo() { }

        public Saludo(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }

    @GetMapping("/api/saludo")
    public Saludo saludo() {
        return new Saludo("Hola");
    }
}
```

Con la aplicación arrancada en el puerto 8080, consulta `curl -i http://localhost:8080/pagina`, `/texto` y `/api/saludo`. Espera HTML renderizado, texto `Hola` y JSON `{"mensaje":"Hola"}` respectivamente. Sin la plantilla o un motor de vistas, devolver `saludo` no basta para producir esa página.

`@RestController` incorpora la semántica de `@ResponseBody`; los convertidores escriben la respuesta. También puede devolverse un cuerpo desde `@Controller`, como demuestra `/texto`. Un RestController no obliga a devolver siempre JSON: depende del valor, los convertidores y la negociación de contenido.

Referencia: [valores de retorno de Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/return-types.html).


## Relación con el resto de la ruta

Los clientes consumen un contrato HTTP cuyo cuerpo puede ser JSON, texto, HTML u otro formato acordado. El contrato API debe ser independiente de la implementación concreta del frontend.



## Ejemplo adicional: aplicación práctica

```java
@RestController
@RequestMapping("/api/tareas")
class TareaController {
    @GetMapping("/saludo")
    String saludo() { return "API disponible"; }
}
```

@RestController escribe el cuerpo de la respuesta HTTP.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **@Controller frente a @RestController**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **@Controller frente a @RestController** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion33/">← 33 · Qué ocurre cuando llega una petición HTTP</a>
  <a href="/spring/leccion35/">35 · @RequestMapping →</a>
</div>
