---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: Estructuras de control
search_title: Lección 03 - Estructuras de control
search_description: Practicarás estructuras condicionales y repetitivas para controlar el flujo de ejecución.
description: Controlarás el flujo de ejecución y depurarás programas Java.
lessons:
  - id: sublecciones
    title: Sublecciones
  - id: practica-guiada
    title: Práctica guiada
  - id: condiciones
    title: Condiciones
  - id: bucles
    title: Bucles
  - id: excepciones-y-depuracion
    title: Excepciones y depuración
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion03/
---

## Objetivo

Controlarás el flujo de ejecución y depurarás programas Java.

## Sublecciones
{: #sublecciones }

<div class="cla-content-map">
  <a href="{{ '/java/leccion03/21-seleccion-con-if-y-switch/' | relative_url }}"><span aria-hidden="true">01</span><strong>Selección con if y switch</strong></a>
  <a href="{{ '/java/leccion03/22-bucles-y-acumuladores/' | relative_url }}"><span aria-hidden="true">02</span><strong>Bucles y acumuladores</strong></a>
  <a href="{{ '/java/leccion03/23-recorrer-un-array/' | relative_url }}"><span aria-hidden="true">03</span><strong>Recorrer un array</strong></a>
  <a href="{{ '/java/leccion03/24-sentencias-break-y-continue/' | relative_url }}"><span aria-hidden="true">04</span><strong>Sentencias break y continue</strong></a>
  <a href="{{ '/java/leccion03/25-validar-entradas-y-capturar-excepciones/' | relative_url }}"><span aria-hidden="true">05</span><strong>Validar entradas y capturar excepciones</strong></a>
  <a href="{{ '/java/leccion03/26-crear-una-excepcion-propia/' | relative_url }}"><span aria-hidden="true">06</span><strong>Crear una excepción propia</strong></a>
  <a href="{{ '/java/leccion03/27-depurar-con-puntos-de-interrupcion/' | relative_url }}"><span aria-hidden="true">07</span><strong>Depurar con puntos de interrupción</strong></a>
  <a href="{{ '/java/leccion03/28-verificar-invariantes-con-assert/' | relative_url }}"><span aria-hidden="true">08</span><strong>Verificar invariantes con assert</strong></a>
  <a href="#practica-guiada"><span aria-hidden="true">→</span><strong>Práctica guiada</strong></a>
</div>

## Práctica guiada · Validación y depuración
{: #practica-guiada }

**Práctica obligatoria.** Utiliza los demás ejercicios como refuerzo o ampliación.



<a href="{{ '/java/proyectos/inventario/Depuracion.java' | relative_url }}">Descargar Depuracion.java</a>


1. **Punto de partida.** Reutiliza la entrada y salida de la lección 02. Para practicar el depurador, sustituye la multiplicación por un bucle desde i = 1 con condición i < cantidad.
2. **Pasos.** Ejecuta con 3 unidades, coloca un breakpoint y registra i y total. Corrige el límite. Define CantidadInvalidaException y reintenta tras capturar una cantidad negativa. Verifica una invariante interna con assert y -ea.
3. **Resultado esperado.** El fallo original produce 5,00 €; el código corregido produce 7,50 €.
4. **Caso de fallo.** Prueba texto inválido, negativo y cero. Introduce temporalmente un total incoherente para comprobar la aserción y restaura el código.

**Evidencia de entrega.** Traza del depurador, excepción propia, comandos con -ea y casos antes y después.

### Rúbrica de la práctica

| Indicador | Puntos |
|---|---:|
| Registra índice y acumulador con el depurador. | 1 |
| Reproduce el fallo y verifica el resultado tras corregirlo. | 1 |
| Demuestra excepción propia y aserción habilitada. | 1 |

Cada indicador vale 1 si la evidencia es suficiente, 0,5 si es parcial y 0 si falta.


## Condiciones

Las estructuras `if`, `else` y `switch` permiten seleccionar un camino según el estado del programa.

```java
int nota = 7;
String resultado = nota >= 5 ? "Aprobado" : "Pendiente";
System.out.println(resultado);

String día = "sábado";
switch (día) {
  case "sábado", "domingo" -> System.out.println("Descanso");
  default -> System.out.println("Clase");
}
```

### Ejercicios de práctica · Condiciones

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a resolver decisiones complejas. Debes utilizar explícitamente condiciones compuestas, orden de reglas y guard clauses. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Condiciones**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por solapamientos y casos frontera. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Condiciones**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en un sistema de acceso o tarifas. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Bucles

Usa `for` cuando conoces el recorrido, `while` cuando depende de una condición y `do-while` cuando debe ejecutarse al menos una vez.

```java
int suma = 0;
for (int número = 1; número <= 5; número++) {
  suma += número;
}
System.out.println(suma);

int intentos = 0;
while (intentos < 3) {
  System.out.println("Intento " + (++intentos));
}
```

`break` termina el bucle y `continue` salta a la siguiente iteración. Úsalos con una condición evidente para no ocultar el flujo.

### Ejercicios de práctica · Bucles

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a controlar repeticiones más complejas. Debes utilizar explícitamente bucles anidados, `break`, `continue` y contadores. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Bucles**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por bucles infinitos y condiciones de salida. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Bucles**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en matrices, búsqueda o juegos de intentos. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Excepciones y depuración


Las excepciones representan situaciones que interrumpen el flujo normal. Captura el problema donde puedas actuar y conserva información útil.

```java
try {
  int valor = Integer.parseInt("abc");
  System.out.println(valor);
} catch (NumberFormatException error) {
  System.out.println("El valor no es un entero");
}
```

Durante la depuración, reproduce el fallo, coloca un punto de ruptura, inspecciona variables y confirma la corrección con una nueva prueba. Una aserción documenta una condición que debería cumplirse durante el desarrollo:

```java
assert saldo >= 0 : "El saldo no puede ser negativo";
```

### Ejercicios de práctica · Excepciones y depuración

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a detectar, tratar y localizar errores. Debes utilizar explícitamente `try/catch/finally`, stack trace, breakpoint, step into/over. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Excepciones y depuración**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por excepciones no controladas y bugs lógicos. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Excepciones y depuración**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en una entrada robusta y una sesión de depuración. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Ejercicios


1. Clasifica un número como positivo, negativo o cero.
2. Calcula la suma y la media de los números introducidos.
3. Imprime una tabla de multiplicar usando un bucle.
4. Solicita números hasta recibir cero y controla entradas no numéricas.
5. Implementa factorial iterativo y recursivo.
6. Introduce un error de índice, depúralo y documenta la causa.

## Refuerzo práctico

### Ejemplo guiado

Lee un entero con `Integer.parseInt(scanner.nextLine())`, captura el error y repite hasta recibir un valor válido.

### Ejercicio propuesto

Implementa división segura, entrada numérica robusta y documenta un bug localizado con el depurador.

## Tarea para casa

Construye un programa de entrada robusta que repita preguntas hasta recibir datos válidos y documenta al menos un error localizado con el depurador.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. Con cantidad = 3, ¿cuántas veces se ejecuta for (int i = 1; i < cantidad; i++)?

- A) Tres veces, con i = 1, i = 2 e i = 3
- B) Tres veces, con i = 0, i = 1 e i = 2
- C) Dos veces, con i = 1 e i = 2
- D) Una vez, con i = 1

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Al llegar a i = 3 la condición se vuelve falsa y el cuerpo no vuelve a ejecutarse.</p>

