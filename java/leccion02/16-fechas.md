---
layout: lesson
route: java
lesson_id: leccion16
lesson_file: 16-fechas-horas
lesson_number: "16"
title: Fechas y horas en Java
description: Aprende a crear, comparar, formatear y calcular diferencias entre fechas y horas utilizando la API java.time de Java 21.
---

# Fechas y horas en Java

Java 21 proporciona la API `java.time` para trabajar con fechas, horas, periodos, duraciones y zonas horarias.

Las clases más utilizadas son:

| Clase | Uso principal |
| --- | --- |
| `LocalDate` | Una fecha sin hora ni zona horaria |
| `LocalTime` | Una hora sin fecha ni zona horaria |
| `LocalDateTime` | Fecha y hora sin zona horaria |
| `ZonedDateTime` | Fecha y hora con zona horaria |
| `Instant` | Un instante concreto en la línea temporal |
| `Period` | Diferencia basada en años, meses y días |
| `Duration` | Diferencia basada en horas, minutos, segundos y nanosegundos |
| `DateTimeFormatter` | Formatear y convertir fechas y horas |
| `ChronoUnit` | Calcular diferencias en unidades concretas |
| `ZoneId` | Representar una zona horaria |

La mayoría de estas clases pertenecen al paquete:

```java
java.time
```

Por ejemplo:

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate hoy = LocalDate.now();

        System.out.println(hoy);
    }
}
```

La salida tendrá el formato ISO:

```text
2026-09-11
```

El valor concreto dependerá del día en el que se ejecute el programa.

<div class="cla-note"><strong>Idea clave</strong><p>La API moderna de fechas y horas de Java se encuentra principalmente en <code>java.time</code>. Para código nuevo, estas clases son preferibles a las antiguas <code>Date</code> y <code>Calendar</code>.</p></div>

## Características de `java.time`

Las clases principales de `java.time` presentan varias características importantes:

- Son fáciles de leer y utilizar.
- Son **inmutables**.
- Sus operaciones devuelven nuevos objetos.
- Permiten trabajar con fechas sin hora, horas sin fecha o combinaciones de ambas.
- Permiten trabajar con zonas horarias.
- Incluyen herramientas para calcular diferencias.
- Permiten convertir texto a fechas y fechas a texto.

Por ejemplo:

```java
LocalDate fecha = LocalDate.of(2026, 9, 11);

LocalDate nuevaFecha = fecha.plusDays(10);

System.out.println(fecha);
System.out.println(nuevaFecha);
```

Salida:

```text
2026-09-11
2026-09-21
```

La fecha original no cambia.

## `LocalDate`

`LocalDate` representa una fecha formada por:

```text
año
mes
día
```

No contiene:

- Hora.
- Minutos.
- Segundos.
- Zona horaria.

Ejemplo:

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate fecha =
            LocalDate.of(2026, 9, 11);

        System.out.println(fecha);
    }
}
```

Salida:

```text
2026-09-11
```

### Fecha actual: `LocalDate.now()`

Para obtener la fecha actual:

```java
LocalDate hoy =
    LocalDate.now();

System.out.println(hoy);
```

El resultado dependerá de la fecha del sistema.

### Crear una fecha con `of()`

Podemos indicar:

```text
año
mes
día
```

Ejemplo:

```java
LocalDate fecha =
    LocalDate.of(2025, 12, 25);

System.out.println(fecha);
```

Salida:

```text
2025-12-25
```

También podemos utilizar `Month`:

```java
import java.time.LocalDate;
import java.time.Month;

LocalDate fecha =
    LocalDate.of(
        2025,
        Month.DECEMBER,
        25
    );
```

### Obtener partes de una fecha

Podemos consultar:

```java
getYear()
getMonth()
getMonthValue()
getDayOfMonth()
getDayOfYear()
getDayOfWeek()
```

Ejemplo:

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

System.out.println(
    "Año: " + fecha.getYear()
);

System.out.println(
    "Mes: " + fecha.getMonth()
);

System.out.println(
    "Número de mes: "
    + fecha.getMonthValue()
);

System.out.println(
    "Día del mes: "
    + fecha.getDayOfMonth()
);

System.out.println(
    "Día del año: "
    + fecha.getDayOfYear()
);

System.out.println(
    "Día de la semana: "
    + fecha.getDayOfWeek()
);
```

### Sumar días

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

LocalDate resultado =
    fecha.plusDays(10);

System.out.println(resultado);
```

Salida:

```text
2026-09-21
```

### Restar días

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

LocalDate resultado =
    fecha.minusDays(10);

System.out.println(resultado);
```

Salida:

```text
2026-09-01
```

### Sumar semanas

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

LocalDate resultado =
    fecha.plusWeeks(2);

System.out.println(resultado);
```

Salida:

```text
2026-09-25
```

### Sumar meses

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

LocalDate resultado =
    fecha.plusMonths(3);

System.out.println(resultado);
```

Salida:

```text
2026-12-11
```

### Sumar años

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

LocalDate resultado =
    fecha.plusYears(5);

System.out.println(resultado);
```

Salida:

```text
2031-09-11
```

### Restar meses y años

```java
LocalDate fecha =
    LocalDate.of(2026, 9, 11);

System.out.println(
    fecha.minusMonths(2)
);

System.out.println(
    fecha.minusYears(1)
);
```

Salida:

```text
2026-07-11
2025-09-11
```

### Comparar fechas

Podemos utilizar:

```java
isBefore()
isAfter()
isEqual()
```

Ejemplo:

```java
LocalDate fecha1 =
    LocalDate.of(2026, 1, 1);

LocalDate fecha2 =
    LocalDate.of(2026, 12, 31);

System.out.println(
    fecha1.isBefore(fecha2)
);

System.out.println(
    fecha1.isAfter(fecha2)
);

System.out.println(
    fecha1.isEqual(fecha2)
);
```

