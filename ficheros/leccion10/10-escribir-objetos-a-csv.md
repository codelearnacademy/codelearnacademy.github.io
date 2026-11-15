---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion10"
lesson_file: "10-escribir-objetos-a-csv"
lesson_number: "10"
title: "Escribir objetos a CSV"
description: "Conversión Producto → fila CSV y persistencia con CSVPrinter."
permalink: "/ficheros/leccion10/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: de-objetos-a-registros
    title: "De objetos a registros"
  - id: patron-que-reutilizaremos
    title: "Patrón que reutilizaremos"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: microproyecto-escribir-un-producto-csv
    title: "Microproyecto · Escribir un producto CSV"
---

# Escribir objetos a CSV

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/10.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/10.webp' | relative_url }}" alt="Objetos → CSV. La escritura usa el orden que establece la cabecera. El escritor escapa las comas y las comillas cuando corresponde." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Convertir `Producto` a una fila escribible.
- Utilizar `CSVPrinter` para quoting y escape.
- Reescribir un catálogo completo de forma segura.

## De objetos a registros
{: #de-objetos-a-registros }

```java
private static Object[] toCsv(Producto p) {
    return new Object[]{p.id(), p.nombre(), p.precio()};
}
```

```java
static void writeAll(Path path, List<Producto> productos) throws IOException {
    CSVFormat format = CSVFormat.DEFAULT.builder()
            .setHeader("id", "nombre", "precio")
            .get();

    try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
         CSVPrinter printer = new CSVPrinter(writer, format)) {
        for (Producto p : productos) {
            printer.printRecord(toCsv(p));
        }
    }
}
```

<div class="cla-note">
<strong>Mejora:</strong>
    <p>La función writeAll debería devolvel un boolean para mejorar el código de cara al testin</p>
</div>

<div class="cla-note"><strong>No construyas CSV a mano</strong><p>Si concatenas cadenas con comas tendrás que reimplementar quoting y escapes. `CSVPrinter` ya conoce esas reglas.</p></div>

## Patrón que reutilizaremos
{: #patron-que-reutilizaremos }

```text
List<Producto> → mapeo → serializador/printer → fichero
```

Ese mismo esquema reaparecerá con `ObjectMapper` y `XmlMapper`.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Guarda un nombre con coma y comprueba el fichero generado.
2. Guarda caracteres como `á`, `ñ` y `€` usando UTF-8.
3. Lee de nuevo lo escrito y compara el resultado.


## Microproyecto · Escribir un producto CSV
{: #microproyecto-escribir-un-producto-csv }

Escribe cabecera id,nombre,precio y una fila con id 1. Conserva comas y acentos del nombre.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F10-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F10-tarea-01.webp' | relative_url }}" alt="Escribir un producto CSV. Resultado esperado: Nombre y precio recuperables" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Nombre y precio recuperables.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion10/F10-tarea-01.zip' | relative_url }}">Descargar F10-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion09/' | relative_url }}">← 9 · Leer CSV a objetos Java</a>
  <a href="{{ '/ficheros/leccion11/' | relative_url }}">11 · CRUD con CSV: CsvCrudDemo →</a>
</div>