</details>

### 2. ¿Qué bloque puede ejecutarse tanto si hay excepción como si no?

- A) case
- B) switch
- C) class
- D) finally

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> finally se usa para acciones finales, aunque existen matices si el proceso termina abruptamente.</p>

</details>

### 3. ¿Qué información útil suele aportar un stack trace?

- A) El contenido de la base de datos
- B) Cadena de llamadas y líneas relacionadas con el error
- C) Solo la versión de Java
- D) La lista de dependencias

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Permite seguir dónde se originó y propagó la excepción.</p>

</details>

### 4. ¿Qué hace un breakpoint?

- A) Pausa la ejecución en un punto para inspeccionar estado
- B) Crea una excepción
- C) Borra una línea
- D) Compila más rápido

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los breakpoints permiten depuración interactiva.</p>

</details>

### 5. ¿Qué diferencia hay entre step into y step over?

- A) No hay diferencia
- B) Over finaliza el programa
- C) Into entra en llamadas; over ejecuta la llamada sin recorrerla internamente
- D) Into compila

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Son dos controles básicos del depurador.</p>

</details>

## Ejercicios propuestos

1. Crea una lectura de entero que repita la pregunta hasta recibir un valor válido.
2. Depura un bucle con un error lógico usando breakpoint y documenta el valor que causa el fallo.
3. Provoca una excepción, interpreta su stack trace y localiza la primera línea de tu código implicada.

