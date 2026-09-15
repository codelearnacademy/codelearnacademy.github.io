---
layout: lesson
route: ficheros
lesson_id: leccion46
lesson_file: 46-jaxb-y-jakarta-xml-binding
lesson_number: "46"
title: JAXB y Jakarta XML Binding
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion46/
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

# JAXB y Jakarta XML Binding

## Qué vas a conseguir

- Comprender **JAXB y Jakarta XML Binding**.
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

Jakarta XML Binding relaciona clases y XML mediante un contexto y operaciones de marshalling/unmarshalling. En Java 21 no viene incluido como JAXB en el JDK. Para este ejemplo añade al POM:

```xml
<dependency>
  <groupId>jakarta.xml.bind</groupId>
  <artifactId>jakarta.xml.bind-api</artifactId>
  <version>4.0.2</version>
</dependency>
<dependency>
  <groupId>org.glassfish.jaxb</groupId>
  <artifactId>jaxb-runtime</artifactId>
  <version>4.0.5</version>
</dependency>
```

Guarda `EjemploJaxb.java` en `src/main/java`:

```java
import java.io.StringReader;
import java.io.StringWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.annotation.*;

public class EjemploJaxb {
    @XmlRootElement(name = "usuario")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Usuario {
        public String nombre;
        public Usuario() {}
        public Usuario(String nombre) { this.nombre = nombre; }
    }
    public static void main(String[] args) throws Exception {
        var context = JAXBContext.newInstance(Usuario.class);
        var out = new StringWriter();
        context.createMarshaller().marshal(new Usuario("Ana"), out);
        String xml = out.toString();
        var copia = (Usuario) context.createUnmarshaller().unmarshal(new StringReader(xml));
        System.out.println(copia.nombre);
    }
}
```

Con las dependencias en el classpath, imprime `Ana`. El XML del ejemplo se genera localmente y es de confianza. Para entradas externas configura explícitamente el parser que suministra los eventos, aplicando la política de la lección 47. JAXB y Jackson XML son APIs distintas; no se sustituyen cambiando solo el nombre de una variable.

Referencia: [Jakarta XML Binding RI](https://eclipse-ee4j.github.io/jaxb-ri/4.0.5/docs/release-documentation.html).


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
  <a href="/ficheros/leccion45/">← 45 · XmlMapper</a>
  <a href="/ficheros/leccion47/">47 · Seguridad XML y XXE →</a>
</div>
