package com.franquicias.api.domain.model;

import java.util.UUID;

public class Producto {

    private String id;
    private String nombre;
    private int stock;

    public Producto(String nombre, int stock) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.stock = stock;
    }

    public void actualizarStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
}