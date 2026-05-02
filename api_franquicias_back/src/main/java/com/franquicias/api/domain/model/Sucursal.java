package com.franquicias.api.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sucursal {

    private String id;
    private String nombre;
    private List<Producto> productos;

    public Sucursal(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String productoId) {
        productos.removeIf(p -> p.getId().equals(productoId));
    }

    public Producto buscarProducto(String productoId) {
        return productos.stream()
                .filter(p -> p.getId().equals(productoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Producto> getProductos() { return productos; }

}