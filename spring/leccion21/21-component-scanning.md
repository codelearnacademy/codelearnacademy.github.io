---
layout: lesson
route: spring
lesson_id: leccion21
lesson_file: 21-component-scanning
lesson_number: "21"
title: Component scanning
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion21/
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
# Component scanning

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Component scanning** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Paquete base: Define dónde buscar. Escaneo: Detecta componentes. Contexto: Registra los beans.]({{ "/assets/images/spring/21-component-scanning.webp" | relative_url }})

## Ejemplo guiado

```java
@Service
class PedidoService { }

@Repository
class PedidoRepository { }
```

Configura component scanning y comprueba que ambos aparecen en el contexto.



## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
@SpringBootApplication(scanBasePackages = "es.ejemplo")
public class Aplicacion {
    public static void main(String[] args) {
        SpringApplication.run(Aplicacion.class, args);
    }
}
```

Los componentes deben estar dentro del ámbito de escaneo.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **Component scanning**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Component scanning** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion20/">← 20 · @Configuration y @Bean</a>
  <a href="/spring/leccion22/">22 · Constructor injection →</a>
</div>
