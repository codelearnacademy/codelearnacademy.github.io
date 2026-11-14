---
layout: lesson
route: spring
lesson_id: leccion05
lesson_file: 05-ioc-di-y-dip-no-son-lo-mismo
lesson_number: "05"
title: IoC, DI y DIP no son lo mismo
description: Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.
permalink: /spring/leccion05/
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

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# IoC, DI y DIP no son lo mismo

Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **IoC, DI y DIP no son lo mismo** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Diseño de objetos, acoplamiento e inyección.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![IoC: Quién controla la creación. DI: Cómo llega el colaborador. DIP: De qué abstracción depende el servicio.]({{ "/assets/images/spring/05-ioc-di-y-dip-no-son-lo-mismo.webp" | relative_url }})

## Ejemplo guiado

Clasifica cada idea:

```text
IoC → quién controla la creación
DI  → cómo recibe un objeto sus colaboradores
DIP → de qué abstracciones debería depender el diseño
```



## Relación con el resto de la ruta

Relaciona estas ideas con SOLID y Clean Code: Spring puede facilitar el desacoplamiento, pero no sustituye un buen diseño.



## Ejemplo adicional: aplicación práctica

```java
interface AlmacenPedidos { void guardar(String codigo); }
@Service
class PedidoService {
    private final AlmacenPedidos almacen;
    PedidoService(AlmacenPedidos almacen) { this.almacen = almacen; }
    void registrar(String codigo) { almacen.guardar(codigo); }
}
```

DIP se refiere a depender de abstracciones; DI es una forma de suministrar la implementación.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Identifica en el ejemplo de **IoC, DI y DIP no son lo mismo** qué clase decide la creación o selección de dependencias.
2. Modifica el ejemplo para recibir una dependencia desde fuera; compara las dos implementaciones sin introducir Spring si no es necesario.
3. Escribe una prueba unitaria que utilice un colaborador falso y razona qué cambió en el acoplamiento.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **IoC, DI y DIP no son lo mismo** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion04/">← 04 · Inyección de dependencias</a>
  <a href="/spring/leccion06/">06 · Qué es Spring Framework →</a>
</div>