## Ejercicios de repaso de la lección

Realiza estos retos después de completar los ejercicios de práctica. Cada concepto de la lección dispone de cinco ejercicios de repaso más autónomos.

### Condiciones

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible resolver decisiones complejas. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Condiciones** a un contexto distinto del explicado en clase, por ejemplo un sistema de acceso o tarifas. Usa condiciones compuestas, orden de reglas y guard clauses y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Condiciones** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con solapamientos y casos frontera. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Condiciones**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Bucles

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible controlar repeticiones más complejas. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Bucles** a un contexto distinto del explicado en clase, por ejemplo matrices, búsqueda o juegos de intentos. Usa bucles anidados, `break`, `continue` y contadores y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Bucles** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con bucles infinitos y condiciones de salida. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Bucles**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Excepciones y depuración

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible detectar, tratar y localizar errores. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Excepciones y depuración** a un contexto distinto del explicado en clase, por ejemplo una entrada robusta y una sesión de depuración. Usa `try/catch/finally`, stack trace, breakpoint, step into/over y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Excepciones y depuración** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con excepciones no controladas y bugs lógicos. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Excepciones y depuración**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Actividades principales de la lección

### Actividad 1 · Entrada numérica segura

**Modalidad:** clase · **Tiempo orientativo:** 30–40 minutos

**Objetivo:** utilizar excepciones para recuperar el programa ante una entrada incorrecta.

Crea un programa que pida una edad y continúe preguntando hasta recibir un entero válido entre 0 y 130. Usa `try/catch` para controlar entradas no numéricas.

**Comprobación:** prueba texto, números negativos, un valor superior a 130 y una edad válida.

### Actividad 2 · Encuentra el bug con el depurador

**Modalidad:** clase · **Tiempo orientativo:** 35–45 minutos

**Objetivo:** usar breakpoints e inspección de variables para localizar un error lógico.

Parte de un programa con un bucle que debería sumar del 1 al 10 pero produce un resultado incorrecto. Coloca un breakpoint, recorre las iteraciones y registra cómo cambian el contador y el acumulador hasta descubrir el fallo.

**Comprobación:** explica por escrito cuál era el error, en qué iteración se hace visible y cómo lo corregiste.

### Actividad 3 · Menú resistente a errores

**Modalidad:** casa · **Tiempo orientativo:** 60–75 minutos

**Objetivo:** crear una aplicación que no termine inesperadamente ante entradas inválidas.

Diseña un menú con al menos tres operaciones. Debe controlar opciones inexistentes, datos no numéricos y operaciones no permitidas. Los mensajes de error deben explicar qué ocurrió y cómo continuar.

**Entrega:** código, `README.md` y cinco pruebas, incluyendo al menos tres entradas erróneas.

<div class="cla-lesson-nav"><a href="/java/leccion02/">← 02 · Fundamentos de Java</a><a href="/java/leccion04/">04 · Organización de clases →</a></div>
