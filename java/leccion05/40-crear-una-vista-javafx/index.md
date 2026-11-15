---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "Crear una vista JavaFX"
permalink: /java/leccion05/40-crear-una-vista-javafx/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Crear una vista JavaFX

En el proyecto JavaFX, conecta la vista FXML con un controlador. Este ejemplo construye una vista mínima por código.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/05-javafx.zip' | relative_url }}">Descargar proyecto JavaFX</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/40.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/40.webp' | relative_url }}" alt="Crear una vista JavaFX. En el proyecto JavaFX, conecta la vista FXML con un controlador. Este ejemplo construye una vista mínima por código. Resultado: Una ventana con el valor 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main extends javafx.application.Application {
    @Override
    public void start(javafx.stage.Stage stage) {
        var campo = new javafx.scene.control.TextField("5");
        var vista = new javafx.scene.layout.VBox(campo);
        stage.setScene(new javafx.scene.Scene(vista));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
```

**Resultado esperado**

```text
Una ventana con el valor 5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/41-controlar-eventos-y-validar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea un campo.
2. Añade una etiqueta.
3. Muestra el stock inicial.
4. Alinea los controles.
5. Añade un botón.
6. Carga datos iniciales.
7. Presenta dos materiales.
8. Detecta un fx:id incorrecto.
9. Comprueba un recurso FXML ausente.
10. Muestra un formulario de inventario utilizable.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Crear una vista JavaFX. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Crear una vista JavaFX</a>
</div>
