---
layout: route
route: ides
title: Entornos de desarrollo Java
search_title: IDEs Java en Debian 13.7.0 netinst
search_description: Ruta práctica para crear una máquina virtual con Debian 13.7.0 netinst, preparar Java 21, Maven y Git, e instalar y configurar VS Code, IntelliJ IDEA, Eclipse y Apache NetBeans.
permalink: /ides/
---

{% assign route = site.data.routes.ides %}

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

## Recorrido de aprendizaje

1. **Virtualización y Debian (1–6):** hipervisor, Debian 13.7.0 `netinst`, creación de la VM, instalación con Xfce e integración con VirtualBox.
2. **Entorno Java común (7–11):** actualización del sistema, JDK 21, Maven, Git y proyecto Maven compartido.
3. **Visual Studio Code (12–14):** instalación, extensiones Java y trabajo con Maven/JUnit.
4. **IntelliJ IDEA (15–16):** instalación de la distribución unificada y configuración del proyecto.
5. **Eclipse IDE (17–18):** instalación de Eclipse IDE for Java Developers e importación Maven.
6. **Apache NetBeans (19–20):** instalación de NetBeans y apertura del mismo proyecto.
7. **Comparación y cierre (21–22):** mismo proyecto, cuatro IDEs, criterios de comparación y verificación final.

<div class="cla-note"><strong>Modelo mental de la ruta</strong><p>El proyecto no pertenece al IDE. El mismo proyecto Maven debe poder compilarse y probarse desde la terminal y abrirse después en VS Code, IntelliJ IDEA, Eclipse y NetBeans sin modificar su estructura.</p></div>

<div class="cla-lesson-nav">
  <span></span>
  <a href="/ides/leccion01/">1 · Qué es un IDE y qué vamos a construir →</a>
</div>
