---
layout: lesson
route: maven
lesson_id: principal16
lesson_number: "16"
title: "Empaquetar y ejecutar la aplicación"
description: "Configura el manifiesto y ejecuta el JAR con sus bibliotecas en los tres sistemas."
permalink: /maven/16-empaquetar-ejecutar/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: manifiesto-y-dependencias
    title: "Manifiesto y dependencias"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Empaquetar y ejecutar la aplicación

Configura el manifiesto y ejecuta el JAR con sus bibliotecas en los tres sistemas.
## Objetivo y punto de partida

Utiliza la aplicación que carga recursos y usa Gson. El JAR convencional contiene tus clases y recursos, pero no todas las dependencias externas.

## Práctica guiada

Conserva las versiones mediante propiedades configuradas en la lección 12. `dependency:copy-dependencies` utilizará el plugin declarado con `${maven-dependency-plugin.version}`.

Dentro del plugin `maven-jar-plugin` existente añade:

```xml
<configuration>
  <archive>
    <manifest>
      <mainClass>com.codelearn.tareas.Main</mainClass>
    </manifest>
  </archive>
</configuration>
```

```bash
mvn clean package
jar tf target/gestor-tareas-1.0.0-SNAPSHOT.jar
mvn dependency:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/lib
```

En macOS/Linux:

```bash
java -cp "target/gestor-tareas-1.0.0-SNAPSHOT.jar:target/lib/*" com.codelearn.tareas.Main
```

En Windows PowerShell:

```powershell
java -cp "target/gestor-tareas-1.0.0-SNAPSHOT.jar;target/lib/*" com.codelearn.tareas.Main
```

Debe imprimirse un JSON cuyo nombre sea `Gestor de tareas`. Las comillas conservan el classpath como un argumento. Windows separa entradas con `;`; macOS/Linux, con `:`.

## Manifiesto y dependencias

`Main-Class` permite a `java -jar` saber dónde empezar, pero no incorpora Gson. Para este proyecto, ejecutar el JAR convencional con `java -jar` sin configurar bibliotecas puede producir `NoClassDefFoundError`. Para una aplicación sin bibliotecas sería suficiente.

El perfil `distribucion` de la lección 10 permite:

```bash
mvn -Pdistribucion clean package
java -jar target/gestor-tareas-1.0.0-SNAPSHOT-all.jar
```

El JAR `-all` sí incluye las bibliotecas. La ampliación A3 explica con detalle esa decisión de distribución. `java -jar` no toma las entradas de `-cp` como una suma automática de classpaths.

## Comprobación y errores habituales

`no main manifest attribute`: falta configuración de manifiesto o ejecutas otro JAR. `ClassNotFoundException`: revisa la clase principal. `NoClassDefFoundError`: revisa las bibliotecas de ejecución.

## Ejercicio

Copia el JAR convencional y `target/lib/` a otra carpeta y ejecútalos con el classpath ajustado. Repite con el JAR `-all` solamente.

## Qué debes recordar

Compilar, empaquetar y ejecutar son comprobaciones distintas. La entrega debe documentar cómo proporcionar las bibliotecas necesarias.

Referencia: [Manifiesto y classpath](https://maven.apache.org/shared/maven-archiver/examples/classpath.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/15-recursos-configuracion/' | relative_url }}">← 15 · Recursos y configuración de la aplicación</a>
<a href="{{ '/maven/17-maven-wrapper/' | relative_url }}">17 · Crear y utilizar Maven Wrapper →</a>
</nav>