Salida:

```text
true
false
false
```

### Comprobar si una fecha es hoy

```java
LocalDate hoy =
    LocalDate.now();

LocalDate fecha =
    LocalDate.now();

if (fecha.isEqual(hoy)) {
    System.out.println(
        "La fecha es hoy"
    );
}
```

### Comparar con `equals()`

También podemos utilizar:

```java
fecha1.equals(fecha2)
```

Ejemplo:

```java
LocalDate a =
    LocalDate.of(2026, 9, 11);

LocalDate b =
    LocalDate.of(2026, 9, 11);

System.out.println(
    a.equals(b)
);
```

Salida:

```text
true
```

## Años bisiestos

`LocalDate` permite comprobar si un año es bisiesto.

```java
LocalDate fecha =
    LocalDate.of(2024, 1, 1);

System.out.println(
    fecha.isLeapYear()
);
```

Salida:

```text
true
```

También podemos utilizar:

```java
java.time.Year.isLeap(2024)
```

Ejemplo:

```java
import java.time.Year;

System.out.println(
    Year.isLeap(2024)
);

System.out.println(
    Year.isLeap(2025)
);
```

Salida:

```text
true
false
```

## Número de días del mes

Podemos utilizar:

```java
lengthOfMonth()
```

Ejemplo:

```java
LocalDate fecha =
    LocalDate.of(2024, 2, 1);

System.out.println(
    fecha.lengthOfMonth()
);
```

Salida:

```text
29
```

Para:

```java
LocalDate fecha =
    LocalDate.of(2025, 2, 1);
```

obtendríamos:

```text
28
```

## Número de días del año

```java
LocalDate fecha =
    LocalDate.of(2024, 1, 1);

System.out.println(
    fecha.lengthOfYear()
);
```

Salida:

```text
366
```

## `LocalTime`

`LocalTime` representa una hora sin fecha y sin zona horaria.

Puede contener:

```text
hora
minuto
segundo
nanosegundo
```

Ejemplo:

```java
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime hora =
            LocalTime.of(14, 30);

        System.out.println(hora);
    }
}
```

Salida:

```text
14:30
```

### Hora actual

```java
LocalTime ahora =
    LocalTime.now();

System.out.println(ahora);
```

El resultado depende de la hora del sistema.

### Crear una hora

```java
LocalTime hora =
    LocalTime.of(18, 45);

System.out.println(hora);
```

Salida:

```text
18:45
```

Con segundos:

```java
LocalTime hora =
    LocalTime.of(
        18,
        45,
        30
    );
```

Salida:

```text
18:45:30
```

### Obtener componentes

```java
LocalTime hora =
    LocalTime.of(
        18,
        45,
        30
    );

System.out.println(
    hora.getHour()
);

System.out.println(
    hora.getMinute()
);

System.out.println(
    hora.getSecond()
);
```

Salida:

```text
18
45
30
```

### Sumar horas

```java
LocalTime hora =
    LocalTime.of(10, 30);

LocalTime resultado =
    hora.plusHours(3);

System.out.println(resultado);
```

Salida:

```text
13:30
```

### Sumar minutos

```java
LocalTime hora =
    LocalTime.of(10, 30);

System.out.println(
    hora.plusMinutes(45)
);
```

Salida:

```text
11:15
```

### Restar horas

```java
LocalTime hora =
    LocalTime.of(10, 30);

System.out.println(
    hora.minusHours(2)
);
```

Salida:

```text
08:30
```

### Comparar horas

```java
LocalTime inicio =
    LocalTime.of(9, 0);

LocalTime fin =
    LocalTime.of(17, 0);

System.out.println(
    inicio.isBefore(fin)
);

System.out.println(
    fin.isAfter(inicio)
);
```

Salida:

```text
true
true
```

## `LocalDateTime`

`LocalDateTime` combina una fecha y una hora.

Por ejemplo:

```java
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        LocalDateTime fechaHora =
            LocalDateTime.of(
                2026,
                9,
                11,
                18,
                30
            );

        System.out.println(fechaHora);
    }
}
```

Salida:

```text
2026-09-11T18:30
```

La letra:

```text
T
```

separa la fecha de la hora en el formato ISO.

### Fecha y hora actuales

```java
LocalDateTime ahora =
    LocalDateTime.now();

System.out.println(ahora);
```

### Crear un `LocalDateTime`

```java
LocalDateTime fechaHora =
    LocalDateTime.of(
        2026,
        12,
        31,
        23,
        59,
        30
    );
```

### Combinar `LocalDate` y `LocalTime`

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

LocalTime hora =
    LocalTime.of(
        18,
        30
    );

LocalDateTime fechaHora =
    LocalDateTime.of(
        fecha,
        hora
    );

System.out.println(fechaHora);
```

Salida:

```text
2026-09-11T18:30
```

También podemos hacer:

```java
LocalDateTime fechaHora =
    fecha.atTime(hora);
```

### Obtener la fecha y la hora por separado

```java
LocalDateTime fechaHora =
    LocalDateTime.of(
        2026,
        9,
        11,
        18,
        30
    );

LocalDate fecha =
    fechaHora.toLocalDate();

LocalTime hora =
    fechaHora.toLocalTime();
```

### Sumar tiempo

```java
LocalDateTime fechaHora =
    LocalDateTime.of(
        2026,
        9,
        11,
        18,
        30
    );

System.out.println(
    fechaHora.plusDays(1)
);

System.out.println(
    fechaHora.plusHours(5)
);

System.out.println(
    fechaHora.plusMinutes(30)
);
```

## Formatear fechas

Por defecto:

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

System.out.println(fecha);
```

produce:

```text
2026-09-11
```

Podemos cambiar el formato utilizando:

