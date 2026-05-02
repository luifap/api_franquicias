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
- (Docker como Infraestructura como Código - IaC)

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

Si no tienes Mongo instalado localmente, usa Docker:

docker run -d -p 27017:27017 --name mongo mongo

Verifica que esta corriendo:
docker ps

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

## Tests

Para ejecutar las pruebas unitarias:

```bash
./mvnw test

---

## Arquitectura

El proyecto sigue Clean Architecture, separando responsabilidades para mantener el sistema escalable, mantenible y testeable:

Controller (API Layer)
Expone los endpoints REST y recibe las peticiones HTTP.
Application / Service Layer
Contiene la lógica de negocio del sistema.
Domain Layer
Modelos del negocio (Franquicia, Sucursal, Producto) sin dependencias externas.
Infrastructure Layer
Implementación de persistencia (MongoDB), configuración y adaptadores.
Repository Layer
Abstracción del acceso a datos.
DTO / Mappers
Transformación entre entidades del dominio y objetos de transferencia.


---

## Enfoque Reactivo

El sistema está preparado para un enfoque reactivo (Reactive Programming) en su diseño de servicios, permitiendo:

Manejo eficiente de múltiples peticiones concurrentes
Mejor escalabilidad bajo carga
Base para evolución futura a Spring WebFlux si se requiere

Actualmente la implementación puede ser imperativa (Spring MVC), pero la arquitectura está pensada para migración/reactividad sin reescritura total.

---

## Docker como Infraestructura como Código (IaC)

El proyecto utiliza Docker para definir y reproducir el entorno completo de ejecución:

Base de datos MongoDB containerizada
API Spring Boot containerizada
Orquestación con docker-compose

Esto permite:

Levantar el sistema completo con un solo comando
Evitar configuración manual del entorno
Garantizar consistencia entre desarrollo y producciónDocker como Infraestructura como Código (IaC)

El proyecto utiliza Docker para definir y reproducir el entorno completo de ejecución:

Base de datos MongoDB containerizada
API Spring Boot containerizada
Orquestación con docker-compose

Esto permite:

Levantar el sistema completo con un solo comando
Evitar configuración manual del entorno
Garantizar consistencia entre desarrollo y producción

---

## Autor

Luisa Fernanda Arboleda Parra
