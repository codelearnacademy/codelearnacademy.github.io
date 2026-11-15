---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Leer y modificar JSON y XML"
permalink: /java/leccion06/48-leer-y-modificar-json-y-xml/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Leer y modificar JSON y XML

En el proyecto Importador, utiliza Jackson y DOM. Este ejemplo modifica un atributo del XML en memoria.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/06-documentos.zip' | relative_url }}">Descargar proyecto Importación de documentos</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/48.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/48.webp' | relative_url }}" alt="Leer y modificar JSON y XML. En el proyecto Importador, utiliza Jackson y DOM. Este ejemplo modifica un atributo del XML en memoria. Resultado: 4" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var fabrica = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        var doc = fabrica.newDocumentBuilder().newDocument();
        var nodo = doc.createElement("material");
        nodo.setAttribute("cantidad", "5");
        doc.appendChild(nodo);
        nodo.setAttribute("cantidad", "4");
        System.out.println(doc.getDocumentElement().getAttribute("cantidad"));
    }
}
```

**Resultado esperado**

```text
4
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/49-agrupar-y-sumar-con-streams/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Lee un atributo XML.
2. Cambia un atributo.
3. Importa JSON con Jackson.
4. Exporta el documento.
5. Recupera el dato exportado.
6. Filtra materiales por categoría.
7. Compara los códigos de dos documentos.
8. Gestiona un documento mal formado.
9. Conserva el fichero anterior ante error.
10. Importa, modifica y vuelve a guardar un inventario.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Leer y modificar JSON y XML. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Leer y modificar JSON y XML</a>
</div>
