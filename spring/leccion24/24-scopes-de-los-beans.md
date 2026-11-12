---
layout: lesson
route: spring
lesson_id: leccion24
lesson_file: 24-scopes-de-los-beans
lesson_number: "24"
title: Scopes de los beans
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion24/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Scopes de los beans

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Scopes de los beans** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

`singleton` significa una instancia por **definición de bean y contenedor**, no una sola instancia de cada clase en toda la aplicación. `prototype` crea una instancia por solicitud al contenedor; inyectarlo una vez en un singleton no crea automáticamente uno nuevo en cada uso.

```java
@Configuration
class Config {
    @Bean StringBuilder primero() { return new StringBuilder(); }
    @Bean StringBuilder segundo() { return new StringBuilder(); }
    @Bean @Scope("prototype")
    StringBuilder temporal() { return new StringBuilder(); }
}
```

Importa las anotaciones de `org.springframework.context.annotation`. Con Spring Context configurado, ejecuta dentro de un método:

```java
try (var context = new AnnotationConfigApplicationContext(Config.class)) {
    System.out.println(context.getBean("primero") == context.getBean("primero"));
    System.out.println(context.getBean("primero") == context.getBean("segundo"));
    System.out.println(context.getBean("temporal") == context.getBean("temporal"));
}
```

Importa también `AnnotationConfigApplicationContext` desde ese paquete. El resultado es `true`, `false`, `false`. Hay dos beans singleton de StringBuilder y no son el mismo objeto. Para obtener prototipos repetidamente desde un singleton, utiliza una solicitud explícita, por ejemplo mediante `ObjectProvider`.

Referencia: [scopes de Spring](https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html).


## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SesionTemporal {
    private final UUID identificador = UUID.randomUUID();
}
```

Compara las instancias obtenidas con singleton y prototype.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **Scopes de los beans**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Scopes de los beans** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion23/">← 23 · Varias implementaciones: @Qualifier y @Primary</a>
  <a href="/spring/leccion25/">25 · Ciclo de vida del bean →</a>
</div>