```java
DateTimeFormatter
```

Importamos:

```java
import java.time.format.DateTimeFormatter;
```

### Formato `dd/MM/yyyy`

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

DateTimeFormatter formato =
    DateTimeFormatter.ofPattern(
        "dd/MM/yyyy"
    );

String resultado =
    fecha.format(formato);

System.out.println(resultado);
```

Salida:

```text
11/09/2026
```

### Patrones frecuentes

| Patrón | Significado | Ejemplo |
| --- | --- | --- |
| `dd` | Día con dos cifras | `01`, `25` |
| `MM` | Mes con dos cifras | `01`, `12` |
| `yyyy` | Año | `2026` |
| `HH` | Hora de 00 a 23 | `18` |
| `hh` | Hora de 01 a 12 | `06` |
| `mm` | Minutos | `45` |
| `ss` | Segundos | `30` |
| `EEEE` | Nombre del día | `viernes` |
| `MMMM` | Nombre del mes | `septiembre` |

<div class="cla-note"><strong>Atención</strong><p><code>MM</code> representa el mes, mientras que <code>mm</code> representa los minutos. Son distintos.</p></div>

## Formatear fecha y hora

```java
LocalDateTime fechaHora =
    LocalDateTime.of(
        2026,
        9,
        11,
        18,
        30,
        15
    );

DateTimeFormatter formato =
    DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss"
    );

System.out.println(
    fechaHora.format(formato)
);
```

Salida:

```text
11/09/2026 18:30:15
```

## Mostrar nombre del mes y día

Para obtener nombres localizados podemos utilizar un `Locale`.

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        LocalDate fecha =
            LocalDate.of(
                2026,
                9,
                11
            );

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern(
                "EEEE, d 'de' MMMM 'de' yyyy",
                new Locale("es", "ES")
            );

        System.out.println(
            fecha.format(formato)
        );
    }
}
```

La salida tendrá una forma similar a:

```text
viernes, 11 de septiembre de 2026
```

## Convertir texto en fecha: `parse()`

Podemos convertir texto ISO directamente:

```java
String texto =
    "2026-09-11";

LocalDate fecha =
    LocalDate.parse(texto);

System.out.println(fecha);
```

Salida:

```text
2026-09-11
```

### Convertir una fecha con formato personalizado

Para:

```text
11/09/2026
```

necesitamos un `DateTimeFormatter`.

```java
String texto =
    "11/09/2026";

DateTimeFormatter formato =
    DateTimeFormatter.ofPattern(
        "dd/MM/yyyy"
    );

LocalDate fecha =
    LocalDate.parse(
        texto,
        formato
    );

System.out.println(fecha);
```

Salida:

```text
2026-09-11
```

## Convertir texto en hora

```java
String texto =
    "18:30";

LocalTime hora =
    LocalTime.parse(texto);

System.out.println(hora);
```

Salida:

```text
18:30
```

Con un formato personalizado:

```java
String texto =
    "18:30:45";

DateTimeFormatter formato =
    DateTimeFormatter.ofPattern(
        "HH:mm:ss"
    );

LocalTime hora =
    LocalTime.parse(
        texto,
        formato
    );
```

## Errores al convertir fechas

Si intentamos:

```java
LocalDate fecha =
    LocalDate.parse(
        "2026-99-99"
    );
```

Java lanza:

```text
DateTimeParseException
```

Podemos tratarla:

```java
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {

        try {

            LocalDate fecha =
                LocalDate.parse(
                    "2026-99-99"
                );

            System.out.println(fecha);

        } catch (DateTimeParseException e) {

            System.out.println(
                "La fecha no es válida"
            );
        }
    }
}
```

<div class="cla-note"><strong>Idea clave</strong><p>Una expresión regular puede comprobar el formato de una fecha, pero <code>LocalDate.parse()</code> puede comprobar además si la fecha representa realmente una fecha válida.</p></div>

## Diferencia entre dos fechas con `Period`

`Period` representa una cantidad de tiempo basada en:

```text
años
meses
días
```

Ejemplo:

```java
import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args) {

        LocalDate inicio =
            LocalDate.of(
                2020,
                1,
                15
            );

        LocalDate fin =
            LocalDate.of(
                2026,
                9,
                11
            );

        Period periodo =
            Period.between(
                inicio,
                fin
            );

        System.out.println(
            "Años: "
            + periodo.getYears()
        );

        System.out.println(
            "Meses: "
            + periodo.getMonths()
        );

        System.out.println(
            "Días: "
            + periodo.getDays()
        );
    }
}
```

El resultado se expresa en componentes:

```text
años
meses
días
```

`Period` no devuelve automáticamente un total absoluto de días.

### Calcular una edad

Uno de los usos más habituales de `Period` es calcular años cumplidos.

```java
LocalDate nacimiento =
    LocalDate.of(
        2000,
        5,
        20
    );

LocalDate hoy =
    LocalDate.now();

Period edad =
    Period.between(
        nacimiento,
        hoy
    );

System.out.println(
    "Edad: "
    + edad.getYears()
);
```

El resultado depende de la fecha actual.

Podemos encapsularlo en un método:

```java
public static int calcularEdad(
        LocalDate nacimiento,
        LocalDate fechaActual) {

    return Period
        .between(
            nacimiento,
            fechaActual
        )
        .getYears();
}
```

Uso:

```java
LocalDate nacimiento =
    LocalDate.of(
        2000,
        5,
        20
    );

int edad =
    calcularEdad(
        nacimiento,
        LocalDate.now()
    );

System.out.println(edad);
```

## Diferencia total en días

Si queremos saber el número total de días entre dos fechas, podemos utilizar:

```java
ChronoUnit.DAYS.between()
```

Importamos:

```java
import java.time.temporal.ChronoUnit;
```

Ejemplo:

