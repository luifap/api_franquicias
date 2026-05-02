# Frontend Franquicias

Aplicación web desarrollada en **React + Vite** para la gestión de franquicias, sucursales y productos.

Se conecta a la API REST del backend para realizar todas las operaciones.

---

## Tecnologías

* React
* Vite
* Axios
* React Router DOM
* Docker

---

## Características

✔ Crear franquicias
✔ Editar franquicias
✔ Agregar sucursales
✔ Editar sucursales
✔ Agregar productos
✔ Editar productos
✔ Eliminar productos
✔ Actualizar stock (+ / -)
✔ Ver detalle de franquicia
✔ Top productos por sucursal
✔ Navegación entre vistas

---

##  Configuración API

El frontend consume la API en:

```js
http://localhost:8080
```

Archivo:

```
src/api/axios.js
```

---

## Ejecución

### Modo desarrollo

```bash
npm install
npm run dev
```

La app estará disponible en:

```bash
http://localhost:5173
```

---

### Ejecutar con Docker

```bash
docker build -t frontend-franquicias .
docker run -p 80:80 frontend-franquicias
```

Accede en:

```bash
http://localhost
```

---

## Dockerfile

```dockerfile
# build stage
FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

RUN npm run build

# production stage
FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
```

---

---

## Funcionalidades principales

###  Dashboard

* Listado de franquicias
* Creación de nuevas franquicias

### Detalle de franquicia

* Gestión de sucursales
* Gestión de productos
* Visualización de top productos

### Productos

* Incrementar / disminuir stock
* Eliminación
* Edición de nombre

---

## Integración con Backend

El frontend consume los endpoints:

```
GET     /franquicias
POST    /franquicias
PUT     /franquicias/{id}

POST    /franquicias/{id}/sucursales
PUT     /franquicias/{fid}/sucursales/{sid}

POST    /franquicias/{fid}/sucursales/{sid}/productos
PUT     /franquicias/{fid}/sucursales/{sid}/productos/{pid}
PUT     /franquicias/{fid}/sucursales/{sid}/productos/{pid}/stock
DELETE  /franquicias/{fid}/sucursales/{sid}/productos/{pid}

GET     /franquicias/{id}/top-productos
```

---

## Notas importantes

* El backend debe estar corriendo en `http://localhost:8080`
* MongoDB debe estar activo
* Docker recomendado para entorno completo

---

## Extras

UI limpia y moderna
Manejo de estado con hooks
Componentes reutilizables
Arquitectura modular
Integración completa con API

---

##Autor

**Luisa Fernanda Arboleda Parra**
Frontend – Sistema de Franquicias

---
