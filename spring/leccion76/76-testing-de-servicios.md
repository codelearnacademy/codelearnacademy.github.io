---
layout: lesson
route: spring
lesson_id: leccion76
lesson_file: 76-testing-de-servicios
lesson_number: "76"
title: Testing de servicios
description: Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.
permalink: /spring/leccion76/
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
# Testing de servicios

Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Testing de servicios** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Pruebas automatizadas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Preparar: Simula el repositorio. Ejecutar: Llama al servicio. Verificar: Comprueba la regla.]({{ "/assets/images/spring/73-testing-de-servicios.webp" | relative_url }})

## Ejemplo guiado

```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock TaskRepository repository;
    @InjectMocks TaskService service;
}
```



### Ejemplo de prueba del servicio

```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void listarSinDatosDevuelveListaVacia() {
        when(repository.findAll()).thenReturn(List.of());

        var resultado = service.listar();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}
```

La clase de servicio debe ofrecer el método `listar()` con la firma que se utilice en el ejemplo. Evita que la prueba dependa de una base de datos real.

## Relación con el resto de la ruta

Maven ejecuta pruebas; Spring ofrece utilidades de test; Testcontainers aporta infraestructura real y Docker hace reproducible esa infraestructura.



## Ejemplo adicional: aplicación práctica

```java
@Test
void completarActualizaElEstado() {
    TaskRepository repository = mock(TaskRepository.class);
    when(repository.findById(3L)).thenReturn(Optional.of(new TaskEntity()));
    // Construir el servicio, invocarlo y verificar el efecto.
}
```

Los tests unitarios pueden utilizar dobles de prueba en lugar de una base real.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Crea una prueba sobre **Testing de servicios** que tenga un resultado esperado verificable.
2. Añade un caso sin registros y otro con datos válidos; evita que las pruebas compartan estado.
3. Ejecuta las pruebas dos veces en distinto orden y comprueba que el resultado no depende de otras pruebas.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Testing de servicios** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion75/">← 75 · @ConfigurationProperties</a>
  <a href="/spring/leccion77/">77 · Testing del contexto Spring →</a>
</div>
