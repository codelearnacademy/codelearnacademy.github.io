---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 02-estructura-programa
lesson_number: "02"
title: Estructura de un programa
description: Entiende la estructura base de una clase y del método main en Java.
---

# Estructura de un programa en Java

Un programa Java se escribe como una o varias clases. Una clase agrupa datos y comportamiento relacionado.

## Forma mínima

```java
public class MiPrograma {
    public static void main(String[] args) {
        System.out.println("Programa ejecutado");
    }
}
```

## Desglose

```java
public class MiPrograma {
```

- `public`: indica acceso público.
- `class`: define una clase.
- `MiPrograma`: nombre de la clase.

```java
public static void main(String[] args) {
```

- `main`: método principal.
- `static`: pertenece a la clase, no a un objeto.
- `void`: no devuelve ningún valor.
- `String[] args`: argumentos de entrada desde consola.

```java
System.out.println("Programa ejecutado");
```

- sentencia ejecutable.
- muestra texto en consola.
- `println` añade salto de línea.

## Buenas prácticas

- Cada clase debe tener una responsabilidad clara.
- El nombre de la clase debe empezar en mayúscula.
- La clase pública debe estar en un archivo con el mismo nombre.

## Ejemplo con varios mensajes

```java
public class Saludo {
    public static void main(String[] args) {
        System.out.println("Hola");
        System.out.println("¿Cómo estás?");
        System.out.println("Java funciona");
    }
}
```

## Errores comunes

- Olvidar la llave de cierre `}`.
- Escribir `main` con una firma distinta.
- Guardar el archivo con otro nombre que no coincida con la clase.

<div class="cla-note"><strong>Regla práctica</strong><p>Cuando el programa no arranca, revisa primero si la clase se llama igual que el archivo y si el método `main` está escrito correctamente.</p></div>

## Ejercicio

Crea una clase `Mensaje` que muestre tres frases en consola.

## Práctica guiada del concepto

1. Escribe una clase simple y asegúrate de que el nombre del archivo coincide con el nombre de la clase.
2. Cambia el orden de las llaves y observa el error del compilador.
3. Refleja: ¿por qué es importante que `main` esté exactamente definido como `public static void main(String[] args)`?

### Código que genera error

```java
public class ErrorEstructura {
    public static void main(String[] args) {
        System.out.println("Hola");
    
}
```

El programa fallará por una llave faltante. La corrección es cerrar correctamente el bloque con `}`.

## Después de esta lección

Ahora ya conoces la base de una clase. El siguiente paso es aprender a guardar información real en variables y tipos.
## Ejercicios de práctica · Estructura de un programa

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a organizar clase, `main`, bloques y sentencias. Debes utilizar explícitamente llaves, punto y coma, métodos y convenciones. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Estructura de un programa**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por llaves desequilibradas, `main` incorrecto y nombre de clase. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Estructura de un programa**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en refactorizar un `main` largo en métodos. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Dónde se agrupan las sentencias de un método?

- A) Entre llaves
- B) Entre comillas
- C) En pom.xml
- D) En una tabla

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Las llaves delimitan el bloque.</p>

</details>

### 2. ¿Qué es `main`?

- A) Un método
- B) Una clase obligatoria
- C) Una variable
- D) Un paquete

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> main es el punto de entrada clásico y es un método.</p>

</details>

### 3. ¿Qué suele terminar una sentencia simple en Java?

- A) ;
- B) :
- C) #
- D) @

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El punto y coma termina muchas sentencias.</p>

</details>

### 4. ¿La indentación cambia por sí sola la semántica de los bloques Java?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los bloques se delimitan por llaves, aunque una buena indentación mejora legibilidad.</p>

</details>

## Ejercicios propuestos

1. Corrige una clase con llaves, punto y coma y firma de `main` incorrectos.

