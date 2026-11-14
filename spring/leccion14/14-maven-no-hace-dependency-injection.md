---
layout: lesson
route: spring
lesson_id: leccion14
lesson_file: 14-maven-no-hace-dependency-injection
lesson_number: "14"
title: Maven no hace Dependency Injection
description: Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.
permalink: /spring/leccion14/
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
# Maven no hace Dependency Injection

Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Maven no hace Dependency Injection** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Maven y gestión de dependencias.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Maven: Resuelve archivos JAR. Spring: Crea objetos e inyecta dependencias.]({{ "/assets/images/spring/14-maven-no-hace-dependency-injection.webp" | relative_url }})

## Ejemplo guiado

```text
pom.xml ──Maven──> JARs en classpath

classpath + configuración
        ──Spring──> beans e inyección
```

Maven no decide qué objeto Java recibe cada constructor.


<div class="cla-note"><strong>No confundas dos dependencias</strong><p>Una dependencia Maven es una biblioteca del proyecto. Dependency Injection es un mecanismo de diseño/ejecución mediante el que Spring proporciona objetos colaboradores.</p></div>


## Relación con el resto de la ruta

Maven resuelve bibliotecas. Spring gestiona objetos. El árbol Maven explica qué código existe en classpath; ApplicationContext explica qué objetos existen en ejecución.



## Ejemplo adicional: aplicación práctica

```java
@Service
class FacturacionService {
    private final FacturaRepository repository;
    FacturacionService(FacturaRepository repository) {
        this.repository = repository;
    }
}
```

Maven descarga dependencias; Spring inyecta objetos en ejecución.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Maven no hace Dependency Injection** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Maven no hace Dependency Injection** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion13/">← 13 · Incorporar Spring con Maven</a>
  <a href="/spring/leccion15/">15 · Dependencias transitivas de Spring →</a>
</div>
