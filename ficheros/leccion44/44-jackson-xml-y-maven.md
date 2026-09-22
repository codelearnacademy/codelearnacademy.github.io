---
layout: lesson
route: ficheros
lesson_id: leccion44
lesson_file: 44-jackson-xml-y-maven
lesson_number: "44"
title: Jackson XML y Maven
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion44/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Jackson XML y Maven

## Qué vas a conseguir

- Comprender **Jackson XML y Maven**.
- Aplicarlo con Java 21.
- Distinguir lectura, parsing, validación y escritura.
- Relacionarlo con Maven, Spring o Docker cuando corresponda.

## Punto de partida

```text
Fichero → bytes/texto → parser → objetos Java → validación → lógica → writer → fichero
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Leer un fichero no es interpretarlo. Un parser entiende el formato; la lógica de negocio valida el significado.</p></div>

## Conceptos clave

- Acceso mediante `Path` y `Files`.
- UTF-8 explícito cuando trabajamos con texto.
- Manejo de errores mediante excepciones.
- Separación entre formato y modelo de dominio.

## Ejemplo guiado

Añade `com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.19.4` a las dependencias Maven del proyecto. Guarda la clase como `EjemploJacksonXml.java` en `src/main/java`.

```java
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class EjemploJacksonXml {
  public record Usuario(String nombre, int edad) {}

  public static void main(String[] args) throws Exception {
    var mapper = new XmlMapper();
    var usuario = new Usuario("Ana", 22);
    var xml = mapper.writeValueAsString(usuario);
    var copia = mapper.readValue(xml, Usuario.class);
    System.out.println(xml);
    System.out.println(copia.nombre());
  }
}
```

El programa genera XML, lo vuelve a convertir en un objeto y muestra su nombre. Jackson XML necesita una dependencia diferente de `jackson-databind`, aunque ambas utilizan conceptos parecidos.



## Relación con el resto de la ruta

XML sigue siendo importante en integraciones empresariales, SOAP, estándares documentales y sistemas legacy.

## Ejercicios propuestos

1. Implementa el procesamiento XML específico de esta lección.
2. Prueba un documento válido y otro mal formado.
3. Añade una entrada con DTD o entidad externa y verifica que se rechaza cuando corresponda.
4. Compara el consumo de memoria y el control del flujo del parser utilizado.
5. Añade una prueba que compruebe el resultado y la política de seguridad XML.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion43/">← 43 · StAX</a>
  <a href="/ficheros/leccion45/">45 · XmlMapper →</a>
</div>
