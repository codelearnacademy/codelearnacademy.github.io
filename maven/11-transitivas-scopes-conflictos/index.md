---
layout: lesson
route: maven
lesson_id: principal11
lesson_number: "11"
title: "Dependencias transitivas, scopes y conflictos"
description: "Lee el árbol de dependencias y resuelve un conflicto controlado."
permalink: /maven/11-transitivas-scopes-conflictos/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: scopes
    title: "Scopes"
  - id: exclusiones-y-comprobación
    title: "Exclusiones y comprobación"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Dependencias transitivas, scopes y conflictos

Lee el árbol de dependencias y resuelve un conflicto controlado.
## Objetivo y punto de partida

Necesitas el proyecto con Gson. Las dependencias transitivas llegan a través de otras bibliotecas; Maven elige una versión cuando coinciden varias rutas al mismo artefacto.

## Práctica guiada

```bash
mvn dependency:tree
mvn dependency:tree -Dverbose
```

Para observar un caso claro, añade temporalmente a `<dependencies>`:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-text</artifactId>
  <version>1.12.0</version>
</dependency>
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.14.0</version>
</dependency>
```

```bash
mvn dependency:tree -Dverbose -Dincludes=org.apache.commons
```

`commons-text` solicita transitivamente otra versión de `commons-lang3`; la declaración directa tiene menor profundidad y gana la mediación. Maven no escoge necesariamente la versión más reciente. A igual profundidad suele prevalecer la primera declaración.

## Scopes

| Scope | Uso |
|---|---|
| `compile` | Disponible al compilar y ejecutar; valor predeterminado |
| `test` | Disponible para compilar y ejecutar pruebas |
| `provided` | Necesario al compilar; lo proporciona el entorno de ejecución |
| `runtime` | Necesario al ejecutar, sin estar en el classpath de compilación principal |
| `import` | Importar un BOM dentro de `dependencyManagement`, con `type=pom` |

El scope afecta a los classpaths y a cómo se propagan las dependencias. No implica que todas se introduzcan físicamente en el JAR convencional.

## Exclusiones y comprobación

Una exclusión se declara dentro de la dependencia por la que llega una biblioteca:

```xml
<exclusions>
  <exclusion>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
  </exclusion>
</exclusions>
```

No la añadas para silenciar avisos sin conocer qué código necesita la biblioteca. Excluir no proporciona automáticamente una alternativa compatible.

## Ejercicio

Retira la declaración directa de `commons-lang3` y compara el árbol. Restaura y después retira ambas dependencias de práctica para conservar el proyecto con Gson.

## Qué debes recordar

El árbol explica el origen y la versión efectiva. Elegir una versión requiere comprobar compatibilidad, además de conseguir un build correcto.

Referencia: [Gestión de dependencias](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/10-profiles/' | relative_url }}">← 10 · Profiles: activar configuraciones de Maven</a>
<a href="{{ '/maven/12-propiedades-versiones/' | relative_url }}">12 · Propiedades y gestión de versiones →</a>
</nav>
