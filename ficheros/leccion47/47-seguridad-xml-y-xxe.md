---
layout: lesson
route: ficheros
lesson_id: leccion47
lesson_file: 47-seguridad-xml-y-xxe
lesson_number: "47"
title: Seguridad XML y XXE
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion47/
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

# Seguridad XML y XXE

## Qué vas a conseguir

- Comprender **Seguridad XML y XXE**.
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

Una entidad externa puede hacer que un parser intente acceder a recursos que no forman parte del documento recibido. El ejemplo siguiente adopta una política estricta: no admite DTD y bloquea acceso externo. No presupone que todas las bibliotecas tengan los mismos valores predeterminados.

Guarda como `XmlSeguro.java`. La prueba utiliza una URI ficticia y un resolver que rechaza cualquier acceso; no lee secretos ni depende de un servidor de red.

```java
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class XmlSeguro {
    static DocumentBuilder builder() throws Exception {
        var f = DocumentBuilderFactory.newInstance();
        f.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        f.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        f.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        f.setXIncludeAware(false);
        var b = f.newDocumentBuilder();
        b.setEntityResolver((publicId, systemId) -> {
            throw new SAXException("Resolución externa bloqueada");
        });
        b.setErrorHandler(new DefaultHandler() {
            @Override public void fatalError(SAXParseException e) throws SAXException { throw e; }
        });
        return b;
    }
    public static void main(String[] args) throws Exception {
        builder().parse(new InputSource(new StringReader("<usuario>Ana</usuario>")));
        String entrada = "<!DOCTYPE usuario [<!ENTITY x SYSTEM 'urn:ejemplo:externo'>]>"
                       + "<usuario>&x;</usuario>";
        try {
            builder().parse(new InputSource(new StringReader(entrada)));
            throw new AssertionError("Se aceptó un documento con DTD");
        } catch (SAXException esperado) {
            System.out.println("XML normal aceptado; DTD rechazado");
        }
    }
}
```

Ejecuta `java XmlSeguro.java`: debe imprimir el mensaje de aceptación/rechazo. Si una propiedad no está soportada, no ignores la excepción para continuar con valores inseguros. También limita tamaño y consumo de recursos: bloquear entidades externas no resuelve todos los riesgos de entradas XML.

Para SAX, StAX, JAXB o Jackson configura el parser apropiado y verifica la misma política con pruebas. Este ejemplo demuestra la política DOM de Java 21; no certifica la configuración de cualquier XmlMapper.

Referencia: [guía de seguridad JAXP](https://docs.oracle.com/en/java/javase/21/security/java-api-xml-processing-jaxp-security-guide.html).


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
  <a href="/ficheros/leccion46/">← 46 · JAXB y Jakarta XML Binding</a>
  <a href="/ficheros/leccion48/">48 · Datos no confiables y validación →</a>
</div>
