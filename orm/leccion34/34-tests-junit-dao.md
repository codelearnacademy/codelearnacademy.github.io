---
layout: "lesson"
route: "orm"
lesson_id: "leccion34"
lesson_file: "34-tests-junit-dao"
lesson_number: "34"
title: "JUnit 5: tests ordenados, aislados y defensivos"
description: "Organizar pruebas de DAO, verificar listas vacías y gestionar errores sin propagar excepciones."
permalink: "/orm/leccion34/"
---

# JUnit 5: tests ordenados, aislados y defensivos

## Secuencia de aprendizaje

1. Listar y comprobar que devuelve `List<Modelo>`.
2. Buscar por ID existente e inexistente.
3. Insertar y verificar persistencia real.
4. Rechazar duplicados.
5. Actualizar y volver a consultar.
6. Eliminar y comprobar ausencia.
7. Evaluar listas vacías, nulos, integridad y `rollback`.
8. Evaluar consultas JPQL de básicas a avanzadas.

## Orden explícito

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteDaoTest extends BaseTest {

    private final ClienteDao dao = new ClienteDao();

    @Test
    @Order(1)
    void verificarListadoOrdenado() {
        List<Cliente> resultado = dao.listarTodos();
        assertNotNull(resultado);
        assertEquals(7, resultado.size());
        assertEquals("12345678A", resultado.get(0).getDni());
    }

    @Test
    @Order(2)
    void verificarBusquedaRegistroInexistente() {
        assertNull(dao.buscarPorId("99999999Z"));
    }
}
```

`@Order` controla **el orden de lectura/ejecución**, pero no significa que los tests deban **depender del resultado del anterior**. Cada test debe iniciar con un estado conocido de SQLite, idealmente una copia temporal de una base semilla.

## Listas vacías y ausencia de excepciones

```java
@Test
@Order(3)
void verificarListadoSinRegistros() {
    sql("DELETE FROM alquileres");
    sql("DELETE FROM clientes");

    List<Cliente> resultado = assertDoesNotThrow(dao::listarTodos);
    assertNotNull(resultado);
    assertTrue(resultado.isEmpty());
}

@Test
@Order(4)
void verificarInsercionRegistroDuplicado() {
    Cliente repetido = new Cliente("12345678A", "Otro", "otro@ejemplo.es", "600000000");
    boolean correcto = assertDoesNotThrow(() -> dao.insertar(repetido));
    assertFalse(correcto);
}
```

El método `sql(...)` pertenece a una base de tests preparada para el curso (`BaseTest`); **no** es API de JUnit. Debe ejecutar sentencias contra la misma base SQLite de prueba que los DAO.

## Qué comprueban los tests

| Área | Evidencia |
|---|---|
| Función | Valores y orden correctos; modelo, no entidad |
| Persistencia | Verificación mediante un contexto JPA nuevo |
| Defensa | `null`, vacío, duplicado, FK inválida, ausencia de excepción |
| Integridad | `rollback` sin efectos parciales |
| JPQL | Resultados, ausencia de coincidencias y estructura exigida |

**Una comprobación del SQL generado por Hibernate no demuestra por sí sola el JPQL original**: Hibernate puede optimizar joins. Para una corrección estructural, no basta buscar `join` en todo el archivo DAO. Aísla la consulta del método o reserva tests técnicos para el profesorado.

## Actividad

Diseña cinco casos para `EquipoDao`: listado, existente, inexistente, duplicado y eliminación bloqueada por FK. Redacta nombres de tests que describan comportamientos sin revelar las cláusulas SQL requeridas.

<details><summary>Autoevaluación: ¿para qué se usa `assertDoesNotThrow`?</summary>

Para verificar que la operación pública no propaga excepciones en los escenarios que el contrato exige gestionar internamente.
</details>

**Siguiente:** [calidad y rúbrica](/orm/leccion35/).