```java
LocalDate inicio =
    LocalDate.of(
        2026,
        9,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        9,
        11
    );

long dias =
    ChronoUnit.DAYS.between(
        inicio,
        fin
    );

System.out.println(dias);
```

Salida:

```text
10
```

## Diferencia en semanas

```java
long semanas =
    ChronoUnit.WEEKS.between(
        inicio,
        fin
    );
```

## Diferencia en meses

```java
LocalDate inicio =
    LocalDate.of(
        2025,
        1,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        7,
        1
    );

long meses =
    ChronoUnit.MONTHS.between(
        inicio,
        fin
    );

System.out.println(meses);
```

Salida:

```text
18
```

## Diferencia en años

```java
LocalDate inicio =
    LocalDate.of(
        2000,
        1,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        1,
        1
    );

long anios =
    ChronoUnit.YEARS.between(
        inicio,
        fin
    );

System.out.println(anios);
```

Salida:

```text
26
```

## `Period` frente a `ChronoUnit`

Supongamos:

```java
LocalDate inicio =
    LocalDate.of(
        2024,
        1,
        15
    );

LocalDate fin =
    LocalDate.of(
        2026,
        4,
        20
    );
```

Con `Period`:

```java
Period periodo =
    Period.between(
        inicio,
        fin
    );

System.out.println(
    periodo.getYears()
);

System.out.println(
    periodo.getMonths()
);

System.out.println(
    periodo.getDays()
);
```

obtenemos la diferencia descompuesta en:

```text
años
meses
días
```

Con:

```java
ChronoUnit.DAYS.between(
    inicio,
    fin
);
```

obtenemos el número total de días.

<div class="cla-note"><strong>Para recordar</strong><p><code>Period</code> es adecuado cuando queremos expresar una diferencia en años, meses y días. <code>ChronoUnit</code> es útil cuando queremos obtener una cantidad total en una unidad concreta.</p></div>

## Diferencia entre horas con `Duration`

`Duration` representa una cantidad de tiempo basada principalmente en:

```text
horas
minutos
segundos
nanosegundos
```

Ejemplo:

```java
import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime inicio =
            LocalTime.of(9, 0);

        LocalTime fin =
            LocalTime.of(17, 30);

        Duration duracion =
            Duration.between(
                inicio,
                fin
            );

        System.out.println(
            duracion.toHours()
        );

        System.out.println(
            duracion.toMinutes()
        );
    }
}
```

Salida:

```text
8
510
```

`toHours()` devuelve horas completas.

`toMinutes()` devuelve el total de minutos.

### Diferencia exacta en horas y minutos

Podemos calcular:

```java
LocalTime inicio =
    LocalTime.of(9, 15);

LocalTime fin =
    LocalTime.of(17, 45);

Duration duracion =
    Duration.between(
        inicio,
        fin
    );

long horas =
    duracion.toHours();

long minutosRestantes =
    duracion.toMinutesPart();

System.out.println(
    horas + " horas y "
    + minutosRestantes
    + " minutos"
);
```

Salida:

```text
8 horas y 30 minutos
```

### Diferencia entre `LocalDateTime`

```java
LocalDateTime inicio =
    LocalDateTime.of(
        2026,
        9,
        11,
        8,
        0
    );

LocalDateTime fin =
    LocalDateTime.of(
        2026,
        9,
        12,
        10,
        30
    );

Duration duracion =
    Duration.between(
        inicio,
        fin
    );

System.out.println(
    duracion.toHours()
);
```

Salida:

```text
26
```

## `Period` frente a `Duration`

| Clase | Trabaja principalmente con |
| --- | --- |
| `Period` | Años, meses y días |
| `Duration` | Horas, minutos, segundos y nanosegundos |

Ejemplo de `Period`:

```java
Period periodo =
    Period.of(
        2,
        3,
        10
    );
```

Representa:

```text
2 años
3 meses
10 días
```

Ejemplo de `Duration`:

```java
Duration duracion =
    Duration.ofHours(5);
```

Representa cinco horas.

## Crear periodos

```java
Period unAnio =
    Period.ofYears(1);

Period tresMeses =
    Period.ofMonths(3);

Period diezDias =
    Period.ofDays(10);
```

Podemos sumarlos a una fecha:

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        1,
        1
    );

LocalDate resultado =
    fecha.plus(
        Period.ofMonths(3)
    );

System.out.println(resultado);
```

Salida:

```text
2026-04-01
```

## Crear duraciones

```java
Duration unaHora =
    Duration.ofHours(1);

Duration treintaMinutos =
    Duration.ofMinutes(30);

Duration diezSegundos =
    Duration.ofSeconds(10);
```

## Calcular días hasta una fecha

Por ejemplo:

```java
LocalDate hoy =
    LocalDate.now();

LocalDate objetivo =
    LocalDate.of(
        2027,
        1,
        1
    );

long dias =
    ChronoUnit.DAYS.between(
        hoy,
        objetivo
    );

System.out.println(
    "Faltan "
    + dias
    + " días"
);
```

Si la fecha objetivo ya ha pasado, el resultado será negativo.

## Calcular días desde una fecha

```java
LocalDate inicio =
    LocalDate.of(
        2020,
        1,
        1
    );

LocalDate hoy =
    LocalDate.now();

long dias =
    ChronoUnit.DAYS.between(
        inicio,
        hoy
    );

System.out.println(dias);
```

## Primer y último día del mes

Podemos obtener el primer día fácilmente:

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

LocalDate primero =
    fecha.withDayOfMonth(1);

System.out.println(primero);
```

Salida:

```text
2026-09-01
```

Para el último:

```java
LocalDate ultimo =
    fecha.withDayOfMonth(
        fecha.lengthOfMonth()
    );

System.out.println(ultimo);
```

Salida:

```text
2026-09-30
```

