---
layout: lesson
route: ficheros
lesson_id: leccion42
lesson_file: 42-sax
lesson_number: "42"
title: SAX
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion42/
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

# SAX

## Qué vas a conseguir

- Comprender **SAX**.
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

SAX comunica eventos a un manejador mientras procesa el documento. Este ejemplo procesa elementos sin construir un árbol DOM. Guarda como `LeerSax.java`.

```java
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class LeerSax {
    public static void main(String[] args) throws Exception {
        var factory = SAXParserFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        var reader = factory.newSAXParser().getXMLReader();
        reader.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        reader.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        reader.setContentHandler(new DefaultHandler() {
            @Override
            public void startElement(String uri, String local, String qName, Attributes attrs) {
                if (qName.equals("usuario")) System.out.println(attrs.getValue("nombre"));
            }
        });
        String xml = """
            <usuarios><usuario nombre="Ana"/><usuario nombre="Luis"/></usuarios>
            """;
        reader.parse(new InputSource(new StringReader(xml)));
    }
}
```

`java LeerSax.java` imprime Ana y Luis a medida que se reciben los eventos. El parser dirige las llamadas: es un modelo push. Si procesas texto mediante `characters`, recuerda que puede llegar dividido en varias llamadas; acumúlalo hasta el evento de cierre correspondiente.


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
  <a href="/ficheros/leccion41/">← 41 · DOM</a>
  <a href="/ficheros/leccion43/">43 · StAX →</a>
</div>
