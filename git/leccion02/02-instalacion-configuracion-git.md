---
layout: lesson
route: git
lesson_id: leccion02
lesson_number: "02"
title: "Instalación y configuración de Git"
description: "Instala Git, identifica su versión y configura tu identidad para comenzar a trabajar con repositorios."
permalink: /git/leccion02/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: crear-la-identidad-en-github
    title: "Crear la identidad en GitHub"
  - id: configurar-la-identidad
    title: "Configurar la identidad"
  - id: configuración-global-y-local
    title: "Configuración global y local"
  - id: preparar-el-entorno-de-prácticas
    title: "Preparar el entorno de prácticas"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Instalación y configuración de Git

Antes de crear repositorios necesitamos comprobar que Git está disponible y configurar la identidad que quedará asociada a nuestros commits.

## Qué vas a conseguir

- Comprobar que Git está instalado.
- Crear una cuenta e identidad básica en GitHub.
- Generar un token de acceso personal para HTTPS.
- Configurar nombre y correo del autor.
- Diferenciar configuración global y local.
- Consultar los valores activos de configuración.
- Preparar una carpeta de trabajo para las siguientes prácticas.

## Punto de partida

Abre un terminal. En Windows puedes utilizar PowerShell, Windows Terminal o la terminal integrada de tu editor. En Linux y macOS puedes utilizar el terminal del sistema.

Comprueba Git:

```bash
git --version
```

Deberías obtener una respuesta similar a:

```text
git version 2.x.x
```

No es necesario que tu número coincida exactamente.

## Crear la identidad en GitHub

GitHub y Git son herramientas relacionadas, pero no son lo mismo. GitHub proporciona la cuenta, el perfil y los repositorios remotos; Git registra localmente el autor de cada commit.