## `TemporalAdjusters`

Java dispone de utilidades para realizar ajustes habituales sobre fechas.

Importamos:

```java
import java.time.temporal.TemporalAdjusters;
```

### Último día del mes

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        2,
        10
    );

LocalDate ultimo =
    fecha.with(
        TemporalAdjusters
            .lastDayOfMonth()
    );

System.out.println(ultimo);
```

Salida:

```text
2026-02-28
```

### Primer día del siguiente mes

```java
LocalDate resultado =
    fecha.with(
        TemporalAdjusters
            .firstDayOfNextMonth()
    );
```

### Próximo lunes

```java
import java.time.DayOfWeek;

LocalDate proximoLunes =
    fecha.with(
        TemporalAdjusters.next(
            DayOfWeek.MONDAY
        )
    );
```

## Día de la semana

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

System.out.println(
    fecha.getDayOfWeek()
);
```

Salida:

```text
FRIDAY
```

Podemos comparar con:

```java
DayOfWeek.FRIDAY
```

Ejemplo:

```java
if (fecha.getDayOfWeek()
        == DayOfWeek.FRIDAY) {

    System.out.println(
        "Es viernes"
    );
}
```

`DayOfWeek` es un `enum`, por lo que es correcto comparar sus valores con `==`.

## Comprobar fin de semana

```java
DayOfWeek dia =
    fecha.getDayOfWeek();

boolean finDeSemana =
    dia == DayOfWeek.SATURDAY
    || dia == DayOfWeek.SUNDAY;

System.out.println(
    finDeSemana
);
```

## `Month`

Java proporciona el `enum`:

```java
Month
```

Ejemplo:

```java
import java.time.Month;

Month mes =
    Month.SEPTEMBER;

System.out.println(
    mes.getValue()
);
```

Salida:

```text
9
```

Podemos crear fechas:

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        Month.SEPTEMBER,
        11
    );
```

## `Year`

La clase `Year` representa un año.

```java
import java.time.Year;

Year anio =
    Year.of(2026);

System.out.println(anio);
```

Salida:

```text
2026
```

Podemos comprobar:

```java
System.out.println(
    anio.isLeap()
);
```

También podemos obtener el año actual:

```java
Year actual =
    Year.now();
```

## `YearMonth`

`YearMonth` representa un año y un mes.

Es útil para:

- Facturación mensual.
- Calendarios.
- Tarjetas con fecha de caducidad.
- Obtener los días de un mes.

Ejemplo:

```java
import java.time.YearMonth;

YearMonth mes =
    YearMonth.of(
        2026,
        2
    );

System.out.println(
    mes.lengthOfMonth()
);
```

Salida:

```text
28
```

Para febrero de 2024:

```java
YearMonth mes =
    YearMonth.of(
        2024,
        2
    );

System.out.println(
    mes.lengthOfMonth()
);
```

Salida:

```text
29
```

## `MonthDay`

`MonthDay` representa un mes y un día sin asociarlo a un año.

Puede ser útil para:

- Cumpleaños.
- Aniversarios.
- Fechas recurrentes.

Ejemplo:

```java
import java.time.MonthDay;

MonthDay cumple =
    MonthDay.of(
        5,
        20
    );

System.out.println(cumple);
```

Salida:

```text
--05-20
```

## Zonas horarias

`LocalDateTime` no almacena ninguna zona horaria.

Si necesitamos representar una fecha y hora asociada a una zona utilizamos:

```java
ZonedDateTime
```

y:

```java
ZoneId
```

Ejemplo:

```java
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {

        ZoneId zona =
            ZoneId.of(
                "Europe/Madrid"
            );

        ZonedDateTime ahora =
            ZonedDateTime.now(zona);

        System.out.println(ahora);
    }
}
```

La salida incluye información de la zona y del desfase horario.

### Fecha en dos zonas

```java
ZoneId madrid =
    ZoneId.of(
        "Europe/Madrid"
    );

ZoneId nuevaYork =
    ZoneId.of(
        "America/New_York"
    );

ZonedDateTime horaMadrid =
    ZonedDateTime.now(madrid);

ZonedDateTime horaNuevaYork =
    horaMadrid.withZoneSameInstant(
        nuevaYork
    );

System.out.println(
    "Madrid: "
    + horaMadrid
);

System.out.println(
    "Nueva York: "
    + horaNuevaYork
);
```

`withZoneSameInstant()` mantiene el mismo instante real y lo representa en otra zona.

<div class="cla-note"><strong>Idea clave</strong><p><code>LocalDateTime</code> representa una fecha y hora local sin zona. <code>ZonedDateTime</code> añade una zona horaria y permite representar correctamente un instante en lugares diferentes.</p></div>

## `Instant`

`Instant` representa un punto concreto en la línea temporal.

Es especialmente útil para:

- Registrar eventos.
- Guardar marcas de tiempo.
- Medir tiempos.
- Trabajar con UTC.

Ejemplo:

```java
import java.time.Instant;

Instant ahora =
    Instant.now();

System.out.println(ahora);
```

La salida utiliza UTC y suele terminar en:

```text
Z
```

Por ejemplo:

```text
2026-09-11T10:15:30.123Z
```

`Z` representa UTC.

## Unix timestamp

Podemos obtener segundos desde el instante Unix:

```java
Instant ahora =
    Instant.now();

long segundos =
    ahora.getEpochSecond();

System.out.println(segundos);
```

También podemos crear un `Instant` a partir de segundos:

```java
Instant instante =
    Instant.ofEpochSecond(
        0
    );

System.out.println(instante);
```

Salida:

```text
1970-01-01T00:00:00Z
```

## Comparar `Instant`

```java
Instant inicio =
    Instant.now();

// operación

Instant fin =
    Instant.now();

