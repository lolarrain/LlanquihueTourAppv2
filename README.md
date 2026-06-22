# Entrega Actividad S5 - Desarrollo Orientado a Objetos I

## Autor del proyecto

Nombre: Paloma Larraín Pereira

## Descripción general del sistema

Proyecto desarrollado en Java como prototipo inicial para la digitalización de procesos administrativos de la agencia turística ficticia Llanquihue Tour.

El sistema busca gestionar, mediante programación orientada a objetos, a las personas vinculadas a la operación de la agencia, como guías turísticos, operadores locales y proveedores de transporte. Para ello, el programa permite cargar datos desde un archivo externo, almacenarlos en una colección dinámica y realizar búsquedas o filtros simples por consola.

## Estructura general del proyecto

El proyecto está organizado en paquetes funcionales:

```text
src/
├── app/
│   └── Main.java
├── model/
│   ├── Persona.java
│   ├── Direccion.java
├── data/
│   └── LectorArchivo.java
├── service/
│   └── GestorPersonas.java
└── util/
    └── Validador.java

resources/
└── personas.txt
```

## Descripción breve de los paquetes

`app`: contiene la clase principal Main.java, encargada de ejecutar el programa y mostrar el menú por consola.

`model`: contiene las clases principales del sistema, como Persona y Direccion.

`data`: contiene la clase encargada de leer los datos desde el archivo externo personas.txt.

`service`: contiene la clase que administra la colección de personas y permite realizar búsquedas o filtros.

`util`: contiene validaciones básicas utilizadas durante la carga de datos.

## Instrucciones para clonar y ejecutar el proyecto

Clona el repositorio desde GitHub:
```text
git clone https://github.com/lolarrain/LlanquihueTourAppv2.git
```
Abre el proyecto en IntelliJ IDEA.

Verifica que las clases estén correctamente ubicadas en sus paquetes correspondientes.

Ejecuta el archivo Main.java desde el paquete app.

Repositorio GitHub: [https://github.com/lolarrain/LlanquihueTourAppv2] Fecha de entrega: [22/06/2026]