Si todavía no tienes cuenta, créala en [github.com](https://github.com/). Utiliza un nombre de usuario que puedas reconocer fácilmente y confirma el correo electrónico. Ese correo será importante para asociar tus commits con tu cuenta.

Por ejemplo, una identidad ficticia para estas prácticas podría ser:

```text
Nombre: Ana Pérez
Usuario de GitHub: anaperez
Correo verificado: ana.perez.alumna@example.com
```

El usuario `ana-perez` identifica la cuenta en GitHub. El nombre y el correo se utilizarán después para configurar Git en el equipo.

Activa también la autenticación en dos pasos desde la configuración de seguridad de GitHub. La contraseña de la cuenta no debe utilizarse para autenticar operaciones de Git por HTTPS.

## Generar un token para HTTPS

Para trabajar con un repositorio remoto mediante HTTPS, GitHub permite utilizar un **Personal Access Token (PAT)** como contraseña. El token funciona como una credencial y solo debe tener los permisos necesarios.

En GitHub:

1. Abre tu foto de perfil y entra en **Settings**.
2. En el menú lateral, selecciona **Developer settings**.
3. Entra en **Personal access tokens** y selecciona **Fine-grained tokens**.
4. Pulsa **Generate new token**.
5. Escribe un nombre reconocible, establece una fecha de caducidad y selecciona tu cuenta como propietario del recurso.
6. En **Repository access**, elige **Only select repositories** y selecciona el repositorio que utilizarás en las prácticas. Para las primeras pruebas también puedes elegir un repositorio vacío de prácticas.
7. En **Repository permissions**, concede a **Contents** el permiso **Read and write**. El permiso **Metadata: Read-only** se incluye como requisito básico.
8. Genera el token y cópialo inmediatamente. GitHub solo lo muestra completo una vez.

Por ejemplo, una configuración razonable para el aula sería:

```text
Token name: practicas-git-2026
Expiration: 30 days
Resource owner: ana-perez
Repository access: solo practicas-git
Contents: Read and write
Metadata: Read-only
```

El valor secreto del token no se muestra aquí ni debe aparecer en apuntes compartidos. El texto `practicas-git-2026` es únicamente el nombre descriptivo del token.

No compartas el token, no lo guardes en un README y no lo escribas en la URL del remoto. Si se publica por error, revócalo desde la misma pantalla y genera uno nuevo.

## Utilizar el token para autenticarte

Con macOS, puedes pedir a Git que utilice el llavero del sistema para recordar la credencial de forma segura:

```bash
git config --global credential.helper osxkeychain
```

Cuando conectes un repositorio HTTPS y ejecutes una operación que necesite autenticación, por ejemplo `git push`, Git solicitará:

```text
Username for 'https://github.com': ana-perez
Password for 'https://anaperez@github.com': pega-aqui-el-token
```

En el campo `Username` escribe tu nombre de usuario de GitHub. En el campo `Password` pega el token, no la contraseña de GitHub. El token no se muestra mientras lo escribes; pulsa `Enter` cuando termines.

Comprueba que el remoto utiliza HTTPS sin incluir credenciales:

```bash
git remote -v
```

Debe tener un formato parecido a este:

```text
origin  https://github.com/anaperez/practicas-git.git (fetch)
origin  https://github.com/anaperez/practicas-git.git (push)
```

En este ejemplo, `anaperez` y `practicas-git` son datos ficticios. Sustitúyelos por tu usuario y el nombre real del repositorio, pero nunca sustituyas `pega-aqui-el-token` por un token escrito en un documento o una captura.

Si Git vuelve a pedir las credenciales, revisa el llavero del sistema y el alcance del token. No uses comandos que incluyan el token directamente, como `https://TOKEN@github.com/...`, porque puede quedar registrado en el historial del terminal.

## Configurar la identidad

Git guarda un autor en cada commit. Configura tu nombre:

```bash
git config --global user.name "Ana Pérez"
```

Y tu correo:

```bash
git config --global user.email "ana.perez.alumna@example.com"
```

Comprueba ambos valores:

```bash
git config --global user.name
git config --global user.email
```

<div class="cla-note"><strong>Importante</strong><p>En un equipo compartido del aula, revisa siempre la identidad antes de hacer commits. No utilices los datos de otra persona.</p></div>

## Configuración global y local

La opción `--global` aplica una configuración al usuario del equipo.

Dentro de un repositorio también podemos definir valores específicos:

```bash
git config user.name "Ana Aula"
```

Un valor local tiene prioridad dentro de ese repositorio.

Consulta todas las opciones activas y su origen:

```bash
git config --list --show-origin
```

## Preparar el entorno de prácticas

Crea una carpeta donde realizarás los ejercicios:

```bash
mkdir practicas-git
cd practicas-git
```

Todavía no es un repositorio Git. En la siguiente lección lo convertiremos en uno.

## Ejemplo guiado

Comprueba estos comandos en orden:

```bash
git --version
git config --global user.name
git config --global user.email
```

Si falta alguno de los dos valores de identidad, configúralo y vuelve a consultarlo.

## Ejercicios propuestos

**Ejercicio 1.** Localiza la versión de Git instalada en tu equipo.

**Ejercicio 2.** Crea o revisa tu cuenta de GitHub, confirma tu correo y activa la autenticación en dos pasos. No compartas capturas que muestren datos privados.

**Ejercicio 3.** Genera un token fine-grained con caducidad y acceso únicamente a un repositorio de prácticas. No lo incluyas en la entrega ni en una captura.

**Ejercicio 4.** Configura el ayudante de credenciales de macOS, conecta un repositorio HTTPS de prácticas y autentícate usando tu usuario y el token.

**Ejercicio 5.** Configura tu nombre y correo de Git y verifica que se muestran correctamente. Utiliza un correo verificado en GitHub.

**Ejercicio 6.** Ejecuta `git config --list --show-origin` e identifica qué archivo contiene `user.name`.

**Reto.** Explica cuándo podría ser útil tener un nombre o correo local diferente del global.

## Qué debes recordar

Antes de comenzar: `git --version` verifica la instalación y `git config` controla la configuración. La cuenta de GitHub autentica las operaciones remotas; el token sustituye a la contraseña en HTTPS y la identidad de Git queda asociada a cada commit.

<div class="cla-lesson-nav">
  <a href="/git/leccion01/">← Lección 01 · Introducción a Git y al control de versiones</a>
  <a href="/git/leccion03/">Lección 03 · Crear el primer repositorio →</a>
</div>