System.out.println(
    fin.isAfter(inicio)
);
```

## Medir duración de una operación

```java
Instant inicio =
    Instant.now();

// código que queremos medir

Instant fin =
    Instant.now();

Duration duracion =
    Duration.between(
        inicio,
        fin
    );

System.out.println(
    duracion.toMillis()
    + " ms"
);
```

Para mediciones precisas de rendimiento dentro de una JVM también suele utilizarse `System.nanoTime()`, pero `Instant` es útil cuando nos interesa un instante real del reloj.

## Ejemplo: calcular edad completa

```java
import java.time.LocalDate;
import java.time.Period;

public class EdadExample {

    public static void main(String[] args) {

        LocalDate nacimiento =
            LocalDate.of(
                2000,
                5,
                20
            );

        LocalDate fecha =
            LocalDate.of(
                2026,
                9,
                11
            );

        Period edad =
            Period.between(
                nacimiento,
                fecha
            );

        System.out.println(
            edad.getYears()
            + " años, "
            + edad.getMonths()
            + " meses y "
            + edad.getDays()
            + " días"
        );
    }
}
```

## Ejemplo: saber si una persona es mayor de edad

Una forma sencilla es comparar su fecha de nacimiento con la fecha límite:

```java
LocalDate nacimiento =
    LocalDate.of(
        2010,
        5,
        20
    );

LocalDate hoy =
    LocalDate.now();

boolean mayorEdad =
    !nacimiento
        .plusYears(18)
        .isAfter(hoy);

System.out.println(
    mayorEdad
);
```

La expresión:

```java
nacimiento.plusYears(18)
```

calcula la fecha en la que la persona cumple 18 años.

## Ejemplo: días entre dos fechas

```java
LocalDate salida =
    LocalDate.of(
        2026,
        7,
        1
    );

LocalDate regreso =
    LocalDate.of(
        2026,
        7,
        15
    );

long dias =
    ChronoUnit.DAYS.between(
        salida,
        regreso
    );

System.out.println(
    "Duración del viaje: "
    + dias
    + " días"
);
```

Salida:

```text
Duración del viaje: 14 días
```

## Ejemplo: diferencia en años

```java
LocalDate inicio =
    LocalDate.of(
        2010,
        1,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        1,
        1
    );

long anios =
    ChronoUnit.YEARS.between(
        inicio,
        fin
    );

System.out.println(anios);
```

Salida:

```text
16
```

## Ejemplo: diferencia en meses

```java
LocalDate inicio =
    LocalDate.of(
        2025,
        1,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        9,
        1
    );

long meses =
    ChronoUnit.MONTHS.between(
        inicio,
        fin
    );

System.out.println(meses);
```

Salida:

```text
20
```

## Ejemplo: duración de una jornada

```java
LocalTime entrada =
    LocalTime.of(8, 30);

LocalTime salida =
    LocalTime.of(16, 45);

Duration duracion =
    Duration.between(
        entrada,
        salida
    );

System.out.println(
    duracion.toHours()
    + " horas y "
    + duracion.toMinutesPart()
    + " minutos"
);
```

Salida:

```text
8 horas y 15 minutos
```

## Ejemplo: sumar 90 minutos

```java
LocalTime hora =
    LocalTime.of(
        10,
        30
    );

LocalTime resultado =
    hora.plusMinutes(90);

System.out.println(resultado);
```

Salida:

```text
12:00
```

## Ejemplo: cita dentro de 15 días

```java
LocalDate hoy =
    LocalDate.now();

LocalDate cita =
    hoy.plusDays(15);

System.out.println(
    "Cita: " + cita
);
```

## Ejemplo: vencimiento dentro de tres meses

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        3,
        15
    );

LocalDate vencimiento =
    fecha.plusMonths(3);

System.out.println(
    vencimiento
);
```

Salida:

```text
2026-06-15
```

## Ejemplo: comprobar si una fecha ha vencido

```java
LocalDate vencimiento =
    LocalDate.of(
        2025,
        12,
        31
    );

LocalDate hoy =
    LocalDate.now();

if (vencimiento.isBefore(hoy)) {

    System.out.println(
        "La fecha ha vencido"
    );

} else {

    System.out.println(
        "La fecha todavía es válida"
    );
}
```

## Ejemplo: comprobar si una fecha está dentro de un intervalo

```java
LocalDate inicio =
    LocalDate.of(
        2026,
        9,
        1
    );

LocalDate fin =
    LocalDate.of(
        2026,
        9,
        30
    );

LocalDate fecha =
    LocalDate.of(
        2026,
        9,
        11
    );

boolean dentro =
    !fecha.isBefore(inicio)
    && !fecha.isAfter(fin);

System.out.println(dentro);
```

Salida:

```text
true
```

## Ejemplo completo

```java
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FechasExample {

    public static void main(String[] args) {

        // 1. Fecha actual
        LocalDate hoy =
            LocalDate.now();

        System.out.println(
            "Hoy: " + hoy
        );

        // 2. Fecha concreta
        LocalDate fecha =
            LocalDate.of(
                2026,
                12,
                25
            );

        System.out.println(
            "Navidad: " + fecha
        );

        // 3. Sumar días
        System.out.println(
            "10 días después: "
            + fecha.plusDays(10)
        );

        // 4. Restar meses
        System.out.println(
            "2 meses antes: "
            + fecha.minusMonths(2)
        );

        // 5. Formatear
        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern(
                "dd/MM/yyyy"
            );

        System.out.println(
            "Formato: "
            + fecha.format(formato)
        );

        // 6. Diferencia en días
        long dias =
            ChronoUnit.DAYS.between(
                hoy,
                fecha
            );

        System.out.println(
            "Diferencia en días: "
            + dias
        );

        // 7. Edad
        LocalDate nacimiento =
            LocalDate.of(
                2000,
                5,
                20
            );

        Period edad =
            Period.between(
                nacimiento,
                hoy
            );

        System.out.println(
            "Edad: "
            + edad.getYears()
        );

        // 8. Hora
        LocalTime inicio =
            LocalTime.of(
                9,
                0
            );

        LocalTime fin =
            LocalTime.of(
                17,
                30
            );

        Duration jornada =
            Duration.between(
                inicio,
                fin
            );

        System.out.println(
            "Jornada: "
            + jornada.toHours()
            + " h "
            + jornada.toMinutesPart()
            + " min"
        );

        // 9. Fecha y hora
        LocalDateTime cita =
            LocalDateTime.of(
                fecha,
                LocalTime.of(
                    18,
                    30
                )
            );

        System.out.println(
            "Cita: " + cita
        );
    }
}
```

