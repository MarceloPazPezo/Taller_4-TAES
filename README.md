# Taller 4: Servicios Web

## Tópicos Avanzados en Ingeniería de Software

**Profesor:** Luis Cabrera Crot  
**Estudiante:** Marcelo Alfredo Paz Pezo  
**Fecha:** 13 de Julio de 2025

---

### 1. Introducción

Este documento detalla la implementación del Proyecto 4, correspondiente a la creación y consumo de un servicio web. El objetivo fue desarrollar una API RESTful utilizando el framework Spring Boot para gestionar el riesgo de incendio en parcelas, basándose en el modelo de datos del taller anterior de Pruebas Unitarias.

El proyecto consiste en un servidor que expone una serie de endpoints para realizar operaciones sobre las parcelas y un cliente de consola en Java que consume dichos servicios.

### 2. Estructura del Proyecto

El proyecto se ha desarrollado utilizando Apache Maven y está organizado en una estructura multi-módulo para cumplir con los requisitos del taller, separando claramente las responsabilidades del servidor y del cliente:

* **`Taller_4-TAES` (Proyecto Padre):** Es el proyecto contenedor que gestiona los dos módulos principales. Contiene el `pom.xml` principal que define las propiedades comunes y la relación entre los módulos.
* **`rest` (Módulo Servidor):** Contiene toda la lógica de la API REST implementada con Spring Boot. Es responsable de exponer los endpoints, gestionar las peticiones y devolver las respuestas en formato JSON.
* **`client` (Módulo Cliente):** Es una aplicación de consola en Java que actúa como consumidor del servicio web. Se conecta al servidor a través de HTTP, realiza peticiones a la API y muestra los resultados obtenidos en la consola.

### 3. Requisitos de Software

Para compilar y ejecutar el proyecto, es necesario tener instalado el siguiente software:

* **Java Development Kit (JDK):** Versión 21 o superior (el proyecto fue desarrollado y probado con JDK 24).
* **Apache Maven:** Versión 3.8 o superior, para la gestión de dependencias y la compilación del proyecto.
* **IDE (Opcional pero recomendado):** Apache NetBeans 19 o superior.

### 4. Instrucciones de Compilación

Desde NetBeans, puedes abrir el proyecto y luego  clic derecho sobre el proyecto padre `Taller_4-TAES` y seleccionar la opción **`Clean and Build`**.

### 5. Instrucciones de Ejecución

La ejecución del proyecto se realiza en dos pasos, ya que el servidor debe estar activo para que el cliente pueda conectarse.

#### **Paso 1: Ejecutar el Servidor (`rest`)**

1. Asegúrese de haber compilado el proyecto como se indicó en el paso anterior.
2. Desde NetBeans, haga clic derecho sobre el módulo **`rest`** y seleccione **`Run`**.
3. La consola de NetBeans mostrará el logo de Spring Boot y, al finalizar, un mensaje similar a: `Tomcat started on port(s): 8080 (http)`.
4. **Importante:** Deje esta consola corriendo. Si la detiene, el servidor se apagará.

El servidor ahora está activo y escuchando peticiones en `http://localhost:8080`.

#### **Paso 2: Ejecutar el Cliente (`client`)**

1. Con el servidor ya en ejecución, vaya al módulo **`client`** en NetBeans.
2. Haga clic derecho sobre el módulo **`client`** y seleccione **`Run`**.
3. Se abrirá una nueva consola de `Output` que mostrará la interacción del cliente con la API: listará las parcelas iniciales, agregará una nueva y volverá a listar para mostrar el cambio.

### 6. Descripción de la API REST

El servidor expone los siguientes endpoints para la gestión de parcelas:

| Método HTTP | URL                                    | Descripción                                             |
| :---------- | :------------------------------------- | :------------------------------------------------------ |
| `GET`       | `/api/parcelas`                        | Devuelve una lista con todas las parcelas registradas.  |
| `GET`       | `/api/parcelas/{rol}`                  | Obtiene los datos de una parcela específica por su ROL. |
| `POST`      | `/api/parcelas`                        | Agrega una nueva parcela al sistema.                    |
| `GET`       | `/api/parcelas/propensas/cantidad`     | Devuelve el número total de parcelas propensas a incendio. |
| `PUT`       | `/api/parcelas/{rol}/cortafuegos`      | Aplica un cortafuegos, modificando el índice de combustible. |

### 7. Capturas

![Captura de pantalla Rest en ejecución](captura_rest.png)

![Captura de pantalla Client en ejecución](captura_client.png)