# 🛒 Bazar API 🛒

API REST desarrollada con Java y Spring Boot para la gestión de productos,
clientes y ventas de un bazar.

El sistema permite administrar el inventario de productos, registrar ventas,
consultar información relacionada con las ventas y controlar el stock
disponible.

## Tecnologías utilizadas:

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Git / GitHub

## Principales Funcionalidades:

### Productos

- Registrar productos.
- Listar todos los productos.
- Consultar un producto por su código.
- Actualizar productos.
- Eliminar productos.
- Consultar productos con stock inferior a 5 unidades.

### Ventas

- Registrar ventas.
- Consultar todas las ventas.
- Consultar una venta por su código.
- Actualizar una venta.
- Eliminar una venta.
- Consultar los productos asociados a una venta.
- Consultar información de ventas realizadas en una fecha determinada.

### Clientes

- Registrar clientes.
- Consultar información de clientes.
- Asociar clientes con ventas.

## Arquitectura del Proyecto

El proyecto utiliza una arquitectura por capas:

Controller → Service → Repository → Database

Cada capa tiene una responsabilidad específica:

- **Controller:** recibe y responde las solicitudes HTTP.
- **Service:** contiene la lógica de negocio.
- **Repository:** gestiona el acceso a la base de datos.
- **Entity:** representa las entidades persistentes del sistema.

## Modelo de datos:

El sistema está compuesto principalmente por las entidades:

- Producto
- Cliente
- Venta
- DetalleVenta

`DetalleVenta` funciona como entidad intermedia entre `Venta` y `Producto`,
permitiendo representar los productos incluidos en cada venta y la cantidad
vendida.

<img width="1097" height="225" alt="image" src="https://github.com/user-attachments/assets/961e61b4-9fa3-4cd8-8f9b-1f1a8227205a" />


## Endpoints principales

### Productos

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/productos/crear` | Crear un producto |
| GET | `/productos` | Obtener todos los productos |
| GET | `/productos/{codigo}` | Obtener un producto |
| PUT | `/productos/editar` | Actualizar un producto |
| DELETE | `/productos/eliminar/{codigo}` | Eliminar un producto |
| GET | `/productos/falta_stock` | Productos con stock menor a 5 |

### Ventas

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/ventas/crear` | Registrar una venta |
| GET | `/ventas` | Obtener todas las ventas |
| GET | `/ventas/{codigo}` | Obtener una venta |
| PUT | `/ventas/editar` | Actualizar una venta |
| DELETE | `/ventas/eliminar/{codigo}` | Eliminar una venta |
| GET | `/ventas/productos/{codigo_venta}` | Obtener productos de una venta |
| GET | `/ventas/{fecha_venta}` | Consultar información de ventas por fecha |

Los endpoints fueron probados mediante Swagger y/o Postman.

##  Pruebas de la API

La API fue probada mediante Postman utilizando una colección que contiene
los diferentes endpoints disponibles en el proyecto.

###  Colección de Postman

La colección puede descargarse directamente desde el repositorio:

[Descargar colección de Postman](./docs/postman/BazarCollection.postman_collection.json)

Para utilizarla:

1. Descargar el archivo `.json`.
2. Abrir Postman.
3. Seleccionar **Import**.
4. Seleccionar el archivo descargado.
5. Ejecutar las solicitudes disponibles en la colección.

## ⚙️ Configuración

Para ejecutar el proyecto correctamente es necesario configurar una base de datos MySQL y establecer las variables de entorno utilizadas por la aplicación.

### 1. Configurar la base de datos

Crear una base de datos MySQL para el proyecto. Por ejemplo:

```sql
CREATE DATABASE bazar;
```

### 2. Configurar las variables de entorno

El proyecto utiliza variables de entorno para establecer la conexión con MySQL:

```text
BD_URL=jdbc:mysql://localhost:3306/bazar?useSSL=false&serverTimezone=UTC
BD_USER=tu_usuario
BD_PASSWORD=tu_contraseña
```

