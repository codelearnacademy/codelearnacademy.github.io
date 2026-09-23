---
layout: "route"
route: "ficheros"
title: "Ficheros"
search_title: "Ficheros y formatos de datos en Java 21"
search_description: "Ruta Java 21 para trabajar con .properties, CSV, JSON y XML usando Files, Apache Commons CSV, Jackson, CRUD y un proyecto final integrador."
permalink: "/ficheros/"
---

{% assign route = site.data.routes.ficheros %}

## Tecnologías utilizadas

<div class="cla-tech-grid">
{% for tech_key in route.technologies %}
  {% assign tech = site.data.technologies[tech_key] %}
  <div class="cla-tech-card">
    <img src="{{ tech.icon | relative_url }}" alt="{{ tech.name }}" width="42" height="42" loading="lazy">
    <strong>{{ tech.name }}</strong>
    <span>{{ tech.description }}</span>
  </div>
{% endfor %}
</div>

## Qué vas a aprender

La ruta parte de las APIs de ficheros de Java 21 y avanza hacia formatos de datos habituales. El mismo modelo `Producto` se reutiliza en CSV, JSON y XML para que puedas comparar las bibliotecas y las representaciones sin cambiar continuamente de dominio.

<div class="cla-note"><strong>Modelo mental de la ruta</strong><p>Separamos acceso al fichero, serialización o parsing, modelo de dominio, validación y lógica. Al final, las implementaciones CSV, JSON y XML cumplen un contrato común y pueden seleccionarse mediante configuración.</p></div>

## Índice completo

### Fundamentos · Lecciones 1–6

Java 21, `Path`, `Files`, UTF-8, excepciones, Maven y el modelo común `Producto`.

1. [Introducción a ficheros en Java 21](/ficheros/leccion01/)
2. [Path y Files](/ficheros/leccion02/)
3. [Lectura y escritura de texto](/ficheros/leccion03/)
4. [IOException y try-with-resources](/ficheros/leccion04/)
5. [Maven y dependencias](/ficheros/leccion05/)
6. [Modelo común Producto](/ficheros/leccion06/)

### `.properties` · Lecciones 7–11

Configuración clave-valor, lectura, escritura y un pequeño CRUD de configuración.

7. [El formato .properties](/ficheros/leccion07/)
8. [Leer .properties](/ficheros/leccion08/)
9. [Crear y modificar .properties](/ficheros/leccion09/)
10. [CRUD con .properties](/ficheros/leccion10/)
11. [Ejercicio: configuración de aplicación](/ficheros/leccion11/)

### CSV · Lecciones 12–17

Apache Commons CSV, mapeo a `Producto`, escritura, CRUD y ejercicio integrador.

12. [El formato CSV](/ficheros/leccion12/)
13. [Apache Commons CSV](/ficheros/leccion13/)
14. [Leer CSV a objetos Java](/ficheros/leccion14/)
15. [Escribir objetos a CSV](/ficheros/leccion15/)
16. [CRUD con CSV](/ficheros/leccion16/)
17. [Ejercicio: catálogo de productos CSV](/ficheros/leccion17/)

### JSON · Lecciones 18–23

Jackson Databind, `ObjectMapper`, colecciones, CRUD e inventario con `Producto`.

18. [El formato JSON](/ficheros/leccion18/)
19. [Jackson con Maven](/ficheros/leccion19/)
20. [Deserializar JSON](/ficheros/leccion20/)
21. [Serializar JSON](/ficheros/leccion21/)
22. [CRUD con JSON](/ficheros/leccion22/)
23. [Ejercicio: inventario JSON](/ficheros/leccion23/)

### XML · Lecciones 24–29

Jackson XML, wrappers de representación, serialización, CRUD y catálogo de `Producto`.

24. [El formato XML](/ficheros/leccion24/)
25. [Jackson XML con Maven](/ficheros/leccion25/)
26. [Deserializar XML](/ficheros/leccion26/)
27. [Serializar XML](/ficheros/leccion27/)
28. [CRUD con XML](/ficheros/leccion28/)
29. [Ejercicio: catálogo de productos XML](/ficheros/leccion29/)

### Integración · Lecciones 30–34

Contrato común de repositorio, inyección por constructor, configuración y proyecto DataBridge.

30. [Diseño común para varios formatos](/ficheros/leccion30/)
31. [Repositorios por formato](/ficheros/leccion31/)
32. [Configurar el programa con .properties](/ficheros/leccion32/)
33. [Proyecto final: DataBridge](/ficheros/leccion33/)
34. [Retos y ampliaciones](/ficheros/leccion34/)

## Proyecto final

En las últimas lecciones construirás **DataBridge**, una aplicación que utiliza `.properties` para seleccionar origen y destino, trabaja con un modelo `Producto` común y convierte información entre CSV, JSON y XML.

<div class="cla-lesson-nav">
  <span></span>
  <a href="/ficheros/leccion01/">1 · Introducción a ficheros en Java 21 →</a>
</div>