## Tabla de referencia rápida

| Operación | Ejemplo |
| --- | --- |
| Fecha actual | `LocalDate.now()` |
| Hora actual | `LocalTime.now()` |
| Fecha y hora actuales | `LocalDateTime.now()` |
| Crear fecha | `LocalDate.of(2026, 9, 11)` |
| Crear hora | `LocalTime.of(18, 30)` |
| Crear fecha y hora | `LocalDateTime.of(2026, 9, 11, 18, 30)` |
| Sumar días | `fecha.plusDays(10)` |
| Restar días | `fecha.minusDays(10)` |
| Sumar meses | `fecha.plusMonths(3)` |
| Restar meses | `fecha.minusMonths(3)` |
| Sumar años | `fecha.plusYears(1)` |
| Restar años | `fecha.minusYears(1)` |
| Comparar anterior | `fecha1.isBefore(fecha2)` |
| Comparar posterior | `fecha1.isAfter(fecha2)` |
| Igualdad | `fecha1.isEqual(fecha2)` |
| Año | `fecha.getYear()` |
| Mes | `fecha.getMonth()` |
| Día | `fecha.getDayOfMonth()` |
| Día semana | `fecha.getDayOfWeek()` |
| Año bisiesto | `fecha.isLeapYear()` |
| Días del mes | `fecha.lengthOfMonth()` |
| Formatear | `fecha.format(formato)` |
| Convertir texto | `LocalDate.parse(texto, formato)` |
| Periodo entre fechas | `Period.between(inicio, fin)` |
| Días totales | `ChronoUnit.DAYS.between(inicio, fin)` |
| Meses totales | `ChronoUnit.MONTHS.between(inicio, fin)` |
| Años totales | `ChronoUnit.YEARS.between(inicio, fin)` |
| Duración entre horas | `Duration.between(inicio, fin)` |

## `Period`, `Duration` y `ChronoUnit`

Una de las dudas más frecuentes es cuándo utilizar cada opción.

### `Period`

Utilízalo cuando quieras expresar una diferencia de calendario:

```text
2 años, 3 meses y 5 días
```

Ejemplo:

```java
Period periodo =
    Period.between(
        fecha1,
        fecha2
    );
```

### `Duration`

Utilízalo cuando quieras medir tiempo:

```text
8 horas
30 minutos
15 segundos
```

Ejemplo:

```java
Duration duracion =
    Duration.between(
        hora1,
        hora2
    );
```

### `ChronoUnit`

Utilízalo cuando quieras obtener un total en una unidad determinada:

```java
long dias =
    ChronoUnit.DAYS.between(
        fecha1,
        fecha2
    );
```

O:

```java
long anios =
    ChronoUnit.YEARS.between(
        fecha1,
        fecha2
    );
```

## Para recordar

- `LocalDate` representa una fecha.
- `LocalTime` representa una hora.
- `LocalDateTime` representa fecha y hora sin zona.
- `ZonedDateTime` representa fecha, hora y zona.
- `Instant` representa un instante en la línea temporal.
- Las clases de `java.time` son inmutables.
- `plusDays()`, `plusMonths()` y `plusYears()` devuelven nuevos objetos.
- `minusDays()`, `minusMonths()` y `minusYears()` permiten restar tiempo.
- `isBefore()` e `isAfter()` comparan fechas y horas.
- `DateTimeFormatter` permite dar formato.
- `parse()` convierte texto en fechas u horas.
- `Period` trabaja con años, meses y días.
- `Duration` trabaja principalmente con unidades de tiempo.
- `ChronoUnit` permite calcular diferencias totales en una unidad.
- `ZoneId` identifica una zona horaria.
- `LocalDateTime` no contiene zona horaria.
- `ZonedDateTime` sí contiene zona horaria.
- `DateTimeParseException` indica problemas al convertir texto en una fecha u hora.

## Ejercicio rápido

Dadas estas fechas:

```java
LocalDate inicio =
    LocalDate.of(
        2020,
        1,
        1
    );

LocalDate fin =
    LocalDate.of(
        2025,
        1,
        1
    );
```

Responde:

```java
ChronoUnit.YEARS.between(
    inicio,
    fin
);
```

Resultado:

```text
5
```

Ahora:

```java
ChronoUnit.MONTHS.between(
    inicio,
    fin
);
```

Resultado:

```text
60
```

Y:

```java
Period periodo =
    Period.between(
        inicio,
        fin
    );

System.out.println(
    periodo.getYears()
);
```

Resultado:

```text
5
```

## Práctica guiada del concepto

Crea un programa llamado:

```text
GestorFechas.java
```

El programa debe:

1. Mostrar la fecha actual.
2. Mostrar la hora actual.
3. Crear una fecha de nacimiento.
4. Calcular la edad en años.
5. Calcular cuántos días han pasado desde una fecha determinada.
6. Crear una fecha futura sumando 30 días.
7. Mostrar una fecha con formato `dd/MM/yyyy`.
8. Convertir `"25/12/2026"` en un `LocalDate`.
9. Comparar dos fechas.
10. Calcular la duración entre `08:30` y `17:15`.
11. Mostrar el primer y último día del mes de una fecha.
12. Comprobar si el año de una fecha es bisiesto.

