---
layout: lesson
route: ficheros
lesson_id: leccion16
lesson_file: 16-properties-en-src-main-resources
lesson_number: "16"
title: Properties en src/main/resources
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion16/
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

# Properties en src/main/resources

## Qué vas a conseguir

- Comprender **Properties en src/main/resources**.
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

Crea `src/main/resources/config.properties` con `app.name=CodeTasks`. Maven copia estos recursos al classpath y los incluye en el JAR. El recurso se abre con la clase, no con una ruta relativa al directorio de trabajo.

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LeerRecurso {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        InputStream stream = LeerRecurso.class.getResourceAsStream("/config.properties");
        if (stream == null) throw new FileNotFoundException("Recurso config.properties ausente");
        try (Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            props.load(reader);
        }
        System.out.println(props.getProperty("app.name"));
    }
}
```

Guarda la clase en `src/main/java/LeerRecurso.java`. Tras `mvn package`, ejecuta `java -cp target/classes LeerRecurso`: debe imprimir `CodeTasks`. Para verificar el recurso empaquetado, ejecuta `java -cp /ruta/absoluta/al/artefacto.jar LeerRecurso` desde otra carpeta. Sustituye la ruta por el JAR generado.

La barra inicial busca desde la raíz del classpath. Un recurso dentro de un JAR no es necesariamente un archivo del sistema operativo ni debe modificarse como configuración persistente. Para valores modificables durante la operación utiliza un archivo externo con ruta explícita.


## Relación con el resto de la ruta

Spring Boot amplía properties mediante application.properties, YAML, profiles y variables de entorno.

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
  <a href="/ficheros/leccion15/">← 15 · Guardar properties</a>
  <a href="/ficheros/leccion17/">17 · Configuración, secretos y buenas prácticas →</a>
</div>
