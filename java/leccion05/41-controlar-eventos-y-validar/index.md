---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "Controlar eventos y validar"
permalink: /java/leccion05/41-controlar-eventos-y-validar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Controlar eventos y validar

Un controlador se ejecuta al pulsar un botón. Comprueba el valor antes de guardar.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/05-javafx.zip' | relative_url }}">Descargar proyecto JavaFX</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/41.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/41.webp' | relative_url }}" alt="Controlar eventos y validar. Un controlador se ejecuta al pulsar un botón. Comprueba el valor antes de guardar. Resultado: Al pulsar Guardar: Cantidad negativa" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main extends javafx.application.Application {
    @Override
    public void start(javafx.stage.Stage stage) {
        var campo = new javafx.scene.control.TextField("-1");
        var boton = new javafx.scene.control.Button("Guardar");
        var estado = new javafx.scene.control.Label();
        boton.setOnAction(evento -> { try { int n = Integer.parseInt(campo.getText()); estado.setText(n < 0 ? "Cantidad negativa" : "Cantidad válida"); } catch (NumberFormatException error) { estado.setText("Introduce un entero"); } });
        stage.setScene(new javafx.scene.Scene(new javafx.scene.layout.VBox(campo, boton, estado)));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
```

**Resultado esperado**

```text
Al pulsar Guardar: Cantidad negativa
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Vincula Guardar.
2. Lee el valor del campo.
3. Actualiza la etiqueta.
4. Valida un entero.
5. Rechaza una cantidad negativa.
6. Guarda el dato válido.
7. Recupera el dato al reabrir.
8. Comprueba texto no numérico.
9. Conserva el fichero ante rechazo.
10. Completa el flujo de edición y confirmación.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Controlar eventos y validar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Controlar eventos y validar</a>
</div>