Una posible solución es:

```java
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GestorFechas {

    public static void main(String[] args) {

        LocalDate hoy =
            LocalDate.now();

        LocalTime ahora =
            LocalTime.now();

        System.out.println(
            "Hoy: " + hoy
        );

        System.out.println(
            "Hora: " + ahora
        );

        LocalDate nacimiento =
            LocalDate.of(
                2000,
                5,
                20
            );

        int edad =
            Period.between(
                nacimiento,
                hoy
            ).getYears();

        System.out.println(
            "Edad: " + edad
        );

        LocalDate referencia =
            LocalDate.of(
                2020,
                1,
                1
            );

        long dias =
            ChronoUnit.DAYS.between(
                referencia,
                hoy
            );

        System.out.println(
            "Días transcurridos: "
            + dias
        );

        LocalDate futura =
            hoy.plusDays(30);

        System.out.println(
            "Dentro de 30 días: "
            + futura
        );

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern(
                "dd/MM/yyyy"
            );

        System.out.println(
            "Fecha formateada: "
            + hoy.format(formato)
        );

        LocalDate navidad =
            LocalDate.parse(
                "25/12/2026",
                formato
            );

        System.out.println(
            "Navidad: " + navidad
        );

        if (navidad.isAfter(hoy)) {

            System.out.println(
                "Navidad es posterior"
            );
        }

        LocalTime entrada =
            LocalTime.of(
                8,
                30
            );

        LocalTime salida =
            LocalTime.of(
                17,
                15
            );

        Duration jornada =
            Duration.between(
                entrada,
                salida
            );

        System.out.println(
            "Jornada: "
            + jornada.toHours()
            + " horas y "
            + jornada.toMinutesPart()
            + " minutos"
        );

        LocalDate primero =
            hoy.withDayOfMonth(1);

        LocalDate ultimo =
            hoy.withDayOfMonth(
                hoy.lengthOfMonth()
            );

        System.out.println(
            "Primer día: "
            + primero
        );

        System.out.println(
            "Último día: "
            + ultimo
        );

        System.out.println(
            "¿Año bisiesto? "
            + hoy.isLeapYear()
        );
    }
}
```

## Prueba tus conocimientos

### Caso 1

```java
LocalDate fecha =
    LocalDate.of(
        2026,
        1,
        1
    );

fecha.plusDays(10);

System.out.println(fecha);
```

Salida:

```text
2026-01-01
```

La fecha no cambia porque `LocalDate` es inmutable.

Para conservar el resultado:

```java
fecha =
    fecha.plusDays(10);
```

### Caso 2

```java
LocalDate fecha =
    LocalDate.of(
        2024,
        2,
        1
    );

System.out.println(
    fecha.lengthOfMonth()
);
```

Salida:

```text
29
```

porque 2024 es bisiesto.

### Caso 3

```java
LocalDate fecha =
    LocalDate.parse(
        "2026-02-30"
    );
```

Durante la ejecución se produce:

```text
DateTimeParseException
```

porque el 30 de febrero no es una fecha válida.

### Caso 4

```java
LocalDate a =
    LocalDate.of(
        2026,
        1,
        1
    );

LocalDate b =
    LocalDate.of(
        2026,
        1,
        10
    );

System.out.println(
    ChronoUnit.DAYS.between(
        a,
        b
    )
);
```

Salida:

```text
9
```

### Caso 5

```java
LocalTime inicio =
    LocalTime.of(
        10,
        0
    );

LocalTime fin =
    LocalTime.of(
        12,
        30
    );

Duration d =
    Duration.between(
        inicio,
        fin
    );

System.out.println(
    d.toMinutes()
);
```

Salida:

```text
150
```

### Caso 6

```java
LocalDate nacimiento =
    LocalDate.of(
        2000,
        5,
        20
    );

LocalDate fecha =
    LocalDate.of(
        2026,
        5,
        19
    );

int edad =
    Period.between(
        nacimiento,
        fecha
    ).getYears();

System.out.println(edad);
```

Salida:

```text
25
```

Todavía no ha cumplido 26 años.

### Caso 7

```java
LocalDate nacimiento =
    LocalDate.of(
        2000,
        5,
        20
    );

LocalDate fecha =
    LocalDate.of(
        2026,
        5,
        20
    );

int edad =
    Period.between(
        nacimiento,
        fecha
    ).getYears();

System.out.println(edad);
```

Salida:

```text
26
```

## Después de esta lección

Tras completar este apartado debes saber distinguir entre:

```java
LocalDate
LocalTime
LocalDateTime
ZonedDateTime
Instant
```

y utilizar la clase adecuada según la información que necesites almacenar.

También debes ser capaz de:

```java
LocalDate.now()
LocalDate.of()
LocalTime.now()
LocalTime.of()
LocalDateTime.now()
plusDays()
plusMonths()
plusYears()
minusDays()
minusMonths()
minusYears()
isBefore()
isAfter()
isEqual()
DateTimeFormatter.ofPattern()
format()
parse()
Period.between()
Duration.between()
ChronoUnit.DAYS.between()
ChronoUnit.MONTHS.between()
ChronoUnit.YEARS.between()
```

Para diferencias expresadas como **años, meses y días**, utiliza normalmente `Period`.

Para diferencias de **horas, minutos y segundos**, utiliza `Duration`.

Para obtener un **total exacto en una unidad concreta**, como días, meses o años completos, utiliza `ChronoUnit`.

Cuando el programa necesite representar una zona horaria real, utiliza `ZoneId` y `ZonedDateTime` en lugar de asumir que un `LocalDateTime` contiene información geográfica o de huso horario.
