---
layout: lesson
route: maven
lesson_id: principal05
lesson_number: "05"
title: "Ciclos de vida, fases y goals"
description: "Entiende qué ejecutan clean, package y verify y cómo intervienen los plugins."
permalink: /maven/05-ciclos-fases-goals/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Ciclos de vida, fases y goals

Entiende qué ejecutan clean, package y verify y cómo intervienen los plugins.
## Objetivo y punto de partida

Utiliza el proyecto compilable de la lección 04. Una fase representa un paso del proceso; un goal es una tarea concreta de un plugin.

## Práctica guiada

```bash
mvn clean package
```

`clean` pertenece a su propio ciclo y elimina resultados anteriores. `package` pertenece al ciclo `default` y alcanza todas las fases anteriores de ese ciclo. Para un proyecto JAR, los enlaces habituales incluyen `compiler:compile`, `surefire:test` y `jar:jar`.

| Fase del ciclo default | Propósito |
|---|---|
| `validate` | Validar el proyecto |
| `compile` | Compilar código principal |
| `test` | Ejecutar pruebas unitarias configuradas |
| `package` | Crear el artefacto |
| `verify` | Ejecutar comprobaciones vinculadas a esta fase |
| `install` | Instalar artefacto y POM en el repositorio local |
| `deploy` | Publicar en el repositorio remoto configurado |

La tabla resume fases relevantes; existen fases intermedias. Maven también define el ciclo `site` para documentación. `mvn package` no ejecuta `clean` implícitamente.

## Comprobación y errores habituales

```bash
mvn clean verify
```

Busca los nombres de plugins en la salida. `verify` incluye el recorrido hasta empaquetar; no añade automáticamente análisis estático ni pruebas de integración si no están configurados. Ejecutar `mvn compile test package` repite recorridos que normalmente puedes expresar con `mvn package`.

## Práctica integradora: preparar Linux y construir un proyecto Maven

En esta práctica trabajarás con el usuario Linux que te ha proporcionado el centro. El objetivo es demostrar que puedes preparar un entorno Java, cambiar la versión activa y construir el proyecto de la ruta Maven desde el terminal.

Trabajarás con dos versiones del JDK:

- **JDK 21**, que ya está instalado en la máquina y que utiliza el proyecto.
- **JDK 17**, que instalarás como segunda versión para practicar el cambio de entorno.

No elimines JDK 21. El proyecto utiliza Java 21 y debe construirse finalmente con esa versión.

### Fase 1. Identificar el usuario y el entorno

Comprueba que estás utilizando el usuario del aula y guarda la salida de estos comandos:

```bash
whoami
pwd
java -version
javac -version
mvn -version
echo "$JAVA_HOME"
echo "$PATH"
```

En `mvn -version`, localiza la línea que indica la versión y la ruta del Java que está utilizando Maven. El usuario Linux, `java`, `javac` y Maven deben poder identificarse en la entrega.

### Fase 2. Instalar una segunda versión del JDK

En Ubuntu o Debian, instala JDK 17 sin eliminar JDK 21:

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

Comprueba que ambas versiones aparecen registradas:

```bash
update-alternatives --list java
update-alternatives --list javac
```

Si utilizas otra distribución, emplea el gestor de paquetes equivalente y documenta el comando utilizado.

### Fase 3. Seleccionar el JDK activo

Selecciona temporalmente JDK 17 para `java` y `javac`:

```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

Después, configura las variables de entorno de la sesión. Sustituye la ruta por la que exista en tu máquina:

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

Comprueba el cambio:

```bash
java -version
javac -version
mvn -version
echo "$JAVA_HOME"
```

Guarda la salida. Las tres herramientas deben mostrar o utilizar JDK 17.

Ahora vuelve a seleccionar JDK 21 y configura sus variables:

```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

Comprueba de nuevo `java -version`, `javac -version` y `mvn -version`. Para conservar la selección en nuevas sesiones, añade las líneas correctas a `~/.bashrc` y abre un terminal nuevo. No dupliques entradas de `JAVA_HOME` y `PATH` sin comprobar antes el archivo.

### Fase 4. Construir el proyecto

Vuelve al proyecto creado en las lecciones anteriores, es decir, a la carpeta que contiene `pom.xml`:

```bash
cd ~/gestor-tareas
mvn clean verify
```

El comando debe terminar con:

```text
BUILD SUCCESS
```

Comprueba también que Maven ha generado el resultado de construcción:

```bash
find target -maxdepth 2 -type f | sort
```

Identifica el archivo JAR y explica qué fases se han ejecutado al utilizar `verify`.

### Fase 5. Comprobar la relación entre JDK y Maven

Selecciona de nuevo JDK 17 y ejecuta `mvn clean verify`. El proyecto debería fallar porque su POM solicita Java 21 mediante `maven.compiler.release`.

No borres ni cambies el POM para ocultar el error. Guarda el mensaje, vuelve a seleccionar JDK 21 y repite:

```bash
mvn clean verify
```

La segunda ejecución debe terminar correctamente.

### Entrega

Entrega un documento breve que incluya:

1. El nombre del usuario Linux, sin contraseñas.
2. La salida de `java -version`, `javac -version` y `mvn -version` con JDK 17.
3. La salida de las mismas órdenes con JDK 21.
4. El valor utilizado para `JAVA_HOME` en cada caso.
5. La evidencia de `BUILD SUCCESS` con JDK 21.
6. El error obtenido al intentar construir con JDK 17 y una explicación de su causa.
7. El comando utilizado para instalar la segunda versión del JDK.

No incluyas contraseñas, claves privadas, tokens ni el contenido completo de archivos de configuración personales.

### Criterios de evaluación

- Mantiene instalados JDK 17 y JDK 21.
- Puede cambiar la versión activa de `java` y `javac`.
- Configura `JAVA_HOME` y `PATH` de forma coherente.
- Comprueba qué JDK utiliza realmente Maven.
- Construye el proyecto con JDK 21 mediante `mvn clean verify`.
- Explica por qué la construcción falla con JDK 17.
- Presenta evidencias reproducibles y no expone información sensible.

## Qué debes recordar

Las fases ordenan el proceso y los plugins realizan el trabajo. Alcanzar una fase ejecuta las anteriores de su ciclo, con las tareas que tenga configuradas.

Referencia: [Ciclo de vida de Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/04-compilar-target/' | relative_url }}">← 04 · Compilar y entender los archivos generados</a>
<a href="{{ '/maven/06-anadir-dependencia/' | relative_url }}">06 · Añadir y utilizar una dependencia →</a>
</nav>
