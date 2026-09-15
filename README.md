# CodeLearn Academy

Formación real basada en ejercicios, proyectos y buenas prácticas profesionales.

## Publicación en GitHub Pages

El repositorio de destino es `codelearnacademy/codelearnacademy.github.io` y la web se publica en https://codelearnacademy.github.io/.

1. Crea o renombra el repositorio como `codelearnacademy.github.io` dentro de la cuenta `codelearnacademy`.
2. En **Settings → Pages → Build and deployment → Source**, selecciona **GitHub Actions**.
3. Sube los archivos fuente del proyecto, incluida `.github/workflows/pages.yml`, a la rama `main`.
4. Comprueba en **Actions** el workflow **Publicar GitHub Pages**. También puedes iniciarlo con **Run workflow** después de activar Pages.

El workflow construye el sitio con Jekyll y publica el resultado de `_site`. La configuración usa `url: "https://codelearnacademy.github.io"` y `baseurl: ""` para servir desde la raíz del dominio.

## Desarrollo local

```bash
bundle install
./scripts/update-build-data.sh
./scripts/validate-site.sh
bundle exec jekyll serve
```

Si el puerto 4000 está ocupado:

```bash
bundle exec jekyll serve --port 4001
```

## Estructura declarativa

La mayor parte de la información repetida se obtiene desde configuración:

- `_config.yml`: branding, tagline, autor, repositorio, SEO y rutas base.
- `_data/routes.yml`: rutas de aprendizaje y lecciones.
- `_data/technologies.yml`: tecnologías e iconos locales.
- `_data/features.yml`: bloque “Qué encontrarás”.
- `_data/navigation.yml`: navegación principal.
- `_data/footer.yml`: columnas del footer.
- `_data/licenses.yml`: atribución de iconos, fuentes y marcas.
- `_data/references.yml`: referencias reutilizables enlazables desde los apuntes docentes.
- `_data/build.yml`: versión, rama, commit, autor y fecha generados desde Git.

## Separación de contenidos

- `java/`: rutas de aprendizaje y apuntes docentes, con `/java/` como entrada de la ruta Java.
- `_documentation/`: documentación técnica profesional publicada bajo `/documentacion/`.
- `_references/`: referencias breves reutilizables publicadas bajo `/referencias/`.
- `1-dam/` y `2-dam/`: programaciones didácticas por curso y módulo.

La programación de `1-dam/pro/` relaciona las unidades del módulo de Programación con la ruta técnica `java/`. `1-dam/ets/` contiene Entornos de desarrollo y `2-dam/aed/` contiene Acceso a datos.

## Assets locales

Los iconos tecnológicos se sirven desde:

```text
assets/images/technologies/
```

No se referencian imágenes externas desde las plantillas.

## Licencias

La página `/licencias/` se genera desde `_data/licenses.yml`.
