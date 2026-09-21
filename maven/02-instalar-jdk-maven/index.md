---
layout: lesson
route: maven
lesson_id: principal02
lesson_number: "02"
title: "Instalar JDK 21 y Maven"
description: "Instala y verifica el entorno en Mac, Linux y Windows 10/11."
permalink: /maven/02-instalar-jdk-maven/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: macbook-intel-y-apple-silicon
    title: "Mac: Intel y Apple Silicon"
  - id: ubuntudebian
    title: "Ubuntu/Debian"
  - id: fedora
    title: "Fedora"
  - id: windows-1011-jdk
    title: "Windows 10/11: JDK"
  - id: windows-1011-maven
    title: "Windows 10/11: Maven"
  - id: maven-manual-en-linux
    title: Maven manual en Linux
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Instalar JDK 21 y Maven

Instala y verifica el entorno en Mac, Linux y Windows 10/11.
## Objetivo y punto de partida

Elige únicamente las instrucciones de tu sistema. La ruta utiliza JDK 21 y Maven 3.9.x; las versiones fijadas en los ejemplos son referencias reproducibles, no una afirmación de que sean las últimas. Instala un **JDK**, que incluye `javac`, en lugar de solo un JRE.

## Mac: Intel y Apple Silicon

Con [Homebrew](https://brew.sh/) instalado, ejecuta:

```bash
brew install openjdk@21 maven
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
export PATH="$JAVA_HOME/bin:$PATH"
```

`brew --prefix` evita asumir `/opt/homebrew` (Apple Silicon) o `/usr/local` (Intel). Para conservar la selección, añade las dos líneas `export` anteriores a `~/.zshrc` usando un editor y abre otra terminal. Si utilizas Bash, elige su archivo de inicio correspondiente. No añadas `bin` a `JAVA_HOME`.

Opcionalmente, para que `/usr/libexec/java_home -v 21` reconozca ese JDK, sigue el enlace de registro indicado por [la fórmula oficial de Homebrew](https://formulae.brew.sh/formula/openjdk@21).

## Ubuntu/Debian

En una versión cuyos repositorios proporcionen OpenJDK 21:

```bash
sudo apt update
sudo apt install openjdk-21-jdk maven
sudo update-alternatives --config java
sudo update-alternatives --config javac
export JAVA_HOME="$(dirname "$(dirname "$(readlink -f "$(command -v javac)")")")"
export PATH="$JAVA_HOME/bin:$PATH"
```

Selecciona Java 21 en ambas alternativas. Conserva los `export` en `~/.bashrc` o `~/.zshrc`, según tu shell. Si `openjdk-21-jdk` no existe en tu distribución, instala Temurin 21 siguiendo [las instrucciones oficiales para Linux](https://adoptium.net/installation/linux); no sustituyas 21 por otra versión sin revisar el POM.

## Fedora

Si la versión de Fedora ofrece el paquete:

```bash
sudo dnf install java-21-openjdk-devel maven
sudo alternatives --config java
sudo alternatives --config javac
export JAVA_HOME="$(dirname "$(dirname "$(readlink -f "$(command -v javac)")")")"
export PATH="$JAVA_HOME/bin:$PATH"
```

Si ese paquete no está disponible, configura el repositorio oficial de Adoptium siguiendo el enlace anterior y utiliza `sudo dnf install temurin-21-jdk maven`. Los nombres disponibles dependen de la versión de la distribución.

## Windows 10/11: JDK

En PowerShell con `winget` disponible:

```powershell
winget install --id EclipseAdoptium.Temurin.21.JDK --exact
```

También puedes descargar el instalador JDK 21 desde [Adoptium](https://adoptium.net/installation/), eligiendo la arquitectura del equipo. Si `winget` no existe, utiliza este instalador. Activa sus opciones para configurar `JAVA_HOME` y `PATH` cuando estén disponibles.

## Windows 10/11: Maven

Descarga el ZIP **binario** de Maven 3.9.x desde [Apache Maven](https://maven.apache.org/download.cgi), extráelo y conserva la carpeta en una ubicación estable, por ejemplo `C:\Herramientas\apache-maven-3.9.11`.

En «Editar las variables de entorno de tu cuenta»:

1. Define `JAVA_HOME` con la carpeta real del JDK instalado, por ejemplo `C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot`. Comprueba su nombre en el Explorador.
2. Añade `%JAVA_HOME%\bin` al `Path`.
3. Añade `C:\Herramientas\apache-maven-3.9.11\bin` al `Path`, ajustando la versión extraída.
4. Abre una nueva ventana de PowerShell.

Para ensayar en la sesión actual, ajusta las rutas reales:

```powershell
$env:JAVA_HOME = 'C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot'
$env:Path = "$env:JAVA_HOME\bin;C:\Herramientas\apache-maven-3.9.11\bin;$env:Path"
Get-Command java, javac, mvn
```

Estos cambios de PowerShell solo duran esa sesión. No necesitas definir `MAVEN_HOME` para el uso básico.

## Maven manual en Linux

El gestor de paquetes puede proporcionar Maven 3.8.x u otra versión. Si necesitas la misma base 3.9.11 de la ruta, descarga el archivo binario `apache-maven-3.9.11-bin.tar.gz` desde el archivo oficial de Apache enlazado en [descargas de Maven](https://maven.apache.org/download.cgi) y comprueba su checksum. Extrae el archivo en una carpeta de tu usuario:

```bash
mkdir -p "$HOME/herramientas"
tar -xzf "$HOME/Downloads/apache-maven-3.9.11-bin.tar.gz" -C "$HOME/herramientas"
export PATH="$HOME/herramientas/apache-maven-3.9.11/bin:$PATH"
```

Ajusta `Downloads` a la carpeta donde guardaste el archivo, por ejemplo `Descargas`. Conserva la línea de `PATH` en el archivo de inicio de tu shell y verifica `mvn -version`. Cuando tengas Wrapper, será este quien seleccione Maven para el proyecto.

## Comprobación y errores habituales

En cualquiera de los sistemas:

```text
java -version
javac -version
mvn -version
```

Los dos primeros deben indicar 21. El tercero debe mostrar Maven 3.9.x, Java 21 y la ruta del JDK elegido. Si Maven usa otro Java, revisa `JAVA_HOME`. Si no encuentra el comando, revisa `PATH` y abre una terminal nueva. En macOS/Linux utiliza `command -v java`; en PowerShell, `Get-Command java`.

## Ejercicio

Guarda las tres salidas en tus notas y localiza la ruta de Java utilizada por Maven. Ejecuta la práctica de la lección anterior.

## Qué debes recordar

Tener Java 21 instalado no garantiza que Maven lo esté utilizando. La comprobación decisiva es `mvn -version`.

Referencia adicional para el identificador de winget: [manifiesto oficial de Temurin 21 JDK](https://github.com/microsoft/winget-pkgs/tree/master/manifests/e/EclipseAdoptium/Temurin/21/JDK).

Referencia: [Instalación de Maven](https://maven.apache.org/install).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/01-problema-que-resuelve-maven/' | relative_url }}">← 01 · Qué problema resuelve Maven</a>
<a href="{{ '/maven/03-primer-proyecto/' | relative_url }}">03 · Crear el primer proyecto Maven →</a>
</nav>
