---
layout: lesson
route: ficheros
lesson_id: leccion41
lesson_file: 41-dom
lesson_number: "41"
title: DOM
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion41/
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

# DOM

## Qué vas a conseguir

- Comprender **DOM**.
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

DOM construye un árbol en memoria para recorrerlo o modificarlo. Guarda este ejemplo como `LeerDom.java`; usa solo Java 21.

```java
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

public class LeerDom {
    public static void main(String[] args) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        String xml = """
            <usuarios><usuario nombre="Ana"/><usuario nombre="Luis"/></usuarios>
            """;
        var document = factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
        var usuarios = document.getElementsByTagName("usuario");
        for (int i = 0; i < usuarios.getLength(); i++) {
            var element = (org.w3c.dom.Element) usuarios.item(i);
            System.out.println(element.getAttribute("nombre"));
        }
    }
}
```

`java LeerDom.java` imprime Ana y Luis. DOM permite volver a cualquier nodo, a cambio de mantener el árbol en memoria. El ejemplo prohíbe DTD y acceso externo; no uses DOM para archivos arbitrariamente grandes. No interviene Jackson.


## Relación con el resto de la ruta

XML sigue siendo importante en integraciones empresariales, SOAP, estándares documentales y sistemas legacy.

## Ejercicios propuestos

1. Reproduce el ejemplo y guarda el resultado en un repositorio Git.
2. Introduce un fichero válido y otro mal formado; compara el comportamiento.
3. Cambia el nombre/ruta del fichero para recibirlo como argumento del programa.
4. Explica qué parte resuelve Java estándar y cuál depende de una biblioteca externa.
5. Escribe una prueba para el caso principal o describe cómo la automatizarías.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion40/">← 40 · JSON frente a XML</a>
  <a href="/ficheros/leccion42/">42 · SAX →</a>
</div>