Estas variables son utilizadas por Spring Boot mediante `application.properties`:

```properties
spring.datasource.url=${BD_URL}
spring.datasource.username=${BD_USER}
spring.datasource.password=${BD_PASSWORD}
```

> **Nota:** No es necesario modificar `application.properties` para colocar las credenciales directamente. Se recomienda utilizar variables de entorno para evitar exponer información sensible en el repositorio.

##  Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/alexander06j/ProyectoBazar.git
```

### 2. Ingresar al directorio del proyecto

```bash
cd ProyectoBazar
```

### 3. Configurar las variables de entorno

Antes de ejecutar la aplicación, asegúrate de que `BD_URL`, `BD_USER` y `BD_PASSWORD` estén configuradas en tu entorno.

### 4. Ejecutar la aplicación

Utilizando Maven:

```bash
mvn spring-boot:run
```

También puedes ejecutar el proyecto directamente desde IntelliJ IDEA utilizando la clase principal de Spring Boot.

Una vez iniciada la aplicación, la API estará disponible en:

```text
http://localhost:8080
```

##  Documentación de la API

La API cuenta con documentación mediante Swagger/OpenAPI, permitiendo visualizar y probar los diferentes endpoints disponibles.

Una vez iniciada la aplicación, acceder a la interfaz de Swagger mediante la ruta configurada en el proyecto.

##  Colección de Postman

El proyecto incluye una colección de Postman con las solicitudes utilizadas para probar los diferentes endpoints de la API.

La colección se encuentra en:

```text
docs/postman/## ⚙️ Configuración

Para ejecutar el proyecto correctamente es necesario configurar una base de datos MySQL y establecer las variables de entorno utilizadas por la aplicación.

### 1. Configurar la base de datos

Crear una base de datos MySQL para el proyecto. Por ejemplo:

```sql
CREATE DATABASE bazar;
```

### 2. Configurar las variables de entorno

El proyecto utiliza variables de entorno para establecer la conexión con MySQL:

```text
BD_URL=jdbc:mysql://localhost:3306/bazar?useSSL=false&serverTimezone=UTC
BD_USER=tu_usuario
BD_PASSWORD=tu_contraseña
```

Estas variables son utilizadas por Spring Boot mediante `application.properties`:

```properties
spring.datasource.url=${BD_URL}
spring.datasource.username=${BD_USER}
spring.datasource.password=${BD_PASSWORD}
```

> **Nota:** No es necesario modificar `application.properties` para colocar las credenciales directamente. Se recomienda utilizar variables de entorno para evitar exponer información sensible en el repositorio.

## ▶️ Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/alexander06j/ProyectoBazar.git
```

### 2. Ingresar al directorio del proyecto

```bash
cd ProyectoBazar
```

### 3. Configurar las variables de entorno

Antes de ejecutar la aplicación, asegúrate de que `BD_URL`, `BD_USER` y `BD_PASSWORD` estén configuradas en tu entorno.

### 4. Ejecutar la aplicación

Utilizando Maven:

```bash
mvn spring-boot:run
```

También puedes ejecutar el proyecto directamente desde IntelliJ IDEA utilizando la clase principal de Spring Boot.

Una vez iniciada la aplicación, la API estará disponible en:

```text
http://localhost:8080
```

##  Documentación de la API

La API cuenta con documentación mediante Swagger/OpenAPI, permitiendo visualizar y probar los diferentes endpoints disponibles.

Una vez iniciada la aplicación, acceder a la interfaz de Swagger mediante la ruta configurada en el proyecto.

##  Colección de Postman

El proyecto incluye una colección de Postman con las solicitudes utilizadas para probar los diferentes endpoints de la API.

La colección se encuentra en:

```text
docs/postman/BazarCollection.postman_collection.json
```

También puede importarse directamente en Postman utilizando la opción **Import**.

```

También puede importarse directamente en Postman utilizando la opción **Import**.
