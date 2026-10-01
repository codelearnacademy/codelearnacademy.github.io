---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion10"
lesson_file: "10-escribir-objetos-a-csv"
lesson_number: "10"
title: "Escribir objetos a CSV"
description: "Conversión Producto → fila CSV y persistencia con CSVPrinter."
permalink: "/ficheros/leccion10/"
---

# Escribir objetos a CSV

## Qué vas a conseguir

- Convertir `Producto` a una fila escribible.
- Utilizar `CSVPrinter` para quoting y escape.
- Reescribir un catálogo completo de forma segura.

## De objetos a registros

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

```text
List<Producto> → mapeo → serializador/printer → fichero
```

Ese mismo esquema reaparecerá con `ObjectMapper` y `XmlMapper`.

## Ejercicios propuestos

1. Guarda un nombre con coma y comprueba el fichero generado.
2. Guarda caracteres como `á`, `ñ` y `€` usando UTF-8.
3. Lee de nuevo lo escrito y compara el resultado.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion09/">← 9 · Leer CSV a objetos Java</a>
  <a href="/ficheros/leccion11/">11 · CRUD con CSV: CsvCrudDemo →</a>
</div>
