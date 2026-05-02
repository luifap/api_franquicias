# API Franquicias

API REST desarrollada en **Spring Boot + MongoDB + Docker** para la gestión de franquicias, sucursales y productos.

---

## Tecnologías

* Java 21
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Docker & Docker Compose
* Maven

---

## Modelo de negocio

* **Franquicia**

    * id
    * nombre
    * sucursales[]

* **Sucursal**

    * id
    * nombre
    * productos[]

* **Producto**

    * id
    * nombre
    * stock

---

## Base URL

```
http://localhost:8080
```

---

## Ejecución

### Ejecutar en local

```bash
git clone https://github.com/luifap/api_franquicias.git
cd api_franquicias

# levantar mongo
docker run -d -p 27017:27017 --name mongo mongo

# compilar proyecto
./mvnw clean package

# ejecutar
./mvnw spring-boot:run
```

---

### Ejecutar con Docker

```bash
docker-compose up --build
```

---

## docker-compose.yml

```yaml
version: '3.8'

services:

  mongo:
    image: mongo:latest
    container_name: mongo
    ports:
      - "27017:27017"
    restart: always

  api:
    build: .
    container_name: api_franquicias
    ports:
      - "8080:8080"
    depends_on:
      - mongo
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/test
```

---

## Endpoints

### Franquicias

#### Crear franquicia

```
POST /franquicias
```

```json
{
  "nombre": "Franquicia Burger"
}
```

---

#### Listar franquicias (paginado)

```
GET /franquicias?page=0&size=10&sort=nombre,asc
```

---

#### Obtener por ID

```
GET /franquicias/{id}
```

---

#### Actualizar franquicia

```
PUT /franquicias/{id}
```

```json
{
  "nombre": "Nuevo nombre"
}
```

---

### Sucursales

#### Crear sucursal

```
POST /franquicias/{id}/sucursales
```

```json
{
  "nombre": "Sucursal Centro"
}
```

---

#### Actualizar sucursal

```
PUT /franquicias/{fid}/sucursales/{sid}
```

```json
{
  "nombre": "Nuevo nombre"
}
```

---

### Productos

#### Crear producto

```
POST /franquicias/{fid}/sucursales/{sid}/productos
```

```json
{
  "nombre": "Hamburguesa",
  "stock": 50
}
```

---

#### Eliminar producto

```
DELETE /franquicias/{fid}/sucursales/{sid}/productos/{pid}
```

---

#### Actualizar stock

```
PUT /franquicias/{fid}/sucursales/{sid}/productos/{pid}/stock
```

```json
{
  "stock": 100
}
```

---

#### Actualizar nombre producto

```
PUT /franquicias/{fid}/sucursales/{sid}/productos/{pid}
```

```json
{
  "nombre": "Nueva Hamburguesa"
}
```

---

### Analítica

#### Top productos por franquicia

```
GET /franquicias/{id}/top-productos
```

Retorna los productos con mayor stock por sucursal.

---

## Manejo de errores

La API retorna respuestas estándar:

| Código | Descripción   |
| ------ | ------------- |
| 400    | Bad Request   |
| 404    | Not Found     |
| 500    | Error interno |

### Ejemplo:

```json
{
  "status": 404,
  "error": "Franquicia no encontrada"
}
```

---

## Pruebas

Puedes probar la API con:

* Postman

---

## Base de datos

```
mongodb://localhost:27017
```

Base usada por defecto:

```
test
```

---

## Arquitectura

El proyecto sigue principios de arquitectura limpia / hexagonal:

* Controller
* Application (Services, DTOs)
* Domain (Modelos y reglas)
* Infrastructure (MongoDB, adapters)

✔ Separación de responsabilidades
✔ Uso de DTOs
✔ Manejo centralizado de errores
✔ Programación funcional (Streams)

---

##  Extras implementados

Paginación
Manejo de errores global
Top productos por sucursal
Arquitectura hexagonal por capas

---

## Autor

**Luisa Fernanda Arboleda Parra**
Proyecto – API de Franquicias

---
