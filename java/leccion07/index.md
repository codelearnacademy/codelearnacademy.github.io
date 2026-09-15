---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: Herencia e interfaces
search_title: Lección 07 - Herencia e interfaces
search_description: Aplicarás herencia, interfaces y polimorfismo para diseñar soluciones extensibles.
description: Aplicarás herencia, interfaces, polimorfismo y composición.
lessons:
  - id: herencia
    title: Herencia y sobrescritura
  - id: interfaces
    title: Interfaces y polimorfismo
  - id: composicion
    title: Composición y diseño
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion07/
---

## Herencia y sobrescritura

La herencia expresa una especialización. La subclase recibe miembros accesibles de la superclase y puede sobrescribir comportamiento con `@Override`.

```java
public class Empleado {
  protected final String nombre;
  public Empleado(String nombre) { this.nombre = nombre; }
  public double coste() { return 0; }
}

public class Desarrollador extends Empleado {
  private final double salario;
  public Desarrollador(String nombre, double salario) {
    super(nombre);
    this.salario = salario;
  }
  @Override public double coste() { return salario; }
}
```

Usa `final` para impedir extensiones o sobrescrituras cuando el diseño lo requiera. Una jerarquía debe tener una relación “es un” clara.

## Interfaces y polimorfismo

Una interfaz define un contrato que distintas clases pueden implementar:

```java
public interface Exportable { String exportar(); }

public class Informe implements Exportable {
  @Override public String exportar() { return "informe"; }
}

Exportable documento = new Informe();
System.out.println(documento.exportar());
```

El código cliente depende del contrato y no de la implementación concreta. Una clase puede implementar varias interfaces, lo que evita la limitación de herencia única.

## Composición y diseño

Prefiere composición cuando un objeto utiliza a otro sin ser una especialización. `Pedido` puede tener un `CalculadorDePrecios`; no necesita heredar de él. Esta decisión reduce acoplamiento y facilita sustituir colaboraciones en pruebas.

## Ejercicios

1. Crea una jerarquía `Vehiculo`, `Coche` y `Moto`.
2. Implementa `Notificable` para correo y consola.
3. Compara una solución con herencia y otra con composición.
4. Diseña un sistema de formas que calcule áreas mediante polimorfismo.
5. Documenta por qué una clase debe ser `abstract`, `final` o una interfaz.
