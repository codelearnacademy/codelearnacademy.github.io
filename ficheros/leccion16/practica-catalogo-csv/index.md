---
layout: "lesson"
route: "ficheros"
lesson_id: "practica-catalogo-csv"
lesson_file: "17-ejercicio-catalogo-de-productos-csv"
lesson_number: "17"
title: "Ejercicio: catálogo de productos CSV"
description: "Ejercicio integrador de CSV con Producto, CRUD, validación y casos de campos que requieren quoting."
permalink: "/ficheros/leccion16/practica-catalogo-csv/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: pizarra-fila-csv
    title: "Una fila CSV se convierte en un producto"
  - id: pizarra-modificar-borrar
    title: "¿Quién hace qué al modificar o borrar?"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: relacion-con-el-resto-de-la-ruta
    title: "Relación con el resto de la ruta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
---

# Ejercicio: catálogo de productos CSV

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Consolidar el CRUD CSV utilizando el mismo modelo `Producto` de la ruta.
- Aplicar validación sin mezclarla con el código específico de Apache Commons CSV.
- Comprobar casos reales de quoting y caracteres UTF-8.

## Punto de partida
{: #punto-de-partida }

Ya puedes leer y escribir `Producto` con Commons CSV. Ahora debes reunir esas operaciones en un pequeño catálogo persistente.

<div class="cla-note"><strong>Reto CSV</strong><p>Incluye al menos un producto cuyo nombre contenga una coma, por ejemplo <code>"Teclado, mecánico"</code>. Si la solución usa Commons CSV correctamente, el campo seguirá siendo uno solo.</p></div>

## Conceptos clave
{: #conceptos-clave }

- `Producto` no conoce el formato CSV.
- El identificador permite localizar, actualizar y eliminar registros.
- Una modificación requiere cargar los datos, aplicar el cambio y persistir el estado resultante.
- Commons CSV debe encargarse del quoting y del escape de campos.

## Una fila CSV se convierte en un producto
{: #pizarra-fila-csv }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/fila-a-producto.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/fila-a-producto.webp' | relative_url }}" alt="Una fila CSV se convierte en un producto. id,nombre,precio / 7,Cuaderno,2.50. Lector CSV. Lee la cabecera y obtiene los campos «7», «Cuaderno» y «2.50» como texto. Mapper. Convierte el ID a long y el precio a double. El nombre sigue siendo String. Construye Producto. Servicio. Consulta si el ID 7 ya existe. Si está libre, pide guardar el producto. Repositorio. Serializa el producto y lo guarda en el fichero del catálogo. Precio ilegible. Con 7,Cuaderno,abc el mapper detiene la conversión. ID duplicado. Si el catálogo ya contiene el ID 7, el servicio rechaza el alta. El fichero queda intacto." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Predice qué componente recibe la fila y cuál detiene el alta si el precio es `abc` o el ID `7` ya existe. El ejemplo usa los tipos de la lección 06.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/fila-a-producto.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>



## ¿Quién hace qué al modificar o borrar?
{: #pizarra-modificar-borrar }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/modificar-borrar.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/modificar-borrar.webp' | relative_url }}" alt="¿Quién hace qué al modificar o borrar?. Catálogo inicial · 7,Cuaderno,2.50. Main. Lee la acción, interpreta los valores y presenta el resultado al usuario. CatalogoService. Valida el cambio y comprueba si existe el ID antes de pedir el cambio. IProductoRepository. La implementación CSV guarda el catálogo resultante. Los demás registros se conservan. Actualizar ID 7. Tras cambiar el precio a 3.00, el catálogo contiene el cuaderno con el precio nuevo. Borrar ID 99. El ID no existe. Se informa del resultado y el fichero queda intacto." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Antes de ejecutar, predice cómo cambia el catálogo al subir el precio del cuaderno a 3.00 y al intentar borrar el ID 99. Compara el contenido del fichero antes y después.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/modificar-borrar.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>

## Ejemplo guiado
{: #ejemplo-guiado }

```csv
id,nombre,precio,stock
1,"Teclado, mecánico",49.99,10
2,Ratón,24.90,25
3,Monitor,189.00,7
```

## Relación con el resto de la ruta
{: #relacion-con-el-resto-de-la-ruta }

Este ejercicio cierra CSV manteniendo `Producto`. En JSON se reutilizará exactamente el mismo dominio y cambiará únicamente el mecanismo de serialización.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Implementa listar, buscar por id, crear, actualizar y eliminar productos.
2. Rechaza ids duplicados, precios negativos y stock negativo.
3. Comprueba que `"Teclado, mecánico"` se conserva después de una actualización de otro producto.
4. Añade un producto con caracteres como `ñ`, `á` o `€` y verifica que se mantiene UTF-8.
5. Vuelve a abrir el fichero después de cada modificación y comprueba que el cambio es persistente.

## Qué debes recordar
{: #que-debes-recordar }

- El CRUD opera sobre `Producto`; Commons CSV resuelve la representación tabular.
- Los casos con comas y comillas son la razón principal para no usar `split(",")`.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion16/' | relative_url }}">← 16 · CRUD con CSV</a>
  <a href="{{ '/ficheros/leccion18/' | relative_url }}">18 · El formato JSON →</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion16/' | relative_url }}">Volver al cierre de CSV</a>
  <a href="{{ '/ficheros/leccion17/' | relative_url }}">Continuar con JSON</a>
</div>
