package com.franquicias.api.application.dto;

public class ProductoResponseDTO {

    private String id;
    private String nombre;
    private int stock;

    public ProductoResponseDTO(String id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
}