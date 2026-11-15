---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion02"
lesson_file: "02-path-y-files"
lesson_number: "2"
title: "Path y Files"
description: "Path y Files: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion02/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: relacion-con-el-resto-de-la-ruta
    title: "Relación con el resto de la ruta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: pizarra-diagnostico
    title: "¿Desde qué carpeta busca Java?"
  - id: diagnostico-de-una-ruta-de-fichero
    title: "Diagnóstico de una ruta de fichero"
  - id: microproyecto-localizar-el-fichero
    title: "Microproyecto · Localizar el fichero"
---

# Path y Files

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Construir rutas portables con `Path`.
- Comprobar, crear y resolver rutas usando `Files`.

## Punto de partida
{: #punto-de-partida }

Las rutas absolutas hacen que un ejemplo funcione en un equipo y falle en otro.

<div class="cla-note"><strong>Rutas portables</strong><p>Construye rutas con <code>Path</code> y evita concatenar separadores del sistema manualmente.</p></div>

## Conceptos clave
{: #conceptos-clave }

- `Path.of(...)` representa una ruta sin abrir el fichero.
- `resolve(...)` compone rutas sin concatenar separadores manualmente.
- `Files.exists`, `createDirectories` y `isRegularFile` permiten validar el entorno.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/02.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/02.webp' | relative_url }}" alt="Directorio de trabajo → ruta absoluta. Resuelve datos/entrada.txt respecto a la carpeta desde la que se ejecuta Java. Distingue fichero regular, directorio y ruta ausente antes de leer." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo guiado
{: #ejemplo-guiado }

```java
Path data = Path.of("data");
Files.createDirectories(data);
Path csv = data.resolve("productos.csv");
System.out.println(csv.toAbsolutePath());
```

## Relación con el resto de la ruta
{: #relacion-con-el-resto-de-la-ruta }

Todas las lecciones posteriores reciben o construyen rutas con `Path`; así los ejemplos de formatos no dependen del sistema operativo.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Crea `data/entrada` y `data/salida` con `Files.createDirectories`.
2. Resuelve dentro de ellas las rutas de un CSV de entrada y un JSON de salida.

## Qué debes recordar
{: #que-debes-recordar }

- No concatenes rutas con `"/"` o `"\"`.
- `Path` describe; `Files` actúa sobre el sistema de ficheros.


## ¿Desde qué carpeta busca Java?
{: #pizarra-diagnostico }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/ruta-fichero.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/ruta-fichero.webp' | relative_url }}" alt="¿Desde qué carpeta busca Java?. datos/catalogo.csv. Directorio de trabajo. Imprime la base absoluta desde la que se está ejecutando Java. Ruta resuelta. Combina la base y la ruta recibida. Normaliza y muestra el resultado. Lectura. Comprueba qué hay en esa ruta e intenta abrir el fichero. Un fallo de acceso requiere su propio diagnóstico. Desde la raíz. /aula/datos/catalogo.csv apunta al fichero. Desde datos/. /aula/datos/datos/catalogo.csv no existe. Usa catalogo.csv desde esa carpeta." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Crea `datos/catalogo.csv` y ejecuta el diagnóstico desde la raíz del proyecto y desde `datos/`. Registra la base, la ruta resultante y el estado. Repite pasando una carpeta como entrada.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/ruta-fichero.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>

## Diagnóstico de una ruta de fichero
{: #diagnostico-de-una-ruta-de-fichero }

El IDE y la terminal pueden iniciar el programa desde directorios distintos. Imprime el directorio de trabajo y la ruta absoluta que Java intenta abrir. Para probar este ejemplo desde la terminal, crea la carpeta `datos/` y guarda una nota en `datos/nota.txt`. Repite la ejecución cambiando el directorio de trabajo.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Diagnostico {
    public static void main(String[] args) {
        Path base = Path.of("").toAbsolutePath();
        Path entrada = Path.of(args.length == 0 ? "datos/nota.txt" : args[0]);
        Path fichero = base.resolve(entrada).normalize();

        System.out.println("Directorio de trabajo: " + base);
        System.out.println("Ruta recibida: " + entrada);
        System.out.println("Ruta comprobada: " + fichero);
        try {
            BasicFileAttributes atributos = Files.readAttributes(fichero, BasicFileAttributes.class);
            if (atributos.isRegularFile()) {
                System.out.println("FICHERO");
            } else if (atributos.isDirectory()) {
                System.out.println("CARPETA");
            } else {
                System.out.println("OTRO");
            }
        } catch (NoSuchFileException error) {
            System.out.println("AUSENTE");
        } catch (IOException error) {
            System.err.println("No se pudo comprobar la ruta: " + error.getMessage());
        }
    }
}
```

Con `datos/nota.txt` presente se espera `FICHERO`. Si pasas `datos` como argumento, se espera `CARPETA`. Prueba también con un nombre que no existe. Comprobar los atributos y abrir el fichero son operaciones distintas. Gestiona también `IOException` durante la lectura.


## Microproyecto · Localizar el fichero
{: #microproyecto-localizar-el-fichero }

Resuelve la ruta recibida respecto a la carpeta base y normalízala. Devuelve FICHERO, CARPETA, AUSENTE u OTRO según su tipo. Propaga IOException cuando no puedas comprobar los atributos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F02-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F02-tarea-01.webp' | relative_url }}" alt="Localizar el fichero. Resultado esperado: FICHERO · CARPETA · AUSENTE" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** FICHERO · CARPETA · AUSENTE.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion02/F02-tarea-01.zip' | relative_url }}">Descargar F02-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion01/' | relative_url }}">← 1 · Introducción a ficheros en Java 21</a>
  <a href="{{ '/ficheros/leccion03/' | relative_url }}">3 · Lectura y escritura de texto →</a>
</div>
