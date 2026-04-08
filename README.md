# Sistema de Login y Fichaje

Proyecto de la asignatura **Fundamentos de la Programación** del ciclo **Desarrollo de Aplicaciones Web (1º DAW)**.

## Descripción

Este proyecto consiste en desarrollar una aplicación en **Java** que simula un sistema de login para una empresa, con dos tipos de usuarios:

- **Administrador**
- **Trabajador**

Según el tipo de usuario que inicie sesión, el programa mostrará distintas opciones por menú.

Además, los trabajadores podrán realizar un **fichaje**, que quedará registrado en un fichero de texto.

## Funcionalidades

### Perfil administrador
- Dar de alta trabajadores
- Dar de baja trabajadores por DNI
- Ver los datos de un trabajador por DNI
- Ver el listado de trabajadores
- Cambiar la contraseña de un trabajador
- Ver los registros de jornada

### Perfil trabajador
- Iniciar sesión
- Realizar fichaje

## Estructura del proyecto

La aplicación está organizada en clases Java, partiendo de una clase principal para ejecutar el programa y una clase `Usuario` para representar a los usuarios del sistema.

Ejemplo de datos que almacena un usuario:

- nombre
- apellido
- dni
- correo
- contraseña
- tipo de usuario

## Tecnologías utilizadas

- **Java**
- Programación orientada a objetos
- Gestión de ficheros de texto
- Git y GitHub

## Autora
Belén Jiménez Sánchez

## Licencia del proyecto
Proyecto académico con fines educativos
