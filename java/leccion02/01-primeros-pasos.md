---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 01-primeros-pasos
lesson_number: "01"
title: Primeros pasos con Java
description: Compila y ejecuta tu primer programa Java desde el terminal.
---

# Primeros pasos con Java

Antes de escribir una aplicación compleja, conviene dominar el ciclo mínimo de trabajo: crear archivo, compilar y ejecutar.

## El ciclo básico

1. Escribes un archivo con extensión `.java`.
2. Lo compilas con `javac`.
3. Ejecutas el resultado con `java`.

```bash
javac Main.java
java Main
```

## Primer programa

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola, Java 21");
    }
}
```

## Qué significa cada parte

- `public class Main`: define una clase pública llamada `Main`.
- `public static void main(String[] args)`: punto de entrada de la aplicación.
- `System.out.println(...)`: escribe un mensaje por consola.

## Regla importante

El nombre del archivo debe coincidir con el nombre de la clase pública. Si la clase se llama `Main`, el archivo debe llamarse `Main.java`.

## Ejercicio rápido

Crea un archivo llamado `Saludo.java` con este contenido:

```java
public class Saludo {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Java");
    }
}
```

Compílalo y ejecútalo:

```bash
javac Saludo.java
java Saludo
```

<div class="cla-note"><strong>Idea clave</strong><p>Cuando ves un programa Java, siempre debe existir una clase, y normalmente esa clase contiene un método `main` que inicia la ejecución.</p></div>

## Para recordar

- `.java` = código fuente.
- `.class` = bytecode compilado.
- `java` = ejecuta la aplicación.

Siguiente paso: aprender la estructura general de un programa Java y no solo copiar líneas sueltas.

## Práctica guiada del concepto

1. Crea un archivo `HolaJava.java` y ejecuta el programa desde el terminal.
2. Cambia el texto del mensaje y verifica que cambia la salida.
3. Responde: ¿Qué ocurre si eliminas la palabra `static` del método `main`?

### Código que genera error

```java
public class HolaJava {
    public void main(String[] args) {
        System.out.println("Esto falla");
    }
}
```

¿Qué ocurre al compilar? El método `main` ya no tiene la firma correcta para que Java lo identifique como punto de entrada. Lo correcto es `public static void main(String[] args)`.

## Después de esta lección

Tras completar este apartado, ya puedes pasar a la estructura del programa y entender cómo encaja el método `main` dentro de una clase.
## Ejercicios de práctica · Primeros pasos con Java

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a compilar y ejecutar desde terminal. Debes utilizar explícitamente `javac`, `java`, archivos `.java` y `.class`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Primeros pasos con Java**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por errores de sintaxis y cambios sin recompilar. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Primeros pasos con Java**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en una pequeña aplicación con dos clases. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Cuál es un ciclo de trabajo básico al programar?

- A) Editar → compilar → ejecutar → corregir
- B) Ejecutar → comprar → borrar
- C) Diseñar → nunca probar
- D) Solo escribir código

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La programación es iterativa.</p>

</details>

### 2. ¿Qué distingue un error de sintaxis?

- A) Impide que el código sea válido para el compilador
- B) Siempre ocurre tras horas de ejecución
- C) Es un error SQL
- D) Solo afecta al estilo

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los errores sintácticos se detectan al analizar/compilar el código.</p>

</details>

### 3. ¿Qué conviene hacer tras un cambio pequeño?

- A) Compilar/probar de nuevo
- B) Esperar al proyecto final
- C) Borrar target
- D) Cambiar de JDK siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los ciclos cortos facilitan localizar errores.</p>

</details>

## Ejercicios propuestos

1. Crea un programa mínimo, introduce dos errores de sintaxis diferentes y documenta el mensaje del compilador.

