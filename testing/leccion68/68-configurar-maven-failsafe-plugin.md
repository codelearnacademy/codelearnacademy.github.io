---
layout: lesson
route: testing
lesson_id: leccion68
lesson_file: 68-configurar-maven-failsafe-plugin
lesson_number: "68"
title: Configurar maven-failsafe-plugin
description: Bloque «Tests de integración y Maven Failsafe». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion68/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: integración-con-maven
    title: Integración con Maven
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Configurar maven-failsafe-plugin

Bloque «Tests de integración y Maven Failsafe». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Configurar maven-failsafe-plugin**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

- **Failsafe**
- **integration-test**
- **verify**
- ***IT**

## Ejemplo guiado

```text
maven-failsafe-plugin:3.6.0 con goals integration-test y verify.
```



## Integración con Maven

Pregunta siempre: ¿es dependencia o plugin?, ¿en qué fase actúa?, ¿genera reportes?, ¿puede producir BUILD FAILURE?, ¿se ejecutará igual en CI?

JUnit, Mockito y AssertJ son dependencias de test. Surefire, Failsafe y JaCoCo son plugins Maven que participan en el build.

## Ejercicios propuestos

1. Reproduce el ejemplo desde Maven, no solo desde el IDE.
2. Provoca un fallo deliberado y localiza el mensaje útil.
3. Añade un caso límite o camino alternativo.
4. Clasifica la prueba por nivel: unit, integration, system o E2E.
5. Explica qué debería ocurrir en CI si esta comprobación falla.

## Qué debes recordar

- Maven convierte las pruebas en una regla reproducible del proyecto.
- `mvn test` y `mvn verify` no significan lo mismo.
- Coverage y complejidad son señales; no sustituyen el razonamiento.
- El objetivo final es que `./mvnw clean verify` represente la definición automática de calidad.

<div class="cla-lesson-nav">
  <a href="/testing/leccion67/">← 67 · Convención *Test frente a *IT</a>
  <a href="/testing/leccion69/">69 · Fases integration-test y verify →</a>
</div>
