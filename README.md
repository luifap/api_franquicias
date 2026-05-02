# API Franquicias

API REST desarrollada en Spring Boot para la gestión de franquicias, sucursales y productos.

---

## Objetivo

Permitir la administración de:

- Franquicias
- Sucursales
- Productos
- Stock de productos
- Consulta de productos con mayor stock por sucursal

---

## Tecnologías

- Java 21
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven
- Docker (opcional)

---

## Modelo de datos

- Franquicia: id, nombre, sucursales[]
- Sucursal: id, nombre, productos[]
- Producto: id, nombre, stock

---

## Cómo ejecutar el proyecto

### Prerrequisitos

Antes de iniciar, asegúrate de tener instalado:

Java 21
Maven (o usar mvnw)
Docker (opcional pero recomendado)

### Opción 1: Ejecución local (RECOMENDADO)

#### 1. Clonar repositorio

git clone https://github.com/luifap/api_franquicias.git
cd api_franquicias/api_franquicias_back

#### 2. Levantar MongoDB

docker run -d -p 27017:27017 --name mongo mongo

#### 3. Ejecutar la API

./mvnw spring-boot:run

#### 4. Acceder

http://localhost:8080

---

### Opción 2: Con Docker

Desde la raíz:

docker-compose up --build

---

## Endpoints

### Franquicias
POST /franquicias  
GET /franquicias  
GET /franquicias/{id}  
PUT /franquicias/{id}  

### Sucursales
POST /franquicias/{id}/sucursales  
PUT /franquicias/{fid}/sucursales/{sid}  

### Productos
POST /franquicias/{fid}/sucursales/{sid}/productos  
DELETE /franquicias/{fid}/sucursales/{sid}/productos/{pid}  
PUT /franquicias/{fid}/sucursales/{sid}/productos/{pid}/stock  
PUT /franquicias/{fid}/sucursales/{sid}/productos/{pid}  

### Analítica
GET /franquicias/{id}/top-productos  

---

## Pruebas

- Postman

---

## Base de datos

mongodb://localhost:27017

---

## Arquitectura

- Controller
- Service
- Domain Model
- Repository
- DTO / Mapper


---

## Autor

Luisa Fernanda Arboleda Parra
